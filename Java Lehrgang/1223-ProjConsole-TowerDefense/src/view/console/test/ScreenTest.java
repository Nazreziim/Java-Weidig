package view.console.test;

import java.util.Arrays;

import view.console.BashControl;

public class ScreenTest {

  public static void main( String[] args ) {

    BashControl.setWindowTitle( "Tower Defence :)" );
    BashControl.setSize( 72, 271 );
    BashControl.setWindowPosition( 0, 0 );
    System.out.println( "WindowSize: " + Arrays.toString( BashControl.getSize() ) );

    // Foreground
    for ( int zeile = 0; zeile < 16; ++zeile ) {
      for ( int spalte = 0; spalte < 16; ++spalte ) {
        BashControl.setForegroundColor( zeile * 16 + spalte );
        System.out.printf( "%4d", zeile * 16 + spalte );
        BashControl.resetAll();
      }
      System.out.println();
    }

    // Background
    for ( int zeile = 0; zeile < 16; ++zeile ) {
      for ( int spalte = 0; spalte < 16; ++spalte ) {
        BashControl.setBackgroundColor( zeile * 16 + spalte );
        System.out.printf( "%4d", zeile * 16 + spalte );
        BashControl.resetAll();
      }
      System.out.println();
    }

    // try {
    // TimeUnit.SECONDS.sleep( 2 );
    // } catch ( InterruptedException e ) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    //
    // BashControl.clearConsole();
    // BashControl.clearConsoleBuffer();
    // BashControl.saveCursorPosition();
    // BashControl.goTo( 10, 10 );
    // BashControl.setForegroundColor( 2 );
    // System.out.println( "Fuer DAWO" );
    // BashControl.restoreCursorPosition();
    //
    // // Textmodes
    // System.out.print( "Normal" );
    // BashControl.bold();
    // System.out.print( "Bold" );
    // BashControl.resetAll();
    // System.out.println( "Normal" );
    //
    // System.out.println( BashControl.ESC + "[1;1]" );
    //
    // System.out.print( "Normal" );
    // BashControl.doubleUnderlined();
    // System.out.print( "doubleUnderlined" );
    // BashControl.resetAll();
    // System.out.println( "Normal" );
    //
    // System.out.print( "Normal" );
    // BashControl.dim();
    // System.out.print( "Dim" );
    // BashControl.resetDim();
    // System.out.println( "Normal" );
    //
    // System.out.print( "Normal" );
    // BashControl.underlined();
    // System.out.print( "Underlined" );
    // BashControl.resetUnderlined();
    // System.out.println( "Normal" );
    //
    // System.out.print( "Normal" );
    // BashControl.inverted();
    // System.out.print( "Inverted" );
    // BashControl.resetInverted();
    // System.out.println( "Normal" );
    //
    // System.out.print( "Normal" );
    // BashControl.hidden();
    // System.out.print( "Hidden" );
    // BashControl.resetHidden();
    // System.out.println( "Normal" );

  }

}
