package sqlite.version2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelleErstellen {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");			
			System.out.println("Verbindung aufgebaut!");
			
			// 1.) SQL-String
			String sql = "CREATE TABLE Firma (id INT PRIMARY KEY, Name TEXT, Adresse CHAR(50), Umsatz REAL);";
			
			// 2.) Statement-Objekt erzeugen
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			// 3.) Aufräumen
			stmt.close();
			conn.close();
					
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
