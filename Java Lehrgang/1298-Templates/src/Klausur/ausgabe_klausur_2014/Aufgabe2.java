package ausgabe_klausur_2014;
/**
*Name:
*DG:
*/
public class Aufgabe2 {
	
	public static void main(String[] args) {
		int[] arr = collatz_array(19);
		System.out.println(collatz_laenge(19));
		print_array(arr);
	}
	
	
	/**
     * Diese Methode gibt ein Array auf der Konsole aus
     */
	public static void print_array(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		
	}
	
	/**
	 * Hier ist Platz für Ihre Methode collatz_array
	 */


	/**
	 *Hier ist Platz für Ihre Methode collatz_laenge
	 */


	
}
