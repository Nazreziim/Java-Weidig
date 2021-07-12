package b1Kapselung.aufgabenLsg;

public class PiggyBankTest {

  public static void main( String[] args ) {
    PiggyBank pb = new PiggyBank();
    pb.init( 500 );

    while ( !pb.isFull() ) {
      pb.add1Cents( 1 );
      pb.add10Cents( 1 );
      pb.add50Cents( 1 );
      pb.add1Euro( 1 );
    }

    System.out.println( pb.isFull() );
    System.out.println( pb.breakPiggy() );
    System.out.println( pb.isBroken() );
    System.out.println( pb.isEmpty() );

  }

}
