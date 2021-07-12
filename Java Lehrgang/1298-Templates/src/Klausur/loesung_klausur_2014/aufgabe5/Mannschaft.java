package loesung_klausur_2014.aufgabe5;

public class Mannschaft {
	private String land;
	private Fussballspieler[] spieler;
	private int staerke; // Die Staerke entspricht der Summe der Staerken der einzelnen Spieler
	
	
	public Mannschaft(String land) {
		this.land = land;
		this.spieler = new Fussballspieler[11];
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
	 * Diese Methode berechnet die Mannschaftsstärke
	 * @return
	 */
	public int calcStaerke() {
		int erg = 0;
		for (Fussballspieler s: spieler) {
			erg += s.getStaerke();
		}
		return erg;
		
	}
	
	
	/**
	 * Diese Methode bestimmt den stärksten Spieler einer Mannschaft und liefert ihn zurück
	 * @return
	 */
	public Fussballspieler getStaerksterSpieler() {
		Fussballspieler erg = spieler[0];
		for (Fussballspieler s : spieler) {
			if (s.getStaerke() > erg.getStaerke()) {
				erg = s;
			}
		}
		return erg;
	}
	
	
	public String getLand() {
		return land;
	}


	@Override
	public String toString() {
		String erg = "Mannschaft " + land + " mit der Staerke " + staerke + " besteht aus:";
//		for (Fussballspieler s : spieler) {
//			erg += s.toString() + " \n";
//		}
		return erg;
	}
	

}
