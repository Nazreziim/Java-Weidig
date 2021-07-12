package randomAccess.aufgaben.verzeichnisstruktur;

import java.io.*;

public class DirStructure {
	private static final String FILENAME = "./src/randomAccess/aufgaben/dirstruct.txt";
	
	public static void loescheDateiInhalt(String pfadName){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(pfadName, "rw");
			// Hinweis:
			// Eine Positionsanweisung .seek(0) bewirkt kein Loeschen der Inhalte!
			raf.setLength(0);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		File userdir = new File(System.getProperty("user.dir"));
		//printFiles(userdir,0);
		printFiles(new File("./src"), 0);
		// Aus der Datei lesen und ausgeben:
		System.out.println(readFromFile());
		
		loescheDateiInhalt(FILENAME);
		
		printFilesV2(new File("./src"), 0);
		//Aus der Datei lesen und ausgeben:
		System.out.println(readFromFile());
	}
	
	/**
	 * Aufgabe 1.1: Ausgabe der Verzeichnisstruktur (rekursiv) in eine Datei
	 * @param userdir - Der übergebene Pfad
	 * @param tiefe - Die aktuelle Tiefe (zur Einrückung
	 */
	private static void printFiles(File userdir, int tiefe) {
		File[] files = userdir.listFiles();
		
		for (File f : files) {			
			// Einrückung generieren
			for (int i=0; i < tiefe; i++) {					
				printToFile("\t");
			}
						
			if (f.isDirectory()) {
				printToFile("\\" + f.getName() + "\n");
				printFiles(f, tiefe + 1);   //rekursiver Aufruf
			} else {
				printToFile("-" + f.getName() + "\n" );
			}
		}
		
	}

	/**
	 * Aufgabe 1.2: Sortierte Ausgabe der Verzeichnisstruktur (mit FilenameFilter) 
	 * @param userdir - Der übergebene Pfad
	 * @param tiefe - Die aktuelle Tiefe (zur Einrückung
	 */
	private static void printFilesV2(File userdir, int tiefe) {
		File[] files = userdir.listFiles(new SortedDirStructureFileFilter());
		File[] folders = userdir.listFiles(new SortedDirStructureFolderFilter());
		
		// zuerst Dateien ausgeben:
		for (File f : files) {
			// Einrückung generieren
			for (int i=0; i < tiefe; i++) {
				printToFile("\t");				 
			}							
			printToFile("-" + f.getName() + "\n");
		}
					
		
		// Dann die Ordner ausgeben
		for (File f : folders) {			
			// Einrückung generieren
			for (int i=0; i < tiefe; i++) {
				printToFile("\t");
			}			
			printToFile("\\" + f.getName() + "\n");
			printFilesV2(f, tiefe + 1);
		}
		
	}
	
	/**
	 * Schreibt einen String in eine RandomAccess-Datei
	 * @param string
	 */
	private static void printToFile(String string) {
		File datei = new File(FILENAME);
		
		try {
			RandomAccessFile raf = new RandomAccessFile(datei, "rw");
			raf.seek(raf.length());
			raf.writeUTF(string);
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/** Liest eine RandomAccess-Datei komplett in einen String aus
	 * @return Der Inhalt der Datei als String
	 */
	private static String readFromFile() {
		File datei = new File(FILENAME);
		String string = new String();
		try {
			RandomAccessFile raf = new RandomAccessFile(datei, "r");
			while (raf.getFilePointer() != raf.length()) {
				string += raf.readUTF();
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return string;
		
	}
}
