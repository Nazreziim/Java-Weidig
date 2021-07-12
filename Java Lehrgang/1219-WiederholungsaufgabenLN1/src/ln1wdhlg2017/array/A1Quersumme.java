package ln1wdhlg2017.array;

public class A1Quersumme {

  public static void main( String[] args ) {
    char[] chars = new char[]{ '0', '1', '2', '3', '9' };
    System.out.println(quersumme( chars ));
  }

  public static int quersumme( char[] chars ) {
    int result = 0;
    for ( char c : chars ) {
      if ( c >= '0' && c <= '9' ) {
        result += c - '0';
      }
    }
    return result;
  }

}
