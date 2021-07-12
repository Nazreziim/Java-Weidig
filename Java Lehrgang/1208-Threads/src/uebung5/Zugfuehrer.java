package uebung5;

public class Zugfuehrer {

  public static void main( String[] args ) {
    Kueche kueche = new Kueche();
    Gruppe grp1 = new Gruppe( 8, kueche );
    Gruppe grp2 = new Gruppe( 8, kueche );

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
