package schritt2MitGeneric;

import schritt1OhneGeneric.hund.Hund;
import schritt1OhneGeneric.katze.Katze;
import schritt1OhneGeneric.object.Mensch;
import schritt1OhneGeneric.object.Schueler;

public class BoxTest {
  public static void main( String[] args ) {

    Box< Hund > box1 = new Box< Hund >( new Hund() );
    Box< Katze > box2 = new Box< Katze >( new Katze() );
    Box< Mensch > box3 = new Box< Mensch >( new Mensch() );
    Box< Schueler > box4 = new Box< Schueler >( new Schueler() );

    System.out.println( box1.getInhalt() );
    box1.getInhalt().bellen();
    // box1.getInhalt().miau(); // Geht nicht, weil kein Hund

    System.out.println( box2.getInhalt() );
    // box2.getInhalt().bellen();
    box2.getInhalt().miau();

    System.out.println( box3.getInhalt() );
    box3.getInhalt().sprechen();

    System.out.println( box4.getInhalt() );
    box4.getInhalt().sprechen();
    box4.getInhalt().lernen();

    Box< Box< Hund > > hbbox = new Box<>( new Box<>( new Hund() ) );
    System.out.println( hbbox.getClass().getCanonicalName() );
    System.out.println( hbbox.getClass().getSimpleName() );
    System.out.println( hbbox.getClass().getName() );
  }
}
