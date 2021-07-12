package _1files;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class _2OrdnerErstellen {
	public static void main(String[] args) {
		/* 1.) Verzeichnisse / Ordner */

		/* 1.1.) Erzeugung */
		System.out.println("\n----- Ordner erzeugen -----\n");
		// Annahme: Ordner und Dateien sind ERSTMAL das gleiche: Ein FileObjekt mit
		// einer Pfadangabe
		File ordner = new File("Weidig\\dateien\\Der Neue Ordner"); // Auch Leerzeichen möglich

		System.out.println(ordner.getAbsolutePath());

		// Exceptionmöglichkeiten von .mkdir anschauen
		System.out.println("Ordner erstellt?: " + ordner.mkdir());
		System.out.println("Ist die File existent?: " + ordner.exists());
		System.out.println("Ist es auch wirkliche ein Ordner?: " + ordner.isDirectory());

		/* 1.2.) Nützliche Methoden */
		System.out.println("\n----- Nützliche Methoden -----\n");
		// EINFACH MAL 10 DATEIEN ERSTELLEN
		for (int i = 1; i <= 10; i++) {
			File tmpNew = new File(ordner.getAbsolutePath() + "/DateiNr." + i + ".txt");
			try {
				tmpNew.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// UND einen Ordner im Ordner
		File newOrdner = new File(ordner.getAbsolutePath() + "/Ordner1");
		newOrdner.mkdir();

		/*
		 * Speichert alle Pfadangaben der Unterdateien (Ordner UND Dateien) von ordner
		 * als FileObjekt in einem Array
		 */
		System.err.println("\n- ungefiltert -");
		File[] files = ordner.listFiles();
		for (File f : files) {
			// Man beachte die Sortierung
			System.out.println(f.getName());
		}
		
		System.err.println("\n- gefiltert -");
		File[] gefiltert = ordner.listFiles(new EndungsFileFilter(".txt"));
		for (File f : gefiltert) {
			// Man beachte die Sortierung
			System.out.println(f.getName());
		}
		
		// Gibt die Menge an Dateien und Ordnern aus in diesem Fall
		System.out.println("\nMenge an Dateien und Ordnern: " + files.length);

		/* 1.3. Ordner löschen */
		System.out.println("\n----- Ordner löschen -----\n");
		// FUNKTIONIERT NICHT, da der Ordner leer sein muss
		System.out.println("Ordner gelöscht?: " + ordner.delete());

		// Alle Inhalte löschen
		for (File f : files) {
			System.out.println(f.getName() + " erfolgreich gelöscht?: " + f.delete());
		}

		// das Files Array mit den JETZT vorhandenen Dateien aktualisieren, da diese
		// nicht automatisch aus dem Array entfernt werden
		files = ordner.listFiles();
		System.out.println("Ordner leer?: " + (files.length == 0));
		System.out.println("Ordner gelöscht?: " + ordner.delete());

		/* 1.4. Verzeichnisstruktur anlegen */
		System.out.println("\n----- Verzeichnisstruktur -----\n");

		File ordnerStruktur = new File("Weidig/dateien/Hauptordner/Unterordner/Unterunterordner");
		System.out.println("Struktur erfolgreich erstellt?: " + ordnerStruktur.mkdirs());

		// Struktur löschen ist NICHT so einfach möglich, da Struktur = EIN Fileobjekt
		// System.out.println(ordnerStruktur.getName() + " erfolgreich gelöscht?: " +
		// ordnerStruktur.delete());
		// Löscht nämlich nur den äußerst rechten Ordner des Strings

		// ACHTUNG: Hier sieht man sehr schön, dass es immer den Überordner nutzt ABER
		// selbstverständlich dann auch alles löscht was leer ist
		while (ordnerStruktur.delete()) {
			ordnerStruktur = ordnerStruktur.getParentFile();
			System.out.println("Neuer Hauptordner: " + ordnerStruktur.getName());
		}

		// ZWINGEND NOTWENDIG BEI DIESEM VERFAHREN
		File reset = new File("Weidig/dateien/");
		reset.mkdir();

	}

}

class EndungsFileFilter implements FilenameFilter {
	private String ending;

	public EndungsFileFilter(String ending) {
		super();
		this.ending = ending;
	}

	@Override
	/**
	 * Testet, ob die Datei name im Verzeichnis dir in die Liste aufgenommen wird
	 * 
	 * @param dir  - Verzeichnis
	 * @param name - Dateiname
	 */
	public boolean accept(File dir, String name) {
		return name.endsWith(ending);

	}

}
