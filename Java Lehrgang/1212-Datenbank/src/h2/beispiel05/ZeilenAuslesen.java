package h2.beispiel05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZeilenAuslesen {
  public static void main( String... args ) {
    try {

      // Treiber laden
      Class.forName( "org.h2.Driver" );

      // Verbindung aufbauen ( Datenbank, User, Passwort )
      // sollte die Datenbank nicht existieren wird eine erstellt.
      Connection conn = DriverManager.getConnection( "jdbc:h2:./db/test", "B_IX_60_00", "P@ssw0rd" );

      // Statement Objekt erstellen (auf diesem können dann SQL statements ausgeführt werden)
      Statement statement = conn.createStatement();
      
      // Zeilen suchen (Die Zeilen werden nur im ResultSet zusammengefasst,
      // zwischen der Zeile im ResultSet und der DB besteht weiterhin eine Verbindung)
      ResultSet result = statement.executeQuery( "SELECT * FROM MESSAGES" );
      while ( result.next() ) {
        System.out.println( result.toString() );
        System.out.println( result.getInt( 1 ) );
        System.out.println( result.getString( 2 ) );
        System.out.println( result.getString( 3 ) );
      }

      // Statement schließen
      statement.close();
      // Verbindung schließen
      conn.close();

    } catch ( SQLException e ) {
      e.printStackTrace();
    } catch ( ClassNotFoundException e1 ) {
      e1.printStackTrace();
    }
  }
}
