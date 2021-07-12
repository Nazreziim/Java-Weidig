package observer.version2_java_util;

import java.util.Observable;

/**
 * Klasse zur Anzeige des Counters mit '#'  
 * @author LGerhard
 *
 */
public class AndereView implements ViewInterface {


	
	@Override
	/**
	 * Diese Methode wird aufgerufen, wenn der Observer über Änderungen im Observable informiert wird
	 * @param Observable o - Referenz auf den Observer (hier: auf das Model)
	 * @param Object arg - Ein optional mitgebbares Objekt (hier nicht genutzt)
	 * 
	 */
	public void update(Observable o, Object arg) {
		for (int i=0; i < ((Model)o).getCtr(); i++) {
			System.out.print("#");
		}
		System.out.print("\n");
		
	}

}
