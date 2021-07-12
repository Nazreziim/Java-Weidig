package beispiel10;

public class SynchronizedBlock1 {
  private int i = 0;

  public void increment() {
    synchronized ( this ) {
      this.i++;
    }
  }

  public int getI() {
    return this.i;
  }
}
