package interfaces;

public class Ich extends Mensch {
	/**
	 * Normale Klassen m�ssen die Methoden von Interfaces implementieren.
	 */

	@Override
	public void trinken(int litermenge) {
		// TODO Auto-generated method stub

	}

	@Override
	public void essen() {
		System.out.println("Ich esse " + this.getLieblingsessen());

	}
	
	

}
