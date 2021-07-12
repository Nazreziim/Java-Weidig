package uebung1;

public class PrimzahlTest {

  public static void main( String[] args ) {
    for ( int i = 0; i < 100; ++i ) {
      System.out.println( i + " ist Prim?: " + new Primzahl( i ).isPrim() );
    }
  }

}
