package aufgaben.dirdb;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;

//TODO: Statments nur einmal anlegen!
public class DirDB {
	// Statische Variablen
	private static int nextdid = 1;
	private static int nextfid = 1;
	
	// Konstanten
	public static final int POPULATE = 1;
	public static final int COUNT = 2;
	public static final int FINDFILE = 3;

	// Variablen
	private int option;
	private String rootDir;

	// DB-Kram
	private final String dbname = "dirs.db"; // Name der SQLite-DB Datei
	private Connection c;
	private Statement stmt;
	
	
	public DirDB(int option, String rootDir) {
		this.option = option;
		this.rootDir = rootDir;
	}

	public void start() {
		switch (option) {
		case POPULATE:
			open();
			createTables();
			populate(rootDir);
			close();
			break;
		case COUNT:
			open();
			int anz = countFiles();
			close();
		}
	}

	/**
	 * Zum Öffnen der DB-Verbindung. Belegt das private Connection-Objekt.
	 */
	private void open() {
		try {
			// MySQL
			/*
			final String hostname = "10.0.26.21"; 
		    final String port = "3306"; 
		    final String dbname = "dirsdb"; 
		    final String user = "usr"; 
		    final String password = "user";
		    Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://"+hostname+":"+port; // +"/"+dbname; 
	 	    c = DriverManager.getConnection(url, user, password); 
	 	    stmt = c.createStatement();
	 	    
	 	    try {
	 	    	stmt.executeUpdate("CREATE DATABASE "+dbname+";");
	 	    } catch (SQLException e) {
	 	    	//Nix
	 	    }
	 	    
	 	    c = DriverManager.getConnection(url + "/" + dbname,user,password);
	 	   stmt = c.createStatement();
	 	   */
	 	   
			// SQLite
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + dbname);
			stmt = c.createStatement();
			
			// Metadaten der Datenbank: ("just for info")
			DatabaseMetaData dmd = c.getMetaData();
			System.out.println("URL: " + dmd.getURL());
			System.out.println("Treiber: " + dmd.getDriverName());
			System.out.println("Version: " + dmd.getDriverVersion());

		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Fehler beim Öffnen der Verbindung: ");
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			c.close();
		} catch (SQLException e) {
			System.err.println("Fehler beim Schliessen der Verbindung: ");
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode legt die Tabellen an. Dazu wird erst ein DROP TABLE und
	 * danach ein CREATE TABLE aufgerufen.
	 */
	private void createTables() {
		String sql;
		// Anlegen der Dir-Tabelle
		try {
			
			try {
				// Wegen der Foreign-Keys in
				sql = "DROP TABLE file;";
				stmt.executeUpdate(sql);
				sql = "DROP TABLE dir;";
				stmt.executeUpdate(sql);				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e){
				//Nix machen!!!
			}
			sql = "CREATE TABLE dir (did INT PRIMARY KEY, dname CHAR(100), fatherid INT, entries INT);";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("Fehler beim Anlegen der dir-Tabelle: ");
			e.printStackTrace();
		}

		// Anlegen der File-Tabelle
		try {
			Statement stmt = c.createStatement();
			try {
				sql = "DROP TABLE file;";
				stmt.executeUpdate(sql);				
			} catch (SQLException e) {
				// Nix machen!
			}
			sql = "CREATE TABLE file (fid INT PRIMARY KEY, did INT, fname CHAR(100), fsize INT, fdate DATE, ftime CHAR(5), FOREIGN KEY (did) REFERENCES dir(did));";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("Fehler beim Anlegne der file-Tabelle");
		}
	}

	/** 
	 * Fügt das Wurzelverzeichnis in die DB ein und ruft rekursiv addDirectory auf.
	 * @param rootDir Das Wurzelverzeichnis
	 */
	private void populate(String rootDir) {
		addDirectory(0,"",rootDir);
	}
	
	private void addDirectory(int fatherid, String parent, String name) {
		// File-Objekt zusammenbauen
		String dname ="";
		if (parent.length() > 0) {
			dname += parent;
			if (!parent.endsWith(File.separator)) {
				dname += File.separator;
			}
		}
		dname += name;
		System.out.println("Verarbeitung Dir: " + dname);
		File dir = new File(dname);
		
		if (dir.isDirectory()) {
			// 1.) Verzeichnis in die dir-Tabelle einfügen
			int did = nextdid++;
			String sql;
			try {				
				sql = "INSERT INTO dir VALUES (" + 
						did + "," + 
						"\'" + name + "\', " +
						fatherid + "," +
						"0)";
				stmt.executeUpdate(sql);				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//2.) Einträge lesen
			File[] files = dir.listFiles();
			if (files != null) {
				for (File f : files) {
					// 2a.) Wenn Eintrag ein Verzeichnis: Rek. Aufruf!
					if (f.isDirectory()) {					
						addDirectory(did,dname,f.getName());
					} 
					
					// 2b.) Wenn Eintrag Datei: Eintrag in file-Tabelle
					if (!f.isDirectory()) {
						
						Date d = new Date(f.lastModified());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");					
						String fdate = sdf.format(d);
						sdf = new SimpleDateFormat("HH-mm");
						String ftime = sdf.format(d);
						int fid = nextfid++;
						System.out.println("Verarbeitung Datei: " + f.getName() + ": Groese:"  + f.length() + ", Date: "+ fdate + ", Time: "+ ftime);
						try {							
							sql = "INSERT INTO file VALUES(" + 
									fid + ", " + 
									did + ", "+
									"\'" + f.getName() + "\'," +
									f.length() + "," + 
									"2013-11-21 , " + //"{d \'" + fdate + "\'},"  +  // "2013-11-21 , " + // d + "," +   
									
									"\'" + ftime + "\');";
							stmt.executeUpdate(sql);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			
				// 3.) Anzahl der Einträge aktualisieren
				try {					
					stmt.executeUpdate("UPDATE dir SET entries = " + files.length + " WHERE did = " + did + ";");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			
			}
			
			
			
			
		}
		
	}
	/**
	 * Zählt die Einträge in dir und file-Tabelle über ein Count-Query
	 * @return Die Anzahl der Einträge in beiden Tabellen
	 */
	private int countFiles() {
		String sql;		
		int erg = 0;
		try {			
			// Anzahl Verzeichnisse:
			sql = "SELECT count(*) FROM dir;";
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				System.out.println("Count: Keine Verzeichnisse gefunden!");
			} else {
				System.out.println("Verzeichnisse: " + rs.getInt(1));
				erg += rs.getInt(1);
			}

			// Anzahl Dateien:
			sql = "SELECT count(*) FROM file;";
			rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				System.out.println("Count: Keine Dateien gefunden!");
			} else {
				System.out.println("Dateien: " + rs.getInt(1));
				erg += rs.getInt(1);
			}
		} catch (SQLException e) {
			System.err.println("Fehler beim Zählen der Datensätze: ");
			e.printStackTrace();
		}
		return erg;
	}

	
	/**
	 * @return the option
	 */
	public int getOption() {
		return option;
	}

	/**
	 * @param option
	 *            the option to set
	 */
	public void setOption(int option) {
		this.option = option;
	}


	/**
	 * @return the rootDir
	 */
	public String getRootDir() {
		return rootDir;
	}

	/**
	 * @param rootDir the rootDir to set
	 */
	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	
	public static void main(String[] args) {
		DirDB dirdb = new DirDB(POPULATE, "D:/");
		dirdb.start();
		dirdb.setOption(dirdb.COUNT);
		dirdb.start();
		
	}
}
