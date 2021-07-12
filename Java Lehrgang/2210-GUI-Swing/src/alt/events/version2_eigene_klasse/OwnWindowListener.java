package alt.events.version2_eigene_klasse;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class OwnWindowListener implements WindowListener {

  @Override
  public void windowActivated( WindowEvent e ) {
    System.out.println( "Hallo Listener!" );

  }

  @Override
  public void windowClosed( WindowEvent e ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowClosing( WindowEvent e ) {
    System.out.println( "Fenster geschlossen" );
    System.exit( 0 );

  }

  @Override
  public void windowDeactivated( WindowEvent e ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeiconified( WindowEvent e ) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowIconified( WindowEvent e ) {

  }

  @Override
  public void windowOpened( WindowEvent e ) {
    System.out.println( "Fenster geöffnet!" );

  }

}
