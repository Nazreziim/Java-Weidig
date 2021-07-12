package aufgaben;

public class ZahlenRatenIf {

	public static void main(String[] args) {
		// Zufallszahlen zwischen 0 und 10 erzeugen 
		final double SPANNE = 11.0; // von 0 - 10 + 1  => Differenz von min und max Wert + 1
		final double MIN_WERT = 0.0;		
		int zahl = (int) ( SPANNE * Math.random() + MIN_WERT);
		
		boolean richtig = false;
		int eingabe = HilfsMeth.readInt("Bitte raten Sie: ");
		
		
		if (eingabe == zahl) {
			richtig = true;
		} else {
			
			eingabe = HilfsMeth.readInt("Bitte raten Sie erneut: ");
			
			if (eingabe == zahl) {
				richtig = true;
			} else {
				
				eingabe = HilfsMeth.readInt("Bitte raten Sie ein letztes Mal: ");
				if (eingabe == zahl) {
					richtig = true;
				} 
			}
		}
		
		// oder Alternativ
/*		
		if (eingabe == zahl) {
			richtig = true;
		} 
		
		if (!richtig) {
			eingabe = HilfsMeth.readInt("Bitte raten Sie erneut: ");
			
			if (eingabe == zahl) {
				richtig = true;
			}	
		}
		
		if (!richtig) {
			eingabe = HilfsMeth.readInt("Bitte raten Sie ein letztes Mal: ");
			
			if (eingabe == zahl) {
				richtig = true;
			}	
		}
		
*/		
		// Ausgabeteil
		if (richtig){
			System.out.println("Sie haben richtig geraten. Die Zahl war: " + zahl);
		}
		else{
			System.out.println("Leider nicht gewonnen, die Zahl war " + zahl);
		}
		
	}

}

