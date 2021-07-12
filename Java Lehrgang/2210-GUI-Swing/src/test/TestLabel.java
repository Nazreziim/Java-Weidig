package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestLabel extends JLabel {

  private static final long serialVersionUID = 6299334965188762336L;

  public static void main( String[] args ) {

    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame tf = new JFrame( "Test" );
        tf.setBounds( 100, 100, 500, 500 );
        TestLabel tl = new TestLabel();
        tl.setBounds( 0, 0, 500, 500 );
        tf.add( tl );
        tf.setVisible( true );
        
      }
    } );

  }

  @Override
  public void paintComponent( Graphics g ) {

    g.fillRect( 10, 10, 100, 100 );
    g.setColor( Color.red );
    g.drawLine( 50, 50, 450, 450 );
  }

}
