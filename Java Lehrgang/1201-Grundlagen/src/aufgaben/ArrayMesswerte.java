package aufgaben;

public class ArrayMesswerte {

	public static void main(String[] args) {
		final int MAX_WERT = 1000;
		final int MIN_WERT = 0;
		int reihung[] = new int[20];
		int maxWert = MIN_WERT;
		int minWert = MAX_WERT;
		double summe = 0.0;
		double durchschnitt = 0.0;
		
		
		/*  Eingabeteil
		 * befuellen der Reihung mit Zufallszahlen
		 */
		for ( int i = 0; i < reihung.length; i++){
			reihung[i] = (int) (Math.random() * 1001.0);
			//Testausgabe
			System.out.println(reihung[i]);
		}
		
		
		/*Verarbeitungsteil
		 * 
		 */
		for ( int i = 0; i < reihung.length; i++){
			// max Wert bestimmen
			if (maxWert < reihung[i]){
				maxWert = reihung[i];
			}
			
			// min Wert bestimmen
			if (minWert > reihung[i]){
				minWert = reihung[i];
			}
			
			summe += (double) reihung[i];
			
		}
		
		durchschnitt =  summe / reihung.length;
		
		/*Ausgabeteil
		 * 
		 */
		System.out.printf("Min-Wert: %5d\n", minWert);
		System.out.printf("Max-Wert: %5d\n", maxWert);
		System.out.printf("Durchschnittswert: %.2f\n", durchschnitt);
		
		
	}

}
