package grundlagen.b6IterativeMethoden;

public class Template_Methoden_Ueberladen{
	public static void main( String... args ){
		int ia = 103;
		int ib = 904;
		
		double da = 103.0;
		double db = 904.0;
		
		int c = mittelwert( ia, ib );
		System.out.println( c );
		
		System.out.println( mittelwert( da, db ) );

		double d = mittelwert( ia, db );
		System.out.println( d );
		
	}
	
	// ----> Zuerst reinkopieren
	public static int mittelwert( int a, int b ){
		int ergebnis = a + b;
		ergebnis = ergebnis / 2;
		return ergebnis;
	}
	
	// ----> Als zweites reinkopieren (Warum geht das jetzt nicht?)
//	public static double mittelwert( int a, int b ){
//		int double = a + b;
//		ergebnis = ergebnis / 2.0;
//		return ergebnis;
//	}
	
	// ----> Als drittes reinkopieren (Welches ist besser lesbar?)
	public static double mittelwert( double a, double b ){
		double ergebnis = ( a + b ) / 2;
		return ergebnis;
	}

	// ----> Als viertes reinkopieren (Wird die Methode überhaupt benötigt? ist sie besser lesbar?)
	public static double mittelwert( int a, double b ){
		return ( a + b ) / 2;
	}
	
	// ----> Neuer Abschnitt. Alle reinkopieren. --> Welche ist am besten lesbar?
	static boolean istGerade( int zahl ) {
		if (zahl % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static boolean istGerade2( int zahl ) {
		boolean gerade = zahl % 2 == 0;
		return gerade;
	}

	static boolean istGerade3( int zahl ) {
		return zahl % 2 == 0;
	}
	
	
}