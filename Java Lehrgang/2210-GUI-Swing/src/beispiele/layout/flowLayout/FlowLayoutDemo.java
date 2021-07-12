
package beispiele.layout.flowLayout;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/flow.html
 */
public class FlowLayoutDemo extends JFrame {

  // Elemente die in mehreren Methoden benötigt werden
  JRadioButton RtoLbutton;
  JRadioButton LtoRbutton;
  FlowLayout layout = new FlowLayout();
  final String RtoL = "Right to left";
  final String LtoR = "Left to right";
  JButton applyButton = new JButton( "Ausrichtung anwenden" );

  public FlowLayoutDemo( String name ) {
    super( name );
  }

  public void addComponentsToPane( Container pane ) {
    JPanel components = new JPanel();
    components.setLayout( layout );
    layout.setAlignment( FlowLayout.TRAILING );
    JPanel controls = new JPanel();
    controls.setLayout( new FlowLayout() );

    LtoRbutton = new JRadioButton( LtoR );
    LtoRbutton.setActionCommand( LtoR );
    LtoRbutton.setSelected( true );
    RtoLbutton = new JRadioButton( RtoL );
    RtoLbutton.setActionCommand( RtoL );

    // Buttons zum JPanel hinzufügen
    components.add( new JButton( "Button 1" ) );
    components.add( new JButton( "Button 2" ) );
    components.add( new JButton( "Button 3" ) );
    components.add( new JButton( "Long-Named Button 4" ) );
    components.add( new JButton( "5" ) );
    // Von links nach rechts Ausrichtung ist Standard
    components.setComponentOrientation( ComponentOrientation.LEFT_TO_RIGHT );

    // Steuerungs Elemente zum SteuerungsPanel hinzufügen
    ButtonGroup group = new ButtonGroup();
    group.add( LtoRbutton );
    group.add( RtoLbutton );
    controls.add( LtoRbutton );
    controls.add( RtoLbutton );
    controls.add( applyButton );

    // Ausrichtung Übernehmen: Implementierung
    applyButton.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent e ) {
        String command = group.getSelection().getActionCommand();
        // Check the selection
        if ( command.equals( "Left to right" ) ) {
          components.setComponentOrientation( ComponentOrientation.LEFT_TO_RIGHT );
        } else {
          components.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
        }
        // Fensterinhalte neu zeichnen
        components.validate();
        components.repaint();
      }
    } );
    pane.add( components, BorderLayout.CENTER );
    pane.add( controls, BorderLayout.SOUTH );
    ;
  }

  /**
   * Create the GUI and show it. For thread safety, this method should be invoked from the event
   * dispatch thread.
   */
  private static void createAndShowGUI() {
    // Create and set up the window.
    FlowLayoutDemo frame = new FlowLayoutDemo( "FlowLayoutDemo" );
    frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
    // Set up the content pane.
    frame.addComponentsToPane( frame.getContentPane() );
    // Display the window.
    frame.pack();
    frame.setVisible( true );
  }

  public static void main( String[] args ) {
    /* Use an appropriate Look and Feel */
    try {
      UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
      // UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
    } catch ( UnsupportedLookAndFeelException ex ) {
      ex.printStackTrace();
    } catch ( IllegalAccessException ex ) {
      ex.printStackTrace();
    } catch ( InstantiationException ex ) {
      ex.printStackTrace();
    } catch ( ClassNotFoundException ex ) {
      ex.printStackTrace();
    }
    /* Turn off metal's use of bold fonts */
    // UIManager.put( "swing.boldMetal", Boolean.FALSE );
    // Schedule a job for the event dispatchi thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater( new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    } );
  }
}
