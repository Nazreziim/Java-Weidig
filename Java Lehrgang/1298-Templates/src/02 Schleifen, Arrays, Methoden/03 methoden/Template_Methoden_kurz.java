package methoden;

class Template_Methoden_kurz {

	static int gibPrimzahl(int zahl) {
		System.out.println("Anfang");
		if (zahl < 10)		
			return 5;
		System.out.println("Mitte");
		if (zahl >= 10)
			return 11;
		System.out.println("Ende");
		return 0;
	}
	
	static double gibPrimzahl2(int zahl) {
		System.out.println("Anfang");
		double zwischenwert = 0.0;
		if (zahl < 10)		
			zwischenwert = 5.0;
		System.out.println("Mitte");
		if (zahl >= 10)
			zwischenwert = 2.0;
		System.out.println("Ende");
		return zwischenwert;
	}
	
	static void halloNutzer(String name) {
		System.out.println("Hallo "+name);
	}
	
	static boolean istGerade(int zahl) {
		if (zahl % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	static int nachfolger(int zahl) {
		zahl = zahl + 1;
		return zahl;
	}

	static int mittelwert(int zahl1, int zahl2) {
		int zahl = zahl1 + zahl2;
		zahl /= 2;
		return zahl;
	}

	static double mittelwert(double zahl1, double zahl2) {
		double zahl = zahl1 + zahl2;
		zahl /= 2;
		return zahl;
	}

	static double mittelwert(int zahl1, double zahl2) {
		double zahl = zahl1 + zahl2;
		zahl /= 2;
		return zahl;
	}
	
	static String doppel(String text) {
		return (text + text.length() + text);
	}
	
	public static void main(String[] args) {
/*		
		System.out.println("TEXT");
		//Rückgabewert anzeigen
		System.out.println(gibPrimzahl(7));
		//mit Rückgabewert rechnen
		System.out.println();
		int zahl = gibPrimzahl(6) + gibPrimzahl(20);		
		System.out.println(zahl);
		System.out.println();
		int zahl2 = gibPrimzahl2(6) + gibPrimzahl2(20);		
		System.out.println(zahl2);
		
		String n1 = "Peter";
		halloNutzer(n1);
		
		System.out.println(istGerade(11));

		int check = 23;
		System.out.println(istGerade((int)gibPrimzahl2(check)));

		int zahl = 11;
		System.out.println("Der Nachfolger von " + zahl + " ist " + nachfolger(zahl));
		System.out.println("Die Zahl ist " + zahl);
		*/
		
		System.out.println(mittelwert(3,5.0));
		System.out.println(doppel("HALLO WELT"));
		
	}

}
