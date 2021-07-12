package BibiProj.dbh2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.jdbc.JdbcSQLException;

import BibiProj.netzwerk.OnlineSuche;

public class main {

  public static void erstelleMedien( Connection con ) throws SQLException {

    // 3. SQL-Anweisung erzeugen
    // Statement Objekt erstellen
    Statement statement = con.createStatement();

    String sqlTabelleAnlegen = "CREATE TABLE IF NOT EXISTS medien (MedId int PRIMARY KEY AUTO_INCREMENT NOT NULL, Name varchar(20), Fsk int DEFAULT 0 CHECK Fsk IN (0,6,12, 18 ) )";

    // 4. SQL- Anweisung ausfuehren
    statement.execute( sqlTabelleAnlegen );

    String sqlDatensaetzeLoeschen = "DELETE FROM medien";
    statement.execute( sqlDatensaetzeLoeschen );

    String sqlDatensatzAnlegen = "INSERT INTO medien (Name, Fsk) VALUES ('Datenbanken', 6)";
    statement.execute( sqlDatensatzAnlegen );

    sqlDatensatzAnlegen = "INSERT INTO medien (Name) VALUES ('XML-Datenbanken')";
    statement.execute( sqlDatensatzAnlegen );

    sqlDatensatzAnlegen = "INSERT INTO medien (Name, Fsk) VALUES ('Malen mit Farben', 6)";
    statement.execute( sqlDatensatzAnlegen );

    sqlDatensatzAnlegen = "INSERT INTO medien (Name, Fsk) VALUES ('Rotkaeppchen', 12)";
    statement.execute( sqlDatensatzAnlegen );

    sqlDatensatzAnlegen = "INSERT INTO medien (Name, Fsk) VALUES ('Pumuckel', 6)";
    statement.execute( sqlDatensatzAnlegen );

    sqlDatensatzAnlegen = "INSERT INTO medien (Name, Fsk) VALUES ('Top Gun', 12)";
    statement.execute( sqlDatensatzAnlegen );

    sqlDatensatzAnlegen = "INSERT INTO medien (Name, Fsk) VALUES ('Meister Eder', 0)";
    statement.execute( sqlDatensatzAnlegen );

    // 5. Ergebnis holen
    String sqlInhaltAnzeigen = "SELECT * FROM medien";

    ResultSet result = statement.executeQuery( sqlInhaltAnzeigen );

    while ( result.next() ) {
      // System.out.println( result.toString() );
      int fsk = result.getInt( "Fsk" );
      String name = result.getString( "Name" );
      int medId = result.getInt( "MedId" );

      System.out.printf( "Datensatz:  Id: %d, Name: %s , Fsk: %d\n", medId, name, fsk );
    }

    String sqlSelectFsk = "SELECT MEDID, NAME FROM MEDIEN WHERE FSK=6";
    result = statement.executeQuery( sqlSelectFsk );

    System.out.println( "Ausgabe alle Fsk = 6 Medien" );
    while ( result.next() ) {
      // System.out.println( result.toString() );
      String name = result.getString( "Name" );
      int medId = result.getInt( "MedId" );

      System.out.printf( "Datensatz:  Id: %d, Name: %s \n", medId, name );
    }

    statement.close();

  }

  public static int abfragenAdresseID( Connection con ) throws SQLException {
    Statement statement = con.createStatement();
    int id = -1;

    String sqlIdAbfrage = "SELECT MAX(AdrId) FROM Adresse";

    ResultSet result = statement.executeQuery( sqlIdAbfrage );

    if ( result.next() ) {
      id = result.getInt( 1 );
    }

    statement.close();
    return id;
  }

