package beispiele.layout.gridLayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
 *
 */
public class GridLayoutFrame extends JFrame {

  private static final long serialVersionUID = -346507630195786321L;

  public GridLayoutFrame() {
    this( "" );
  }

  public GridLayoutFrame( String name ) {
    this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    // GridLayout mit 2 Spalten und 10 px horizontalem / vertikalem Abstand
    this.setLayout( new GridLayout( 0, 2, 10, 10 ) );
    this.add( new JButton( "Button 1" ) );
    this.add( new JButton( "Button 2" ) );
    this.add( new JButton( "Button 3" ) );
    this.add( new JButton( "Button 4" ) );
    this.add( new JButton( "Button 5" ) );

    this.setVisible( true );
    this.pack();
  }
}
