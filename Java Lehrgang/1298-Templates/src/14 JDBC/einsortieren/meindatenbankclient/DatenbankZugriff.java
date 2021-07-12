/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package einsortieren.meindatenbankclient;

import java.sql.*;

import einsortieren.meindatenbankclient.exceptions.NoConnectionException;
import einsortieren.meindatenbankclient.exceptions.StillConnectedException;

/**
 * Diese Klasse dient zur Kommunikation mit eine MySQL-Datenbank. Sie stellt diverse
 * Methoden zum Verbinden, Absenden von Anfragen und zum Beenden bereit.
 * Diese Klasse ist ein Singleton. Das heißt, dass zur Kommunikation mit der Datenbank nur
 * ein Objekt dieser Klasse im System ist. Dieses erhält man mit getInstance().
 * @author dborkowitz
 */
public class DatenbankZugriff {

    /**
     * Singleton Instanz dieser Klasse.
     */
    private static DatenbankZugriff instance;
    /**
     * Verbindungsobjekt zur Datenbank
     */
    public Connection con;
    private DBTyp typ;

    /**
     * Konstruktor kann nicht von außen aufgerufen werden.
     */
    private DatenbankZugriff() {
    }

    /**
     * Liefert die einzige Instanz dieser Klasse, die im System existiert.
     * @return Singleton-Instanz
     */
    public static DatenbankZugriff getInstance() {
        if (instance == null) {
            instance = new DatenbankZugriff();
            instance.setTyp(DBTyp.MySQL);
        }
        return instance;
    }

    public void setTyp(DBTyp typ) {
        this.typ = typ;
        try {
            if (typ == DBTyp.ORACLE) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } else if (typ == DBTyp.MySQL) {
                Class.forName("com.mysql.jdbc.Driver");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 
     * Diese Funktion dient zum Aufbau einer Verbindung zum Datenbankserver.Sie muss als
     * erstes aufgerufen werden, bevor irgendeine andere Funktion verwendet werden kann.
     * @param host Name des Datenbankservers 
     * @param user  Benutzername für Datenbank
     * @param password  Password des Benutzers
     * @throws SQLException Wird geworfen, wenn keine Verbindung zum Server herstellbar ist (z.b. falscher Host, falscher User, falsches Passwort).
     * @throws StillConnectedException
     */
    public void connect(String host, String user, String password) throws SQLException, StillConnectedException {
        if (con == null) {
            if (typ == DBTyp.ORACLE) {
                con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":1521:XE", user, password);
            } else if (typ == DBTyp.MySQL) {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306", user, password);
            }
        } else {
            throw new StillConnectedException();
        }
    }

    /**
     * Diese Funktion dient zum Schließen der Verbindung zum Server.
     * @throws SQLException Datenbankverbindung kann nicht geschlossen werden.
     * @throws NoConnectionException Es wurde vorher keine Verbindung aufgebaut <a href = "#connect">connect()</a>
     */
    public void close() throws SQLException, NoConnectionException {
        if (isConnected()) {
            con.close();
            con = null;
        } else {
            throw new NoConnectionException();
        }
    }

    /**
     * Funktion prüft, ob eine Verbindung hergestellt ist.
     * @return true wenn eine Verbindung besteht, false sonst
     */
    public boolean isConnected() {
        return con != null;
    }

    /**
     * Diese Funktion sendet ein Query (hier sind nur Abfragen gültig - keine Manipulationen der Datensätze)
     * an die Datenbank und liefert das Ergebnis der
     * Abfrage als ResultSet zurück. MySQL
     * @param query Abfrage an innerhalb einer Database.
     * @param database  Database in der die Tabellen für die Query enthalten sind.
     * @return  ResultSet mit dem Ergebnis der Query.
     * @throws SQLException Wird geworfen, wenn die Query nicht ausführbar ist.
     * @throws NoConnectionException Es wurde vorher keine Verbindung aufgebaut <a href = "#connect">connect()</a>
     */
    public ResultSet executeQuery(String query, String database) throws SQLException, NoConnectionException {
        if (this.isConnected()) {
            this.changeDatabase(database);
            ResultSet set = executeQuery(query);
            return set;
        } else {
            throw new NoConnectionException();
        }
    }
    /**
     * Diese Funktion sendet ein Query (hier sind nur Abfragen gültig - keine Manipulationen der Datensätze)
     * an die Datenbank und liefert das Ergebnis der
     * Abfrage als ResultSet zurück.
     * @param query Abfrage an innerhalb einer Database.
     * @return  ResultSet mit dem Ergebnis der Query.
     * @throws SQLException Wird geworfen, wenn die Query nicht ausführbar ist.
     * @throws NoConnectionException Es wurde vorher keine Verbindung aufgebaut <a href = "#connect">connect()</a>
     */
    public ResultSet executeQuery(String query) throws SQLException, NoConnectionException {
        if (this.isConnected()) {
            Statement stmt = (Statement) con.createStatement();
            ResultSet set = (ResultSet) stmt.executeQuery(query);
            return set;
        } else {
            throw new NoConnectionException();
        }
    }

    /**
     * Diese Funktion sendet ein Datenmanipulation (Z.B. mittels Insert)
     * an die Datenbank.
     * @param query Manipulationsquery für einen Datensatz innerhalb einer Database.
     * @param database  Database in der die Tabellen für die Query enthalten sind.
     * @throws SQLException Wird geworfen, wenn die Query nicht ausführbar ist.
     * @throws NoConnectionException Es wurde vorher keine Verbindung aufgebaut <a href = "#connect">connect()</a>
     */
    public void executeManipulation(String query, String database) throws SQLException, NoConnectionException {
        if (this.isConnected()) {
            Statement stmt = (Statement) con.createStatement();
            this.changeDatabase(database);
            stmt.execute(query);

        } else {
            throw new NoConnectionException();
        }
    }

    /**
     * Liefert alle Databases des Datenbankservers.
     * @return ResultSet mit Databases
     * @throws SQLException Wird geworfen, wenn die Query nicht ausführbar ist.
     * @throws NoConnectionException Es wurde vorher keine Verbindung aufgebaut <a href = "#connect">connect()</a>
     */
    public ResultSet getAllDatabases() throws SQLException, NoConnectionException {
        if (this.isConnected()) {
            ResultSet set = (ResultSet) con.getMetaData().getCatalogs();
            if (!set.next()) {
                Statement stmt = (Statement) con.createStatement();
                set = stmt.executeQuery("select  * from tab");
            }
            return set;
        } else {
            throw new NoConnectionException();
        }
    }

    /**
     * Wechselt die Database;
     * @param database Name der Database.
     * @throws SQLException Wird geworfen, wenn der Wechsel nicht durchführbar ist.
     * @throws NoConnectionException Es wurde vorher keine Verbindung aufgebaut <a href = "#connect">connect()</a>
     */
    public void changeDatabase(String database) throws SQLException, NoConnectionException {
        if (this.isConnected()) {
            Statement stmt = (Statement) con.createStatement();
            String change = "use " + database + ";";
            stmt.execute(change);

        } else {
            throw new NoConnectionException();
        }
    }
}
