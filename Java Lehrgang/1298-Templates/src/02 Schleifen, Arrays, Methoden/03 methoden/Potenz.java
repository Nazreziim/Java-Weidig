package methoden;
public class Potenz {

	private static int potenz(int basis, int exponent) {
		int erg = 0;
		// Ausschlieﬂen von Fehlern
		if (exponent < 0) {
			erg = 0;
		} else if (exponent == 0) {
			erg = 1;
		} else if (exponent == 1) {
			erg = basis;
		} else {
/*/ Multiplikation
			erg = 1; // Vorbelegung f¸r Multiplikation
			// Durchlaufen der Exponenten
			for (int i = 1; i <= exponent; i++) {
				// Mit Multiplikation:
				erg = erg * basis;  // z. B. 8 * 5 
			}
*/
// Addition
			erg = 1; // Vorbelegung f¸r Multiplikation
			for (int i = 1; i <= exponent; i++) { // es folgt: erg = erg * basis
				// Bestimmen von Zwischenwerten (f¸r jede Potenz neu)
				int summand = 0;
				for (int j = 1; j <= basis; j++) {
					summand = summand + erg;
				}
				erg = summand;
			}
		}
		return erg;
	}

	public static void main(String[] args) {
		System.out.println(potenz(5,0)); // ist das 8?
		System.out.println();
		System.out.println(potenz(5,1)); // ist das 8?
		System.out.println();
		System.out.println(potenz(5,2)); // ist das 8?
		System.out.println();
		System.out.println(potenz(5,3)); // ist das 1024?
		System.out.println();
		System.out.println(potenz(2,10)); // ist das 1024?
	}

}