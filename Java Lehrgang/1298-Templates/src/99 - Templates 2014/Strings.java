class Strings {
	public static void main (String[] argumente) {
		
		/*
		KONKATENATION
		*/
		String mein_name = "Christian Rolly";
		System.out.println("Mein Name ist " + mein_name);
		System.out.println(mein_name + 'A');
		System.out.println(mein_name + 35);
		System.out.println(35 + mein_name);
		System.out.println(35 + 35 + mein_name);
		System.out.println(mein_name + (35 + 35));
		System.out.println(mein_name + 35 * 'A');
		
		//einzelne Character rausziehen
		System.out.println(mein_name.charAt(3));
		
		/*
		Argumente
		*/
		
		argumente[0] = "Tschuess";
		
		System.out.println(argumente[0] + argumente[1]);
		
		/*
		Werte mit Aufruf einlesen
		*/
		
		System.out.println("Bitte den Namen eingeben!");
		String name = new java.util.Scanner(System.in).next();
		int zahl = new java.util.Scanner(System.in).nextInt();
		
		System.out.println("Hallo " + zahl);
	}
}
