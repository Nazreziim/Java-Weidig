package alt.einfuehrung.awt;

import java.awt.Frame;

public class HelloAwtFrame {
  public static void main( String[] args ) {
    Frame f = new Frame( "Das Fenster zur Welt!" );
    f.setSize( 300, 200 );
    f.setVisible( true );
    // Dieses Fenster ist so noch nicht schließbar!
    // Hier müssten selbst Fensterereignisse abgefangen werden
    // Der Swing-JFrame horcht selbstständig auf ein WindowEvent
  }
}
