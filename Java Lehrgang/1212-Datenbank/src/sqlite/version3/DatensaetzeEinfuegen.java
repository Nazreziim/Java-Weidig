package sqlite.version3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatensaetzeEinfuegen {

	public static void main(String[] args) {
		//Voraussetzung: Tabelle existiert!
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:./db/test.sqlite");			
			System.out.println("Verbindung aufgebaut!");
			
			// SQL-String für INSERT
			Statement stmt = conn.createStatement();
			
      String sql = "INSERT INTO Firma (id, Name, Adresse, Umsatz) VALUES (1, \'Apple\', \'Kupertito\', 12345.67);";
      stmt.executeUpdate( sql );
      sql = "INSERT INTO Firma (id, Name, Adresse, Umsatz) VALUES (2, '\'Google\'', \'California\', 234545.67);";
      stmt.executeUpdate( sql );
      sql = "INSERT INTO Firma (id, Name, Adresse, Umsatz) VALUES (3, 'Microsoft', 'Silicon Valley', 341235.68);";
      stmt.executeUpdate( sql );
      sql = "INSERT INTO Firma (id, Name, Adresse, Umsatz) VALUES (4, 'Cisco', 'Auch in Amerika', 323895.68);";
      stmt.executeUpdate( sql );
			
			// Aufräumen
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
