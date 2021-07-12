package beispiel10;

public class SynchronizedMethode {

  private int i = 0;

  public synchronized void increment() {
    this.i++;
  }

  public int getI() {
    return this.i;
  }

}
