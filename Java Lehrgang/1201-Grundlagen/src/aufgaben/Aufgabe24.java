package aufgaben;

import java.util.Scanner;

public class Aufgabe24 {

  public static void main( String[] args ) {

/*    int tiere = HilfsMeth.readInt( "Anzahl Schafe:" );

    int geld = (int) Math.pow( tiere, 2 );

    int scheine = geld / 10;

    int alt = ( scheine / 2 + scheine % 2 ) * 10;

    int jung = geld - alt;

    System.out.println( alt + " " + jung + " Differenz: " + ( alt - jung ) );
    

//    for ( long i = 0; i < Math.sqrt( Long.MAX_VALUE ); ++i ) {
//      if ( ( ( i * i ) / 10 ) % 2 == 1 ) {
//        System.out.println( i );
//      }
//    }
    
    // Scheck = 2€ weil:
    // Immer wenn der ältere Mehr bekommt ist die Differenz 4.
    // Der ältere bekommt nur mehr, wenn die Anzahl der Schafe 
    // auf 4 oder 6 endet. => ungerade Anzahl an 10€-Scheinen. */
	  
	  
	  Scanner sc = new Scanner(System.in);
		int anzahlSchafe;
		double betrag;
		double muenzen;
		double scheck = 0;
		double bruderA;
		double bruderB;

		System.out.println("Geben Sie die Anzahl der Schafe ein:");
		anzahlSchafe = sc.nextInt();

		betrag = Math.pow(anzahlSchafe, 2);
		muenzen = betrag % 10;

		bruderA = (betrag - muenzen) / 2;
		if (bruderA % 2 == 1) {
			bruderA += 5;
			bruderB = bruderA - 10 + muenzen;
			scheck = (bruderA - bruderB) / 2;
		} else {
			bruderB = bruderA + muenzen;
		}

		System.out.printf(
				"Insgesamt hatten die Brüder %d Schafe.\nDer Preis pro Schaf waren somit auch %d€.\nSie verdienten insgesamt %.0f € mit dem Verkauf der Herde.\nBruder A erhält %.0f€.\nBruder B erhält %.0f€.\nBruderA muss BruderB %.2f € mit dem Scheck geben.",
				anzahlSchafe, anzahlSchafe, betrag, bruderA, bruderB, scheck);
	}

  }

