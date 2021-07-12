package file;

import java.io.*;
import java.util.*;

public class FileTest {

	public static void dateiModus(File file){
		
		// Pfad- und Dateiangaben
		System.out.println("Dateiname: " + file.getName());
		System.out.println("Dateipfad: " + file.getPath());
		System.out.println("absoluter DateipfadUndName: " + file.getAbsolutePath());
		
		// Datei- und Verzeichnisinformationen
		System.out.println("Verzeichnis? " +  file.isDirectory());
		System.out.println("Datei? " +  file.isFile());
		
		System.out.println("In welchem Modus wird die Datei geoeffnet?");
		System.out.println("===========================================");
		System.out.println("Schreibmodus: " + file.canWrite());
		System.out.println("Lesemodus: " + file.canRead());
		System.out.println("Ausfuehrbar: " + file.canExecute());
		
		System.out.println();
	}
	
	
	public static boolean istDateiErzeugt(File file){
		boolean erzeugt = false;

		System.out.printf("pruefe, ob Datei: %s schon existiert? %b\n" , file.getName(),  file.exists());		
		
		if (!file.exists()) {
			try {
				erzeugt = file.createNewFile();
			} catch (IOException e) {
				// schreiben auf Standard-Ausgabe
				System.out.println("==> Fehler: Datei/Verzeichnis konnte nicht angelegt werden!");
				// schreiben in Fehler-Ausgabe
				// e.printStackTrace();
			}
		}
		
		System.out.println("Wurde die Datei erfolgreich angelegt? " + erzeugt);
		System.out.println("Pfad und Name der Datei: " + file.getAbsolutePath());
		System.out.printf("pruefe, ob Datei: %s jetzt existiert? %b\n" , file.getName(),  file.exists());	
		System.out.println();
		
		return erzeugt;
	}
	
	public static boolean istOrdnerGeloescht(File ordner){
		boolean geloescht = false;
		
		if (ordner.isDirectory()){
			
			System.out.printf("pruefe, ob Ordner: %s existiert? %b\n" , ordner.getName(), ordner.exists());
		
			if ( ordner.exists()){
				geloescht = ordner.delete();
			}
			else
			{
				System.out.printf("Ordner: %s existiert nicht!\n", ordner.getAbsolutePath());
			}
		}
		else{
			System.out.println("Es handelt sich um keinen Ordner");
		}
		
		System.out.println();
		
		return geloescht;
	}
	
	public static boolean istOrdnerLeer(File ordner){
		boolean istLeer = false;
		File[] contents =  null;
		
		if (ordner.isDirectory()){
			
			System.out.printf("pruefe, ob Ordner: %s existiert? %b\n" , ordner.getName(), ordner.exists());
		
			if ( ordner.exists()){
				contents =  ordner.listFiles();
				istLeer = contents.length == 0;
			}
			else
			{
				System.out.printf("Ordner: %s existiert nicht!\n", ordner.getAbsolutePath());
			}
		}
		else{
			System.out.println("Es handelt sich um keinen Ordner");
		}
		
		System.out.println();
		
		
		return istLeer;
	}
	
	public static void entferneDateienAusOrdner(File ordner){
		File[] contents =  null;
		
		if (! istOrdnerLeer(ordner)){
			System.out.printf("pruefe Ordner: %s nach beinhalteten Dateien\n" , ordner.getName());
			
			contents = ordner.listFiles();
			for(File file : contents){
				if (file.isFile()){
					
					if ( file.delete() ){
						System.out.printf("-> Datei: %s wuerde geloescht.\n", file.getName());
					}
					
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 1.) File als Datei
		// relative Pfadangabe, bezogen auf Projekt-Verzeichnis
		File datei = new File("test.txt");			
		
		istDateiErzeugt(datei);
		
		Date datum = new Date(datei.lastModified());		
		
		System.out.println("Modifizierungs-Datum: " + datum);
		System.out.println("Dateigroesse in Byte: " + datei.length());
		
		dateiModus(datei);
		
		System.out.println("Dateimodi aendern");
		datei.setReadOnly();	
		
		dateiModus(datei);
		
		datei.delete();
		
		
		System.out.println();
		
		// Datei in einem noch nicht existierendem Ordner anlegen!
		File datei1 = new File("./08 Dateien und Streams/ordner1/test.txt");
		
		System.out.println("Konnte die Datei angelegt werden? " + istDateiErzeugt(datei1));
		System.out.println();
		
		/**************************************************************************************/
		System.out.println("----------------------------------------------------------");
		System.out.println();
		
		// 2.) File als Ordner
		// relative Pfadangabe
		File ordner = new File("./08 Dateien und Streams/ordner1");
		// anlegen eines Ordners
		ordner.mkdir();
		
		System.out.println("Ist ordner1 ein Ordner? "  + ordner.isDirectory());
		System.out.println("Ist text.txt ein Ordner? " + datei.isDirectory());
		System.out.println();
		
		// Datei in einem existierenden Ordner anlegen!
		istDateiErzeugt(datei1);
		
		
		
		// loeschen von Ordnern mit beinhalteten Dateien
		System.out.println("Wurde Ordner geloescht? " + istOrdnerGeloescht(ordner));
		
		System.out.println("Ist Ordner leer? " + istOrdnerLeer(ordner));
		
		entferneDateienAusOrdner(ordner);
		
		System.out.println("Wurde Ordner geloescht? " + istOrdnerGeloescht(ordner));
		System.out.println();
		
		
		/***********************************************************************************/
		
		ordner = new File("./");
		File[] contents =  ordner.listFiles();
		
		
		for (int i=0; i<contents.length; i++) {
			System.out.println(contents[i]);
			//System.out.println(contents[i].getName());
		}
		
		
//		File[] roots = File.listRoots();
//		for (File i : roots) {
//			System.out.println(i);
//		}
//		
//		JavaFileFilter filter = new JavaFileFilter(".java");
//		contents = ordner.listFiles(filter);
//		for (int i=0; i<contents.length; i++) {
//			System.out.println(contents[i].getName());
//		}
//		
//		filter = new JavaFileFilter(".txt");
//		contents = ordner.listFiles(filter);
//		for (int i=0; i<contents.length; i++) {
//			System.out.println(contents[i].getName());
//		}
		
	}

}
