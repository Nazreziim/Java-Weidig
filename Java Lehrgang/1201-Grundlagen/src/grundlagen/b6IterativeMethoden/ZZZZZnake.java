package grundlagen.b6IterativeMethoden;

import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

public class ZZZZZnake {

  public static void main( String[] args ) {

    int maxX = 39, maxY = 9;

    Point playerPosition = randomPoint( maxX, maxY );
    Point[] snakePosition = new Point[ 5 ];
    Point goldPosition = randomPoint( maxX, maxY );
    Point doorPosition = randomPoint( maxX, maxY );
    boolean rich = false;
    // int runde = 0;
    int snakeHead = 0;
    Point tmp = randomPoint( maxX, maxY );
    for ( int x = 0; x < snakePosition.length; ++x ) {
      snakePosition[ x ] = new Point( tmp );
    }

    while ( true ) {
      // Raster mit Figuren zeichnen.
      for ( int y = 0; y < 10; ++y ) {
        for ( int x = 0; x < 39; ++x ) {
          Point p = new Point( x, y );
          if ( playerPosition.equals( p ) ) {
            System.out.print( '&' );
          } else if ( doorPosition.equals( p ) ) {
            System.out.print( '#' );
          } else if ( Arrays.asList( snakePosition ).contains( p ) ) {
            System.out.print( 'S' );
          } else if ( goldPosition.equals( p ) ) {
            System.out.print( '€' );
          } else {
            System.out.print( '.' );
          }
        }
        System.out.println();
      }
      // Status feststellen
      if ( rich && playerPosition.equals( doorPosition ) ) {
        System.out.println( "Gewonnen!" );
        return;
      }
      if ( Arrays.asList( snakePosition ).contains( playerPosition ) ) {
        System.out.println( "ZZZZZZZZZZ. Die Schlange hat Dich!" );
        return;
      }
      if ( playerPosition.equals( goldPosition ) ) {
        rich = true;
        goldPosition.setLocation( -1, -1 );
      }

      // Spieler bewegen
      movePlayer( playerPosition, maxX, maxY );

      // if ( ++runde % 5 == 0 ) { // Schalngen bewegen sich nur alle 5 Runden
      // Schlange bewegt sich in Richtung Spieler
      Point tmpSnakeHead = new Point( snakePosition[ snakeHead ] );
      if ( tmpSnakeHead.x < playerPosition.x ) {
        ++tmpSnakeHead.x;
      } else if ( tmpSnakeHead.x > playerPosition.x ) {
        --tmpSnakeHead.x;
      }
      if ( tmpSnakeHead.y < playerPosition.y ) {
        ++tmpSnakeHead.y;
      } else if ( tmpSnakeHead.y > playerPosition.y ) {
        --tmpSnakeHead.y;
      }
      snakeHead = ( snakeHead + 1 ) % snakePosition.length;
      snakePosition[ snakeHead ] = tmpSnakeHead;
      // }
    } // end while
  }

  private static void movePlayer( Point playerPosition, int maxX, int maxY ) {
    // Konsoleneingabe und Spielerposition verändern
    Scanner sc = new java.util.Scanner( System.in );
    switch ( sc.next() ) {
      // Spielfeld ist im Bereich 0/0 .. 39/9
      case "w" :
        playerPosition.y = Math.max( 0, playerPosition.y - 1 );
        break;
      case "s" :
        playerPosition.y = Math.min( maxY, playerPosition.y + 1 );
        break;
      case "a" :
        playerPosition.x = Math.max( 0, playerPosition.x - 1 );
        break;
      case "d" :
        playerPosition.x = Math.min( maxX, playerPosition.x + 1 );
        break;
    }
    sc.close();
  }

  private static Point randomPoint( int x, int y ) {
    return new Point( (int) ( Math.random() * ( x + 1 ) ), (int) ( Math.random() * ( y + 1 ) ) );
  }

}
