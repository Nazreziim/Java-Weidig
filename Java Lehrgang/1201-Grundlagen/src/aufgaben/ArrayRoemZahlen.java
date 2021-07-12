package aufgaben;

public class ArrayRoemZahlen {

	// Nutzung fuer Index der umsetzTabelle
	enum RoemZahlen { I, V, X, L, C, D, M, N };
	
	public static void main(String[] args) {
		final int [] umsetzTabelle = {1, 5, 10, 50, 100, 500, 1000, 0 };
		String eingabe = null;
		String[] roemZahlenStr = null;
		RoemZahlen [] roemZahlen = null;
		int ergDez = 0;
		boolean formatOk = true;
		
		System.out.println("Bitte roemische Zahl eingeben und N fuer\nEingabeende:");
		eingabe = HilfsMeth.readString("(jeder Buchstabe durch ein Leerzeichen ge-\ntrennt)");
		
		roemZahlenStr = eingabe.split(" ");
		

		
		if (roemZahlenStr[roemZahlenStr.length -1 ].equals("N") ){
			
			roemZahlen = new RoemZahlen[roemZahlenStr.length];
			
			for ( int i = 0; i < roemZahlen.length; i++ ){
				roemZahlen[i] = RoemZahlen.valueOf(roemZahlenStr[i]);
			}
			
			for ( int i = 0; i < roemZahlen.length -1 ; i++ ){
				
				if ( umsetzTabelle[roemZahlen[i].ordinal()] < umsetzTabelle[roemZahlen[i + 1].ordinal()] &&
					roemZahlen[i + 1] != RoemZahlen.N	){ // bewirkt, dass die letzte gueltige Zahl addiert wird
					ergDez = ergDez - umsetzTabelle[roemZahlen[i].ordinal()];
				}
				else{
					ergDez = ergDez + umsetzTabelle[roemZahlen[i].ordinal()];
				}
				
				System.out.println(ergDez);
			}
			
		}
		else{
			formatOk = false;
		}

		if (formatOk){
			System.out.println("Ergebnis: " + ergDez);
		}
		else{
			System.out.println("Formatfehler");
		}
			
	}

}
