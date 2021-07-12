package ln1wdhlg2018.aufgabe04switchsignum;

import java.util.Arrays;

public class SwitchSignum {

  public static void main( String[] args ) {
    int[] iArr = new int[]{ 5, 6, 9, -3, 9, 0 };
    boolean[] bArr = new boolean[]{ true, false, true, true, false, true };
    int[] result = switchSignum( iArr, bArr );
    System.out.println( Arrays.toString( result ) );
  }

  private static int[] switchSignum( int[] iArr, boolean[] bArr ) {
    int[] result = null;
    if ( iArr != null && bArr != null && iArr.length == bArr.length ) {
      result = new int[ iArr.length ];
      for ( int i = 0; i < iArr.length; ++i ) {
        result[ i ] = bArr[ i ] ? iArr[ i ] : -iArr[ i ];
      }
    }
    return result;
  }

}
