package aufgaben;

public class ArrayHex2Dez{

	public static void main(String[] args){
		final int basis = 16;
		String eingabe = null;
		boolean formatOk = true;
		int ergebnis = 0;
		int laufIndex = 2;
		char aktuellesZeichen = ' ';
		// Eingabeteil
		System.out.println("Geben Sie ein Hexadezimalezahl in der Form:");
		eingabe = HilfsMeth.readString("X\'ABC\'");
		
		// Verarbeitungsteil
		// ueberpruefen der formalen Vorgaben 
		if ( eingabe.length() >= 4     && 
			 eingabe.startsWith("X\'") && 
		     eingabe.endsWith("\'")         ){
			
			while ( formatOk && laufIndex < (eingabe.length() -1) ){
				aktuellesZeichen = eingabe.charAt(laufIndex);
				
				if ( Character.isDigit(aktuellesZeichen)                    ||
					 ( aktuellesZeichen >= 'A' && aktuellesZeichen <= 'F' ) ){
				
						ergebnis = ergebnis * basis + Character.digit(aktuellesZeichen, basis);
					 }
					 else{
					 	 formatOk = false;
					 }			
				
				laufIndex++;
			}
		}
		else{
			formatOk = false;
		}
		
		
		// Ausgabeteil
		if ( formatOk ){
			System.out.println("Ergebnis: " + ergebnis);
		}
		else{
			System.out.println("Formatfehler");
		}
	}

}