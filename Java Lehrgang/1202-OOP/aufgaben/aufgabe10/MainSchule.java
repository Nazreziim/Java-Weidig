package aufgabe10;

public class MainSchule {

  public static void main( String[] args ) {

    Lehrer l1 = new Lehrer( "Frau Lehrer", 33, "Musik" );
    System.out.println( l1 );

    Schueler s1 = new Schueler( "Max", 12, 6 );
    System.out.println( s1 );

    Schueler s2 = new Klassensprecher( "Moritz", 12, 6, 4 );
    System.out.println( s2 );

    Schueler s3 = new Klassensprecher( "Kevin", 12, 6, 3 );
    System.out.println( s3 );
    
    Mensch m1 = new Lehrer( "Tom", 31, "Ada" );
    
    l1.essen();
    s1.essen();

  }

}
