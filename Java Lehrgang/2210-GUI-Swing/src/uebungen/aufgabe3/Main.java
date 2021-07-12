package uebungen.aufgabe3;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class Main {

  public static void main( String[] args ) {

    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame( "Man nennt es \"Das Fenster\"" );
        frame.setBounds( 100, 100, 600, 200 );
        frame.setVisible( true );
        frame.addComponentListener( new ComponentAdapter() {
          @Override
          public void componentMoved( ComponentEvent e ) {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int gap = 50;
            int screenWidth = (int) dim.getWidth();
            int screenHeight = (int) dim.getHeight();
            int windowLeft = (int) frame.getBounds().getMinX();
            int windowTop = (int) frame.getBounds().getMinY();
            int windowRight = (int) frame.getBounds().getMaxX();
            int windowBottom = (int) frame.getBounds().getMaxY();

            if ( Math.abs( windowLeft ) < gap ) {
              frame.setBounds( 0, windowTop, windowRight - windowLeft, windowBottom - windowTop );
            } else if ( Math.abs( screenWidth - windowRight ) < gap ) {
              frame.setBounds( screenWidth - ( windowRight - windowLeft ), windowTop,
                      windowRight - windowLeft, windowBottom - windowTop );
            } else if ( Math.abs( windowTop ) < gap ) {
              frame.setBounds( windowLeft, 0, windowRight - windowLeft, windowBottom - windowTop );
            } else if ( Math.abs( screenHeight - windowBottom ) < gap ) {
              frame.setBounds( windowLeft, screenHeight - ( windowBottom - windowTop ),
                      windowRight - windowLeft, windowBottom - windowTop );
            }
          }
        } );
        frame.addMouseMotionListener( new MouseMotionAdapter() {
          public void mouseMoved( java.awt.event.MouseEvent e ) {
            frame.setTitle( "Man nennt es \"Das Fenster\" x=" + e.getX() + ",y=" + e.getY() );
          }
        } );
      }
    } );
  }
}
