package schulverwaltung;
/**
 * Klasse verwaltet die Noten fuer ein
 * Zeugnis eines Schuelers.
 * @author user
 *
 */
public class Zeugnis {

	public final static int MATHEMATIK = 0; // idx fuer Noten
	public final static int DEUTSCH = 1; // idx fuer Noten
	public final static int CHEMIE = 2; // idx fuer Noten
	public final static int ENGLISCH = 3; // idx fuer Noten
	
	private boolean bestanden;
	
	private int [] noten;
	
	
	/**
	 * Konstruktor
	 * @param noten
	 */
	public Zeugnis(int ... noten) {
		this.noten =  noten;
			
		this.bestanden = pruefeNoten();
	}

	/**
	 * Prueft, ob Zeugnisnoten fuer das 
	 * Bestehen des Schuljahres ausreichen.
	 * @return
	 */
	public boolean isBestanden() {
		return bestanden;
	}


	/**
	 * Methode prueft alle Noten und
	 * und ermittelt das Ergebnis.
	 * @return
	 */
	private boolean pruefeNoten(){
		boolean bestanden = true;
		int anzahl5 = 0;
		int idxNoten = 0;
		while (idxNoten < noten.length && bestanden){
			if (noten[idxNoten] == 6){
				bestanden = false;
			}
			else if (noten[idxNoten] == 5){
				anzahl5++;
				if (anzahl5 == 2){
					bestanden = false;
				}
			}
			idxNoten++;
		}
	
		
		return bestanden;
	}



	@Override
	public String toString() {
		
		return "Schuljahr bestanden: " + bestanden + "\n"+ 
		       "Mathematik: " + noten[MATHEMATIK] + " Deutsch: " + noten[DEUTSCH]  + " Chemie: " + noten[CHEMIE] + " Englisch: " + noten[ENGLISCH];
	}
	
	
	
}
