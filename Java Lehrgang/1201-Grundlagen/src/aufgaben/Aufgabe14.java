package aufgaben;


public class Aufgabe14 {

  public static void main( String[] args ) {

    int preisProKiloInCent = HilfsMeth.readInt( "Geben sie den Kilopreis in Cent ein:" );
    int gewichtInGramm = HilfsMeth.readInt( "Geben Sie das Gewicht in Gramm ein:" );
    int mwstInProzent = HilfsMeth.readInt( "Geben Sie die MWSt in Prozent ein:" );

    double brutto = preisProKiloInCent / 100.0 * gewichtInGramm / 1000.0;
    double mwst = brutto / ( 1.0 + mwstInProzent / 100.0 );
    double netto = brutto - mwst;

    System.out.printf( "Brutto %8.2f Euro%n", brutto );
    System.out.printf( "MWSt   %8.2f Euro%n", mwst );
    System.out.printf( "Netto  %8.2f Euro%n", netto );

  }

}
