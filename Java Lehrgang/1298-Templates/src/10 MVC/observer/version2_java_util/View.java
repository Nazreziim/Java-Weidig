package observer.version2_java_util;

import java.util.Observable;

/**
 * Klasse zur Anzeige des Counters mit dem Text "Der Z�hler betr�gt: " 
 * @author LGerhard
 *
 */
public class View implements ViewInterface {

	/**
	 * Diese Methode wird aufgerufen, wenn der Observer �ber �nderungen im Observable informiert wird
	 * @param o - Referenz auf den Observer (hier: auf das Model)
	 * @param arg - Ein optional mitgebbares Objekt (hier nicht genutzt)
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Der Z�hler betr�gt: " + ((Model)o).getCtr());
		
	}

}
