package file;

import java.io.File;
import java.io.FilenameFilter;
/*
 * FilenameFilter: Zum Überprüfen von Dateinamen (oder Verzeichnisnamen) in einem Verzeichnis - String-orientiert!!!
 * FileFilter: Zum Überprüfen von File-Objekten (z.B. zur Prüfung ob es sich um eine Datei handelt!)
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
