package grundlagen.b3Bedingungen;


public class Template07KontrollstrukturSwitch {
	
	public static void main(String[] args) {
		
		// Deklarationsteil
		// Zufallszahl erzeugen fuer Monate 1-12 erzeugen
		final double SPANNE = 12.0; // von 1 - 12 + 1  => Differenz von min und max Wert + 1
		final double MIN_WERT = 1.0;		
		int monat = 0; 
		int tage = 0;
		boolean eingabe = false;
		
		// Eingabeteil-- Erweiterung mit IF
		// Nutzerabfrage?
		if (eingabe){
		 monat = HilfsMeth.readInt("Geben Sie einen Monat ein: ");
		}
		else{		
			monat =  (int) ( SPANNE * Math.random() + MIN_WERT);
		}
		
		// Es sind auch Strings fuer die switch-Anweisung erlaubt!
		// Verarbeitung
		switch (monat) {
			case 1: 
			case 3: 
			case 5: 
			case 7: 
			case 8: 
			case 10: 
			case 12: 
				tage = 31;
				break;
			case 4: 
			case 6: 
			case 9: 		
			case 11: 
				tage = 30;
				break;					
			case 2: 
				tage = 28; 
				break;
				
		}

				
		// Ausgabeteil
		if (tage != 0){
			System.out.println("Der Monat: " + monat + " hat " + tage); 
		}
		else{
			System.out.println("Ungültige Eingabe");
		}
	}
}

