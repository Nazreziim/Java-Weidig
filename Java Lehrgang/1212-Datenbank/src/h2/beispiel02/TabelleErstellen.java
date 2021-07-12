package h2.beispiel02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelleErstellen {

  public static void main( String... args ) {
    try {
      
      // Treiber laden
      Class.forName( "org.h2.Driver" );
      
      // Verbindung aufbauen ( Datenbank, User, Passwort )
      // sollte die Datenbank nicht existieren wird eine erstellt.
      Connection adminConn = DriverManager.getConnection( "jdbc:h2:./db/test", "DBAdmin", "P@ssw0rd" );
      
      // Statement Objekt erstellen (auf diesem können dann SQL statements ausgeführt werden)
      Statement statement = adminConn.createStatement();
      // Statement ausführen (hier wird eine Tabelle angelegt)
      statement.execute(
              "CREATE TABLE IF NOT EXISTS MESSAGES(ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, AUTOR VARCHAR(30), CONTENT VARCHAR(1024))" );
      // SQL Statements unter: http://www.h2database.com/html/grammar.html
      
      // Statement schließen
      statement.close();
      // Verbindung schließen
      adminConn.close();
      
    } catch ( SQLException e ) {
      e.printStackTrace();
    } catch ( ClassNotFoundException e1 ) {
      e1.printStackTrace();
    }
  }

}
