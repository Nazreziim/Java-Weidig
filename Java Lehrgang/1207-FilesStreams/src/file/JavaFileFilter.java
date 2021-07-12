package file;

import java.io.File;
import java.io.FilenameFilter;
/*
 * FilenameFilter: Zum �berpr�fen von Dateinamen (oder Verzeichnisnamen) in einem Verzeichnis - String-orientiert!!!
 * FileFilter: Zum �berpr�fen von File-Objekten (z.B. zur Pr�fung ob es sich um eine Datei handelt!)
 */
public class JavaFileFilter implements FilenameFilter {
	private String endung;
	
	public JavaFileFilter(String endung) {
		super();
		this.endung = endung;	
	}
	
	
	@Override
	public boolean accept(File dir, String name) {		
		return name.endsWith(this.endung);
	}

}
