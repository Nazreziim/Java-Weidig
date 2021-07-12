package abstrakteKlassen;

public abstract class Mensch {
	int a = 5;
	public final int b = 5;
	

	//Abstrakte Methode ohne Parameter
	public abstract void essen();
	
	//Abstrakte Methode mit Parameter
	public abstract void trinken(int litermenge);
	
	/**
	 * Funktioniert nicht, da abstrakte Methoden
	 * keinen K�rper enthalten.
	public abstract boolean bisDreiZ�hlen() {
		return true;
	} **/

	//NICHT abstrakte Methode, welche sich wie eine
	//normale Methode verh�lt und nutzbar ist.
	public void sprechen() {
		System.out.println("Ich spreche!");
		
		
	/**
	 * Warum mache ich das?
	 * Abstrakte Klassen dienen haupts�chlich zur
	 * gr��eren Sicherheit um quasi noch weniger
	 * Zugriff auf die Inhalte der Klasse durch
	 * die abstrakte Klasse zu erhalten.
	 */
	}
}
