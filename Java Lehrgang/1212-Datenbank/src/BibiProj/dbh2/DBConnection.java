package BibiProj.dbh2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private Statement stmt;
	private Connection con;
	
	private static DBConnection instance = null;
	public static synchronized DBConnection getInstance() throws SQLException, ClassNotFoundException  {
		if (instance == null) instance = new DBConnection();
		return instance;
	}
	
	private DBConnection() throws SQLException, ClassNotFoundException  {
	  // 1. Treiber laden
      Class.forName( "org.h2.Driver" );

      // DriverManager.setLogWriter( new PrintWriter( System.out ) );
      // 2. Verbindung zur Datenbank aufbauen
      con = DriverManager.getConnection( "jdbc:h2:./db/Bibi", "Admin", "admin" );
	}
	
	public void execute(String sql) throws SQLException  {
		stmt = con.createStatement();
		stmt.execute(sql);
		stmt.close();
	}
	
	public ResultSet executeQuery(String sql) throws SQLException  {
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	public void close() throws SQLException {
	   if ( con != null ) {
	     this.con.close();
	   }
	}
}
