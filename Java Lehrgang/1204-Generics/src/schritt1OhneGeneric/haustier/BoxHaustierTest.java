package schritt1OhneGeneric.haustier;

import schritt1OhneGeneric.hund.Hund;
import schritt1OhneGeneric.katze.Katze;

public class BoxHaustierTest {

  public static void main( String[] args ) {

    BoxHaustier box1 = new BoxHaustier( new Hund() );
    BoxHaustier box2 = new BoxHaustier( new Katze() );

    System.out.println( box1.getInhalt() );
    ((Hund)box1.getInhalt()).bellen(); // Warum geht denn das jetzt nicht mehr?    
    // Was müsste man tun um das Problem zu umgehen? Sie kennen bereits eine Lösung.

    System.out.println( box2.getInhalt() );
    // box2.getInhalt().bellen();
    ((Katze)box2.getInhalt()).miau();
  }

}
