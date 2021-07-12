package interfaces;

//ABSTRACT und Public können weggelassen werden
public abstract interface Säugetier {

	/**
	 * Nur anhand der Formattierung lässt sich erkennen, dass int alter eigentlich
	 * public static final int alter ist.
	 **/
	int alter = 0;

	/**
	 * Wird als Fehler gekennzeichnet, da Final Variablen initialisiert werden
	 * müssen.
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
	 * public Säugetier(){
	 * }
	 */

	public abstract void essen();

	public abstract void trinken(int litermenge);

	/**
	 * Funktioniert nicht, da abstrakte Methoden keinen Körper enthalten. Auch bei
	 * Interfaces.
	 * 
	 * public abstract boolean bisDreiZählen() { return true; }
	 **/

	/**
	 * Funktioniert nicht, da in Interfaces nur abstrakte Methoden deklariert
	 * werden. Heißt jede normal geklarierte Methode in Interfaces wird automatisch
	 * als abstract gekennzeichnet.
	 * 
	 * public void sprechen() { System.out.println("Ich spreche!"); }
	 */

	// Default Methoden sind spezielle Methoden
	// Welche für Interfaces erst später dazukamen.
	// Diese sind nutzbar um eine quasi Mehrfachvererbung
	// zu ermöglichen.
	public default void bewegen() {
		System.out.println("BEWEGE!");
		// this.kilometerstand++;    --> Nicht möglich, da final nicht verändert werden kann.
	}
	
	//Möglichkeit sinnvoll auf die Variablen zuzugreifen
	//Ohne ein Warning zu erhalten
	public default String getLieblingsessen() {
		return lieblingsessen;
	}
}
