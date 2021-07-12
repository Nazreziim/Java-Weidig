package mariadb.p1connect;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class MariaDbMain {

  private final static String USERNAME = "b-ix-59";
  private final static String PASSWORD = "b-ix-59";

  private final static String DB = "b-ix-59";
  private final static String SERVER_STRING = "jdbc:mariadb://127.0.0.1:3306/";

  public static void main( String[] args ) {

    Enumeration< Driver > tmp = DriverManager.getDrivers();
    while ( tmp.hasMoreElements() ) {
      System.out.println( tmp.nextElement() );
    }

    try {
      Connection connection = DriverManager.getConnection( //
              SERVER_STRING + DB + "?user=" + USERNAME + "&password=" + PASSWORD );

      Statement statement = connection.createStatement();
      String sql = "show databases;";
      statement.execute( sql );
      ResultSet resultSet = statement.getResultSet();
      while ( resultSet.next() ) {
        System.out.println( resultSet.getString( 1 ) );
      }

      connection.close();
    } catch ( SQLException e ) {
      e.printStackTrace();
    }

  }

}
