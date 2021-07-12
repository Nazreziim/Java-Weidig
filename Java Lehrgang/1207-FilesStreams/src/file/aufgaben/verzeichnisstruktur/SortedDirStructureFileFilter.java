package file.aufgaben.verzeichnisstruktur;

import java.io.File;
import java.io.FileFilter;

public class SortedDirStructureFileFilter implements FileFilter {

	public SortedDirStructureFileFilter() {
	}

	/**
	 * accept(File dir) prüft, ob es sich um eine Datei handelt,
	 * @return true fuer eine Datei 
	 */
	public boolean accept(File f) {
		
		return f.isFile();
	}

}
