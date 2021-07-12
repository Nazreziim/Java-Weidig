package beispiele.pane.tabbedPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TabbedPaneDemo extends JFrame {
  private static final long serialVersionUID = -5133965757798312274L;

  public TabbedPaneDemo() {
    this( "" );
  }

  public TabbedPaneDemo( String name ) {
    super( name );
    this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    JTabbedPane tabbedPane = new JTabbedPane( JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT );
    tabbedPane.add( createTableDemo(), "JTable", 0 );
    tabbedPane.add( createListDemo(), "JList", 1 );
    tabbedPane.add( createTableDemo(), "JTable" );
    tabbedPane.add( createListDemo(), "JList" );
    tabbedPane.add( createTableDemo(), "JTable" );
    tabbedPane.add( createListDemo(), "JList" );
    this.add( tabbedPane );
    this.pack();
    this.setVisible( true );
  }

  public static JPanel createTableDemo() {
    JPanel root = new JPanel();
    root.setLayout( new BorderLayout() );
    root.setBorder(
            BorderFactory.createTitledBorder( BorderFactory.createLineBorder( Color.BLACK, 3 ),
                    "JTable", TitledBorder.TOP, TitledBorder.RIGHT ) );

    // Spaltennamen definieren
    String[] spalten = new String[ 5 ];
    spalten[ 0 ] = "Dienstgrad";
    spalten[ 1 ] = "Name";
    spalten[ 2 ] = "Vorname";
    spalten[ 3 ] = "Geburtsjahr";
    spalten[ 4 ] = "BS";

    // Inhalt definieren
    Object[][] daten = new Object[ 5 ][ 5 ];
    daten[ 0 ] = new Object[]{ "G", "Mustermann", "Max", new Integer( 1982 ),
            new Boolean( false ) };
    daten[ 1 ] = new Object[]{ "OG", "Musterfrau", "Monika", new Integer( 1978 ),
            new Boolean( false ) };
    daten[ 2 ] = new Object[]{ "HFw", "Hamann", "Toni", new Integer( 1990 ), new Boolean( true ) };
    daten[ 3 ] = new Object[]{ "Lt", "Stark", "Chris", new Integer( 1988 ), new Boolean( true ) };
    daten[ 4 ] = new Object[]{ "OTL", "Wünsche", "Wolf", new Integer( 1969 ), new Boolean( true ) };

    TableModel testModel = new DefaultTableModel( daten, spalten ) {
      private static final long serialVersionUID = 6109781664833832263L;

      @Override
      public Class< ? > getColumnClass( int columnIndex ) {
        return getValueAt( 0, columnIndex ).getClass();
      }

      @Override
      public boolean isCellEditable( int row, int column ) {
        return column == 4;
      }
    };

    StatusBar sBar = new StatusBar();
    testModel.addTableModelListener( sBar );

    JTable table = new JTable( testModel );
    table.getTableHeader().getColumnModel().getColumn( 1 ).setMinWidth( 200 );

    // Zeilenweise auswählen erlauben / verbieten
    table.setRowSelectionAllowed( true );
    // Spaltenweise auswählen erlauben / verbieten
    table.setColumnSelectionAllowed( true );

    JScrollPane scrollPane = new JScrollPane( table );

    scrollPane.setPreferredSize( new Dimension( 600, 300 ) );
    table.setPreferredSize( new Dimension( 600, 300 ) );
    table.setAutoCreateRowSorter( true );
    root.add( scrollPane, BorderLayout.CENTER );
    root.add( sBar, BorderLayout.SOUTH );

    return root;
  }

  public static JPanel createListDemo() {
    JPanel root = new JPanel();
    root.setLayout( new BorderLayout() );
    root.setBorder(
            BorderFactory.createTitledBorder( BorderFactory.createLineBorder( Color.BLACK, 3 ),
                    "JList", TitledBorder.TOP, TitledBorder.RIGHT ) );
    JPanel panel = new JPanel();
    panel.setBorder( BorderFactory.createTitledBorder( "Accounts" ) );
    panel.setLayout( new GridLayout( 0, 2, 10, 10 ) );

    String[] values = new String[ 20 ];
    for ( int i = 0; i < values.length; ++i ) {
      values[ i ] = "Nutzer" + ( i + 1 );
    }

    DefaultListModel< String > lModel = new DefaultListModel< String >() {
      private static final long serialVersionUID = 6975230295368108113L;

      @Override
      public String getElementAt( int index ) {
        return "Account: " + super.getElementAt( index );
      }
    };

    JList< String > liste = new JList< String >( lModel );
    liste.setVisibleRowCount( 5 );
    for ( String s : values ) {
      lModel.addElement( s );
    }

    JScrollPane scroll = new JScrollPane( liste );

    panel.add( scroll );
    JButton b = new JButton( "Absenden" );
    panel.add( b );

    root.add( panel );
    return root;
  }

  public static void main( String... strings ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        try { // Look and Feel setzen
          UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
        } catch ( ClassNotFoundException e ) {
        } catch ( InstantiationException e ) {
        } catch ( IllegalAccessException e ) {
        } catch ( UnsupportedLookAndFeelException e ) {
        }
        new TabbedPaneDemo();
      }
    } );
  }
}

class StatusBar extends JLabel implements TableModelListener {
  private static final long serialVersionUID = 4224788184365545586L;

  @Override
  public void tableChanged( TableModelEvent e ) {
    DefaultTableModel model = (DefaultTableModel) e.getSource();
    String bez = ( (String) model.getValueAt( e.getFirstRow(), 0 ) ) + " "
            + ( (String) model.getValueAt( e.getFirstRow(), 1 ) ) + ", "
            + ( (String) model.getValueAt( e.getFirstRow(), 2 ) );
    String aktion = "";
    if ( ( (Boolean) model.getValueAt( e.getFirstRow(), 4 ) ) ) {
      aktion = " ist jetzt BS.";
    } else {
      aktion = " ist kein BS mehr.";
    }
    this.setText( bez + aktion );
  }

}
