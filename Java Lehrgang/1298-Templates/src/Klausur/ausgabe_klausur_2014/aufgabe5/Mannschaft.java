package ausgabe_klausur_2014.aufgabe5;
/**
*Name:
*DG:
*/
public class Mannschaft {
	private String land;
	private Fussballspieler[] spieler;
	private int staerke; // Die Staerke entspricht der Summe der Staerken der einzelnen Spieler
	
	
	public Mannschaft(String land) {
		// Hier müssen Ihre Ergänzungen hin
		
		generateSpieler();
		this.staerke = calcStaerke();
	}

	
	/**
	 * Diese Methode erstellt einen Torwart und soviele Feldspieler, dass das spieler-Array komplett befüllt ist
	 */
	private void generateSpieler() {
		spieler[0] = new Torwart("Torwart", 1);
		for (int i = 1; i < spieler.length; i++) {
			spieler[i] = new Feldspieler("Feldspieler", i+1);
		}
		
	}
	
	/**
	 *  Schreiben Sie hier die Methode calcStaerke()
	 * 
	 */

	
	
	/**
	 * Schreiben Sie hier die Methode getStaerksterSpieler()
	 * @return
	 */
	
	
	public String getLand() {
		return land;
	}
	
	

}
