package beispiel08;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceBeispiel {

  public static void main( String[] args ) {
    // Neuer ThreadPool mit Scheduled Executor Service
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool( 1 );
    
    scheduler.scheduleAtFixedRate( new Runnable() {
      @Override
      public void run() {
        System.out.println( "Tata" );
      }
    },
            1 /* Startverzögerung */,
            2 /* Dauer */,
            TimeUnit.SECONDS );
  }

}
