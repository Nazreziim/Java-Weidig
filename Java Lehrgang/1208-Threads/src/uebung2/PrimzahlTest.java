package uebung2;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PrimzahlTest {

  public static void main( String[] args ) {
    // Teil 2
    System.out.println( "Ab welcher Zahl soll begonnen werden?" );
    int start = zahlEinlesen();
    zehnZahlenPrim( start );

    try {
      Thread.sleep( 5000 );
    } catch ( InterruptedException e ) {
    }

    // Teil 3
    System.out.println( "Ab welcher Zahl wollen sie testen?" );
    start = zahlEinlesen();
    System.out.println( "Wie viele Zahlen wollen Sie testen?" );
    int anzahl = zahlEinlesen();
    anzahlPrim( start, anzahl );

    try {
      Thread.sleep( 5000 );
    } catch ( InterruptedException e ) {
    }

    // Teil 4
    System.out.println( "Startwert:" );
    start = zahlEinlesen();
    System.out.println( "Endwert:" );
    int ende = zahlEinlesen();
    anzahl = ende - start + 1;
    anzahlPrim( start, anzahl );
  }

  // 2
  public static void zehnZahlenPrim( int start ) {
    for ( int i = start; i < start + 10; ++i ) {
      new PrimzahlThread( i ).start();
    }
  }

  // 3
  public static void anzahlPrim( int start, int anzahl ) {
    Thread[] threads = new Thread[ 10 ];
    // Über die Zahlen laufen die geprüft werden
    for ( int i = start; i < start + anzahl; ++i ) {
      boolean gestartet = false;
      // Wiederholen solange der Thread für i noch nicht gestartet wurde
      while ( !gestartet ) {
        // Über die möglichen Threads laufen
        for ( int threadIdx = 0; !gestartet && threadIdx < threads.length; ++threadIdx ) {
          // Prüfen ob kein Thread vorhanden ODER Thread bereits fertig
          if ( threads[ threadIdx ] == null || !threads[ threadIdx ].isAlive() ) {
            // Neuen Thread anlegen
            threads[ threadIdx ] = new PrimzahlThread( i );
            // Neuen Thread starten
            threads[ threadIdx ].start();
            // i als gestartet markieren, es geht weiter mit i+1
            gestartet = true;
          }
        }
      }
    }
  }

  public static int zahlEinlesen() {
    boolean erfolg = false;
    Scanner sc = new Scanner( System.in );
    int result = 0;
    do {
      try {
        result = sc.nextInt();
        erfolg = true;
      } catch ( InputMismatchException e ) {
        System.err.println( "Das war keine Zahl." );
        sc.next();
      } catch ( NoSuchElementException e ) {
        System.err.println( "Da fehlt was?" );
      }
    } while ( !erfolg );
    return result;
  }

}
