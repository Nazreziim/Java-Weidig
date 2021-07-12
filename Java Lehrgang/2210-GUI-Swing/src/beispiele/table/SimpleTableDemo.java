package beispiele.table;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * 
 * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
 */
public class SimpleTableDemo extends JFrame {
  private static final long serialVersionUID = -6826241731122724606L;

  public SimpleTableDemo() {
    this( "" );
  }

  public SimpleTableDemo( String name ) {
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
    // table.setRowSelectionAllowed( false );
    // Spaltenweise auswählen erlauben / verbieten
    table.setColumnSelectionAllowed( true );
    // table.setColumnSelectionAllowed( false );
    // Zellenweise auswählen erlauben / verbieten
    // table.setCellSelectionEnabled( false );
    // table.setCellSelectionEnabled( true );
    JScrollPane scrollPane = new JScrollPane( table );

    // scrollPane.setBorder( BorderFactory.createDashedBorder( Color.RED, 100, 50 ) );
    scrollPane.setPreferredSize( new Dimension( 600, 300 ) );
    table.setPreferredSize( new Dimension( 600, 300 ) );
    table.setAutoCreateRowSorter( true );
    this.setLayout( new BorderLayout() );
    this.add( scrollPane, BorderLayout.CENTER );
    this.add( sBar, BorderLayout.SOUTH );
    this.setVisible( true );
    this.pack();
  }

}

class StatusBar extends JLabel implements TableModelListener {
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
