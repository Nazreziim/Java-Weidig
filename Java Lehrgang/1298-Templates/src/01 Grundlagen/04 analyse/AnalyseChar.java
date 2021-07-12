package analyse;

/**
 * Analyseaufgabe für den 08.04.2013
 * 
 * Was wird hier ausgegeben?
 * 
 * 
 * @author LGerhard
 *
 */
public class AnalyseChar {
	public static void main(String args[]) {
		char zeichen = 'A';
		char ein_anderes = 'G';
	
		while (zeichen < ein_anderes) {
			System.out.println(zeichen + " ");
			zeichen++;
		}
		
		int zahl = 7;
		if (zeichen == ein_anderes) {
			zahl *= ++zahl;
		} else {
			zahl -= zahl++;
		}
		
		System.out.println(zahl);
		zeichen++;
		System.out.println(zeichen--);
		
	}
}
