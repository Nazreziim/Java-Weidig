package b1Kapselung.aufgabenLsg;

import java.util.Date;

public class MitarbeiterTest {

  public static void main( String[] args ) {
    Mitarbeiter[] mita = new Mitarbeiter[ 50 ];

    mita[ 0 ] = new Mitarbeiter( "Max", "Mustermann", "CEO", new Date().toString(),
            Math.random() * 500.0 );
    mita[ 1 ] = new Mitarbeiter( "Linda", "Mustermann", "CIO", new Date().toString(),
            Math.random() * 500.0 );
    mita[ 2 ] = new Mitarbeiter( "Hermine", "Mustermann", "C3PO", new Date().toString(),
            Math.random() * 500.0 );
    mita[ 3 ] = new Mitarbeiter( "Tom", "Mustermann", "R2D2", new Date().toString(),
            Math.random() * 500.0 );
    mita[ 4 ] = new Mitarbeiter( "Waltraut", "Mustermann", "Post", new Date().toString(),
            Math.random() * 500.0 );
    mita[ 5 ] = new Mitarbeiter( "Arthur", "Mustermann", "UvD", new Date().toString(),
            Math.random() * 500.0 );
    mita[ 6 ] = new Mitarbeiter( "Robin", "Mustermann", "GvD", new Date().toString(),
            Math.random() * 500.0 );

    ausgabeMitarbeiter( mita, 5 );
  }

  public static void ausgabeMitarbeiter( Mitarbeiter[] mita, long persNr ) {
    for ( Mitarbeiter m : mita ) {
      if ( m != null && m.getPersNr() == persNr ) {
        System.out.println( m );
      }
    }
  }

}
