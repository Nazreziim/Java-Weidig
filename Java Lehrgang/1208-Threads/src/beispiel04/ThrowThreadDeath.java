package beispiel04;

public class ThrowThreadDeath {

  public static void main( String[] args ) {
    Thread t = new Thread() {
      @Override
      public void run() {
        try {
          while ( true )
            System.out.println( "I Like To Move It." );
        } catch ( ThreadDeath td ) {
          System.out.println( "Das Leben ist nicht totzukriegen." );
          td.printStackTrace();
          throw td;
        }
      }
    };
    t.start();
    try {
      Thread.sleep( 1 );
    } catch ( InterruptedException e ) {
    }
    t.stop();
    try {
      Thread.sleep( 1 );
    } catch ( InterruptedException e ) {
    }
    System.out.println( "Thread t wurde gestoppt." );
  }

}
