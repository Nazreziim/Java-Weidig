package methoden;

public class Template_Rekursion {
public static void main(String[] args) {
	int n = 4397;
	int m = 5;
	System.out.println("Die Quersumme von " + n + " ist " + quersumme(n));
	System.out.println("Die Fakultaet von " + m + " ist " + fak(m) + " oder mit ner Schleife: " + fak_mit_schleife(m));
	
	n = 5;
	int erg = add(5);
	System.out.println(erg);
	
	String name = "Peter Lustig";
	schreibeRekursiv(name);
	
	schreibeVieleZahlen(10);
	
	System.out.println(isPallindrom("Uh"));
}

public static int quersumme(int z) {
	int qs = 0;
	
	// Berechnung der "primitiven" Quersumme
	while (z != 0) {
		qs = qs + (z % 10);
		z = z / 10;
	}
	
	// Rekursive Weiterreichung ???
	if (qs < 10) {
		return qs;
	} else {
		return quersumme(qs);
	}
			
}

// Iterative (= mit Schleifen) Berechnung der Fakultaet

public static int fakMitSchleife(int n) {
	int erg = 1;
	for (int i=1; i <= n; i++) {
		erg *= i; 
	}
	return erg;	
}


// Rekursive Berechnung der Fakultaet
public static int fak(int n) {
	int erg = 0;
	if (n == 0) {
		erg = 1;  // Rekursionsende
	} else {
		erg = n * fak(n-1); // Rekursionsschritt
	}		
	return erg;
}

static int add(int zahl) {
	int erg = 0;
	// Rekursionsschritt
	if (zahl > 0) {
		erg = add(zahl - 1) + zahl;
	}  else {
		// Rekurssionsabbruch
		erg = 0;
	}		
	return erg;
}

static void schreibeRekursiv(String name) {
	// Rekursionsschritt
	if (name.length() > 1) {
		System.out.println(name.charAt(0));
		System.out.println();
		String namekurz = name.substring(1, name.length());
		schreibeRekursiv(namekurz);
	} //if (name.length() == 1) {
	// Rekursionsabbruch
	else {
		System.out.println(name);
	}
}

static void schreibeVieleZahlen(int anzahl) {
	// Rekursionsschritt
	if (anzahl > 1) {
		schreibeVieleZahlen(anzahl - 1);
		for (int i = 0; i < anzahl; i++) {
			System.out.print(anzahl);
		}
		System.out.println();
	}
	// Rekursionsabbruch
	if(anzahl == 1) {
		System.out.println(anzahl);
	}
}

static boolean isPallindrom(String s) {
	boolean erg = false;
	// Rekursionsschritt
	s = s.toLowerCase(); // alle Buchstaben klein
	if (s.length() > 1) {
		// Prüfen, ob erste und letzte Stelle identische sind
		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			String kurzString = s.substring(1,s.length()-1);
			erg = isPallindrom(kurzString);				
		} else { // frühzeitiger Abbruch
			erg = false;
		}
	}
	// Rekursionsabbruch - leere Worte und Worte mit einem Zeichen sind immer ein Pallindrom
	if (s.length() <= 1) {
		erg = true;
	}
	return erg;
}




}
