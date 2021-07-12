package h2.beispiel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VerbindungsAufbau {
  public static void main( String... args ) {
    try {
      Class.forName( "org.h2.Driver" );
      Connection conn = DriverManager.getConnection( "jdbc:h2:./test", "sa", "" );
      
      
      conn.close();
    } catch ( SQLException e ) {
      e.printStackTrace();
    } catch ( ClassNotFoundException e1 ) {
      e1.printStackTrace();
    }
  }
}
