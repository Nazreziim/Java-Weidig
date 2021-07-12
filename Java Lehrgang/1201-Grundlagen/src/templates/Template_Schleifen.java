package templates;

import java.util.Scanner;


public class Template_Schleifen {

	/**
	 * Addition von int-Werten
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner eingabe = new Scanner(System.in);
		int eingabeWert = 0;
		int anzahlWerte = 0;
		int ergebnis = 0;
		anzahlWerte = HilfsMeth.readInt("Anzahl Werte: ");
		System.out.print("Wie viele Werte sollen addiert werden: ");
		anzahlWerte = eingabe.nextInt();
		
		
		// while-Schleife - kopfgesteuerte Schleife
		
		// 1. Laufvariable muss deklariert werden
		int aktuelleAnzahl = 0;
		// 2. Eintrittbedingung muss erfuellt sein (TRUE)
		// Wie oft soll die Schleife durchlaufen werden? von 0 bis n-mal
		
		while (aktuelleAnzahl < anzahlWerte)
		{
			// Eingabe der Werte
			// Abfrage der Werte
			System.out.printf("Geben Sie die %d .Zahl ein: ", aktuelleAnzahl + 1);
			eingabeWert = eingabe.nextInt();
			
			// Verarbeitung der Werte
			ergebnis = ergebnis + eingabeWert;
			
			// 3. Laufvariable hochzaehlen
			aktuelleAnzahl++;
		}
		
		// Ausgabe der Daten
		System.out.println("Ergebnis : " + ergebnis);
		
		//**************************************************************************
		// do-while-Schleife - fussgesteuerte Schleife
		// // Wie oft soll die Schleife durchlaufen werden? von 1 bis n-mal
		// jede Schleife ist auch mit einem Label zu versehen, macht jedoch
		// nur Sinn bei verschachtelten Schleifen
		Name:
		do
		{
			// alle Schleifen abbrechbar mit break-Anweisung
			break Name;
		}while(true);
		
		
		//**************************************************************************
		// for-Schleife - Zaehlschleife
		// for ( Initialisierung; Bedingung; Aktualisierung) // Schleifenkopf
		// 1. Bei Eintritt in die Schleife, wird Initialisiert(Laufvariable deklariert und initialisiert 
		//  
		// 2. Prüfung der Bedingung
		//    wenn TRUE dann fuehre alle Anweisungen in der Schleife durch (Schleifenrumpf)
		//    wenn FALSE dann gehe nicht in die Schleife
		// 3. Am Ende der Schleife, Sprung zum Schleifenanfang; 
		//    Aktualisierung wird durchgefuehrt und siehe Punkt 2 (Laufvariable erhoeht)
		ergebnis = 0;
		 
		for ( int anzahl = 0; anzahl < anzahlWerte; anzahl++)
		{
			// Eingabe der Werte
			// Abfrage der Werte
			System.out.printf("Geben Sie die %d .Zahl ein: ", anzahl + 1);
			eingabeWert = eingabe.nextInt();
			
			// Verarbeitung der Werte
			ergebnis += eingabeWert;
			
		}
		
		// Ausgabe der Daten
		System.out.println("Ergebnis : " + ergebnis);

		
		// for-each-Schleife, nur bei Datenstrukturen anwendbar z.B. Arrays
		// for ( int wert : Reihe) Ausblick

		//********************************************************************
		
		// Ausgabe von Zahlen 1 - 10 
		
		final int maxWert = 10;
		int aktuellerWert = 1;
		
		// Eintrittsbedingung muss erfuellt sein (Ausdruck => TRUE)
		while ( aktuellerWert <= maxWert)
		{
			System.out.print(aktuellerWert + " ");
			// hochzaehlen nicht vergessen!!
			aktuellerWert++;
		}
		System.out.println();
		
		// Ausgabe von Zahlen 10 - 1 reverse
		for (int i = 10; i > 0; i--)
		{
			System.out.printf("%3d",i);
		}
		System.out.println();
		
		
		// verschachtelten Schleifen ************************************
		// mit * Rechteck fuellen
		for ( int zeile = 0; zeile < 5; zeile++ )
		{
			for ( int spalte = 0; spalte < 10; spalte++)
			{
				System.out.print("*");
			}
			// Zeilenumbruch
			System.out.println();
		}
		
		// Zeilenumbruch
		System.out.println();
		
		// nur einen Rahmen mit * zeichnen
		for ( int zeile = 0; zeile < 5; zeile++ )
		{
			for ( int spalte = 0; spalte < 10; spalte++)
			{
				if ( (zeile == 0)  || (zeile == 4) ||
					 (spalte == 0) || (spalte == 9)  )
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			// Zeilenumbruch
			System.out.println();
		}
	}
}
