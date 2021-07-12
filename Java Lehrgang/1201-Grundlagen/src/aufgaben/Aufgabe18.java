package aufgaben;


public class Aufgabe18 {

  public static void main( String[] args ) {

    int zahl = HilfsMeth.readInt( "Zahl: " );

    if ( 5 <= zahl && zahl <= 100 ) {
      System.out.println( zahl );
    } else {
      System.out.println( "falsche Eingabe" );
    }

  }

}
