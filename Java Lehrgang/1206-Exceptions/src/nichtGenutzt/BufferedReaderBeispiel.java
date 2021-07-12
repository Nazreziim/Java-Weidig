package nichtGenutzt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderBeispiel {
  public static void main( String... strings ) {
    // InputStreamReader ließt Eingaben (Zeichen für Zeichen) von Streams,
    // hier ließt er von der Standardeingabe (die Console).
    InputStreamReader isr = new InputStreamReader( System.in );

    // BufferedReader hat einen Zwischenspeicher, um die Eingabestreams nicht dauerhaft zu
    // reservieren.
    BufferedReader br = new BufferedReader( isr );

    // Diese Klasse BufferedReader eignet sich gut um ganze Zeilen einzulesen.
//    String line = br.readLine(); // Exception muss abgefangen werden.
//    System.out.println( line );

    // Oder einzelne Zeichen.
//    char c = (char) br.read(); // Exception muss abgefangen werden.
//    System.out.println( c );

  }
}
