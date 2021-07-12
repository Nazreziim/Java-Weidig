package aufgaben;

public class Aufgabe30 {

  public static void main( String[] args ) {

    int n = HilfsMeth.readInt( "n = " );

    int fak = 1;

    for ( int i = n; i > 1; fak *= i, --i  ) {
    }
    
    System.out.println( "n! = " + fak );

  }

}
