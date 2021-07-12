package ln1wdhlg2018.aufgabe03banknote;

import java.util.Arrays;

public class Banknote {

  public static void main( String[] args ) {
    char[] test = new char[]{ 'Z', '6', '0', '1', '6', '2', '2', '0', '0', '2', '2' };
    System.out.println( Arrays.toString( test ) + ": " + berechneSeriennummer( test ) );
  }

  public static int berechneSeriennummer( char[] snr ) {
    int result = 0;
    if ( snr.length == 11 ) {
      int nzb = snr[ 0 ] - 'A' + 1;
      int add = nzb / 10 + nzb % 10;
      for ( int i = 1; i < snr.length; ++i ) {
        add += snr[ i ] - '0';
      }
      result = add % 9;
      result = 8 - result;
      result = result == 0 ? 9 : result;
    }

    return result;
  }

}
