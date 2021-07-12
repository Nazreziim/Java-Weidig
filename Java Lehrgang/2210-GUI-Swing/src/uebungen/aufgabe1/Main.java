package uebungen.aufgabe1;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

  public static void main( String[] args ) {

    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame( "Man nennt es \"Das Fenster\"" );
        frame.setBounds( 100, 100, 600, 200 );
        frame.setVisible( true );
      }
    } );
  }

}
