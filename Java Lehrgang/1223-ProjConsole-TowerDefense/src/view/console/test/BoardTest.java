package view.console.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.Coord2D;
import model.board.Board;
import model.board.Direction;
import model.board.Field;
import model.board.Path;
import model.creeps.Creep;
import model.creeps.NormalCreep;
import model.tower.Tower;
import view.console.BashControl;

public class BoardTest {

  private final static int SPALTEN_PRO_ZEILE = 2;

  public static void main( String[] args ) {

    final int HOEHE = 13;
    final int BREITE = 30;
    final int ZOOM = 4; // Anzahl Zeilen in einem Feld

    LinkedList< Coord2D > path = new LinkedList<>();
    path.add( new Coord2D( 1, 0 ) );
    path.add( new Coord2D( 1, 1 ) );
    path.add( new Coord2D( 2, 1 ) );
    path.add( new Coord2D( 3, 1 ) );
    path.add( new Coord2D( 4, 1 ) );
    path.add( new Coord2D( 5, 1 ) );
    path.add( new Coord2D( 5, 2 ) );
    path.add( new Coord2D( 5, 3 ) );
    path.add( new Coord2D( 5, 4 ) );
    path.add( new Coord2D( 5, 5 ) );
    path.add( new Coord2D( 5, 6 ) );
    path.add( new Coord2D( 5, 7 ) );
    path.add( new Coord2D( 4, 7 ) );
    path.add( new Coord2D( 3, 7 ) );
    path.add( new Coord2D( 2, 7 ) );
    path.add( new Coord2D( 1, 7 ) );
    path.add( new Coord2D( 1, 6 ) );
    path.add( new Coord2D( 1, 5 ) );
    path.add( new Coord2D( 1, 4 ) );
    path.add( new Coord2D( 1, 3 ) );
    path.add( new Coord2D( 0, 3 ) );
    path.add( new Coord2D( 0, 2 ) );

    try {
      Scanner sc = new Scanner( System.in );

      Board board = new Board( HOEHE, BREITE );
      boolean built = board.buildTower( new Coord2D( 0, 0 ) );
      built = board.buildTower( new Coord2D( 0, 1 ) );
      built = board.buildTower( new Coord2D( 1, 2 ) );
      built = board.buildTower( new Coord2D( 2, 2 ) );
      built = board.buildTower( new Coord2D( 4, 2 ) );
      built = board.buildTower( new Coord2D( 4, 6 ) );

      NormalCreep creep = new NormalCreep();
      board.addCreep( creep );

      // ( (Path) board.getBoard()[ path.get( 0 ).getRow() ][ path.get( 0 ).getColumn() ]
      // ).getCreepList().add( new NormalCreep() );
      // ( (Path) board.getBoard()[ path.get( 0 ).getRow() ][ path.get( 0 ).getColumn() ]
      // ).getCreepList().add( new NormalCreep() );
      // ( (Path) board.getBoard()[ path.get( 0 ).getRow() ][ path.get( 0 ).getColumn() ]
      // ).getCreepList().add( new NormalCreep() );
      // ( (Path) board.getBoard()[ path.get( 0 ).getRow() ][ path.get( 0 ).getColumn() ]
      // ).getCreepList().add( new NormalCreep() );

      BashControl.setSize( 72, 271 );
      BashControl.clearConsole();
      BashControl.clearConsoleBuffer();
      BashControl.goTo( 1, 1 );

      // long start = System.currentTimeMillis();
      boolean moved = true;
      drawGrid( board, ZOOM );
      while ( moved ) {
        drawFields( board, ZOOM );
        TimeUnit.MILLISECONDS.sleep( 500 );
        moved = board.step();
      }
      drawFields( board, ZOOM );
      // System.out.print( System.currentTimeMillis() - start );

      sc.nextLine();
      BashControl.clearConsole();
      BashControl.clearConsoleBuffer();
      BashControl.goTo( 1, 1 );
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

  }

  /**
   * Diese Methode stellt das gesamte Board dar.
   * 
   * @param board
   * @param inhaltHoehe
   */
  public static void drawFields( Board board, final int inhaltHoehe ) {
    BashControl.saveCursorPosition();
    final int inhaltBreite = SPALTEN_PRO_ZEILE * inhaltHoehe;
    List< Coord2D > pathL = board.getPath();
    Field[][] f = board.getBoard();

    for ( int row = 0; row < f.length; ++row ) {
      for ( int column = 0; column < f[ row ].length; ++column ) {
        int ground = ( row + 1 ) * ( inhaltHoehe + 1 );
        int ceiling = row * ( inhaltHoehe + 1 );
        int left = column * ( inhaltBreite + 1 );
        int right = ( column + 1 ) * ( inhaltBreite + 1 );
        Field field = f[ row ][ column ];
        if ( field instanceof Path ) {
          drawPath( ground, ceiling, left, right, (Path) field );
        } else if ( field instanceof Tower ) {
          drawTower( ceiling, left );
        }
      }
    }
    BashControl.restoreCursorPosition();
  }

  /**
   * <code>|  ^     |</code><br>
   * <code>|-+-|    |</code><br>
   * <code>| | |    |</code><br>
   * <code>| /-\    |</code><br>
   * 
   * @param ground
   * @param ceiling
   * @param left
   * @param right
   * @param field
   */
  private static void drawTower( int ceiling, int left ) {
    BashControl.setForegroundColor( 7 );
    BashControl.goTo( ceiling + 2, left + 2 );
    System.out.print( "  ^     " );
    BashControl.goTo( ceiling + 3, left + 2 );
    System.out.print( "-|-|    " );
    BashControl.goTo( ceiling + 4, left + 2 );
    System.out.print( " | |    " );
    BashControl.goTo( ceiling + 5, left + 2 );
    System.out.print( " /-\\    " );
  }

  private static void drawPath( int ground, int ceiling, int left, int right, Path p ) {
    Direction dir = p.getDirection();

    if ( dir == Direction.UP ) {
      if ( p.isFirst() ) {
        print( '^', ground, ground, left + 1, right - 1, 7, 0 );
      }
      print( '^', ceiling, ceiling, ceiling == 0 ? left + 3 : left + 1, right - 1, 7, 0 );
    } else if ( dir == Direction.DOWN ) {
      if ( p.isFirst() ) {
        print( 'v', ceiling, ceiling, ceiling == 0 ? left + 3 : left + 1, right - 1, 7, 0 );
      }
      print( 'v', ground, ground, left + 1, right - 1, 7, 0 );
    } else if ( dir == Direction.LEFT ) {
      if ( p.isFirst() ) {
        print( '<', ceiling + 1, ground - 1, right, right, 7, 0 );
      }
      print( '<', left == 0 ? ceiling + 2 : ceiling + 1, ground - 1, left, left, 7, 0 );
    } else if ( dir == Direction.RIGHT ) {
      if ( p.isFirst() ) {
        print( '>', left == 0 ? ceiling + 2 : ceiling + 1, ground - 1, left, left, 7, 0 );
      }
      print( '>', ceiling + 1, ground - 1, right, right, 7, 0 );
    }
    int backgroundColor = 232;
    if ( p.isFirst() ) {
      backgroundColor = 239;
    } else if ( p.isLast() ) {
      backgroundColor = 237;
    }
    printPathElement( ceiling, ground, left, right, backgroundColor, p );
  }

  private static void printPathElement( int ceiling, int ground, int left, int right, int backgroundColor, Path p ) {
    int size = p.getCreepList().size();
    print( ' ', ceiling + 1, ground - 1, left + 1, right - 1, 7, backgroundColor );
    if ( size > 0 ) {
      drawCreep( ceiling, left, backgroundColor, p.getCreepList().get( 0 ) );
    }
    if ( size > 1 ) {
      drawCreep( ceiling, left + 4, backgroundColor, p.getCreepList().get( 1 ) );
    }
    if ( size > 2 ) {
      drawCreep( ceiling + 2, left, backgroundColor, p.getCreepList().get( 2 ) );
    }
    if ( size > 3 ) {
      drawCreep( ceiling + 2, left + 4, backgroundColor, p.getCreepList().get( 2 ) );
    }
  }

  private static void drawCreep( int ceiling, int left, int backgroundColor, Creep creep ) {
    BashControl.setBackgroundColor( backgroundColor );
    int foregroundColor = 10;
    int health = creep.getHealth();
    if ( health < 25 ) {
      foregroundColor = 1;
    } else if ( health < 50 ) {
      foregroundColor = 208;
    } else if ( health < 75 ) {
      foregroundColor = 11;
    }
    BashControl.setForegroundColor( foregroundColor );
    BashControl.goTo( ceiling + 2, left + 2 );
    System.out.print( "-/\\-" );
    BashControl.goTo( ceiling + 3, left + 2 );
    System.out.print( "-\\/-" );
  }

  private static void print( char c, int top, int bottom, int left, int right, int fColor, int bColor ) {
    for ( int zeile = top; zeile <= bottom; ++zeile ) {
      for ( int spalte = left; spalte <= right; ++spalte ) {
        BashControl.goTo( zeile + 1, spalte + 1 );
        BashControl.setForegroundColor( fColor );
        BashControl.setBackgroundColor( bColor );
        System.out.print( c );
      }
    }
  }

  public static void drawGrid( Board board, final int inhaltHoehe ) {
    final int inhaltBreite = SPALTEN_PRO_ZEILE * inhaltHoehe;
    for ( int zeile = 0; zeile < ( inhaltHoehe + 1 ) * board.getHeight() + 1; ++zeile ) {
      int fRow = ( zeile - 1 ) / ( inhaltHoehe + 1 );
      for ( int spalte = 0; spalte < ( inhaltBreite + 1 ) * board.getWidth() + 1; ++spalte ) {
        int fColumn = ( spalte - 1 ) / ( inhaltBreite + 1 );
        BashControl.goTo( zeile + 1, spalte + 1 );
        if ( zeile % ( inhaltHoehe + 1 ) == 0 && spalte % ( inhaltBreite + 1 ) == 0 ) {
          System.out.print( "+" );
        } else if ( zeile == 0 && spalte % ( inhaltBreite + 1 ) == 1 ) {
          System.out.printf( "%02d", fColumn );
        } else if ( zeile > 0 && zeile % ( inhaltHoehe + 1 ) == 0 || zeile == 0 && spalte % ( inhaltBreite + 1 ) > 2 ) {
          System.out.print( "-" );
        } else if ( spalte == 0 && zeile % ( inhaltHoehe + 1 ) == 1 ) {
          System.out.printf( "%X", fRow );
        } else if ( spalte > 0 && spalte % ( inhaltBreite + 1 ) == 0 || spalte == 0 && zeile % ( inhaltHoehe + 1 ) > 1 ) {
          System.out.print( "|" );
        }
      }
    }
    System.out.println();
  }

}
