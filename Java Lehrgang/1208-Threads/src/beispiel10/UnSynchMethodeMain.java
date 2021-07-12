package beispiel10;

public class UnSynchMethodeMain {

  public static void main( String[] args ) {
    UnSynchMethode uMeth = new UnSynchMethode();

    Runnable r = new Runnable() {
      @Override
      public void run() {
        for ( int i = 0; i < 10_000; ++i ) {
          uMeth.increment();
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

    System.out.println( uMeth.getI() );

  }

}
