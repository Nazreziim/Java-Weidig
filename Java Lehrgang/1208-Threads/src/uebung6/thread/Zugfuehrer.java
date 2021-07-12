package uebung6.thread;

public class Zugfuehrer {

  public static void main( String[] args ) {
    Kueche kueche = new Kueche();

    System.out.println( "Zug zum Essen." );
    try {
      Zug zug = new Zug( 4, kueche );
      zug.start();
      zug.join();
    } catch ( InterruptedException e ) {
    }

    System.out.println( "Zug ist vom Essen zurück." );
  }

}
