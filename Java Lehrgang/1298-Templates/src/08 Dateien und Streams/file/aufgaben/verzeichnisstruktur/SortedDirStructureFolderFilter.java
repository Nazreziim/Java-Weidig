package file.aufgaben.verzeichnisstruktur;

import java.io.*;

public class SortedDirStructureFolderFilter implements FilenameFilter {

		public SortedDirStructureFolderFilter() {
		}

		/**
		 * accept(File dir, String name) prüft, ob eine Datei im Verzeichnis dir mit Name name existiert,
		 * die bestimmte Eigenschaften erfüllt.
		 * Hier wird überprüft, ob name ein Verzeichnis ist.
		 * @return true, wenn Eigenschaften zutreffen 
		 */
		public boolean accept(File f, String s) {
			boolean erg;
			// Erstellen eines neuen Datei-Objekts aus den Parametern
			File datei = new File(f.getAbsolutePath() + File.separatorChar + s);
			if (datei.isFile()) {
				erg = false;
			} else {
				erg = true;
			}
			return erg;
		}

	}
