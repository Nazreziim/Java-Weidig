package uebung4;

public class Zugfuehrer {

  public static void main( String[] args ) {
    Gruppe grp1 = new Gruppe( 8 );
    Gruppe grp2 = new Gruppe( 8 );

    System.out.println( "Gruppen 1 + 2 zum Essen." );
    grp1.start();
    grp2.start();

    try {
      grp1.join();
      grp2.join();
    } catch ( InterruptedException e ) {
    }

    System.out.println( "Gruppen 1 + 2 sind vom Essen zurück." );
  }

}
