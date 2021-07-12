package unterricht;

import java.io.File;
import java.io.FilenameFilter;

public class EndungsFileFilter implements FilenameFilter {
	private String ending;
	
	public EndungsFileFilter(String ending) {
		super();
		this.ending = ending;
	}

	
	@Override
	/**
	 * Testet, ob die Datei name im Verzeichnis dir in die Liste aufgenommen wird
	 * @param dir - Verzeichnis
	 * @param name - Dateiname 
	 */
	public boolean accept(File dir, String name) {
		return name.endsWith(ending);
		
	}

}
