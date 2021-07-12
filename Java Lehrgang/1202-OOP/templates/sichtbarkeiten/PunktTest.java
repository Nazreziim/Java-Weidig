package sichtbarkeiten;

public class PunktTest {

  public static void main( String[] args ) {

    Punkt p = new Punkt( 3, 4 );

    p.a = 3; // package // selbes Paket
    System.out.println( p.a );
    p.b = 4; // public
    System.out.println( p.b );
    p.c = 5; // protected // selbes Paket + erbende Klassen
    System.out.println( p.c );
    // p.x = 6; // private // nur die selbe Klasse
    // System.out.println( p.x );

    // Punkt.a = 3; // funktioniert nur mit statischen Attributen
    Punkt.d = 3; // Zugriff auf statisches Attribut
    p.d = 4; // Zugriff auf statische Attribute über ein Objekt
    // ist möglich, sollte aber nicht verwendet werden => Lesbarkeit.

    Punkt p2 = new Punkt();

    System.out.println( "x = " + p.getX() );
    System.out.println( "y = " + p.getY() );

    System.out.println( p2 );

  }

}
