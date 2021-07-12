package BibiProj.dbh2;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DbZugriff {

  protected void exec( String sql ) {

    DBConnection con;
    try {
      // Ausgabe der erstellten SQL-Anweisungen
      System.out.println( sql );
      con = DBConnection.getInstance();
      con.execute( sql );
    } catch ( ClassNotFoundException | SQLException e ) {
      e.printStackTrace();
    }
  }

  protected ResultSet execQuery( String sql ) {

    DBConnection con;
    ResultSet result = null;
    try {

      // System.out.println(sql);
      con = DBConnection.getInstance();
      result = con.executeQuery( sql );

    } catch ( ClassNotFoundException | SQLException e ) {
      e.printStackTrace();
    }
    return result;

  }

  public abstract void loeschenAllerDaten();

  public abstract void ausgabeAllerDaten();

  public abstract int getLastID();
}
