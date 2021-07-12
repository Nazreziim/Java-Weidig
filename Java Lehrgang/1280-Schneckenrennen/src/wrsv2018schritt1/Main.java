package wrsv2018schritt1;

import wrsv2018schritt1.model.Rennschnecke;
import wrsv2018schritt1.model.RennschneckenVerwaltung;
import wrsv2018schritt1.view.RennschneckenVerwaltungView;

public class Main {

  public static void main( String[] args ) {

    // Modell anlegen
    RennschneckenVerwaltung rsv = new RennschneckenVerwaltung();

    // Testschnecken
    for ( int i = 1; !rsv.istVoll(); ++i ) {
      rsv.hinzufuegen( new Rennschnecke( "Testschnecke" + ( 1 + i ), (double) i, i % 2 == 0 ) );
    }

    // View anlegen
    RennschneckenVerwaltungView rsvv = new RennschneckenVerwaltungView( rsv );
    rsvv.anzeigen();

  }

}
