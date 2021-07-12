package aufgaben;

public class Aufgabe09 {
  public static void main( String[] args ) {
    //@formatter:off
    int a = 21;                   // 0000 0000 0000 0000 0000 0000 0001 0101
    int b = 28;                   // 0000 0000 0000 0000 0000 0000 0001 1100 
    System.out.println( a & b );  // 0000 0000 0000 0000 0000 0000 0001 0100 => 20
    System.out.println( a ^ b );  // 0000 0000 0000 0000 0000 0000 0000 1001 =>  9
    System.out.println( a >> 2 ); // 0000 0000 0000 0000 0000 0000 0000 0101 =>  5
    //@formatter:on
    // System.out.println( a && b ); // Fehler!

  }
}
