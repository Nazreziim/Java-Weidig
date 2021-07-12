package loesung_klausur_2014;

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
	 * Diese Methode erstellt ein int-Array, in dem sich alle Folgenglieder der Collatz-Folge
	 * beginnend beim Parameter befinden, bis das erste Mal die Eins erreicht
	 * @param zahl Das Startelement der Folge
	 * @return 
	 */
	private static int[] collatz_array(int zahl) {
		int[] erg = new int[collatz_laenge(zahl) + 1];  // Muss um eins länger sein!!!
		erg[0] = zahl;
		
		for(int i=1; i<erg.length; i++) {
			if (zahl % 2 == 0) {
				zahl = zahl / 2;
			} else {
				zahl = 3 * zahl + 1;
			}
			erg[i] = zahl;
		}
		
		
		return erg;
	}

	/**
	 * Dies Methode berechnet rekursiv die Länge der Collatz-Folge, beginnend bei n bis zum Folgenglied "1"
	 * @param zahl
	 * @return
	 */
	private static int collatz_laenge(int zahl) {
		int erg = 0;
		if (zahl != 1) {
			if (zahl % 2 == 0) {
				erg = collatz_laenge(zahl / 2) + 1;
			}
			if (zahl % 2 != 0) {
				erg = collatz_laenge(3 * zahl + 1) + 1;
			}
			
		}
		return erg;
	}

	
}
