package alt.layout.look_and_feel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

/**
 * Eine Klasse mit der sich die unterschiedlichen Layout-Manager von Swing betrachten lassen
 * 
 * @author LGerhard
 */
public class AllLayoutManagers extends JFrame {

  public AllLayoutManagers( int x, int y ) {
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    this.setSize( 300, 200 );

    JTabbedPane p = new JTabbedPane( JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT );
    p.addTab( "Flow", genFlowLayoutPanel() );
    p.addTab( "Border", genBorderLayoutPanel() );
    p.addTab( "Grid", genGridLayoutPanel() );
    p.addTab( "GridBag", genGridBagLayoutPanel() );
    p.addTab( "Null", genNullLayoutPanel() );
    p.addTab( "Box", genBoxLayoutPanel() );
    p.addTab( "Card", genCardLayoutPanel() );
    // Jetzt wir die Tabbedpane zum Frame hinzugefügt.
    this.add( p );
    this.setVisible( true );
  }

  private JPanel genFlowLayoutPanel() {
    JPanel p = new JPanel();
    p.setLayout( new FlowLayout() );
    JComboBox choice = new JComboBox();
    choice.addItem( "Mike: Mein Gott Walter" );
    choice.addItem( "Helge: Katzeklo" );

    p.add( choice );

    ImageIcon icon = new ImageIcon( "./12 GUI/res/save.gif" );
    JButton b = new JButton( icon );

    p.add( b );

    return p;
  }

  private JPanel genBorderLayoutPanel() {
    JPanel p = new JPanel();
    p.setLayout( new BorderLayout( 10, 5 ) );
    // Hier anstelle Richtungskonstanten, Konstanten die von Leserichtung
    // abhängen
    p.add( new JButton( "Top" ), BorderLayout.PAGE_START );
    p.add( new JButton( "Right" ), BorderLayout.LINE_END );
    p.add( new JButton( "Bottom" ), BorderLayout.PAGE_END );
    p.add( new JButton( "Left" ), BorderLayout.LINE_START );
    p.add( new JButton( "Center" ) ); // ohne Positionsangabe immer in der Mitte
    return p;
  }

  private JPanel genGridLayoutPanel() {
    JPanel f = new JPanel();
    // Es muÃŸ nur Spalten oder Zeilen angegeben werden, das jeweils andere
    // brechnet sich aus den hinzugefÃ¼gten Elementen
    f.setLayout( new GridLayout( /* 3 */0, 2, 6, 3 ) );
    f.add( new JLabel( " Name?" ) );
    f.add( new JTextField() );
    f.add( new JLabel( " Alter?" ) );
    f.add( new JFormattedTextField( NumberFormat.getIntegerInstance() ) );
    f.add( new JLabel( " Passwort eingeben:" ) );
    f.add( new JPasswordField() );

    return f;
  }

