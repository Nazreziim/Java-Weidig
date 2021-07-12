package beispiel07;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SorterMain {

  public static void main( String[] args ) {
    // Byte Array mit 4 Millionen Feldern erstellen
    byte[] b = new byte[ 4_000_000 ];

    // Felder mit Zufallswerten belegen.
    new Random().nextBytes( b );
    // Anfangswerte ausgaben
    System.out.printf( "%d, %d, %d%n", b[ 0 ], b[ 1 ], b[ b.length - 1 ] );

    // Neues Callable Objekt anlagen
    Callable< byte[] > c = new SorterCallable( b );

    // Wachsenden Thread Pool erstellen
    ExecutorService executor = Executors.newCachedThreadPool();

    // Callable an den ThreadPool senden
    Future< byte[] > result = executor.submit( c );

    // Ergebnis Variable
    byte[] bs;

    try {
      // Auf das Ergebnis des Threads warten
      bs = result.get();
      // Teile des Ergebnis ausgeben
      System.out.printf( "%d, %d, %d%n", bs[ 0 ], bs[ 1 ], bs[ bs.length - 1 ] );
    } catch ( InterruptedException | ExecutionException e ) {
      e.printStackTrace();
    }

    // Executor Service (ThreadPool) beenden. Ohne diese Zeile endet das Programm nicht!
    executor.shutdown();
  }

}
