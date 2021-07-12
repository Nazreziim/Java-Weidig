package beispiele.table;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

/**
 * 
 * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 */
public class ExtendedTableDemo extends JFrame {

  public ExtendedTableDemo() {
    this( "" );
  }

  public ExtendedTableDemo( String name ) {
    super( name );
    this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    try { // Look and Feel setzen
      UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
    } catch ( ClassNotFoundException e ) {
    } catch ( InstantiationException e ) {
    } catch ( IllegalAccessException e ) {
    } catch ( UnsupportedLookAndFeelException e ) {
    }

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

    JPanel contentPane = new JPanel();
    contentPane.setBorder( BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder( Color.BLACK, 2, true ), "TestTitel",
            TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION ) );

    TableModel testModel = new ExtendedTableModel( daten, spalten );
    JTable table = new JTable( testModel );

    table.setRowSelectionAllowed( true );
    table.setColumnSelectionAllowed( true );

    table.setFillsViewportHeight( true );
    JScrollPane scrollPane = new JScrollPane( table );

    table.setAutoCreateRowSorter( true );

    contentPane.add( scrollPane );
    this.add( contentPane );
    this.setVisible( true );
    this.pack();
  }

  public static void main( String... strings ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        new ExtendedTableDemo();
      }
    } );
  }
}
