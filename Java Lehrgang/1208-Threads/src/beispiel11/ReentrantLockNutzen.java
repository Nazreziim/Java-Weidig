package beispiel11;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockNutzen {
  private int i = 0;
  ReentrantLock lock = new ReentrantLock();

  public void increment() {
    lock.lock();
    this.i++;
    lock.unlock();
  }

  public int getI() {
    return this.i;
  }
}
