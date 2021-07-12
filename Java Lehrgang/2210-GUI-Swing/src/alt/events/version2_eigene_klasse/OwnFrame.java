package alt.events.version2_eigene_klasse;

import javax.swing.JFrame;

public class OwnFrame extends JFrame {

  public OwnFrame( int x, int y ) {
    super( "OwnFrame" );
    this.setSize( x, y );
    this.addWindowListener( new OwnWindowListener() );

  }

  public static void main( String[] args ) {
    OwnFrame f = new OwnFrame( 640, 480 );
    f.setVisible( true );
  }
}
