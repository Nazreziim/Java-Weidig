package aufgabe9.main;

// statische imports sind nicht empfehlenswert
import static java.lang.Math.pow;
import static java.lang.System.out;

import aufgabe9.Punkt2D;
import aufgabe9.Punkt3D;

public class PunktMain {

  public static void main( String[] args ) {

    Punkt2D p2 = new Punkt2D( 0, 0 );
    Punkt3D p3 = new Punkt3D();

    // Auf Vererbungshierarchie prüfen
    out.println( p2 instanceof Punkt2D ); // true
    out.println( p2 instanceof Punkt3D ); // false
    out.println( p3 instanceof Punkt2D ); // true
    out.println( p3 instanceof Punkt3D ); // true

    // Prüfen auf genaue Klasse:
    System.out.println( p2.getClass() == Punkt2D.class ); // true
    System.out.println( p2.getClass() == Punkt3D.class ); // false
    // System.out.println( p3.getClass() == Punkt2D.class ); // false
    System.out.println( p3.getClass() == Punkt3D.class ); // true

    System.out.println( p2.getClass() != p3.getClass() ); // true

    System.out.println( p2 );
    System.out.println( p3 );
    
    // Lesbarkeit leidet hier deutlich.
    System.out.println( pow( 3, 2) );
  }

}
