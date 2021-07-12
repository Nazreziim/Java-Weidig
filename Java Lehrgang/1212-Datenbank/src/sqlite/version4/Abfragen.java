package sqlite.version4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Abfragen {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:./db/test.sqlite");			
			System.out.println("Verbindung aufgebaut!");
			Statement stmt = conn.createStatement();
			
			// 2.) UPDATE-Statement
			String sql = "UPDATE Firma SET  Umsatz = 10.01 WHERE id = 1;";
			stmt.executeUpdate(sql);
			
			// 1.) SELECT-Statement
			 sql = "SELECT * FROM Firma;";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("Name");
				String adresse = rs.getString("Adresse");
				float umsatz = rs.getFloat("Umsatz");
				
				System.out.println("ID : " + id + ", Name: " + name + ", Adr.: " + adresse + ", Umsatz: " + umsatz);
			}
			
			
			
			
			// Aufräumen
			rs.close();
			stmt.close();
			conn.close();
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
