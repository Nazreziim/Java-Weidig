package beispiele.layout.gridBagLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
 *
 */
public class GridBagLayoutFrame extends JFrame {

  private static final long serialVersionUID = -346507630195786321L;

  public GridBagLayoutFrame() {
    this( "" );
  }

  public GridBagLayoutFrame( String name ) {
    this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    JButton button;
    this.setLayout( new GridBagLayout() );
    GridBagConstraints c = new GridBagConstraints(); // BedingungsObjekt

    button = new JButton( "Button 1" );
    c.fill = GridBagConstraints.HORIZONTAL; // Constraints zurücksetzen
    c.gridx = 0; // Horizontale Position
    c.gridy = 0; // Vertikale Position
    this.add( button, c ); // Button mit Constraints hinzufügen

    button = new JButton( "Button 2" );
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5; // Die Gewichtung der Größenveränderung in xRichtung(Breite)
                     // Ohne diese Angabe ändert sich die Größe nicht.
    c.gridx = 1;
    c.gridy = 0;
    this.add( button, c );

    button = new JButton( "Button 3" );
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 2; // Horizontale Position
    c.gridy = 0;
    this.add( button, c );

    button = new JButton( "Long-Named Button 4" );
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 40; // make this component tall
    c.weightx = 0.0;
    c.gridwidth = 3; // Über mehrere Felder ziehen. hier: 3
    c.gridx = 0;
    c.gridy = 1;
    this.add( button, c );

    button = new JButton( "5" );
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 0; // reset to default
    c.weighty = 1.0; // Vertikalen 
    c.anchor = GridBagConstraints.PAGE_END; // Button am unteren Rand festhalten
    c.insets = new Insets( 10, 0, 0, 0 ); // Abstand nach oben
    c.gridx = 1; // aligned with button 2
    c.gridwidth = 2; // 2 columns wide
    c.gridy = 2; // third row
    this.add( button, c );

    this.setVisible( true );
    this.pack();
  }
}
