package aufgaben.primzahl;



public class Main {
	public static final int ANZAHL_THREADS = 10;
	private static Thread[] threads = new Thread[ANZAHL_THREADS];
	
	
	public static void main(String[] args) {

		// 2. Teil
		int start = HilfsMeth.readInt("Welcher Startwert?");
		testPrimeThread(start);
				
		// 3. Teil
		start = HilfsMeth.readInt("Welcher Startwert?");
		int anzahl = HilfsMeth.readInt("Wieviele Zahlen sollen getestet werden?");
		testPrimeThreadAnzahl(start, anzahl);
		
		// 4. Teil
		start = HilfsMeth.readInt("Welcher Startwert?");
		int ende = HilfsMeth.readInt("Welcher Endwert?");
		testPrimeThreadBereich(start, ende);

	}

	/**
	 * Diese Methode testet ausgehend von start 10 Zahlen, ob sie prim sind. 
	 * @param start - Der Startwert
	 */
	private static void testPrimeThread(int start) {
		// Threads erstellen:
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Primzahl(start, i));
			threads[i].start();
			start++;
		}
		
	}
	
	/**
	 * Diese Methode testet mit Hilfe von Threads, ob die Zahlen 
	 * von start bis ende Primzahlen sind 
	 * @param start - Der Startwert
	 * @param ende - Der Endwert
	 */
	private static void testPrimeThreadBereich(int start, int ende) {
		for (int zahl = start; zahl < ende; zahl++) {
			boolean threadGestartet = false;
			while (!threadGestartet) {
				// Gehe durch alle Threads
				for (int i = 0; i < threads.length; i++) {
					// Sobald ein nicht-beschäftigter Thread gefunden: neuen Thread 
					// mit akt. Zahl erzeugen und starten
					if (!threads[i].isAlive() && !threadGestartet) {
						threads[i] = new Thread(new Primzahl(zahl,i));						
						threadGestartet = true;
						threads[i].start();
					}
				}				
			}
		}
	}

	/**
	 * Diese Methode testet von start ausgehend anzahl Zahlen, ob sie prim sind.
	 * @param start - Der Startwert
	 * @param anzahl - Die Anzahl der zu testenden Zahlen
	 */
	private static void testPrimeThreadAnzahl(int start, int anzahl) {				
		
		for (int zahl = start; zahl < start + anzahl; zahl++) {
			boolean threadGestartet = false;
			while (!threadGestartet) {
				// Gehe durch alle Threads
				for (int i = 0; i < threads.length; i++) {
					// Sobald ein nicht-beschäftigter Thread gefunden: neuen Thread 
					// mit akt. Zahl erzeugen und starten
					if (!threads[i].isAlive() && !threadGestartet) {
						threads[i] = new Thread(new Primzahl(zahl,i));						
						threadGestartet = true;
						threads[i].start();
					}
				}				
			}
		}
	}

}
