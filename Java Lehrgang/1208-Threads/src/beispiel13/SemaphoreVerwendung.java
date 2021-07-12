package beispiel13;

import java.util.concurrent.Semaphore;

public class SemaphoreVerwendung {
  private final int maxAvailable = 100;
  private Semaphore available = new Semaphore( maxAvailable, true );

  // Keine effiziente Datenstruktur, nur zum Zeigen.
  protected Object[] items = new Object[ this.maxAvailable ];
  protected boolean[] used = new boolean[ this.maxAvailable ];

  // Ressource holen / sperren
  public Object getItem() throws InterruptedException {
    available.acquire();
    return getNextAvailableItem();
  }

  // Ressource zurückgeben / freigeben
  public void putItem( Object x ) {
    if ( markAsUnused( x ) )
      available.release();
  }

  protected synchronized Object getNextAvailableItem() {
    for ( int i = 0; i < this.maxAvailable; ++i ) {
      if ( !used[ i ] ) {
        used[ i ] = true;
        return items[ i ];
      }
    }
    return null;
  }

  protected synchronized boolean markAsUnused( Object item ) {
    for ( int i = 0; i < this.maxAvailable; ++i ) {
      if ( item == items[ i ] ) {
        if ( used[ i ] ) {
          used[ i ] = false;
          return true;
        } else
          return false;
      }
    }
    return false;
  }
}
