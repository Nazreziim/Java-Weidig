package alt.events.version4_innere_klassen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AnonymousClassFrame extends JFrame {

  public AnonymousClassFrame( int x, int y ) {
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    this.setSize( x, y );

    // anonyme Klasse, jetzt existiert ein derartiger Adapter nur dort, wo ad
    // g�ltig ist
    WindowAdapter ad = new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.out.println( "Schlie�en mit Adapter" );
        sayHello();
        System.exit( 0 );
      }
    };
    // Hinzuf�gen des Adapters als Listener f�r WindowEvents.
    this.addWindowListener( ad );
    this.setVisible( true );
  }

  public void sayHello() {

    System.out.println( "Hello!" );
  }

  public static void main( String[] args ) {
    AnonymousClassFrame of = new AnonymousClassFrame( 640, 480 );
  }
}
