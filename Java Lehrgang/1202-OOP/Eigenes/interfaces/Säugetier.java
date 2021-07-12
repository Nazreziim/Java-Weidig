package interfaces;

//ABSTRACT und Public k�nnen weggelassen werden
public abstract interface S�ugetier {

	/**
	 * Nur anhand der Formattierung l�sst sich erkennen, dass int alter eigentlich
	 * public static final int alter ist.
	 **/
	int alter = 0;

	/**
	 * Wird als Fehler gekennzeichnet, da Final Variablen initialisiert werden
	 * m�ssen.
	 * 
	 * int kilometerstand;
	 **/
	
	/**
	 * Wird ebenfalls als falsch angezeigt, da 
	 * nur public static final erlaubt ist. 
	 * 
	 * private int kilometerstand;
	 */
	
	public static final String lieblingsessen = "FLEISCH";
	
	
	/**
	 * Funktioniert nicht, da Interfaces
	 * keine Konstruktoren haben.
	 * 
	 * public S�ugetier(){
	 * }
	 */

	public abstract void essen();

	public abstract void trinken(int litermenge);

	/**
	 * Funktioniert nicht, da abstrakte Methoden keinen K�rper enthalten. Auch bei
	 * Interfaces.
	 * 
	 * public abstract boolean bisDreiZ�hlen() { return true; }
	 **/

	/**
	 * Funktioniert nicht, da in Interfaces nur abstrakte Methoden deklariert
	 * werden. Hei�t jede normal geklarierte Methode in Interfaces wird automatisch
	 * als abstract gekennzeichnet.
	 * 
	 * public void sprechen() { System.out.println("Ich spreche!"); }
	 */

	// Default Methoden sind spezielle Methoden
	// Welche f�r Interfaces erst sp�ter dazukamen.
	// Diese sind nutzbar um eine quasi Mehrfachvererbung
	// zu erm�glichen.
	public default void bewegen() {
		System.out.println("BEWEGE!");
		// this.kilometerstand++;    --> Nicht m�glich, da final nicht ver�ndert werden kann.
	}
	
	//M�glichkeit sinnvoll auf die Variablen zuzugreifen
	//Ohne ein Warning zu erhalten
	public default String getLieblingsessen() {
		return lieblingsessen;
	}
}
