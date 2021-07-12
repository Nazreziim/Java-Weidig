package alt.events.version3_mit_adapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * WindowAdapter implementiert alle Methoden aus WindowListener, WindowStateListener,
 * WindowFocusListener mit leeren Körper. D.h. nun muss ich nur noch die Methoden schreiben, die ich
 * brauch.
 * 
 * @author Daniel
 *
 */
public class CloseWindowAction extends WindowAdapter {

  public void windowClosing( WindowEvent e ) {
    System.out.println( "Schließen mit Adapter" );
    System.exit( 0 );
  }

}
