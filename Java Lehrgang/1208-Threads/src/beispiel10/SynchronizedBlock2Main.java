package beispiel10;

public class SynchronizedBlock2Main {

  public static void main( String[] args ) {
    long start = System.nanoTime();

    SynchronizedBlock2 block2 = new SynchronizedBlock2();

    Runnable r = new Runnable() {
      @Override
      public void run() {
        for ( int i = 0; i < 10_000; ++i ) {
          block2.increment();
          block2.decrement();
        }
      }
    };

    Thread t1 = new Thread( r );
    Thread t2 = new Thread( r );

    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch ( InterruptedException e ) {
      // Tue nichts.
    }

    System.out.println( block2.getI() );
    System.out.println( block2.getJ() );

    System.out.println(
            "Dauer: " + String.format( "%,d", System.nanoTime() - start ) + " Nanosekunden." );
  }
}
