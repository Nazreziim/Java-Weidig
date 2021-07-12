package ergänzungen.zeitUndImports;

public class Zeit {
	public static void main(String[] args) {
		// Gibt die Differenz zwischen jetzt und dem 1.1.1970 um Mitternacht (UTC) in
		// Millsekunden aus (ALS LONG WERT)
		System.out.println(System.currentTimeMillis());
		
		

		//Weise start die aktuelle Zeit zu
		long start = System.currentTimeMillis();

		//IRGENDEINE ANWEISUNG DIE LANGE DAUERT
		for (int i = 0; i < 10e4; i++) {
			//Gebe i aus
			System.out.println("i = " + i);
			//Gebe die aktuell dafür benötigte Zeit aus (in ms)
			System.out.println("Benötigte Zeit: [in ms]" + (System.currentTimeMillis() - start));
		}

		//EIN ABSATZ  
		System.out.println();
		
		//Differenz in ms
		long differenz = System.currentTimeMillis() - start;
		//Damit ich die Nachkommastellen erhalte
		double differenzS = differenz / 1000.0;
		double differenzM = differenz / 60000.0;
		System.out.printf("Benötigte Zeit in Millisekunden = %d  %n", differenz);
		System.out.printf("Benötigte Zeit in Sekunden = %f     %n", differenzS);
		System.out.printf("Benötigte Zeit in Minuten = %f %n", differenzM);
	}
}
