package loesung;

//Name:
//Dienstgrad:

//Name:
//Dienstgrad:
import java.util.Scanner;

import loesung_imp.HilfsMeth;

public class Aufgabe2 {
	
	public static void main(String[] args) {
		
		/*Scanner eingabe = new Scanner(System.in);
		System.out.println("Geben Sie die umzudrehende Zahl ein: ");
		int zahl = eingabe.nextInt();
		
		//System.out.println(reverse(zahl));
		//System.out.println(reverse2(zahl));
		//System.out.println(reverse3(zahl));
		//System.out.println(reverse4(zahl));
		System.out.println(reverse_rek(zahl));*/
	

	System.out.println(rev(HilfsMeth.readInt("Zahl !")));
	}
	public static int rev(int x){
		return rev1(0, x);
	}
	
	public static int rev1(int summe, int zahl){
		int ergebnis = 0;
		if (zahl == 0) {
			ergebnis = summe;
		}
		else {
			ergebnis = rev1(10 * summe + zahl % 10, zahl / 10);
		}
			return ergebnis;
		
		
	
	}
	
	/*    Hierher gehört Ihre Methode "reverse" .  */
	
	/***
	 * Wandelt eine Ziffer in ein Character um.
	 */
	private static char toChar(int ziffer)
	{
		return (char) (ziffer + '0');
	}
	
	/***
	 * Ermittelt die Anzahl Ziffern einer Zahl
	 * @param zahl
	 * @param basis
	 * @return Anzahl der Ziffern der uebergebenen Zahl
	 */
	private static int gebeAnzahlZiffern(int zahl, int basis)
	{
		int anzahlStellen = 0;
		while (zahl != 0)
		{
			zahl /= basis;
			anzahlStellen++;
		}
		
		return anzahlStellen;
	}
	
	/***
	 * Invertiert die uebergebene Zahl
	 * @param zahl
	 * @return Char-Array (Invertierte Zahl als String) 
	 */	
	private static char[] reverse(int zahl)
	{
		final int basis = 10;
		final int maxStellen = 10;
		int laufvar = 0;
		int beginIndex = 0;
		char[] hilfsArray = new char[maxStellen];
		
		if (zahl == 0)
		{
			return new char[] {'0'};
		}
				
		// Vorinitialisieren
		for ( int i = 0; i < hilfsArray.length; i++)
		{
			hilfsArray[i] = '0';
		}
		
		// Zahl in String konvertieren und reverse ablegen
		while (zahl != 0)
		{
			hilfsArray[laufvar] = toChar(zahl % basis);
			zahl /= basis;
			laufvar++;
		}
		
		// fuehrende Nullen entfernen
		while (hilfsArray[beginIndex] == '0') 
		{
			beginIndex++;
		}
		
		// Anzahl Ziffern
		char[] ergebnis = new char[laufvar - beginIndex];
		
		for ( int i = 0; i < ergebnis.length; i++)
		{
			ergebnis[i] = hilfsArray[beginIndex++];
		}
		
		return ergebnis;
	}
	
	/***
	 * Invertiert die uebergebene Zahl
	 * @param zahl
	 * @return Char-Array (Invertierte Zahl als String) 
	 */
	private static char[] reverse2(int zahl)
	{
		final int basis = 10;

		int zahlRev = reverse3(zahl);
		
		// Anzahl Ziffern
		char[] ergebnis = new char[gebeAnzahlZiffern(zahlRev, basis)];
		
		// Array reverse befuellen
		for ( int i = ergebnis.length - 1; i >= 0; i--)
		{
			ergebnis[i] = toChar(zahlRev % basis);
			zahlRev /= basis;
		}
		
		return ergebnis;
	}
	
	/***
	 * Invertiert die uebergebene Zahl
	 * @param zahl 
	 * @return int-Wert der uebergebenen Zahl
	 */
	private static int reverse3(int zahl)
	{
		final int basis = 10;

		int zahlRev = 0;
				
		// Zahl in String konvertieren und reverse ablegen
		while (zahl != 0)
		{
			// invertieren mit Horner-Schema, dadurch wird letzte Stelle zur hoechsten Stelle
			zahlRev = zahlRev * basis + (zahl % basis);
			zahl /= basis;
		}
				
		return zahlRev;
	}
	
	/***
	 * Invertiert die uebergebene Zahl
	 * @param zahl
	 * @return Char-Array (Invertierte Zahl als String) 
	 */	
	private static char[] reverse4(int zahl)
	{
		final int basis = 10;
		final int maxStellen = 10;
		int laufvar = 0;
		int ziffer = 0;
		char[] hilfsArray = new char[maxStellen];
		boolean istVorneNull = true;
		boolean restOk = false;
					
		// Vorinitialisieren
		for ( int i = 0; i < hilfsArray.length; i++)
		{
			hilfsArray[i] = '0';
		}
		
		// Zahl in String konvertieren und reverse ablegen
		while (zahl != 0)
		{
			// letzte Ziffer ermitteln
			ziffer = zahl % basis;
			
			istVorneNull = (ziffer  == 0);
			
			if (!istVorneNull || restOk)
			{
				hilfsArray[laufvar] = toChar(ziffer);
				laufvar++;
				restOk = true;
			}
			zahl /= basis;
		}
		
		
		// Anzahl Ziffern
		char[] ergebnis = new char[laufvar];
		
		for ( int i = 0; i < ergebnis.length; i++)
		{
			ergebnis[i] = hilfsArray[i];
		}
		
		return ergebnis;
	}
	
	public static int gebeAnzahlStellen_rek(int zahl)
	{
		final int basis = 10;
		int erg = 0;
		
		if (zahl < basis )
		{
			erg = 1;
		}
		else
		{
			erg = 	1 + gebeAnzahlStellen_rek(zahl/basis);
		}
		return erg;
	}
	
	private static int potenz_rek(int basis, int exp)
	{
		int erg = 0;
		if (exp == 0)
		{
			erg = 1;
		}
		else if ( exp == 1 )
		{
			erg = basis;	
		}
		else
		{
			erg = 	potenz_rek(basis, exp-1) * basis;
		}
		return erg;
	}
	
	/***
	 * Invertiert die uebergebene Zahl
	 * @param zahl 
	 * @return int-Wert der uebergebenen Zahl
	 */
	private static int reverse_rek(int zahl)
	{
		final int basis = 10;
		int ergebnis = 0;
		int wert =  zahl % basis;
		
		
		if (zahl < basis)
		{
			ergebnis = 	zahl; // einstellige Zahl
		}
		else
		{
			
			wert = wert *  potenz_rek(basis, gebeAnzahlStellen_rek(zahl)-1);
			ergebnis = wert + reverse_rek(zahl/basis);
		}
			
		return ergebnis;
	}
	

}
