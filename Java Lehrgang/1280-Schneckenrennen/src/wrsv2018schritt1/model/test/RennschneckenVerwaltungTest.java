package wrsv2018schritt1.model.test;

import wrsv2018schritt1.model.Rennschnecke;
import wrsv2018schritt1.model.RennschneckenVerwaltung;

public class RennschneckenVerwaltungTest {

  public static void main( String[] args ) {
    Rennschnecke rs1 = new Rennschnecke( "Dolly", 3.5, true );
    Rennschnecke rs2 = new Rennschnecke( "Harald", 1.5, true );
    Rennschnecke rs3 = new Rennschnecke( "Wilma", 2.5, true );
    Rennschnecke rs4 = new Rennschnecke( "Fling", 5.5, true );
    Rennschnecke rs5 = new Rennschnecke( "Dutch", 4.5, true );

    RennschneckenVerwaltung rsl = new RennschneckenVerwaltung();
    rsl.hinzufuegen( rs1 );
    rsl.hinzufuegen( rs2 );
    rsl.hinzufuegen( rs3 );
    rsl.hinzufuegen( rs4 );
    rsl.hinzufuegen( rs5 );
    rsl.hinzufuegen( rs5 );

    System.out.println( rsl );

    rsl.entfernen( rs5 );

    System.out.println( rsl );

  }

}
