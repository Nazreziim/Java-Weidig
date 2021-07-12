package beispiele.layout.boxLayout;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
 */
public class BoxLayoutFrame extends JFrame {

  public BoxLayoutFrame() {
    this( "" );
  }

  public BoxLayoutFrame( String name ) {
    super( name );
    this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    JPanel top = new JPanel();
    top.setLayout( new BoxLayout( top, BoxLayout.Y_AXIS ) );
    JLabel label = new JLabel( "Test Liste" );
    label.setAlignmentX( Component.LEFT_ALIGNMENT );
    top.add( label );
    top.add( Box.createRigidArea( new Dimension( 0, 5 ) ) );
    JScrollPane listScroller = new JScrollPane(
            new JList< Integer >( new Integer[]{ 10, 20, 30, 50, 40, 60, 70, 90 } ) );
    listScroller.setPreferredSize( new Dimension( 250, 100 ) );
    top.add( listScroller );
    top.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );

    JPanel buttonPane = new JPanel();
    buttonPane.setLayout( new BoxLayout( buttonPane, BoxLayout.X_AXIS ) );
    buttonPane.setBorder( BorderFactory.createEmptyBorder( 0, 10, 10, 10 ) );
    buttonPane.add( Box.createHorizontalGlue() );
    buttonPane.add( new JButton( "Cancel" ) );
    buttonPane.add( Box.createRigidArea( new Dimension( 10, 0 ) ) );
    buttonPane.add( new JButton( "Set" ) );
    Container contentPane = getContentPane();
    contentPane.add( top, BorderLayout.CENTER );
    contentPane.add( buttonPane, BorderLayout.SOUTH );

    this.setVisible( true );
    this.pack();
  }

}
