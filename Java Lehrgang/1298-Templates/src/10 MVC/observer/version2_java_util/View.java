package observer.version2_java_util;

import java.util.Observable;

/**
 * Klasse zur Anzeige des Counters mit dem Text "Der Zähler beträgt: " 
 * @author LGerhard
 *
 */
public class View implements ViewInterface {

	/**
	 * Diese Methode wird aufgerufen, wenn der Observer über Änderungen im Observable informiert wird
	 * @param o - Referenz auf den Observer (hier: auf das Model)
	 * @param arg - Ein optional mitgebbares Objekt (hier nicht genutzt)
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Der Zähler beträgt: " + ((Model)o).getCtr());
		
	}

}
