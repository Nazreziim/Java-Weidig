package beispiele.internalFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * http://docs.oracle.com/javase/tutorial/uiswing/components/internalframe.html
 */
public class InternalFrameDemo extends JFrame implements ActionListener {
  JDesktopPane desktop;

  public InternalFrameDemo() {
    super( "InternalFrameDemo" );

    setBounds( 100, 100, 500, 500 );
    // Set up the GUI.
    desktop = new JDesktopPane(); // Ein spezielles LayeredPane
    createFrame(); // Das erste Fenster erzeugen
    setContentPane( desktop );
    setJMenuBar( createMenuBar() );

    // Make dragging a little faster but perhaps uglier.
    desktop.setDragMode( JDesktopPane.OUTLINE_DRAG_MODE );
  }

  protected JMenuBar createMenuBar() {
    JMenuBar menuBar = new JMenuBar();

    // JMenu erzeugen
    JMenu menu = new JMenu( "Document" );
    menu.setMnemonic( KeyEvent.VK_D );
    menuBar.add( menu );

    // Erstes JMenuItem erzeugen
    JMenuItem menuItem = new JMenuItem( "New" );
    menuItem.setMnemonic( KeyEvent.VK_N );
    menuItem.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.ALT_MASK ) );
    menuItem.setActionCommand( "new" );
    menuItem.addActionListener( this );
    menu.add( menuItem );

    // Zweites JMenuItem erzeugen
    menuItem = new JMenuItem( "Quit" );
    menuItem.setMnemonic( KeyEvent.VK_Q );
    menuItem.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_Q, ActionEvent.ALT_MASK ) );
    menuItem.setActionCommand( "quit" );
    menuItem.addActionListener( this );
    menu.add( menuItem );

    return menuBar;
  }

  // Auf Auswahl in der MenuBar reagieren
  // Diese Klasse ist ein ActionListener
  public void actionPerformed( ActionEvent e ) {
    if ( "new".equals( e.getActionCommand() ) ) {
      // Neues internes Fenster erzeugen
      createFrame();
    } else {
      // Schlieﬂen (‰uﬂeres Fenster) 
      quit();
    }
  }

  // Internes Fenster erzeugen
  protected void createFrame() {
    JInternalFrame frame = new JInternalFrame( "Titel", true, // Schlieﬂbar
            true, // Grˆﬂe Ver‰nderbar
            true, // Maximierbar
            true // Minimierbar
    );
    JLabel anzeige = new JLabel( "Test Text im Test Fenster" );
    anzeige.setOpaque( false );
    anzeige.setPreferredSize( new Dimension( 150, 50 ) );
    frame.add( anzeige );
    frame.pack();
    frame.setVisible( true );
    desktop.add( frame );
    try {
      frame.setSelected( true );
    } catch ( java.beans.PropertyVetoException e ) {
    }
  }

  // Quit the application.
  protected void quit() {
    this.dispose();
  }

  /**
   * Create the GUI and show it. For thread safety, this method should be invoked from the
   * event-dispatching thread.
   */
  private static void createAndShowGUI() {
    try { // Look and Feel setzen
      UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
    } catch ( ClassNotFoundException e ) {
    } catch ( InstantiationException e ) {
    } catch ( IllegalAccessException e ) {
    } catch ( UnsupportedLookAndFeelException e ) {
    }

    // ƒuﬂeres Fenster erzeugen
    InternalFrameDemo frame = new InternalFrameDemo();
    frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

    // Display the window.
    frame.setVisible( true );
  }

  public static void main( String[] args ) {
    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater( new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    } );
  }
}
