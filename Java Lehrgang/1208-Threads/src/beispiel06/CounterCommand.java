package beispiel06;

public class CounterCommand implements Runnable {

  @Override
  public void run() {
    for ( int i = 0; i < 20; ++i ) {
      System.out.println( i );
      try {
        Thread.sleep( 10 );
      } catch ( InterruptedException e ) {
      }
    }
  }

}
