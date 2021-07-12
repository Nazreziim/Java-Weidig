package h2.beispiel05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NutzerAnlegen {
  public static void main( String... args ) {
    try {

      // Treiber laden
      Class.forName( "org.h2.Driver" );

      // Verbindung aufbauen ( Datenbank, User, Passwort )
      // sollte die Datenbank nicht existieren wird eine erstellt.
      Connection adminConn = DriverManager.getConnection( "jdbc:h2:./db/test", "DBAdmin", "P@ssw0rd" );

      // Statement Objekt erstellen (auf diesem können dann SQL statements ausgeführt werden)
      Statement statement = adminConn.createStatement();

      // Nutzer anlegen
      statement.execute( "CREATE USER B_IX_60_00 PASSWORD 'P@ssw0rd'" );

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
