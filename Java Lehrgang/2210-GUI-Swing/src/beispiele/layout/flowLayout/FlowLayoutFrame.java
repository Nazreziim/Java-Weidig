package beispiele.layout.flowLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/flow.html
 *
 */
public class FlowLayoutFrame extends JFrame {
  private static final long serialVersionUID = 9216758348752501173L;

  public FlowLayoutFrame() {
    this( "" );
  }

  public FlowLayoutFrame( String name ) {
    super( name );
    this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    JPanel panel = new JPanel();
    // FlowLayout ist Standard bei JPanel, hier ein FlowLayout mit Ausrichtung (zentriert) und
    // Abstand vertikal/horizontal 10/10
    panel.setLayout( new FlowLayout( FlowLayout.CENTER, 10, 10 ) );
    JButton button = new JButton( "1" );
    panel.add( button );
    button = new JButton( "2" );
    panel.add( button );
    button = new JButton( "3" );
    panel.add( button );

    this.add( panel );

    this.setVisible( true );
    this.pack();
  }
}
