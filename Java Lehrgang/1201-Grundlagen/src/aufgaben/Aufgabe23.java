package aufgaben;


public class Aufgabe23 {

  public static void main( String[] args ) {

    int punkteA = HilfsMeth.readInt( "SpielerA:" );
    int punkteB = HilfsMeth.readInt( "SpielerB:" );
    int punkteC = HilfsMeth.readInt( "SpielerC:" );

    if ( punkteA > punkteB ) {
      System.out.println( "SpielerB zahlt " + ( punkteA - punkteB ) + "€ an SpielerA" );
    } else if ( punkteA < punkteB ) {
      System.out.println( "SpielerA zahlt " + ( punkteB - punkteA ) + "€ an SpielerB" );
    }
    
    if ( punkteA > punkteC ) {
      System.out.println( "SpielerC zahlt " + ( punkteA - punkteC ) + "€ an SpielerA" );
    } else if ( punkteA < punkteB ) {
      System.out.println( "SpielerA zahlt " + ( punkteC - punkteA ) + "€ an SpielerC" );
    }
    
    if ( punkteB > punkteC ) {
      System.out.println( "SpielerC zahlt " + ( punkteB - punkteC ) + "€ an SpielerB" );
    } else if ( punkteA < punkteB ) {
      System.out.println( "SpielerB zahlt " + ( punkteC - punkteB ) + "€ an SpielerC" );
    }

  }

}
