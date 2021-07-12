package ausgabe_klausur_2014;
/**
*Name:
*DG:
*/
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
	 * Hier ist Platz für Ihre Methode schluesselalphabet
	 */
	

	/**
	 * Hier ist Platz für Ihre Methode verschluessele
	 */
	
}