  public static void erstelleKunden( Connection con ) throws SQLException {
    Statement statement = con.createStatement();
    
    
    String sqlTabelleAnlegen = "CREATE TABLE IF NOT EXISTS adresse (AdrId int PRIMARY KEY AUTO_INCREMENT NOT NULL, Plz varchar(5), Ort varchar(30))";
    statement.execute( sqlTabelleAnlegen );
    
    String sqlDatensaetzeLoeschenAdr = "DELETE FROM adresse";
    String sqlDatensaetzeLoeschenKdn = "DELETE FROM kunde";
    
    try {
   
      statement.execute( sqlDatensaetzeLoeschenAdr );
    }
    catch ( JdbcSQLException e) {
      System.out.println( "Loeschen der Adressen ist fehlgbeschlagen!" + e);
      // wegen foreign key Standard-Implementierung
      statement.execute( sqlDatensaetzeLoeschenKdn );
      statement.execute( sqlDatensaetzeLoeschenAdr );
      
    }
    
    
    //  Tabellen anlegen und Inhalte loeschen
    sqlTabelleAnlegen = "CREATE TABLE IF NOT EXISTS kunde (KdId int PRIMARY KEY AUTO_INCREMENT NOT NULL, Name varchar(20), Vorname varchar(20), AdrId int REFERENCES adresse(AdrID) )";

    // 4. SQL- Anweisung ausfuehren
    statement.execute( sqlTabelleAnlegen );
  
    statement.execute( sqlDatensaetzeLoeschenKdn );
    
    
    //*************************************************************************
    String sqlDatensatzAnlegen = null;
    
    sqlDatensatzAnlegen = "INSERT INTO adresse (Plz, Ort ) VALUES ('50000', 'Koeln')";
    statement.execute( sqlDatensatzAnlegen );
    int id = abfragenAdresseID( con );   
    sqlDatensatzAnlegen = String.format( "INSERT INTO kunde (Name, Vorname, AdrId ) VALUES ('Maier', 'Herbert', %d )", id);
    statement.execute( sqlDatensatzAnlegen );   
      
    
    sqlDatensatzAnlegen = "INSERT INTO adresse (Plz, Ort ) VALUES ('80000', 'Muenchen')";
    statement.execute( sqlDatensatzAnlegen );
    id = abfragenAdresseID( con ); 
    sqlDatensatzAnlegen = String.format( "INSERT INTO kunde (Name, Vorname, AdrId ) VALUES ('Mueller', 'Bernd', %d )", id);
    statement.execute( sqlDatensatzAnlegen );
    
   
    sqlDatensatzAnlegen = "INSERT INTO adresse (Plz, Ort ) VALUES ('70000', 'Stuttgart')";
    statement.execute( sqlDatensatzAnlegen );
    id = abfragenAdresseID( con );
    sqlDatensatzAnlegen = String.format( "INSERT INTO kunde (Name, Vorname, AdrId ) VALUES ('Huber', 'Christian', %d )", id);
    statement.execute( sqlDatensatzAnlegen );
    
    
    
    sqlDatensatzAnlegen = "INSERT INTO adresse (Plz, Ort ) VALUES ('10000', 'Berlin')";
    statement.execute( sqlDatensatzAnlegen );
    id = abfragenAdresseID( con );
    sqlDatensatzAnlegen = String.format( "INSERT INTO kunde (Name, Vorname, AdrId ) VALUES ('Mustermann', 'Max', %d )", id);
    statement.execute( sqlDatensatzAnlegen );

    // Ausgabe 
    
    String sqlAusgabeKunde = "SELECT KUNDE.KDID, KUNDE.NAME, ADRESSE.PLZ, ADRESSE.ORT FROM KUNDE, ADRESSE WHERE KUNDE.ADRID=ADRESSE.ADRID";
    
    ResultSet result = statement.executeQuery( sqlAusgabeKunde );
    
    while ( result.next()) {
      
      System.out.printf("Kunde: KdId: %d, Name: %s, Plz: %s, Ort: %s\n", result.getInt( 1 ), result.getString( 2 ), result.getString( 3 ), result.getString( 4 )  );
    }
    
    statement.close();
  }

  
  private static void erstelleMedien() throws ClassNotFoundException, SQLException {
      MedienDb medienDb = new MedienDb();
      OnlineSuche buchSuche = new OnlineSuche("9783836241199");
      OnlineSuche buchSuche2 = new OnlineSuche("9783426511855");
      
      medienDb.loeschenAllerDaten();
      medienDb.speichern( new Medium("Datenbank", 6) );
      medienDb.speichern( new Medium("XML-Datenbank") );
      medienDb.speichern( new Medium("Malen mit Farben", 6) );
      medienDb.speichern( new Medium("Rotkaeppchen", 12) );
      medienDb.speichern( new Medium("Pumuckel", 6) );
      medienDb.speichern( new Medium("Top Gun", 12) );
      medienDb.speichern( new Medium("Meister Eder") );
      medienDb.speichern( new Medium(buchSuche.getBuchEintrag().getTitel()) );
      medienDb.speichern( new Medium(buchSuche2.getBuchEintrag().getTitel()) );
      
      medienDb.ausgabeAllerDaten();
      medienDb.ausgabeAllerMedien( 6 );
      
      DBConnection.getInstance().close();
  }
  
  
  public static void main( String[] args ) {

    try {
      erstelleMedien();
    } catch ( ClassNotFoundException | SQLException e ) {
      e.printStackTrace();
    }
    
    try {
      // 1. Treiber laden
      Class.forName( "org.h2.Driver" );

      // DriverManager.setLogWriter( new PrintWriter( System.out ) );
      // 2. Verbindung zur Datenbank aufbauen
      Connection con = DriverManager.getConnection( "jdbc:h2:./db/Bibi", "Admin", "admin" );

      // erstelleMedien(con);

      erstelleKunden( con );

      // 6. Verbindung schliessen
      con.close();

    } catch ( SQLException | ClassNotFoundException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
