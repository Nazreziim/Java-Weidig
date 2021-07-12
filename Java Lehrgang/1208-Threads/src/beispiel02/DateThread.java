package beispiel02;

import java.time.LocalTime;

public class DateThread extends Thread {

  @Override
  public void run() {
    for ( int i = 0; i < 20; ++i ) {
      System.out.println( LocalTime.now() );
    }

  }

}
