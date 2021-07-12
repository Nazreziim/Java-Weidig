package h2.beispiel03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ZeilenEinfuegen {
  public static void main( String... args ) {
    try {

      // Treiber laden
      Class.forName( "org.h2.Driver" );

      // Verbindung aufbauen ( Datenbank, User, Passwort )
      // sollte die Datenbank nicht existieren wird eine erstellt.
      Connection adminConn = DriverManager.getConnection( "jdbc:h2:./db/test", "DBAdmin", "P@ssw0rd" );

      // Statement Objekt erstellen (auf diesem k�nnen dann SQL statements ausgef�hrt werden)
      Statement statement = adminConn.createStatement();

      // Zeile in DB einf�gen.
      statement.execute( "INSERT INTO MESSAGES (AUTOR, CONTENT) VALUES( 'Trump', 'America First!')" );
      statement.execute( "INSERT INTO MESSAGES (AUTOR, CONTENT) VALUES( 'Macron', 'France Last.')" );
      statement.execute( "INSERT INTO MESSAGES (AUTOR, CONTENT) VALUES( 'May', 'Fuck EU!')" );
      statement.execute( "INSERT INTO MESSAGES (AUTOR, CONTENT) VALUES( 'Kim Jong-un', 'I kill you all.')" );

      // Statement schlie�en
      statement.close();
      // Verbindung schlie�en
      adminConn.close();
      
    } catch ( SQLException e ) {
      e.printStackTrace();
    } catch ( ClassNotFoundException e1 ) {
      e1.printStackTrace();
    }
  }
}
