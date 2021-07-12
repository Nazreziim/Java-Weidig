package datentypen;


class Template_Variablen {
	public static void main (String[] args) {
		
		// 1.) Variablen 
		int zahl = -3; // Das ist eine Deklaration mit Initialisierung
		int zahl2; // Das ist eine Deklaration ohne Initialisierung
				   // ist zwar zulässig aber gefährlich		
		int noch_ne_zahl; 
		int viele_$; 
		int stärke = 100;   //NICHT TUN!
		int änderung = 50;  //AUCH NICHT!
		// int 3zehn;		// Bezeichner müssen mit _ $ oder Buchstaben beginnen		
		System.out.println(zahl);
		System.out.println(änderung);
		
		
		int var1 = 5, var2 = 10, var3 = 15;  // NICHT TUN
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		
		// 2.) Datentypen
		// 2.1 Zahlentypen (ganzzahlig)
		// 2.1.1 byte, short, int
		byte ein_byte = 56;
		byte noch_ein_byte = 100;
		ein_byte = (byte) (ein_byte + noch_ein_byte); // Hier muss gecastet werden!
		int ueberlauf = 2000000000;
		ueberlauf = ueberlauf + ueberlauf;
		ueberlauf = 010;  					//Oktalsystem
		int bin_test = 0b1011; 				//Binärsystem
		int hex_test = 0x3A;				//Hexadezimalsystem
		System.out.println(ein_byte);
		/*System.out.println(noch_ein_byte);
		System.out.println(ueberlauf);
		System.out.println(bin_test);
		System.out.println(hex_test);*/
		
		
		// 2.1.2 long
		long grosse_zahl = 2_000_000_000;
		grosse_zahl = grosse_zahl + grosse_zahl;  //Das ist ein Longwert, der durch die Addition zweier Long-Werte entsteht
		//grosse_zahl = (long) 4_000_000_000;       // Casting geht hier nicht - 4000000000 wird trotzdem als int interpretiert
		grosse_zahl = 4_000_000_000L;
		System.out.println(grosse_zahl);
		
		int grosser_int = 2_000_000_000 + 1_000_000_000;
		System.out.println(grosser_int);
		
		// 2.2 Fliesskommatypen
		double kommazahl = 1.2; 
		kommazahl = kommazahl + 0.000000000000001;
		kommazahl = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;  // Ungenauigkeit bei Fließkommazahlen!!!
		
		double groesster_double = Double.MAX_VALUE;
		groesster_double = groesster_double + 1;
		double kleinster_double = Double.MIN_VALUE;
		kommazahl = 3;
		System.out.println(kommazahl);
		System.out.println(groesster_double);
		
		float floatzahl = (float) 1.2;   //Casting geht!
		floatzahl = 3.67F;
		floatzahl = 3.23E-2F;
		System.out.println(floatzahl);
				
		// 2.3 Wahrheitstypen
		boolean die_wahrheit_ist = true;
		// die_wahrheit_ist = die_wahrheit_ist + (boolean)0b1;  // Casting von int nach boolean ist nicht möglich
		System.out.println(die_wahrheit_ist);
		
		// 2.4 Zeichentypen
		char gib_mir_ein_zeichen = 'A';
		
		char eins = '1';
		int eins_zahl = (int)eins + 3;
		eins = (char) eins_zahl;
		
		System.out.println(gib_mir_ein_zeichen);
		System.out.println(eins_zahl);
		System.out.println(eins);
		// So mache ich aus einem Großbuchstaben einen kleinen
		System.out.println( (char) ( (int)gib_mir_ein_zeichen + 32 ) );
		
		// Und hier das ganze noch mal "abgefahren"
		int abstand_A_a = 'a'  - 'A';
		System.out.println( (char) ( (int)gib_mir_ein_zeichen + abstand_A_a ) );
		
		// Besondere Character
		char besonders = '\'';   // \ ist das Escape-Zeichen
		besonders = '"';         // das muss in einem String escaped werden
		besonders = '\u005A';    // Unicode-Angabe
		besonders = '\\';
		besonders = '\n'; 		 // new line \b = Backspace, \t = Tabulator
		besonders = '\132';		 // Oktal-Zeichen
		System.out.println(besonders);
		System.out.println("Hal\blo \" Welt");
		
		// 3.) Konstanten - immer groß schreiben
		final int KONSTANTE = 5;
		// KONSTANTE = 4;  // Sobald die Konstante einen Wert hat, kann der nicht mehr verändert werden
		
		final int KONST_2;
		KONST_2 = 4;
		
		System.out.println(KONST_2 + KONSTANTE);
		int variable = KONST_2 + KONSTANTE;
		final int KONST_3 = KONST_2 + KONSTANTE;
		
		System.out.println(Math.E);
		
		// 4. ) Sichtbarkeitsbereiche / Gültigkeitsbereiche
		{ // Block 1
			int sichtbar = 5;
			System.out.println(sichtbar);
			{ //Block 1.1
				// int sichtbar = 3;               // sichtbar aus Block 1 existiert hier noch - deshalb kann das nicht neu deklariert werden
				// System.out.println(sichtbar);
			}
		}
		
		{ // Block 2
			int sichtbar = 6;
			System.out.println(sichtbar);
		}		
		int sichtbar = 4;
		System.out.println(sichtbar);
		
		// 5.) Casting 
		// 5.1 implizit
		byte b = 5;
		int in = b;
		
		// Versuch: implizites Casting long -> float
		long lange_zahl = 1345L;
		lange_zahl = Long.MAX_VALUE;
		float float_zahl = lange_zahl;
		System.out.println(lange_zahl);
		System.out.println(float_zahl);
		
		// int -> float
		float_zahl = Integer.MAX_VALUE;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(float_zahl);
		
		// char -> int
		int buchst_als_zahl = 'A';
		System.out.println(buchst_als_zahl);
				
		// 5.2 explizit
		// Größerer in kleinerer Typ
		lange_zahl = (long) 345;
		byte byte_zahl = 67;
		short kurze_zahl = 130;
		byte_zahl = (byte) kurze_zahl;
		System.out.println(byte_zahl);
		
		// Gleitkomma in ganzzahlig
		double doppel_zahl = 1.789;   // .789 wird abgeschnitten - nicht gerundet
		in = (int) doppel_zahl;
		System.out.println(in);
		
		doppel_zahl = 1.2345E50;
		in = (int) doppel_zahl;
		System.out.println(doppel_zahl);
		System.out.println(in);
	}

}


