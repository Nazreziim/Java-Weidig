package beispiele.layout.borderLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
 *
 */
public class BorderLayoutFrame extends JFrame {
  private static final long serialVersionUID = 9216758348752501173L;

  public BorderLayoutFrame() {
    this( "" );
  }

  public BorderLayoutFrame( String name ) {
    super( name );
    this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    BorderLayout borderLayout = new BorderLayout();
    this.setLayout( borderLayout );

    // Oberer Button
    JButton top = new JButton( "Button 1 (PAGE_START) | (NORTH)" );
    this.add( top, BorderLayout.PAGE_START );

    // Mittlerer Button
    JButton center = new JButton( "Button 2 (CENTER)" );
    center.setPreferredSize( new Dimension( 200, 100 ) );
    this.add( center, BorderLayout.CENTER );

    // Linker Button
    JButton left = new JButton( "Button 3 (LINE_START) | (WEST)" );
    this.add( left, BorderLayout.LINE_START );

    // Unterer Button
    JButton bottom = new JButton( "Button 4 (PAGE_END) | (SOUTH)" );
    this.add( bottom, BorderLayout.PAGE_END );

    // Rechter Button
    JButton right = new JButton( "Button 5 (LINE_END) | (EAST)" );
    this.add( right, BorderLayout.LINE_END );

    this.setVisible( true );
    this.pack();
  }
}
