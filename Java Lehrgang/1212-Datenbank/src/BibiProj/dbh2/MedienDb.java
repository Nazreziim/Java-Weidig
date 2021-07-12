package BibiProj.dbh2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedienDb extends DbZugriff{

  public MedienDb() {
     createTable();
  }

  private void createTable() {
    String sqlTabelleAnlegen = "CREATE TABLE IF NOT EXISTS medien (MedId int PRIMARY KEY AUTO_INCREMENT NOT NULL, Name varchar(100), Fsk int DEFAULT 0 CHECK Fsk IN (0,6,12, 18 ) )";
     exec(sqlTabelleAnlegen);
  }

  
  public int getLastID() {
    int id = -1;

    String sqlIdAbfrage = "SELECT MAX(MedId) FROM Medien";

    ResultSet result = execQuery( sqlIdAbfrage );

    try {
      if ( result.next() ) {
        id = result.getInt( 1 );
      }
    } catch ( SQLException e ) {
      e.printStackTrace();
    }

    return id;
  }
  
  public void speichern(Medium medien) {
    
    if ( medien != null ) {
      String sqlDatensatzAnlegen = String.format( "INSERT INTO medien (Name, Fsk) VALUES ('%s', %d)", medien.getName(), medien.getFsk());
      exec(sqlDatensatzAnlegen);
      medien.setId( getLastID() );     
    }
    
  }
  
  public void ausgabeAllerDaten() {
    String sqlInhaltAnzeigen = "SELECT * FROM medien";
    Medium medium = null;

    ResultSet result = execQuery( sqlInhaltAnzeigen );

    try {
      while ( result.next() ) {
        
        // System.out.println( result.toString() );
        int fsk = result.getInt( "Fsk" );
        String name = result.getString( "Name" );
        int medId = result.getInt( "MedId" );
        medium = new Medium( medId, name, fsk );
        
        System.out.println( medium );
      }
    } catch ( SQLException e ) {
      e.printStackTrace();
    }
  }
  
  public void ausgabeAllerMedien(int fsk) {
    String sqlSelectFsk = String.format( "SELECT MEDID, NAME FROM MEDIEN WHERE FSK=%d", fsk );
    Medium medium = null;

    ResultSet result = execQuery( sqlSelectFsk );

    System.out.printf( "Ausgabe alle Fsk = %d Medien\n", fsk );
    
    try {
      while ( result.next() ) {
        // System.out.println( result.toString() );
        String name = result.getString( "Name" );
        int medId = result.getInt( "MedId" );

        medium = new Medium( medId, name, fsk );
        
        System.out.println( medium );
      }
    } catch ( SQLException e ) {
      e.printStackTrace();
    }
  }
  
  public void loeschenAllerDaten() {
    String sqlDatensaetzeLoeschen = "DELETE FROM medien";
    exec( sqlDatensaetzeLoeschen );
  }
  
}
