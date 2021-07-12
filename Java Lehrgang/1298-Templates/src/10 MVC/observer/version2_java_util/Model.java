package observer.version2_java_util;

import java.util.Observable;

/**
 * Das Model (hier ein Counter) der Applikation. Erweitert Observable, um die als Observer angebundenen 
 * Views informieren zu k�nnen. 
 * @see Observable
 * @see View
 * @see AndereView
 * @author LGerhard
 *
 */
public class Model extends Observable implements ModelInterface{
	private int ctr = 0;
	
	
	/**
	 * Erh�ht den Z�hler um 1. Danach wird setChanged() und notifyObservers() aufgerufen, um die Observer zu informieren.
	 * @see java.util.Observable#setChanged()
	 * @see java.util.Observable#notifyObservers()
	 */
	@Override
	public void inkr() {
		ctr++;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Verringer den Z�hler um 1. Danach wird setChanged() und notifyObservers() aufgerufen, um die Observer zu informieren.
	 * @see java.util.Observable#setChanged()
	 * @see java.util.Observable#notifyObservers()
	 */
	@Override
	public void dekr() {
		ctr--;
		// Diese Methodenaufrufe informieren die Observer �ber �nderungen
		this.setChanged();
		this.notifyObservers();
	}
	
	@Override
	public int getCtr() {
		return ctr;
	}
}
