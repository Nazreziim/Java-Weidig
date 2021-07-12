package aufgabe6;

public class LehrgangTest {

  public static void main( String[] args ) {
    Lehrgang ada2020 = new Lehrgang( 130326L, "AnwProgBw Ada", 1, 1, 75, "2020-02-18", "2020-09-18" );
    Lehrgang java2020 = new Lehrgang( 130345L, "AnwProgBw Java", 1, 1, 58, "2020-10-06", "2020-12-23" );
    
    System.out.println( ada2020 );
    System.out.println( java2020 );
  }

}
