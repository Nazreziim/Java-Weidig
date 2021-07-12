package grundlagen.b2Variablen;

class Template_Operatoren {
	public static void main(String[] args) {
		// Variablendeklaration ohne Wertzuweisung
		int eine_zahl;
		
		// 1.) Zuweisungsoperator
		eine_zahl = 68;
		System.out.println(eine_zahl);      // Ausgabe: 68
		System.out.println(eine_zahl = 47); // 1. Zuweisung 2. Ausgabe: 47
		System.out.println(eine_zahl);      // Ausgabe: 47
		System.out.println();
		
		// 2.) Arithmetische Operatoren
		//     Deklarationen:
		int zahl_1 = 64;
		int zahl_2 = 0xA;    // Hexadezimale Zahl
		float zahl_3 = 4.2F;
		int zahl_4 = 010;    // Eine Zahl im Oktalsystem
		int zahl_5 = 7;
		
		System.out.println(zahl_1 + zahl_5);		
		zahl_2 = zahl_1 + zahl_5;  // zahl_2 wird zu 71
		zahl_4 = zahl_5 * 4;       // zahl_4 wird zu 28
		float ergebnis = zahl_4 - zahl_3; // linke Seite der Zuweisung muss vom Datentyp float sein
		System.out.println(ergebnis);
		
		// Division unterschiedlicher Zahl-Datentypen 
		// - float / float => float
		// - int / float   => float
		// - float / int   => float
		// - int / int     => int		
		float ergebnis_2 = 21 / 8.0f;
		System.out.println(ergebnis_2);
		// System.out.println(21 / 0);  // Hier wird eine Exception geworfen - kompilierbar ist das aber noch!
		System.out.println("Willkommen in der 2. Klasse - wir rechnen heute 21:8");
		System.out.println("21 : 8 = " + 21 / 8 + " Rest " + 21 % 8);
		System.out.println(7.0f % 3.2f);   // % geht auch bei float
		
		// 3.) Kombinationen aus arithmetischen und Zuweisungsoperatoren
		int z1 = 5;
		z1 += 4;                 // z1 = z1 + 4;
		System.out.println(z1);
		z1 -= 3;                 // z1 = z1 - 3;
		z1 /= 2;                 // z1 = z1 / 2;
		System.out.println(z1);
		System.out.println();
		
		// 4.) Arithmetische Operatoren: Inkrement / Dekrement
		int z2;
		z2 = 7;
		z2++; // z2 = z2 + 1;
		System.out.println(z2);
		z2--; // z2 = z2 - 1;
		System.out.println(z2);
		
		int z3 = 10;
		System.out.println(z3++);  // postfix: z3 wird erst NACH seiner Ausgabe erhöht
		System.out.println(z3);
		
		z3 = 10;
		System.out.println(++z3);  // präfix: z3 wird schon VOR der Ausgabe erhöht
		System.out.println(z3);
		
		int zahl = 5;
		int erg = ++zahl;  //Präfix: erg = zahl + 1; zahl = erg;
		erg = zahl++;  //Postfix: erg = zahl; zahl = zahl + 1; 
		System.out.println(erg);
		zahl = 5;
		erg = ++zahl + zahl++;
		System.out.println(erg);
		System.out.println(zahl);
		
		// 5.) Relationale Operatoren - Ergebnis ist IMMER boolean!
		System.out.println(3 < 7); 
		boolean istGleich = 5 == 8;
		System.out.println(istGleich);
		istGleich = 'U' != 'X';
		System.out.println(istGleich);
		System.out.println();
		
		// 6.) Logische Operatoren - bekommen immer boolesche Operanden
		boolean istRot = true;
		boolean istGerade = false;
		boolean istErsteHaelfte = true;
		
		System.out.println(!(istRot || istGerade));
		
		//                 true        true              => true
		System.out.println(z3 == 11 && istErsteHaelfte);
		
		//                 true            false             => true
		System.out.println(zahl_5 > -10 || ergebnis == 23.0);
		
		
		// 7.) Bitlogische Operatoren
		System.out.println("\n Bitlogische Operatoren");
		zahl = 5;
		zahl = ~zahl;
		System.out.println(zahl);
		System.out.println(3 & 5);
		
		// Bit-Shift
		System.out.println(3 << 2);
		System.out.println(3 >> 1);
		
		// Bedingungsoperator (tenär)
		int erg2 = 0;
		erg2 = (zahl > 0) ? 100 : -100; // Bitte mal gesehen haben aber nicht benutzen.
	}
}
