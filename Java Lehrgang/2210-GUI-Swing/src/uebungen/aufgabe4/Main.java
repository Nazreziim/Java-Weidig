package uebungen.aufgabe4;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

  public static void main( String[] args ) {

    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame( "Man nennt es \"Das Fenster\"" );
        frame.setBounds( 100, 100, 600, 200 );
        frame.setVisible( true );
        frame.setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
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
              frame.setLocation( 0, windowTop );
            } else if ( Math.abs( screenWidth - windowRight ) < gap ) {
              frame.setLocation( screenWidth - ( windowRight - windowLeft ), windowTop );
            } else if ( Math.abs( windowTop ) < gap ) {
              frame.setLocation( windowLeft, 0 );
            } else if ( Math.abs( screenHeight - windowBottom ) < gap ) {
              frame.setLocation( windowLeft, screenHeight - ( windowBottom - windowTop ) );
            }
          }
        } );
        frame.addMouseMotionListener( new MouseMotionAdapter() {
          @Override
          public void mouseMoved( java.awt.event.MouseEvent e ) {
            frame.setTitle( "Man nennt es \"Das Fenster\" x=" + e.getX() + ",y=" + e.getY() );
          }
        } );
        frame.addWindowListener( new WindowAdapter() {
          @Override
          public void windowClosing( WindowEvent e ) {
            frame.dispose();
          }

          @Override
          public void windowIconified( WindowEvent e ) {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int newX = (int) ( Math.random() * ( dim.getWidth()
                    - ( frame.getBounds().getMaxX() - frame.getBounds().getMinX() ) ) );
            int newy = (int) ( Math.random() * ( dim.getHeight()
                    - ( frame.getBounds().getMaxY() - frame.getBounds().getMinY() ) ) );
            frame.setLocation( newX, newy );
            frame.setState( Frame.NORMAL );
          }
        } );
      }
    } );
  }
}
