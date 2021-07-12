package aufgaben;


public class Aufgabe17 {

  public static void main( String[] args ) {

    int zahl1 = HilfsMeth.readInt( "Zahl 1:" );
    int zahl2 = HilfsMeth.readInt( "Zahl 2:" );
    int zahl3 = HilfsMeth.readInt( "Zahl 3:" );

    if ( zahl1 <= zahl2 && zahl2 <= zahl3 || zahl1 >= zahl2 && zahl2 >= zahl3 ) {
      System.out.println( "Median: " + zahl2 );
    } else if ( zahl2 <= zahl1 && zahl1 <= zahl3 || zahl2 >= zahl1 && zahl1 >= zahl3 ) {
      System.out.println( "Median: " + zahl1 );
    } else {
      System.out.println( "Median: " + zahl3 );
    }

  }

}
