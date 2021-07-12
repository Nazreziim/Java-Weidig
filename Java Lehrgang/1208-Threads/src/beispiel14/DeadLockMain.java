package beispiel14;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class T1 extends Thread {
  @Override
  public void run() {
    DeadLockMain.lock1.lock();
    System.out.println( "T1: Lock auf lock1 bekommen" );

    try {
      TimeUnit.SECONDS.sleep( 1 );
    } catch ( InterruptedException e ) {
    }

    DeadLockMain.lock2.lock();
    System.out.println( "T1: Lock auf lock2 bekommen" );

    DeadLockMain.lock2.unlock();
    DeadLockMain.lock1.unlock();
  }
}

class T2 extends Thread {
  @Override
  public void run() {
    DeadLockMain.lock2.lock();
    System.out.println( "T2: Lock auf lock2 bekommen" );

    DeadLockMain.lock1.lock();
    System.out.println( "T2: Lock auf lock1 bekommen" );

    DeadLockMain.lock1.unlock();
    DeadLockMain.lock2.unlock();
  }
}

public class DeadLockMain {

  static Lock lock1 = new ReentrantLock();
  static Lock lock2 = new ReentrantLock();

  public static void main( String[] args ) {
    new T1().start();
    new T2().start();
  }

}
