package sqlite.version1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatenbankErstellen {

	public static void main(String[] args) {
		try {
			// 1.) DB-Treiber in die Virtuelle Maschine laden
			Class.forName("org.sqlite.JDBC");
			
			// 2.) Verbindung zur DB aufbauen: Protokoll:Subprotokoll:Treiberspezifisch
			Connection conn = DriverManager.getConnection("jdbc:sqlite:./db/test.sqlite");
			
			System.out.println("Verbindung aufgebaut!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
