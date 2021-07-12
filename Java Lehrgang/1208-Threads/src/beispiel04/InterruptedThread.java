package beispiel04;

public class InterruptedThread {

  public static void main( String... args ) {

    // neuen Anonymen Thread anlegen
    Thread t = new Thread() {
      @Override
      public void run() {
        // Ausgabe am Anfang
        System.out.println( "Es gibt ein Leben vor dem Tod.  " );

        // Schleife, bis der Thread interrupted wurde
        while ( !isInterrupted() ) {
          // Ausgabe während er läuft
          System.out.println( "Und er läuft und er läuft und er läuft" );

          try {
            // Pause für 0,5 Sekunden einlegen
            Thread.sleep( 500 );
            // Falls es einen Interrupt gibt, während er schläft...
          } catch ( InterruptedException e ) {
            // Muss das Flag extra gesetzt werden, dies geschieht nicht, während der Thread schläft.
            interrupt();
            // Ausgabe der Statusinformation (Unterbrechung)
            System.out.println( "Unterbrechung in sleep()" );
          }
        }

        // Ausgabe am Ende
        System.out.println( "Das Ende" );
      }
    };

    // Thread starten
    t.start();

    // Schlafen legen des aktuellen Threads
    try {
      Thread.sleep( 2000 );
    } catch ( InterruptedException e ) {
      System.err.println( "Wer sollte mich denn Unterbrechen?" );
    }
    // Den t Thread unterbrechen (Bitten mit der Arbeit aufzuhören.)
    t.interrupt();
  }
}
