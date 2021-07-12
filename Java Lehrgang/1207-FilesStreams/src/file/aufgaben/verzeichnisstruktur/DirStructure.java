package file.aufgaben.verzeichnisstruktur;

import java.io.*;

public class DirStructure {

	public DirStructure() {
	}

	public static void main(String[] args) {
		File userdir = new File(System.getProperty("user.dir"));
		printFiles(userdir);
		//printFiles(new File("./src"),0);
		//printFilesV2(new File("./src"), 0);
	}
	
	/**
	 * Aufgabe 1: Ausgabe der Verzeichnisstruktur (rekursiv)
	 * @param userdir - Der übergebene Pfad
	 */
	private static void printFiles(File userdir) {
		printFiles(userdir, 0);
	}
	
	/**
	 * Aufgabe 1: Ausgabe der Verzeichnisstruktur (rekursiv)
	 * @param userdir - Der übergebene Pfad
	 * @param tiefe - Die aktuelle Tiefe (zur Einrückung)
	 */
	private static void printFiles(File userdir, int tiefe) {
		File[] files = userdir.listFiles();
		for (File f : files) {
			
			// Einrückung generieren
			for (int i=0; i < tiefe; i++) {
				System.out.print("\t");
			}
						
			if (f.isDirectory()) {
				System.out.println("\\" + f.getName() );
				printFiles(f, tiefe + 1);   //rekursiver Aufruf
			} else {
				System.out.println("-" + f.getName() );
			}
		}
		
	}

	/**
	 * Aufgabe 2: Sortierte Ausgabe der Verzeichnisstruktur (mit FileFilter) 
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
				System.out.print("\t");				 
			}							
			System.out.println("-" + f.getName());
		}
					
		
		// Dann die Ordner ausgeben
		for (File f : folders) {			
			// Einrückung generieren
			for (int i=0; i < tiefe; i++) {
				System.out.print("\t");
			}			
			System.out.println("\\" + f.getName());
			printFilesV2(f, tiefe + 1);
		}
		
	}
}
