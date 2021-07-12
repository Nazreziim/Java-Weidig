package unterricht;

import java.io.File;
import java.io.IOException;

public class FileMain {

	public static void main(String[] args)  {
		
		// 1.) File-Objekte für Dateien
		// ----------------------------
		// Absolute Pfadangabe
		File datei = new File("D:"+ File.separatorChar + "WorkspaceJava/zweite_datei.txt");
		// Relative Pfadangabe
		File datei2 = new File("./08 Dateien und Streams/unterricht/dritte_datei.txt");
		
		// Neue Dateien erstellen - wenn sie noch nicht physisch existieren
		if (!datei2.exists()){ 
			try {
				//datei.createNewFile();
				datei2.createNewFile();
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}
		
		// Andere interessante Methoden in File:
		System.out.println(datei2.length());  // Ausgabe der Datei-Länge
		System.out.println(datei2.exists());  // true, wenn Datei (physisch) existiert
		System.out.println(datei2.getParent());
		datei2.setReadOnly();  // Datei ist jetzt schreibgeschützt
		
		// Dateien löschen
		datei.delete();
		//datei2.delete();
			
		System.out.println(datei2.exists());  // true, wenn Datei (physisch) existiert
		
		
		// 2.) File-Objekte für Verzeichnisse / Ordner
		// -------------------------------------------
		File ordner = new File(datei2.getParent() + "/ordner1");
		
		// Ordner physisch erstellen
		try {
			ordner.mkdir();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(ordner.isDirectory());
		File[] files = ordner.listFiles();  // liefert alle Dateien und Unterordner (= File) in dem Ordner zurück
		
		EndungsFileFilter tff = new EndungsFileFilter(".java");
		files = ordner.listFiles(tff);
		System.out.println(files.length);  // liefert die Anzahl der Textdateien in ordner
		
		
	}

}
