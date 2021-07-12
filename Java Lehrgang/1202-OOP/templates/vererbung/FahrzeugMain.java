package vererbung;

public class FahrzeugMain {

  public static void main( String[] args ) {

    Fahrzeug f = new Fahrzeug( "audi" );
    System.out.println( "Fahrzeug: " + f );
    System.out.println( f.fahren() );

    Pkw p = new Pkw( "opel" );
    System.out.println( "Pkw: " + p );
    System.out.println( p.fahren() );

    Fahrzeug f2 = new Pkw( "porsche", 12 );
    System.out.println( "Fahrzeug: " + f2 );
    System.out.println( f2.fahren() );

    Bmw3 b = new Bmw3( "bmw", 5 );
    b.hupen();
    System.out.println( b.fahren() );

    Fahrzeug f3 = b;
    System.out.println( f3.fahren() );
    ( (Bmw3) f3 ).hupen();

    if ( f instanceof Bmw3 ) {
      Bmw3 d = (Bmw3) f;
      d.hupen();
    }
    
    System.out.println( f2.getClass() );

  }

}
