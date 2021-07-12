package beispiel05;

class AThread extends Thread {
  public int result = 0;

  @Override
  public void run() {
    for ( int i = 0; i < 1000; ++i ) {
      result += i;
    }
  }
}

class BThread extends Thread {
  public long result = 0L;

  @Override
  public void run() {
    for ( int i = 0; i < 1000; ++i ) {
      result *= i;
    }
  }
}

public class Warten {

  public static void main( String[] args ) throws InterruptedException {
    Thread a = new AThread();
    Thread b = new BThread();

    a.start();
    b.start();

    // Warten auf a
    a.join();
    // Warten auf b
    b.join();

  }

}
