package beispiel11;

public class ReentrantLockNutzenFinallyMain {

  public static void main( String[] args ) {
    ReentrantLockNutzenFinally test = new ReentrantLockNutzenFinally();

    Runnable r = new Runnable() {
      @Override
      public void run() {
        for ( int i = 0; i < 10_000; ++i ) {
          test.increment();
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

    System.out.println( test.getI() );
  }

}
