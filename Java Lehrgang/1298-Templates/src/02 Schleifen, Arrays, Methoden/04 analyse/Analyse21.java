//package analyse;

/**
 * Analyseaufgabe für den 10.04.2013
 *
 * Ackermann!
 * Was wird hier ausgegeben?
 * 
 * 
 * @author LGerhard
 *
 */
public class Analyse21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 3;
		int b = 2;
		System.out.println(methode(a,b));

	}

	private static int methode(int a, int b) {
		int erg = 0;
		if (a == 0) {
			erg = b+1;
		} else if (b == 0 ) {
			erg = methode(a-1,1);
		} else {
			erg = methode(a-1, methode(a, b-1));
		}
		return erg;
	}

}
