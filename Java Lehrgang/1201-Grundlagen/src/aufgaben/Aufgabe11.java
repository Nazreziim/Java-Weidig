package aufgaben;


public class Aufgabe11 {

  public static void main( String[] args ) {

    float a = HilfsMeth.readFloat( "Geben Sie eine Gleitpunktzahl ein:" );
    float b = HilfsMeth.readFloat( "Geben Sie eine Gleitpunktzahl ein:" );
    float c = HilfsMeth.readFloat( "Geben Sie eine Gleitpunktzahl ein:" );

    float summe = a + b + c;
    float durchschnitt = summe / 3.0F;

    System.out.println( "Die Summe:            " + summe );
    System.out.println( "Der Durchschnitt:     " + durchschnitt );
  }

}
