package uebung6.runnable;

public class SoldatRunnable implements Runnable {
  private static long count = 1;

  private final long id;
  private boolean gepackt;

  public SoldatRunnable() {
    this.id = SoldatRunnable.count++;
    this.gepackt = false;
  }

  @Override
  public void run() {
    if ( !this.gepackt ) {
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
    this.gepackt = true;
  }

  public void essen() {
    System.out.println( "Soldat " + this.id + " geht essen: Hmmmm" );
    try {
      Thread.sleep( (long) ( Math.random() * 5000 ) );
    } catch ( InterruptedException e ) {
    }
    System.out.println( "Soldat " + this.id + " meldet sich zurück vom Essen: Satt" );
  }

}
