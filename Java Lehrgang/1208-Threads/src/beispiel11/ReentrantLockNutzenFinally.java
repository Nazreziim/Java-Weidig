package beispiel11;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockNutzenFinally {
  private int i = 0;
  ReentrantLock lock = new ReentrantLock();

  public void increment() {
    // Lock erfragen
    lock.lock();
    try {
      i++;
      // In einem Prozent der Fälle soll eine Exception geworfen werden.
      if ( Math.random() > 0.99 ) {
        throw new IOException();
      }
    } catch ( IOException e ) {
      // Ausgabe bei Exception
      System.out.println( "Misst da ist was schief gelaufen" );
      // Simulation, dass der Rest nicht mehr ausgeführt wird.
      return;
    }
    // Lock zurückgeben
    lock.unlock();
  }

  public int getI() {
    return this.i;
  }
}
