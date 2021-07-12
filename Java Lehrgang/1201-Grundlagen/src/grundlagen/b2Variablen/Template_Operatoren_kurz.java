package grundlagen.b2Variablen;

class Template_Operatoren_kurz {
	public static void main(String[] args) {
		// Arithmetische Operatoren
		int erg = 7 / 3;  // ganzzahlige Division
		float float_erg = 7.0f / 3.0f; // Division mit Gleitkommazahlen
		double double_erg = 7 / 3.0;
		float_erg = (float)7 / 3;
		double_erg = 11.0 / 3.0f;
		System.out.println(float_erg);
		System.out.println(double_erg);
		System.out.println(7.0f % 3.2f);   // % geht auch bei float
		
		// Verbundoperatoren
		erg += 5;   // erg = erg + 5;
		
		// Inkrement / Dekrement
		int zahl = 5;
		erg = ++zahl;  //Präfix: erg = zahl + 1; zahl = erg;
		erg = zahl++;  //Postfix: erg = zahl; zahl = zahl + 1; 
		System.out.println(erg);
		zahl = 5;
		erg = ++zahl + zahl++;
		System.out.println(erg);
		System.out.println(zahl);
		
		// Bitlogische Operatoren
		zahl = 5;
		zahl = ~zahl;
		System.out.println(zahl);
		System.out.println(3 & 5);
		
		// Bit-Shift
		System.out.println(3 << 2);
		System.out.println(3 >> 1);
		
		// Bedingungsoperator (tenär)
		int erg1 = 0;
		erg1 = (zahl > 0) ? 100 : -100; // Bitte mal gesehen haben aber nicht benutzen.
	}
}
