package randomAccess.aufgaben.verzeichnisstruktur;

import java.io.File;
import java.io.FileFilter;


public class SortedDirStructureFileFilter implements FileFilter {

	public SortedDirStructureFileFilter() {
	}

	/**
	 * accept(File f) prüft, ob es sich um eine Datei handelt.
	 * @return true, wenn es sich um eine Datei handelt
	 */
	public boolean accept(File f) {
		
		return f.isFile();
	}

}
