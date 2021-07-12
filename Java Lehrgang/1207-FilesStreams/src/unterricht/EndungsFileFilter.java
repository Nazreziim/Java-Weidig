package unterricht;

import java.io.File;
import java.io.FilenameFilter;

public class EndungsFileFilter implements FilenameFilter {
	private String endung;
	
	public EndungsFileFilter(String endung) {
		super();
		this.endung = endung;
	}

	
	@Override
	/**
	 * Testet, ob die Datei name im Verzeichnis dir in die Liste aufgenommen wird
	 * @param dir - Verzeichnis
	 * @param name - Dateiname 
	 */
	public boolean accept(File dir, String name) {
		return name.endsWith(endung);
		
	}

}
