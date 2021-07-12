package beispiel07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolsNutzen {

  public static void main( String[] args ) throws InterruptedException {
    Runnable ra = new Runnable() {
      @Override
      public void run() {
        System.out.println( "A1: " + Thread.currentThread() );
        System.out.println( "A2: " + Thread.currentThread() );
      }
    };

    Runnable rb = new Runnable() {
      @Override
      public void run() {
        System.out.println( "B1: " + Thread.currentThread() );
        System.out.println( "B2: " + Thread.currentThread() );
      }
    };

    ExecutorService executor = Executors.newCachedThreadPool();

    executor.execute( ra );
    executor.execute( rb );

    Thread.sleep( 500 );

    executor.execute( ra );
    executor.execute( rb );

    // Beendet alle Threads im ThreadPool
    executor.shutdown();
  }
}
