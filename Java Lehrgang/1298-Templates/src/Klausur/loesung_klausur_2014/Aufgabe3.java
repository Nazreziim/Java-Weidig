package loesung_klausur_2014;

public class Aufgabe3 { // Vigenère Verschlüsselung

	public static void main(String[] args) {
		char[] klartext = {'D','A','S','I','S','T','E','I','N','E','G','E','H','E','I','M','E','N','A','C','H','R','I','C','H','T'};
		
		char[] schluessel_wort = {'H','A','L','L','O'};		
		char[] schluessel_alphabet= schluesselalphabet(schluessel_wort, klartext.length);
		
		char[] verschluesselt = verschluessele(klartext, schluessel_alphabet);
		
		print_array(klartext);
		print_array(schluessel_alphabet);
		print_array(verschluesselt);
	}
	

	/**
     * Diese Methode gibt ein Array auf der Konsole aus
     */
	public static void print_array(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		
	}
	
	/**
	 * Diese Methode erstellt den Schlüssel der Vigenere-Verschlüsselung. Sie erhält dazu ein Wort 
	 * und gibt dieses Wort so oft aneinander gereiht in einem Array zurück, wie der zweite Parameter Länge
	 * angibt.
	 * @param wort
	 * @param laenge
	 * @return
	 */
	public static char[] schluesselalphabet(char[] wort, int laenge) {
		char[] erg = new char[laenge];

		for (int i = 0; i < erg.length; i++) {
			erg[i] = wort[i % wort.length];
		}
		return erg;
	}

	/**
	 * Diese Methode führt die eigenlichte Verschlüsselung durch: Jeder Character aus dem klartext-Array
	 * wird um soviele Positionen im Alphabet nach hinten verschoben, wie die Position des Characters i,
	 * schluessel_alphabet-Array angibt. Das Ergebnis wird ebenfalls als Array zurückgegeben
	 * @param klartext
	 * @param schluessel_alphabet
	 * @return
	 */
	private static char[] verschluessele(char[] klartext, char[] schluessel_alphabet) {
		char[] erg = new char[klartext.length];
		for (int i = 0; i < erg.length; i++) {
			int versch = schluessel_alphabet[i] - 'A';
			erg[i] = (char) (klartext[i] + versch);
			if (erg[i] > 'Z') {
				erg[i] = (char) (erg[i] % 'Z' + 'A');
			}
		}
		return erg;
	}
}
