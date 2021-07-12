package datentypen;

class Template_Exkurs_String {
	public static void main (String[] args) {
		// 1.) String
		String mein_name = "Lars Gerhard";
		String hs_name = new String("Hoersaal 03");  // das versteht man spätestens in 3 Wochen
		
		// 1.1 Konkatenation
		System.out.println(mein_name + " - das bin ich!");
		System.out.println(mein_name + 'A');   // impl. Casting
		System.out.println(mein_name + 35);    // impl. Casting
		System.out.println(35 + mein_name);
		System.out.println(35 + 35 + mein_name);
		System.out.println(35 + mein_name + 35);
		System.out.println(mein_name + 35 + 35);
		System.out.println(mein_name + 35 * 2);
		System.out.println(mein_name + (35 + 35) );
		
		// 1.2 Methode: charAt
		int pos = 0;
		System.out.println( mein_name.charAt(pos) );
		
		// 2.) Werte einlesen
		System.out.print("Heute ist: ");
		String tag = args[0];
		System.out.println(tag);
		/*System.out.print("Morgen ist: ");
		String morgen = args[1];
		System.out.println(morgen);*/
		// Jetzt mal einen Integer:
		int zahl = Integer.parseInt(args[0]);
		zahl = zahl +3;
		System.out.println(zahl);
		
		// Mit HilfMeth
		//int zahl2 = HilfsMeth.readInt("Wie heisst die Zahl?");
		//System.out.println(zahl2 + 5);
		
	}
}
