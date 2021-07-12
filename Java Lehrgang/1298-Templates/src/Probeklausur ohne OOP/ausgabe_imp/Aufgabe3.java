package ausgabe_imp;

import ausgabe.HilfsMeth;
// Name:
// Dienstgrad:

public class Aufgabe3{
	
	public static void main(String[] args) {
		int zeile = HilfsMeth.readInt("Groesse des Array (Zeilen)? ");
		int spalte = HilfsMeth.readInt("Groesse des Array (Spalten)? ");
		int[][] feld = new int[zeile][spalte];
		fillArray(feld);
		printArray ( summArray(feld) );
		
	}
	
	/*liest ein int-Array ein*/
	//hier könnte eine Methode fillArray stehen
	
	/*gibt ein int-Array aus*/
	//hier könnte eine Methode printArray stehen
	
	
	/*  Ergänzen Sie hier Ihre Methode "summArray"  */
		
	
}

