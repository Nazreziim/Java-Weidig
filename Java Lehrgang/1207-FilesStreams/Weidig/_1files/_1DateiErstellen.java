package _1files;

import java.io.File;
import java.io.IOException;

public class _1DateiErstellen {
	public static void main(String[] args) {
		/* 1.) Dateien / Files */
		/* 1.1.) Wo befinde ich mich gerade? */

		// Erzeugt leeres File Objekt mit Bezug auf das aktuelle Projektverzeichnis
		File hierBinIch = new File("");

		// Gibt das Verzeichnis der Datei aus [komplett ab der Festplatte beginnend]
		System.out.println(hierBinIch.getAbsolutePath());

		/* 1.2.) Datei erstellen */

		/* 1.2.1) Pfadangaben */
		// Neues Fileobjekt erstellen -> String = Pfadangabe
		// Absolute Pfadangabe
		File datei = new File("D:" + File.separatorChar
				+ "Entwicklung\\repo/Java-2021_Weidig\\Java Lehrgang/1207-FilesStreams/Weidig/dateien/UnsereErsteDatei.txt");
		// --> Seperatoren wie angegeben m�glich
		System.out.println(datei.getAbsolutePath());

		// Relative Pfadangabe
		File datei2 = new File("../1207-FilesStreams/Weidig/dateien/UnsereZweiteDatei.txt");
		// .getPath gibt den Pfad wie er im File Objekt angegeben ist aus
		// .. <- springt in den Verzeichnissen zur�ck
		System.out.println(datei2.getPath());

		/* 1.2.2) Datei erzeugen */
		// M�chte ExceptionHandling [Methode createNewFile f�r Exceptiosn angucken]
		try {
			// Wird immer ausgef�hrt aber gibt false zur�ck falls Datei schon vorhanden
			// --> Programm starten --> Nochmal starten
			System.out.println("Datei2 erzeugt?: " + datei2.createNewFile());
			System.out.println("Datei erzeugt?: " + datei.createNewFile());
		} catch (IOException e) {
			// TRITT EIN WENN DER ANGEGEBENE PFAD NICHT GEFUNDEN WERDEN KANN
			e.printStackTrace();
		}

		/* 1.3. N�tzliche Methoden */

		System.out.println("Dateil�nge Datei: " + datei2.length()); // 0 --> Ausgabe der Datei-L�nge
		System.out.println("Datei2 vorhanden? " + datei2.exists()); // true --> Ja ist vorhanden [da oben erstellt]
		System.out.println("Oberverzeichnis: " + datei2.getParent()); // Gibt das OBERVerzeichnis zur�ck
		System.out.println("Jetzt schreibgesch�tzt?: " + datei2.setReadOnly()); // Gibt true sobald es ausgef�hrt werden konnte
		System.out.println("Ist die Datei beschreibbar?: " + datei2.canWrite()); // true wenn beschreibbar
		System.out.println("Ist die Datei lesbar?: " + datei2.canRead()); // true wenn lesbar
		System.out.println("Ist die Datei ausf�hrbar?: " + datei2.canExecute()); // true wenn ausf�hrbar
		
		// L�SCHEN:
		System.out.println("Datei2 gel�scht?: " + datei2.delete());
		System.out.println("Datei gel�scht?: " + datei.delete());

	}
}
