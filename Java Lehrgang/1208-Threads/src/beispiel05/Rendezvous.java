package beispiel05;

class JoinerThread extends Thread {
  private int result = 0;

  @Override
  public void run() {
    this.result = 1;
  }

  public int getResult() {
    return this.result;
  }
}

public class Rendezvous {

  public static void main( String[] args ) throws InterruptedException {
    JoinerThread jt = new JoinerThread();
    jt.start();

    // Die nächste Zeile, lasst diesen Thread auf den JoinerThread warten.
    // Wird nicht gewartet, liefert jt.getResult() den Wert 0 zurück, weil die run()-Methode noch nicht durchgelaufen ist.
    // jt.join();
    System.out.println( jt.getResult() );
  }

}