  /**
   * Hilfsmethode um mit GridBagConstraint ein Element zum Container hinzuzufügen
   * 
   * @param cont Der Container für den das Layout gesetzt wurde und in den eingefügt wird
   * @param gbl Der Layoutmanager - also konkret das GridBagLayout!
   * @param c Die Komponente, die aufgenommen werden soll
   * @param x x-Koordinate im GridBag-Raster
   * @param y y-Koordinate im GridBag-Raster
   * @param width Anzahl der Zellen, die die Komponenten in der Breite einnehmen soll
   * @param height Anzahl der Zellen, deie Komponente in der Höhe einnehmen soll
   * @param weightx
   * @param weighty
   */
  private static void addComponent( Container cont, GridBagLayout gbl, Component c, int x, int y,
          int width, int height, double weightx, double weighty ) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.gridwidth = width;
    gbc.gridheight = height;
    gbc.weightx = weightx;
    gbc.weighty = weighty;
    gbl.setConstraints( c, gbc );
    cont.add( c );
  }

  private JPanel genGridBagLayoutPanel() {
    JPanel f = new JPanel();
    GridBagLayout gbl = new GridBagLayout();
    f.setLayout( gbl );
    // x y w h wx wy
    addComponent( f, gbl, new JButton( "1" ), 0, 0, 2, 2, 1.0, 1.0 );
    addComponent( f, gbl, new JButton( "2" ), 2, 0, 1, 1, 0, 1.0 );
    addComponent( f, gbl, new JButton( "3" ), 2, 1, 1, 1, 0, 0 );
    addComponent( f, gbl, new JButton( "4" ), 0, 2, 3, 1, 0, 1.0 );
    addComponent( f, gbl, new JButton( "5" ), 0, 3, 2, 1, 0, 0 );
    addComponent( f, gbl, new JButton( "6" ), 0, 4, 2, 1, 0, 0 );
    addComponent( f, gbl, new JButton( "7" ), 2, 3, 1, 2, 0, 0 );

    return f;
  }

  private JPanel genNullLayoutPanel() {
    JPanel c = new JPanel();
    c.setLayout( null );
    JButton b = new JButton( "Snug Weste blau, innen rot" );
    b.setBounds( 0, 0, 200, 50 );
    c.add( b );
    b = new JButton( "HPX Gore-tex Ocean Jacket" );
    b.setBounds( 250, 0, 150, 50 );
    c.add( b );
    return c;
  }

  private JPanel genBoxLayoutPanel() {
    JPanel p = new JPanel();
    p.setLayout( new BoxLayout( p, BoxLayout.Y_AXIS ) );
    p.add( new JButton( "<" ) );
    p.add( new JButton( ">" ) );
    return p;
  }

  private JPanel genCardLayoutPanel() {
    // Erstellen der Karten
    JPanel card1 = new JPanel();
    card1.add( new JButton( "Button 1" ) );
    card1.add( new JButton( "Button 2" ) );
    card1.add( new JButton( "Button 3" ) );

    JPanel card2 = new JPanel();
    card2.add( new JTextField( "TextField", 20 ) );

    // Nun das Panel mit CardLayout
    JPanel cardsPanel = new JPanel();
    cardsPanel.setLayout( new CardLayout( 10, 10 ) );
    cardsPanel.add( card1, "Karte mit Buttons" );
    cardsPanel.add( card2, "Karte mit Textfeld" );

    // Eine Combobox zum Umschalten zwischen den Karten mit ItemListener
    JComboBox cb = new JComboBox( new String[]{ "Karte mit Buttons", "Karte mit Textfeld" } );
    cb.setEditable( false );
    cb.addItemListener( new ItemListener() {
      @Override
      public void itemStateChanged( ItemEvent e ) {
        // Verrückter Kram um an das cardsPanel zu kommen
        JPanel cardsPanel = ( (JPanel) ( ( (JComboBox) e.getSource() ).getParent()
                .getComponent( 1 ) ) );
        CardLayout cl = (CardLayout) ( cardsPanel.getLayout() );
        String s = (String) e.getItem();
        cl.show( cardsPanel, s );

      }
    } );

    JPanel containerPanel = new JPanel();
    containerPanel.setLayout( new GridLayout( 2, 0 ) );
    containerPanel.add( cb );
    containerPanel.add( cardsPanel );
    return containerPanel;
  }

  public static void main( String[] args ) {
    // Das setzt das Windows Look & Feel - !System!
    try {
      UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
    } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException
            | UnsupportedLookAndFeelException e ) {
      e.printStackTrace();
    }

    // Für das Metal L&F gibt es drei Themes: DefaultMetal, Ocean, Test
    try {
      UIManager.setLookAndFeel( new MetalLookAndFeel() );
      MetalLookAndFeel.setCurrentTheme( new OceanTheme() );
    } catch ( UnsupportedLookAndFeelException e ) {
      e.printStackTrace();
    }

    // Nimbus L&F seit Java SE 6 - sehr stark anpassbar - siehe Java Tutorials
    try {
      for ( LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ) {
        if ( "Nimbus".equals( info.getName() ) ) {
          UIManager.setLookAndFeel( info.getClassName() );
          break;
        }
      }
    } catch ( Exception e ) {
      // If Nimbus is not available, you can set the GUI to another look and feel.
    }

    AllLayoutManagers of = new AllLayoutManagers( 300, 200 );
  }
}
