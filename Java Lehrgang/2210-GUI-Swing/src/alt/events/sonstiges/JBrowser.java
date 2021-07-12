package alt.events.sonstiges;

import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class JBrowser extends JEditorPane implements HyperlinkListener {

  JBrowser( String url ) {
    setEditable( false );
    this.setContentType( "text/html" );
    addHyperlinkListener( this );
    try {
      setPage( new URL( url ) );
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  @Override
  public void hyperlinkUpdate( HyperlinkEvent event ) {
    HyperlinkEvent.EventType typ = event.getEventType();
    if ( typ == HyperlinkEvent.EventType.ACTIVATED ) {
      try {
        setPage( event.getURL() );
      } catch ( IOException e ) {
        JOptionPane.showMessageDialog( this,
                "Kann dem Link nicht folgen: " + event.getURL().toExternalForm(), "Ladefehler",
                JOptionPane.ERROR_MESSAGE );
      }
    }
  }

  public static void main( String[] args ) {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 600, 500 );
    f.add( new JScrollPane( new JBrowser( "http://www.w3.org" ) ) );
    f.setVisible( true );
  }
}
