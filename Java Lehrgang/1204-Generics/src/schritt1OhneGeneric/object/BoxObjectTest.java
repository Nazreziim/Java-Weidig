package schritt1OhneGeneric.object;

import schritt1OhneGeneric.hund.Hund;
import schritt1OhneGeneric.katze.Katze;

public class BoxObjectTest {
  public static void main( String[] args ) {

    BoxObject box1 = new BoxObject( new Hund() );
    BoxObject box2 = new BoxObject( new Katze() );
    BoxObject box3 = new BoxObject( new Mensch() );
    BoxObject box4 = new BoxObject( new Schueler() );

    System.out.println( box1.getInhalt() );
    // box1.getInhalt().bellen(); // Was müsste man jetzt also hier machen?
    // box1.getInhalt().miau(); // Macht das noch Sinn soweit zu abstrahieren?

    System.out.println( box2.getInhalt() );
    // box2.getInhalt().bellen();
    // box2.getInhalt().miau();

    System.out.println( box3.getInhalt() );
    // box3.getInhalt().bellen();
    // box3.getInhalt().miau();

    System.out.println( box4.getInhalt() );
    // box4.getInhalt().bellen();
    // box4.getInhalt().miau();
  }
}
