package beispiel10;

public class SynchronizedBlock2 {
  private int i = 0;
  private int j = 0;

  private Object iMonitor = new Object();
  private Object jMonitor = new Object();

  public void increment() {
//    synchronized ( iMonitor ) {
      this.i++;
//      try {
//        Thread.sleep( 200 );
//      } catch ( InterruptedException e ) {
//        // Tue nichts
//      }
//    }
  }

  public void decrement() {
//    synchronized ( jMonitor ) {
      this.j--;
//      try {
//        Thread.sleep( 200 );
//      } catch ( InterruptedException e ) {
//        // Tue nichts
//      }
//    }
  }

  public int getI() {
    return this.i;
  }

  public int getJ() {
    return this.j;
  }
}
