package uebungen.aufgabe5;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class JClosableFrame extends JFrame {
  private static final long serialVersionUID = 3107291373382765177L;

  public JClosableFrame() {
    this( "" );
  }

  public JClosableFrame( String title ) {
    super( title );
    this.setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );
    this.addWindowListener( new WindowAdapter() {
      @Override
      public void windowClosing( WindowEvent e ) {
        int answer = JOptionPane.showConfirmDialog( null, "Fenster schlieﬂen?",
                "Sicherheitsabfrage", JOptionPane.YES_NO_OPTION );
        if ( answer == 0 ) {
          ( (JFrame) e.getSource() ).dispose();
        }
      }
    } );
  }

}
