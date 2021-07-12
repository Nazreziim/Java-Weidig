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
          // Ausgabe w�hrend er l�uft
          System.out.println( "Und er l�uft und er l�uft und er l�uft" );

          try {
            // Pause f�r 0,5 Sekunden einlegen
            Thread.sleep( 500 );
            // Falls es einen Interrupt gibt, w�hrend er schl�ft...
          } catch ( InterruptedException e ) {
            // Muss das Flag extra gesetzt werden, dies geschieht nicht, w�hrend der Thread schl�ft.
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
    // Den t Thread unterbrechen (Bitten mit der Arbeit aufzuh�ren.)
    t.interrupt();
  }
}
