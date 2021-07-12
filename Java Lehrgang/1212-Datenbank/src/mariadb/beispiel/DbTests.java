package mariadb.beispiel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Enumeration;

public class DbTests {

  public static void main( String[] args ) {

    System.out.println( "DB-Treiber:" );
    Enumeration< Driver > drivers = DriverManager.getDrivers();
    while ( drivers.hasMoreElements() ) {
      System.out.println( drivers.nextElement() );
    }
    System.out.println( "---" );

    final String DB_USER = "b-ix-59-02";
    final String DB_PASS = "b-ix-59-02";
    final String DB = "b-ix-59-02";
    final String DRIVER = "jdbc:mariadb";
    final String SERVER = "fea12a-008wd01";

    try {
      // Connection connection = DriverManager.getConnection( //
      // DRIVER + "://" + SERVER + "/" + DB + "?user=" + DB_USER + "&password=" + DB_PASS //
      // );
      Connection connection = DriverManager.getConnection( //
              DRIVER + "://" + SERVER + "/" + DB, //
              DB_USER, //
              DB_PASS //
      );

      System.out.println( connection );

      Statement statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );

      // System.out.println( "Sichtbare Datenbanken: " );
      // String sql = "show databases;";

      // String sql = "show tables;";

      String[] sql = { "CREATE TABLE IF NOT EXISTS persons ( " //
              + "id INT PRIMARY KEY AUTO_INCREMENT, " //
              + "name VARCHAR(50) NOT NULL , " //
              + "vorname VARCHAR(50) NOT NULL , " //
              + "geburtsdatum DATE NOT NULL"//
              + ");", //
              "INSERT INTO persons ( NAME, VORNAME, GEBURTSDATUM ) VALUES ( 'Mönch', 'Kim', {d '2019-12-09' } ) ;",
              "INSERT INTO persons ( NAME, VORNAME, GEBURTSDATUM ) VALUES ( 'Beuse', 'Paul', {d '2019-12-09' } ) ;",
              "INSERT INTO persons ( NAME, VORNAME, GEBURTSDATUM ) VALUES ( 'Köster', 'Max', {d '2019-12-09' } ) ;",
              "INSERT INTO persons ( NAME, VORNAME, GEBURTSDATUM ) VALUES ( 'Svoboda', 'Kai', {d '2019-12-09' } ) ;",
              "INSERT INTO persons ( NAME, VORNAME, GEBURTSDATUM ) VALUES ( 'Traber', 'Andrea', {d '2019-12-09' } ) ;",
              "INSERT INTO persons ( NAME, VORNAME, GEBURTSDATUM ) VALUES ( 'Erol', 'Hakan', {d '2019-12-09' } ) ;",
              "SELECT * FROM persons;", //
              "UPDATE persons SET NAME = 'Mustermann', VORNAME = 'Max' WHERE ID ='6';", //
              "SELECT * FROM persons;", //
              "DELETE FROM persons WHERE id = '6';", //
              "SELECT * FROM persons ORDER BY name ASC;", //
              "DROP TABLE persons" };

      for ( String s : sql ) {

        statement.execute( s );
        ResultSet resultSet = statement.getResultSet();

        // Beim hinzufügen gibt es kein ResultSet für das Ergebnis.
        if ( resultSet != null ) {

          // ResultSet updaten.
          resultSet.absolute( 2 );
          resultSet.updateInt( 1, 7 );
          resultSet.updateString( 2, "Test" );
          resultSet.updateString( 3, "TestVorname" );
          resultSet.updateDate( 4, Date.valueOf( LocalDate.of( 1990, 05, 01 ) ) );
          resultSet.updateRow();

          // ResultSet insert.
          // resultSet.moveToInsertRow();
          // resultSet.updateString( 2, "Beuse" );
          // resultSet.updateString( 3, "Paul" );
          // resultSet.updateDate( 4, Date.valueOf( LocalDate.now() ) );
          // resultSet.insertRow();

          resultSet.beforeFirst();
          ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
          int spaltenAnzahl = resultSetMetaData.getColumnCount();
          for ( int i = 1; i <= resultSetMetaData.getColumnCount(); ++i ) {
            System.out.print( resultSetMetaData.getColumnName( i ) + ", " );
          }
          System.out.println();
          while ( resultSet.next() ) {
            for ( int i = 1; i <= spaltenAnzahl; ++i ) {
              System.out.print( resultSet.getString( i ) + ", " );
            }
            System.out.println();
          }
        }
      }

      connection.close();

    } catch ( SQLException e ) {
      System.err.println( "SQLState: " + e.getSQLState() );
      System.err.println( "Error Code: " + e.getErrorCode() );
      System.err.println( "Message: " + e.getMessage() );
      System.err.println( "Cause: " + e.getCause() );
    }

  }

}
