package view.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

// https://misc.flogisoft.com/bash/tip_colors_and_formatting

// https://stackoverflow.com/questions/5243445/bash-command-to-change-size-of-bash-window

// https://man7.org/linux/man-pages/man4/console_codes.4.html

public abstract class BashControl {

  public static final char ESC = (char) 033;
  public static final char BEL = (char) 007;

  public static void goTo( int row, int column ) {
    if ( row < 0 )
      throw new IllegalArgumentException( "row must be positive : " + row );
    if ( column < 0 )
      throw new IllegalArgumentException( "column must be positive : " + column );
    System.out.print( ESC + "[" + row + ";" + column + "H" );
  }

  public static void setForegroundColor( int color ) {
    if ( color < 0 || color > 255 )
      throw new IllegalArgumentException( "color must be between 0 and 255 : " + color );
    System.out.print( ESC + "[38;5;" + color + "m" );
  }

  public static void setBackgroundColor( int color ) {
    if ( color < 0 || color > 255 )
      throw new IllegalArgumentException( "color must be between 0 and 255 : " + color );
    System.out.print( ESC + "[48;5;" + color + "m" );
  }

  public static void resetAll() {
    System.out.print( ESC + "[0m" );
  }

  public static void bold() {
    System.out.print( ESC + "[1m" );
  }

  public static void doubleUnderlined() {
    System.out.print( ESC + "[21m" );
  }

  public static void dim() {
    System.out.print( ESC + "[2m" );
  }

  public static void resetDim() {
    System.out.print( ESC + "[22m" );
  }

  public static void underlined() {
    System.out.print( ESC + "[4m" );
  }

  public static void resetUnderlined() {
    System.out.print( ESC + "[24m" );
  }

  public static void inverted() {
    System.out.print( ESC + "[7m" );
  }

  public static void resetInverted() {
    System.out.print( ESC + "[27m" );
  }

  public static void hidden() {
    System.out.print( ESC + "[8m" );
  }

  public static void resetHidden() {
    System.out.print( ESC + "[28m" );
  }

  public static int[] getSize() {
    int[] result = null;
    try {
      Process p = new ProcessBuilder( "stty", "size" ).inheritIO().redirectOutput( Redirect.PIPE ).start();
      BufferedReader br = new BufferedReader( new InputStreamReader( p.getInputStream() ) );
      p.waitFor();
      String line = br.readLine();
      br.close();
      if ( line != null ) {
        String[] tmp = line.split( " " );
        result = new int[ tmp.length ];
        for ( int i = 0; i < result.length; ++i ) {
          result[ i ] = Integer.parseInt( tmp[ i ] );
        }
      }
    } catch ( IOException e ) {
      e.printStackTrace();
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }
    return result;
  }

  public static void setSize( int rows, int columns ) {
    if ( rows < 0 )
      throw new IllegalArgumentException( "row must be positive : " + rows );
    if ( columns < 0 )
      throw new IllegalArgumentException( "column must be positive : " + columns );
    System.out.print( ESC + "[8;" + rows + ";" + columns + "t" );
  }

  public static void clear() {
    try {
      new ProcessBuilder( "clear" ).inheritIO().start().waitFor();
    } catch ( InterruptedException | IOException e ) {
      System.err.println( "clear() was not possible" );
    }
  }

  public static void clearLineFromCursorToEnd() {
    System.out.print( ESC + "[K" );
  }

  public static void clearLineFromStartToCursor() {
    System.out.print( ESC + "[1K" );
  }

  public static void clearLine() {
    System.out.print( ESC + "[2K" );
  }

  public static void clearConsoleFromCursorToEnd() {
    System.out.print( ESC + "[J" );
  }

  public static void clearConsoleFromStartToCursor() {
    System.out.print( ESC + "[1J" );
  }

  public static void clearConsole() {
    System.out.print( ESC + "[2J" );
  }

  public static void clearConsoleBuffer() {
    System.out.print( ESC + "[3J" );
  }

  public static void setWindowTitle( String title ) {
    System.out.print( ESC + "]2;" + title + BEL );
  }

  public static void saveCursorPosition() {
    System.out.print( ESC + "[s" );
  }

  public static void restoreCursorPosition() {
    System.out.print( ESC + "[u" );
  }

  public static void setWindowPosition( int left, int top ) {
    if ( left < 0 )
      throw new IllegalArgumentException( "x must be positive : " + left );
    if ( top < 0 )
      throw new IllegalArgumentException( "y must be positive : " + top );
    System.out.print( ESC + "[3;" + left + ";" + top + "t" );
  }

  public static void minimizeWindow() {
    System.out.print( ESC + "[2t" );
  }

  public static void focusWindow() {
    System.out.print( ESC + "[1t" );
  }

  public static void maximizeWindow() {
    System.out.print( ESC + "[9;1t" );
  }

  public static void toTheFront() {
    System.out.print( ESC + "[5t" );
  }
  
  public static void moveOneUpFirstColumn() {
    System.out.print( ESC + "[1F" );
  }

}
