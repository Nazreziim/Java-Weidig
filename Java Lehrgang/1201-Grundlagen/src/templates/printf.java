package templates;
import java.util.Locale;

public class printf {
	//Formatierungsregel: %[flags][width][.precision]conversion-character (z.B. %-10.2f
	//																			(Minus = Linksb�ndig)
	//																			(10 = Mindestens 10 Zeichen [ohne Minus = Rechtsb�ndig])
	//																			(.2 = 2 Nachkommastellen (mit Zeichen. [wahlweise auch , o.�.])
	//																			(f = Float)
	// Formatierungszeichen: s = Zeichenfolgen, d = Dezimalzahlen, f = Flie�kommazahlen, t = Datum/Uhrzeitswerte
	
	public static void main(String[] args) {
		System.out.printf("baeldung%nline%nterminator"); //%n als Trennzeichen
		
		//String-Formattierung
		System.out.printf("'%s' %n", "baeldung"); //String klein und Absatz
		System.out.printf("'%S' %n", "baeldung"); //String gro� und Absatz
		
		System.out.printf("'%15s' %n", "baeldung");//Mindestel�nge 15 String klein und Absatz
		System.out.printf("'%-20s' %n", "baeldung");//Linksb�ndig Mindestl�nge 10 String klein und Absatz 
		
		System.out.printf("%2.2s %n", "Hi there!"); //Die erste �x� - Nummer in der % x.ys -Syntax ist das Auff�llen 
												 //Y ist die Anzahl der Zeichen. --> Ausgabe: Hi
		
		System.out.printf("%d er String: %s %n %d er String: %s %n", 1, "Wort1", 2, "Wort2");
												//%d --> Dezimalzahl deren Zuweisung nach dem Hauptstring erfolgt
												//%s --> String 
												//%n --> Absatz
												//Bei printf wird von links nach rechts gepr�ft welche Flag (String, Int etc.)
												//Genutzt wird und anschlie�end nach dem ersten Komma ebenfalls von
												//links nach rechts der Wert zugewiesen.
		
		
		//GanzzahlFormatierung
		System.out.printf(Locale.US, "%,d %n", 10000); //Ausgabe: 10,000
		System.out.printf(Locale.ITALY, "%,d %n", 10000); //Ausgabe: 10.000
		//ACHTUNG LOCALE MUSS IMPORTIERT WERDEN
		
		//Fload- und Double Formatierung
		System.out.printf("'%5.2f'%n", 5.1473); //Breite: 5, und L�nge des Dezimalteils ist 2 (rundet automatisch)
		//LOCALE und , etc. sind hier nicht ver�nderbar
		//�ndern des Kommas:
		System.out.println(String.format(Locale.ROOT, "'%5.2f'%n", 5.1473));
										//FORMAT, ARGS
										//--> Locale, printf text, printf variablen
		
	}
}
