package uebung6.thread;

public class Soldat extends Thread {
  private static long count = 1;

  private final long id;
  private boolean gepackt = false;

  public Soldat() {
    this.id = Soldat.count++;
  }

  public Soldat( long id ) {
    this.id = id;
  }

  public Soldat( long id, boolean gepackt ) {
    this.id = id;
    this.gepackt = gepackt;
  }

  @Override
  public void run() {
    if ( !gepackt ) {
      this.packen();
    } else {
      this.essen();
    }
  }

  public void packen() {
    System.out.println( "Soldat " + this.id + " meldet sich ab zum Ausrüstung Packen: Ciao" );
    try {
      Thread.sleep( (long) ( Math.random() * 5000 ) );
    } catch ( InterruptedException e ) {
    }
    System.out.println(
            "Soldat " + this.id + " meldet sich zurück vom Ausrüstung Packen: Wieder da" );
  }

  public void essen() {
    System.out.println( "Soldat " + this.id + " geht essen: Hmmmm" );
    try {
      Thread.sleep( (long) ( Math.random() * 5000 ) );
    } catch ( InterruptedException e ) {
    }
    System.out.println( "Soldat " + this.id + " meldet sich zurück vom Essen: Satt" );
  }

  public long getId() {
    return this.id;
  }
}
