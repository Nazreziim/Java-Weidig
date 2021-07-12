package aufgaben;

public class ArrayAbzaehlReim {

	public static void main(String[] args) {
		final int ANZAHL_SILBEN = 2;
		final int ANZAHL_SPIELER = 4;
		
		boolean [] mitspieler = new boolean[ANZAHL_SPIELER];
		int idxSpieler = 0;
		int silberZaehler = 1;
		int ausfallZaehler = 0;
		boolean beendet = false;
		
		
		// Vorinitialisierung Mitspieler
		for (int i = 0; i < mitspieler.length; i++){
			mitspieler[i] = true;
		}
		
		while (!beendet){
			
			if (mitspieler[idxSpieler]){
				
				if (silberZaehler == ANZAHL_SILBEN){  // Reimende
					
					mitspieler[idxSpieler] = false;
					silberZaehler = 0;
					ausfallZaehler++;
					
					if ( ausfallZaehler != ANZAHL_SPIELER ) {
						System.out.println( (idxSpieler + 1) + ".Spieler ist ausgeschieden."); 
					}
					else{
						System.out.println( (idxSpieler + 1) + ".Spieler hat gewonnen.");
						beendet = true;
					}
						
				}
				silberZaehler++;
			}
			
			// naechster Spieler auswaehlen
			idxSpieler = ( idxSpieler + 1 ) % ANZAHL_SPIELER;
		}
		
	}

}
