package alt.events.version1_windowlistener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Diese Klasse soll zeigen, wie man einen Listener implementiert. Hier ist der Listener auch gleich
 * Event-Quelle, nämlich ein JFrame. Damit müssen alle Methode von WindowListener implementiert
 * werden. Vorteile: - alle Attribute der Quelle sind direkt greifbar. Nachteil: - eigene Klasse als
 * Listener ist bei größeren Projekten greifbarer
 * 
 * @author LGerhard
 *
 */
public class CloseWindowListener extends JFrame implements WindowListener {

  public CloseWindowListener() {
    super( "Hallo Listener" );
    this.setSize( 640, 480 );
    // Listener für Window-Events anmelden, hier ist es das Objekt selbst, kann aber auch ein
    // anderes Objekt sein
    // Nicht alle Komponenten können alle Eventarten auslösen, deshalb hat jede
    // Komponente nur addXXXListener()-Methoden für entsprechende Events, die ausgelöst
    // werden können.
    this.addWindowListener( this );
    // Reiht Listener in eine interne Liste des Objekts ein. Bei eintretenden Event werden
    // alle Listener in Liste informiert.

    // Listener wieder entfernen
    // this.removeWindowListener(this);

    this.setVisible( true );

  }

  /*
   * Folgend die Methoden aus WindowListener. Jeder, der WindowListener sein möchte, muß diese
   * Methoden implementieren. Wir implementieren alle mit leeren Rumpf, außer windowClosing.
   */

  /**
   * Wird aufgerufen, wenn Fenster aktiviert wird.
   */
  public void windowActivated( WindowEvent e ) {
    System.out.println( "Aktivierung!" );

  }

  /**
   * Wird aufgerufen, wenn Fenster mit dispose() geschlossen wird
   */
  public void windowClosed( WindowEvent e ) {
    System.out.println( "Disposed!" );

  }

  /**
   * Wird aufgerufen wenn das Fenster geschlossen wird.
   */
  public void windowClosing( WindowEvent e ) {
    JLabel l = new JLabel( "Fenster wird geschlossen", SwingConstants.CENTER );
    this.add( l );
    // Bei Änderung eines Frames nach dem Anzeigen, muss validate ausgeführt werden, damit Layout
    // angepasst/ neu berechnet wird.
    // Mit Aufruf von update(Graphics g) wird neu gezeichnet.
    // das Frame neu gezeichnet.

    this.validate();

    this.update( this.getGraphics() );

    System.out.println( "Fenster wird geschlossen" );

    try {
      Thread.sleep( 2000 );
    } catch ( InterruptedException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    System.exit( 0 );
    // dispose gibt die zugeordneten Windows-Ressourcen frei und entfernt das Fenster aus der
    // Owner-Child-Registrierung
    // this.dispose();
  }

  /**
   * Wenn Fenster deaktiviert wird.
   */
  public void windowDeactivated( WindowEvent e ) {
    System.out.println( "Jetzt wird deaktiviert" );

  }

  /**
   * Wird aufgerufen, wenn das Fenster aus Icon wieder geholt wird.
   */
  public void windowDeiconified( WindowEvent e ) {
    // TODO Auto-generated method stub

  }

  /**
   * Wird aufgerufen, wenn das Fenster zum Icon minimiert wird.
   */
  public void windowIconified( WindowEvent e ) {

  }

  /**
   * Wird aufgerufen wenn Fenster geöffnet wird.
   */
  public void windowOpened( WindowEvent e ) {
    System.out.println( "Jetzt wirds geöffnet" );

  }

  public static void main( String args[] ) {
    new CloseWindowListener();
  }

}
