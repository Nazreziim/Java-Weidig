package nichtGenutzt;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerBeispiel {

  public static void main( String[] args ) {
    // Die Scanner Klasse repräsentiert einen Parser, der auf InputStreams angewendet werden kann.
    // Zum Beispiel die Standardeingabe (Console).
    // Ein Parser zerlegt eine Zeichenkette in Tokens (Elemente), die Standardeinstellung ist die
    // Trennung bei Whitespaces.
    Scanner sc = new Scanner( System.in );

    // Der Scanner kann ebenfalls eine komplette Zeile lesen,
    // (in einen String)
    String line = sc.nextLine();
    System.out.println( line );

    // oder das nächste Token,
    String input = sc.next();
    System.out.println( input );

    try {
      // oder das nächste Token (interpretiert als Integer),
      Integer i = sc.nextInt();
      System.out.println( i );
    } catch ( InputMismatchException e ) {
      System.err.println( sc.next() + " ist keine Zahl." );
    }

    try {
      // oder das nächste Token (interpretiert als Long), usw. usf
      Long l = sc.nextLong();
      System.out.println( l );
      // Sie finden alle Methoden wie immer in der JavaDoc.
    } catch ( InputMismatchException e ) {
      System.err.println( sc.next() + " ist keine Zahl." );
    }

    // Sie können auch das Pattern ändern, zum Beispiel in ein Komma:
    sc.useDelimiter( "," );
    // von nun an wird der Input durch Kommas in Token getrennt.
    System.out.println( sc.next() );
    System.out.println( sc.next() );
  }

}
