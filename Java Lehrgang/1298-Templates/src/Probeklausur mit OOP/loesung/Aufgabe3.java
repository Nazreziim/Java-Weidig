package loesung;

//Name:
//Dienstgrad:

import java.util.Scanner;

public class Aufgabe3{
	
	public static void main(String[] args) {
		
		Scanner eingabe = new Scanner(System.in);
		System.out.print("Groesse des Array (Zeilen)? ");
		int zeile = eingabe.nextInt();
		System.out.print("Groesse des Array (Spalten)? ");
		int spalte = eingabe.nextInt();
		int[][] feld = new int[zeile][spalte];
		fillArray(feld);
		printArray ( summArray(feld) );
		
	}

	/*liest ein int-Array ein*/
	//hier könnte eine Methode fillArray stehen
	
	/*gibt ein int-Array aus*/
	//hier könnte eine Methode printArray stehen
	
	
	/*  Ergänzen Sie hier Ihre Methode "summArray"  */
		
	
	
	/***
	 * Gibt alle int-werte eines Int-Arrays aus. 
	 */
	private static void printArray(int[] werte) {
		
		for (int index = 0; index < werte.length; index++)
		{
			System.out.println(werte[index] + " ");
		}
	}

	/***
	 * Berechnet die Zeilensummen eines 2.Dim int-Arrays, 
	 * hinterlegt die Ergebnisse in einem 1.Dim Array und gibt diese zurueck.
	 */
	private static int[] summArray(int[][] feld) {

		int[] ergebnis = new int[feld.length];
	
		for (int zeile = 0; zeile < feld.length; zeile++)
		{
			//System.out.println("Eingabe Aktuelle Zeile: " + (zeile+1));
			ergebnis[zeile] = 0;

			for (int spalte = 0; spalte < feld[zeile].length; spalte++)
			{
				//System.out.printf("Eingabe Aktuelle Spalte: %d\n", (spalte + 1));
				ergebnis[zeile] += feld[zeile][spalte];
			}
		}
		
		return ergebnis;
	}

	/***
	 * Routine zum Befuellen eines 2.Dim int-Arrays ueber Tastatur
	 */
	private static void fillArray(int[][] feld) {
		Scanner eingabe = new Scanner(System.in);
		
		for (int zeile = 0; zeile < feld.length; zeile++)
		{
			System.out.println("Eingabe Aktuelle Zeile: " + (zeile+1));
			
			for (int spalte = 0; spalte < feld[zeile].length; spalte++)
			{
				System.out.printf("Eingabe Aktuelle Spalte: %d =>", (spalte + 1));
				feld[zeile][spalte] = eingabe.nextInt();
			}
		}
	}
	
}

