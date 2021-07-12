package uebung3;

public class Soldat extends Thread {
  private static long count = 1;

  private final long id;

  public Soldat() {
    this.id = Soldat.count++;
  }

  @Override
  public void run() {
    this.packen();
  }

  public void packen() {
    System.out.println( "Soldat " + this.id + " meldet sich ab zum Ausr�stung Packen: Ciao" );
    try {
      Thread.sleep( (long) ( Math.random() * 5000 ) );
    } catch ( InterruptedException e ) {
    }
    System.out.println(
            "Soldat " + this.id + " meldet sich zur�ck vom Ausr�stung Packen: Wieder da" );
  }
}
