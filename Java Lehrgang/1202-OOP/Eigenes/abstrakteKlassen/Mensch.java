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
	 * keinen Körper enthalten.
	public abstract boolean bisDreiZählen() {
		return true;
	} **/

	//NICHT abstrakte Methode, welche sich wie eine
	//normale Methode verhält und nutzbar ist.
	public void sprechen() {
		System.out.println("Ich spreche!");
		
		
	/**
	 * Warum mache ich das?
	 * Abstrakte Klassen dienen hauptsächlich zur
	 * größeren Sicherheit um quasi noch weniger
	 * Zugriff auf die Inhalte der Klasse durch
	 * die abstrakte Klasse zu erhalten.
	 */
	}
}
