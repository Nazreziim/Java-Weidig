package randomAccess.aufgaben.verzeichnisstruktur;

import java.io.*;

public class SortedDirStructureFolderFilter implements FileFilter {

		public SortedDirStructureFolderFilter() {
		}

		/**
		 * accept(File dir) prüft, ob es sich um ein Verzeichnis handelt.
		 * @return true, wenn es sich um ein Verzeichnis handelt
		 */
		public boolean accept(File dir) {
			
			return dir.isDirectory();
		}

	}
