package beispiel12;

public class LockedArrayListenNutzen {

  public static void main( String[] args ) {
    LockedArrayList< String > liste = new LockedArrayList< String >();

    Runnable schreiber = new Runnable() {
      @Override
      public void run() {
        while ( true ) {
          String s = "Element_" + (int) ( Math.random() * 10 + 1 );
          System.out
                  .println( Thread.currentThread().getName() + " fügt Element '" + s + "' hinzu." );
          liste.add( s );
          try {
            Thread.sleep( 50 );
          } catch ( InterruptedException e ) {
            // tue nichts
          }

        }
      }
    };

    Runnable leser = new Runnable() {
      @Override
      public void run() {
        while ( true ) {
          System.out.println( Thread.currentThread().getName() + " holt Element '"
                  + liste.get( (int) ( Math.random() * liste.length() ) ) + "' von der Liste." );
          try {
            Thread.sleep( 200 );
          } catch ( InterruptedException e ) {
            // tue nichts
          }
        }
      }
    };

    Thread t1 = new Thread( schreiber );
    Thread t2 = new Thread( leser );
    Thread t3 = new Thread( leser );
    Thread t4 = new Thread( leser );
    Thread t5 = new Thread( leser );

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();

    try {
      t1.join();
      t2.join();
      t3.join();
      t4.join();
      t5.join();
    } catch ( InterruptedException e ) {
      // Tue nichts
    }

    System.out.println( "Fertig." );
  }

}
