package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnTest {

	public static void main(String[] args) {
		// Konstanten für den Verbindungsaufbau
		final String hostname = "10.0.26.21";
		final String port = "3306";
		final String dbname = "test";		
		final String user = "usr";
		final String password = "user";
		
		// 1.) Treiber Laden
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Fehler beim Laden des Treibers: ");
			e.printStackTrace();
		}
		
		
		// 2.) Connection erstellen
		String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Verbindung steht!");			
			System.out.println("DB-Treiber: " + conn.getMetaData().getDriverName());
			System.out.println("Benutzer: "+conn.getMetaData().getUserName());
			
			Statement stmt = conn.createStatement();
			try  {
			stmt.executeUpdate("CREATE DATABASE larsdb;");
			} catch (SQLException e){
				// NICHTS TUN!
				
			}
			
			// Aufräumen
			stmt.close();
			conn.close();
			
			// Quick and Dirty!
			conn = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/larsdb",user, password);
			
			
			
			
		} catch (SQLException e) {
			System.err.println("Fehler beim Verbindungsaufbau: ");
			e.printStackTrace();
		}
		
		

	}

}
