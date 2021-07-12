package file.aufgaben.verzeichnisstruktur;

import java.io.*;

public class DirStructure {

	public DirStructure() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		File userdir = new File(System.getProperty("user.dir"));
		printFilesV2(userdir,0);
		

	}
	
	/**
	 * Aufgabe 1: Ausgabe der Verzeichnisstruktur (rekursiv)
	 * @param userdir - Der �bergebene Pfad
	 * @param tiefe - Die aktuelle Tiefe (zur Einr�ckung
	 */
	private static void printFiles(File userdir, int tiefe) {
		File[] files = userdir.listFiles();
		for (File f : files) {
			
			// Einr�ckung generieren
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
	 * Aufgabe 2: Sortierte Ausgabe der Verzeichnisstruktur (mit FilenameFilter) 
	 * @param userdir - Der �bergebene Pfad
	 * @param tiefe - Die aktuelle Tiefe (zur Einr�ckung
	 */
	private static void printFilesV2(File userdir, int tiefe) {
		File[] files = userdir.listFiles(new SortedDirStructureFileFilter());
		File[] folders = userdir.listFiles(new SortedDirStructureFolderFilter());
		
		// zuerst Dateien ausgeben:
		for (File f : files) {
			// Einr�ckung generieren
			for (int i=0; i < tiefe; i++) {
				System.out.print("\t");				 
			}							
			System.out.println("-" + f.getName());
		}
					
		
		// Dann die Ordner ausgeben
		for (File f : folders) {			
			// Einr�ckung generieren
			for (int i=0; i < tiefe; i++) {
				System.out.print("\t");
			}			
			System.out.println("\\" + f.getName());
			printFilesV2(f, tiefe + 1);
		}
		
	}
}
