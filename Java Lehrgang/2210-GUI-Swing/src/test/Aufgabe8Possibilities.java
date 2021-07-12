package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Aufgabe8Possibilities {

  public static void main( String[] args ) {
    long start = System.nanoTime();
    List< String > possibilities = generatePossibilitiesPhone( 1797979790 );
    long ende = System.nanoTime();
    // for ( String s : possibilities ) {
    // System.out.println( s );
    // }
    System.out.println( possibilities.size() + " Möglichkeiten gefunden." );
    System.out.println( "Zusammengestellt in " + ( ende - start ) + " Nanosekunden." );
  }

  public static List< String > generatePossibilitiesPhone( int number ) {
    Map< Integer, List< String > > map = new HashMap< Integer, List< String > >();

    for ( int i = 0; i < 10; ++i ) {
      map.put( i, new ArrayList< String >() );
    }

    map.get( 0 ).add( "0" );
    map.get( 1 ).add( "1" );
    map.get( 2 ).addAll( Arrays.asList( "A", "B", "C" ) );
    map.get( 3 ).addAll( Arrays.asList( "D", "E", "F" ) );
    map.get( 4 ).addAll( Arrays.asList( "G", "H", "I" ) );
    map.get( 5 ).addAll( Arrays.asList( "J", "K", "L" ) );
    map.get( 6 ).addAll( Arrays.asList( "M", "N", "O" ) );
    map.get( 7 ).addAll( Arrays.asList( "P", "Q", "R", "S" ) );
    map.get( 8 ).addAll( Arrays.asList( "T", "U", "V" ) );
    map.get( 9 ).addAll( Arrays.asList( "W", "X", "Y", "Z" ) );

    return generatePossibilities( number, map );
  }

  private static List< String > generatePossibilities( int number,
          Map< Integer, List< String > > map ) {

    List< String > result = new LinkedList< String >();

    if ( number / 10 == 0 ) {
      for ( String s : map.get( number ) ) {
        result.add( s );
      }
    } else {
      int ziffer = number;
      int stelle = 1;
      while ( ziffer / 10 > 0 ) {
        ziffer /= 10;
        stelle *= 10;
      }

      List< String > listeEndeString = generatePossibilities( number - ziffer * stelle, map );
      for ( String s : map.get( ziffer ) ) {
        for ( String sEnde : listeEndeString ) {
          result.add( s + sEnde );
        }
      }
    }
    return result;
  }

}
