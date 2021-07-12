package abstrakteKlassen;

public class Ich extends Mensch {

	@Override
	public void essen() {
		System.out.println("Ich esse!");
		
	}

	@Override
	public void trinken(int litermenge) {
		System.out.println("Ich trinke " + litermenge + " Wasser!");
		
	}

}
