package aufgaben;


public class Aufgabe19 {

  public static void main( String[] args ) {

    int wert = HilfsMeth.readInt( "Einkaufswert:" );

    double rabatt = 0.0;

    if ( wert >= 1000 ) {
      rabatt = 50.0;
    } else if ( wert >= 300 ) {
      rabatt = wert * 0.03;
    } else if ( wert >= 100 ) {
      rabatt = wert * 0.02;
    }

    double betrag = wert - rabatt;

    if ( wert >= 1000 ) {
      System.out.println( "Rabattgruppe: 50 €" );
    } else if ( wert >= 300 ) {
      System.out.println( "Rabattgruppe: 3 %" );
    } else if ( wert >= 100 ) {
      System.out.println( "Rabattgruppe: 2 %" );
    }
    
    System.out.printf( "Rabatt:       %.2f €%n", rabatt );
    System.out.printf( "Betrag:       %.2f €%n", betrag );

  }

}
