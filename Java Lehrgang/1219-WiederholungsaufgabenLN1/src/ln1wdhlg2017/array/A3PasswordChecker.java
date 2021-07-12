package ln1wdhlg2017.array;

public class A3PasswordChecker {

  public static void main( String... args ) {
    System.out.println( checkPassword( "AxB1&a8c".toCharArray() ) );
    System.out.println( checkPassword( "1passw0rt".toCharArray() ) );
  }

  public static boolean checkPassword( char[] password ) {
    boolean eightChars = false;
    boolean twoLetters = false;
    boolean twoDidgits = false;
    boolean upperLowerLetter = false;
    boolean specialChar = false;
    boolean didgitSpecialCharWithin = false;

    int upperLetters = 0;
    int lowerLetters = 0;
    int didgits = 0;
    int specialChars = 0;

    if ( password.length >= 8 ) {
      eightChars = true;
    }

    for ( int i = 0; i < password.length; ++i ) {
      if ( password[ i ] >= 'a' && password[ i ] <= 'z' ) {
        ++lowerLetters;
      } else if ( password[ i ] >= 'A' && password[ i ] <= 'Z' ) {
        ++upperLetters;
      } else if ( password[ i ] >= '0' && password[ i ] <= '9' ) {
        ++didgits;
        if ( i != 0 && i != password.length - 1 ) {
          didgitSpecialCharWithin = true;
        }
      } else if ( password[ i ] >= 32 && password[ i ] <= 127 ) {
        ++specialChars;
        if ( i != 0 && i != password.length - 1 ) {
          didgitSpecialCharWithin = true;
        }
      }
    }

    if ( upperLetters + lowerLetters >= 2 ) {
      twoLetters = true;
    }
    if ( didgits >= 2 ) {
      twoDidgits = true;
    }
    if ( upperLetters >= 1 && lowerLetters >= 1 ) {
      upperLowerLetter = true;
    }
    if ( specialChars >= 1 ) {
      specialChar = true;
    }

    return eightChars && twoLetters && twoDidgits && upperLowerLetter && specialChar
            && didgitSpecialCharWithin;
  }

}
