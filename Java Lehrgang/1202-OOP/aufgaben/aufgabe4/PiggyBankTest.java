package aufgabe4;

import aufgabe3.PiggyBank;

public class PiggyBankTest {

  public static void main( String[] args ) {

    PiggyBank pb = new PiggyBank();

    pb.init( 100 );

    System.out.println( "-1?   (true)  " + ( -1 == pb.add1Cents( -1 ) ) );
    System.out.println( "-2?   (true)  " + ( -2 == pb.add2Cents( -2 ) ) );
    System.out.println( "-5?   (true)  " + ( -5 == pb.add5Cents( -5 ) ) );
    System.out.println( "-10?  (true)  " + ( -10 == pb.add10Cents( -10 ) ) );
    System.out.println( "-20?  (true)  " + ( -20 == pb.add20Cents( -20 ) ) );
    System.out.println( "-50?  (true)  " + ( -50 == pb.add50Cents( -50 ) ) );
    System.out.println( "-100? (true)  " + ( -100 == pb.add1Euros( -100 ) ) );
    System.out.println( "-200? (true)  " + ( -200 == pb.add2Euros( -200 ) ) );

    System.out.println( "Leer? (true)  " + pb.isEmpty() );
    System.out.println( "Voll? (false) " + pb.isFull() );

    int ueberlauf = 0;
    while ( ueberlauf == 0 ) {
      ueberlauf += pb.add1Cents( 1 );
      ueberlauf += pb.add2Cents( 1 );
      ueberlauf += pb.add5Cents( 1 );
      ueberlauf += pb.add10Cents( 1 );
      ueberlauf += pb.add20Cents( 1 );
      ueberlauf += pb.add50Cents( 1 );
      ueberlauf += pb.add1Euros( 1 );
      ueberlauf += pb.add2Euros( 1 );
    }
    System.out.println( "ueberlauf = " + ueberlauf + " == 4? (true) " + ( ueberlauf == 4 ) );

    System.out.println( "Leer? (false) " + pb.isEmpty() );
    System.out.println( "Voll? (true)  " + pb.isFull() );

    System.out.println( "Kaputt? (false) " + pb.isBroken() );

    System.out.println( "zerbrechen: Anzahl Cent = (4674) " + pb.breakPiggy() );
    /* 13 * 1 Cent
     * + 13 * 2 Cent
     * + 13 * 5 Cent
     * + 13 * 10 Cent
     * + 12 * 20 Cent
     * + 12 * 50 Cent
     * + 12 * 100 Cent
     * + 12 * 200 Cent
     * = 4_674 Cent
     */

    System.out.println( "Kaputt? (true)  " + pb.isBroken() );

  }

}
