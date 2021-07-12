package file.aufgaben.verzeichnisstruktur;

import java.io.File;
import java.io.FilenameFilter;

public class SortedDirStructureFileFilter implements FilenameFilter {

	public SortedDirStructureFileFilter() {
	}

	/**
	 * accept(File dir, String name) prüft, ob eine Datei im Verzeichnis dir mit Name name existiert,
	 * die bestimmte Eigenschaften erfüllt.
	 * Hier wird überprüft, ob name eine Datei ist.
	 * @return true, wenn Eigenschaften zutreffen 
	 */
	public boolean accept(File f, String s) {
		boolean erg;
		// Erstellen eines neuen Datei-Objekts aus den Parametern
		File datei = new File(f.getAbsolutePath() + File.separatorChar + s);
		
		if (datei.isFile()) {			
			erg = true;
		} else {
			erg = false;
		}
		return erg;
	}

}