//class Template_Variablen {
//	public static void main (String[] args) {
//		
//		// 1.) Variablen 
//		int zahl = -3; // Das ist eine Deklaration mit Initialisierung
//		int zahl2; // Das ist eine Deklaration ohne Initialisierung
//				   // ist zwar zulässig aber gefährlich		
//		int noch_ne_zahl; 
//		int viele_$; 
//		int stärke = 100;   //NICHT TUN!
//		int änderung = 50;  //AUCH NICHT!
//		// int 3zehn;		// Bezeichner müssen mit _ $ oder Buchstaben beginnen		
//		System.out.println(zahl);
//		System.out.println(änderung);
//		
//		
//		int var1 = 5, var2 = 10, var3 = 15;  // NICHT TUN
//		
//		System.out.println(var1);
//		System.out.println(var2);
//		System.out.println(var3);
//		
//		// 2.) Datentypen
//		// 2.1 Zahlentypen (ganzzahlig)
//		// 2.1.1 byte, short, int
//		byte ein_byte = 56;
//		byte noch_ein_byte = 100;
//		ein_byte = (byte) (ein_byte + noch_ein_byte); // Hier muss gecastet werden!
//		int ueberlauf = 2000000000;
//		ueberlauf = ueberlauf + ueberlauf;
//		ueberlauf = 010;  					//Oktalsystem
//		int bin_test = 0b1011; 				//Binärsystem
//		int hex_test = 0x3A;				//Hexadezimalsystem
//		System.out.println(ein_byte);
//		/*System.out.println(noch_ein_byte);
//		System.out.println(ueberlauf);
//		System.out.println(bin_test);
//		System.out.println(hex_test);*/
//		
//		
//		// 2.1.2 long
//		long grosse_zahl = 2_000_000_000;
//		grosse_zahl = grosse_zahl + grosse_zahl;  //Das ist ein Longwert, der durch die Addition zweier Long-Werte entsteht
//		//grosse_zahl = (long) 4_000_000_000;       // Casting geht hier nicht - 4000000000 wird trotzdem als int interpretiert
//		grosse_zahl = 4_000_000_000L;
//		System.out.println(grosse_zahl);
//		
//		int grosser_int = 2_000_000_000 + 1_000_000_000;
//		System.out.println(grosser_int);
//		
//		// 2.2 Fliesskommatypen
//		double kommazahl = 1.2; 
//		kommazahl = kommazahl + 0.000000000000001;
//		kommazahl = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;  // Ungenauigkeit bei Fließkommazahlen!!!
//		
//		double groesster_double = Double.MAX_VALUE;
//		groesster_double = groesster_double + 1;
//		double kleinster_double = Double.MIN_VALUE;
//		kommazahl = 3;
//		System.out.println(kommazahl);
//		System.out.println(groesster_double);
//		
//		float floatzahl = (float) 1.2;   //Casting geht!
//		floatzahl = 3.67F;
//		floatzahl = 3.23E-2F;
//		System.out.println(floatzahl);
//				
//		// 2.3 Wahrheitstypen
//		boolean die_wahrheit_ist = true;
//		// die_wahrheit_ist = die_wahrheit_ist + (boolean)0b1;  // Casting von int nach boolean ist nicht möglich
//		System.out.println(die_wahrheit_ist);
//		
//		// 2.4 Zeichentypen
//		char gib_mir_ein_zeichen = 'A';
//		
//		char eins = '1';
//		int eins_zahl = (int)eins + 3;
//		eins = (char) eins_zahl;
//		
//		System.out.println(gib_mir_ein_zeichen);
//		System.out.println(eins_zahl);
//		System.out.println(eins);
//		// So mache ich aus einem Großbuchstaben einen kleinen
//		System.out.println( (char) ( (int)gib_mir_ein_zeichen + 32 ) );
//		
//		// Und hier das ganze noch mal "abgefahren"
//		int abstand_A_a = 'a'  - 'A';
//		System.out.println( (char) ( (int)gib_mir_ein_zeichen + abstand_A_a ) );
//		
//		// Besondere Character
//		char besonders = '\'';   // \ ist das Escape-Zeichen
//		besonders = '"';         // das muss in einem String escaped werden
//		besonders = '\u005A';    // Unicode-Angabe
//		besonders = '\\';
//		besonders = '\n'; 		 // new line \b = Backspace, \t = Tabulator
//		besonders = '\132';		 // Oktal-Zeichen
//		System.out.println(besonders);
//		System.out.println("Hal\blo \" Welt");
//		
//		// 3.) Konstanten - immer groß schreiben
//		final int KONSTANTE = 5;
//		// KONSTANTE = 4;  // Sobald die Konstante einen Wert hat, kann der nicht mehr verändert werden
//		
//		final int KONST_2;
//		KONST_2 = 4;
//		
//		System.out.println(KONST_2 + KONSTANTE);
//		int variable = KONST_2 + KONSTANTE;
//		final int KONST_3 = KONST_2 + KONSTANTE;
//		
//		System.out.println(Math.E);
//		
//		// 4. ) Sichtbarkeitsbereiche / Gültigkeitsbereiche
//		{ // Block 1
//			int sichtbar = 5;
//			System.out.println(sichtbar);
//			{ //Block 1.1
//				// int sichtbar = 3;               // sichtbar aus Block 1 existiert hier noch - deshalb kann das nicht neu deklariert werden
//				// System.out.println(sichtbar);
//			}
//		}
//		
//		{ // Block 2
//			int sichtbar = 6;
//			System.out.println(sichtbar);
//		}		
//		int sichtbar = 4;
//		System.out.println(sichtbar);
//		
//		// 5.) Casting 
//		// 5.1 implizit
//		byte b = 5;
//		int in = b;
//		
//		// Versuch: implizites Casting long -> float
//		long lange_zahl = 1345L;
//		lange_zahl = Long.MAX_VALUE;
//		float float_zahl = lange_zahl;
//		System.out.println(lange_zahl);
//		System.out.println(float_zahl);
//		
//		// int -> float
//		float_zahl = Integer.MAX_VALUE;
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(float_zahl);
//		
//		// char -> int
//		int buchst_als_zahl = 'A';
//		System.out.println(buchst_als_zahl);
//				
//		// 5.2 explizit
//		// Größerer in kleinerer Typ
//		lange_zahl = (long) 345;
//		byte byte_zahl = 67;
//		short kurze_zahl = 130;
//		byte_zahl = (byte) kurze_zahl;
//		System.out.println(byte_zahl);
//		
//		// Gleitkomma in ganzzahlig
//		double doppel_zahl = 1.789;   // .789 wird abgeschnitten - nicht gerundet
//		in = (int) doppel_zahl;
//		System.out.println(in);
//		
//		doppel_zahl = 1.2345E50;
//		in = (int) doppel_zahl;
//		System.out.println(doppel_zahl);
//		System.out.println(in);
//	}
//
//}
//
