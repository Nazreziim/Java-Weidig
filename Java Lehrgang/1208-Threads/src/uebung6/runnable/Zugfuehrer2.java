package uebung6.runnable;

public class Zugfuehrer2 {

  public static void main( String[] args ) {
    Kueche2 kueche = new Kueche2();

    System.out.println( "Zug zum Essen." );
    try {
      Zug2 zug = new Zug2( 4, kueche );
      zug.start();
      zug.join();
    } catch ( InterruptedException e ) {
    }

    System.out.println( "Zug ist vom Essen zurück." );
  }

}
