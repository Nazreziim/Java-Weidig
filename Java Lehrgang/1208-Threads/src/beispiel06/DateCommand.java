package beispiel06;

import java.time.LocalDateTime;

public class DateCommand implements Runnable {

  @Override
  public void run() {
    for ( int i = 0; i < 20; ++i ) {
      System.out.println( LocalDateTime.now() );
      try {
        Thread.sleep( 10 );
      } catch ( InterruptedException e ) {
      }
    }
  }

}
