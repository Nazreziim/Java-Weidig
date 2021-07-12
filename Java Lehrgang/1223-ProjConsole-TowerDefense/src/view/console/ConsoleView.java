package view.console;

import java.util.Scanner;

import model.board.Board;
import model.board.Direction;
import model.board.Field;
import model.board.Path;
import model.creeps.Creep;
import model.tower.Tower;
import view.View;

public class ConsoleView implements View {

  private final static int SPALTEN_PRO_ZEILE = 2;
  private final int INHALT_HOEHE = 4; // Anzahl Zeilen in einem Feld

  private Board model;
  private Scanner scanner;

  public ConsoleView( Board model ) {
    this.model = model;
    this.scanner = new Scanner( System.in );
  }

  public void drawGrid() {
    BashControl.setSize( this.model.getHeight() * 5 + 4, this.model.getWidth() * 9 + 1 );
    BashControl.clearConsole();
    BashControl.clearConsoleBuffer();
    BashControl.goTo( 1, 1 );

    final int inhaltBreite = SPALTEN_PRO_ZEILE * INHALT_HOEHE;
    for ( int zeile = 0; zeile < ( INHALT_HOEHE + 1 ) * model.getHeight() + 1; ++zeile ) {
      int fRow = ( zeile - 1 ) / ( INHALT_HOEHE + 1 );
      for ( int spalte = 0; spalte < ( inhaltBreite + 1 ) * model.getWidth() + 1; ++spalte ) {
        int fColumn = ( spalte - 1 ) / ( inhaltBreite + 1 );
        BashControl.goTo( zeile + 1, spalte + 1 );
        if ( zeile % ( INHALT_HOEHE + 1 ) == 0 && spalte % ( inhaltBreite + 1 ) == 0 ) {
          System.out.print( "+" );
        } else if ( zeile == 0 && spalte % ( inhaltBreite + 1 ) == 1 ) {
          System.out.printf( "%02d", fColumn );
        } else if ( zeile > 0 && zeile % ( INHALT_HOEHE + 1 ) == 0 || zeile == 0 && spalte % ( inhaltBreite + 1 ) > 2 ) {
          System.out.print( "-" );
        } else if ( spalte == 0 && zeile % ( INHALT_HOEHE + 1 ) == 1 ) {
          System.out.printf( "%X", fRow );
        } else if ( spalte > 0 && spalte % ( inhaltBreite + 1 ) == 0 || spalte == 0 && zeile % ( INHALT_HOEHE + 1 ) > 1 ) {
          System.out.print( "|" );
        }
      }
    }
    System.out.println();
  }

  public void drawFields() {
    BashControl.saveCursorPosition();
    final int inhaltBreite = SPALTEN_PRO_ZEILE * INHALT_HOEHE;
    Field[][] f = this.model.getBoard();

    for ( int row = 0; row < f.length; ++row ) {
      for ( int column = 0; column < f[ row ].length; ++column ) {
        int ground = ( row + 1 ) * ( INHALT_HOEHE + 1 );
        int ceiling = row * ( INHALT_HOEHE + 1 );
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
   * <code>|&nbsp;&nbsp;^&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|</code><br>
   * <code>|-+-|&nbsp;&nbsp;&nbsp;&nbsp;|</code><br>
   * <code>| | |&nbsp;&nbsp;&nbsp;&nbsp;|</code><br>
   * <code>| /-\&nbsp;&nbsp;&nbsp;&nbsp;|</code><br>
   * 
   * @param ground
   * @param ceiling
   * @param left
   * @param right
   * @param field
   */
  private void drawTower( int ceiling, int left ) {
    BashControl.setForegroundColor( 7 );
    BashControl.setBackgroundColor( 0 );
    BashControl.goTo( ceiling + 2, left + 2 );
    System.out.print( "  ^     " );
    BashControl.goTo( ceiling + 3, left + 2 );
    System.out.print( "-|-|    " );
    BashControl.goTo( ceiling + 4, left + 2 );
    System.out.print( " | |    " );
    BashControl.goTo( ceiling + 5, left + 2 );
    System.out.print( " /-\\    " );
  }

  private void drawPath( int ground, int ceiling, int left, int right, Path p ) {
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
    int backgroundColor = 235;
    if ( p.isFirst() ) {
      backgroundColor = 239;
    } else if ( p.isLast() ) {
      backgroundColor = 237;
    }
    printPathElement( ceiling, ground, left, right, backgroundColor, p );
  }

  private void printPathElement( int ceiling, int ground, int left, int right, int backgroundColor, Path p ) {
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

  /**
   * <code>+--------+</code><br>
   * <code>|-/\--/\-|</code><br>
   * <code>|-\/--\/-|</code><br>
   * <code>|-/\--/\-|</code><br>
   * <code>|-\/--\/-|</code><br>
   * <code>+--------+</code><br>
   * 
   * @param ceiling
   * @param left
   * @param backgroundColor
   * @param creep
   */
  private void drawCreep( int ceiling, int left, int backgroundColor, Creep creep ) {
    BashControl.setBackgroundColor( backgroundColor );
    int foregroundColor = 10;
    double healthQuotient = (double) creep.getHealth() / creep.getMaxHealth();

    if ( healthQuotient < 0.25 ) {
      foregroundColor = 1;
    } else if ( healthQuotient < 0.50 ) {
      foregroundColor = 208;
    } else if ( healthQuotient < 0.75 ) {
      foregroundColor = 11;
    }
    BashControl.setForegroundColor( foregroundColor );
    BashControl.goTo( ceiling + 2, left + 2 );
    System.out.print( CreepView.getLine( creep.getCreepEnum(), 0 ) );
    BashControl.goTo( ceiling + 3, left + 2 );
    System.out.print( CreepView.getLine( creep.getCreepEnum(), 1 ) );
  }

  private void print( char c, int top, int bottom, int left, int right, int fColor, int bColor ) {
    for ( int zeile = top; zeile <= bottom; ++zeile ) {
      for ( int spalte = left; spalte <= right; ++spalte ) {
        BashControl.goTo( zeile + 1, spalte + 1 );
        BashControl.setForegroundColor( fColor );
        BashControl.setBackgroundColor( bColor );
        System.out.print( c );
      }
    }
  }

  @Override
  public void drawMenu() {
    // BashControl.goTo( this.model.getHeight() * 5 + 3, 1 );
    System.out.println( "T <row> <column> : Tower, P : Pause" );
  }

  @Override
  public String getPlayerName() {
    System.out.print( "Spielername: " );
    String playerName = this.scanner.nextLine();
    return playerName;
  }

  @Override
  public void drawBanner() {
    // TODO Auto-generated method stub
  }

  @Override
  public String getInput() {
    // TODO Auto-generated method stub
    return null;
  }

}
