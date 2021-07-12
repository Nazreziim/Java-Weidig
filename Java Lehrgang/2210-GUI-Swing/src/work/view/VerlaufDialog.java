package work.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.TableRowSorter;

import work.contoller.VerlaufFilterController;
import work.model.Rechner;
import work.model.VerlaufTableModel;

public class VerlaufDialog extends JDialog {

  private static final long serialVersionUID = 1L;

  public static final String NAME_FILTER_BOX = "filterComboBox";
  public static final String NAME_FILTER_BY_BOX = "filterByComboBox";
  public static final String NAME_BTN_CLEAR = "ClearButton";

  private final Rechner rechner;
  private final VerlaufTableModel tableModel;
  private final JTable verlaufTableView;
  private final VerlaufFilterController verlaufController;
  private JComboBox< String > filterByComboBox;
  private JComboBox< String > filterComboBox;
  private JButton clearBtn;
 
 
  public VerlaufDialog( JFrame owner, Rechner rechner ) {
    super( owner );
    this.setLayout( new BorderLayout() );
    this.rechner = rechner;
    this.tableModel = new VerlaufTableModel( this.rechner );
    
    this.verlaufTableView = new JTable( this.tableModel );
    this.verlaufTableView.setDefaultRenderer( LocalDateTime.class, new VerlaufTableCellRenderer() );

    this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );

    this.setTitle( "Minikalkulator Hsl60 Verlauf" );
    Rectangle ownerBounds = owner.getBounds();
    this.setBounds( new Rectangle( (int) ( ownerBounds.getMaxX() + 100 ),
            (int) ( ownerBounds.getMinY() ), 0, 0 ) );
    this.setPreferredSize( new Dimension( 450, 200 ) );

    this.createAnsShowGui();

    this.verlaufController = new VerlaufFilterController( this, tableModel, rechner );
        
    this.filterByComboBox.addActionListener( verlaufController );
    this.filterComboBox.addActionListener( verlaufController );
    this.clearBtn.addActionListener( verlaufController );
    
    // loest Event in Combobox aus.
    this.setFilterByDefaultSelect();
  }

  private void setDefaultColumnWidth() {
      verlaufTableView.getColumn( this.tableModel.getColumnName( VerlaufTableModel.SPALTE_TIME ) ).setPreferredWidth( 130 );
      verlaufTableView.getColumn( this.tableModel.getColumnName( VerlaufTableModel.SPALTE_OP1 ) ).setPreferredWidth( 50 );
      verlaufTableView.getColumn( this.tableModel.getColumnName( VerlaufTableModel.SPALTE_OPERATION ) ).setPreferredWidth(75 );
      verlaufTableView.getColumn( this.tableModel.getColumnName( VerlaufTableModel.SPALTE_OP2 ) ).setPreferredWidth( 50 );
      verlaufTableView.getColumn( this.tableModel.getColumnName( VerlaufTableModel.SPALTE_ERGEBNIS ) ).setPreferredWidth( 75 );
  }
  
  private void createAnsShowGui() {

    verlaufTableView.setAutoCreateRowSorter( true );
    verlaufTableView.setFillsViewportHeight( true );
    verlaufTableView.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
  
    setDefaultColumnWidth();

    
    JScrollPane scrollPane = new JScrollPane( verlaufTableView );
    this.add( scrollPane, BorderLayout.CENTER );

    this.add( this.createActionPanel(), BorderLayout.SOUTH );

    this.pack();
    this.setVisible( true );
    
  }

  public String getTableColumnName( int spalteModel ) {
    // wandelt die Spalte vom Model in die Spalte der View (Tabelle) um und sucht in Spaltenname der
    // Tabelle.
    return this.verlaufTableView
            .getColumnName( this.verlaufTableView.convertColumnIndexToModel( spalteModel ) );
  }

  public int getTableColumnIndex( String columnIdentifer ) {

    return this.verlaufTableView.convertColumnIndexToView(
            this.verlaufTableView.getColumnModel().getColumnIndex( columnIdentifer ) );
  }

  @SuppressWarnings( "unchecked" )
  public void setTableRowFilter(
          RowFilter< ? super VerlaufTableModel, ? super Integer > filter ) {
    ( (TableRowSorter< VerlaufTableModel >) verlaufTableView.getRowSorter() )
            .setRowFilter( filter );
  }
  
  
  private JPanel createActionPanel() {
    JPanel panel = new JPanel( new FlowLayout( FlowLayout.LEFT ) );

    panel.setBorder( BorderFactory.createEmptyBorder( 10, 5, 10, 5 ) );

    this.clearBtn = new JButton( "Clear" );
    this.clearBtn.setName( NAME_BTN_CLEAR );
    this.clearBtn.setPreferredSize( new Dimension( 70, 20 ) );

    panel.add( this.clearBtn );

    JLabel filterByLabel = new JLabel( "Filtern nach :" );
    this.filterByComboBox = new JComboBox< String >( this.tableModel.getColumnNames() );
    this.filterByComboBox.setName( NAME_FILTER_BY_BOX );

    JLabel filterLabel = new JLabel( " >= " );
    this.filterComboBox = new JComboBox< String >();
    this.filterComboBox.setName( NAME_FILTER_BOX );

    this.filterByComboBox.setPreferredSize( new Dimension( 100, 20 ) );
    this.filterComboBox.setPreferredSize( new Dimension( 120, 20 ) );

    panel.add( filterByLabel );
    panel.add( this.filterByComboBox );
    panel.add( filterLabel );
    panel.add( this.filterComboBox );

    return panel;
  }

  
  public void setModelFilterBox(ComboBoxModel<String> model) {
    filterComboBox.setModel( model );
  }
  
  public String getFilterBoxSelectItem() {
    return (String) filterComboBox.getSelectedItem();
  }

  public String getFilterByBoxSelectItem() {
    return (String) filterByComboBox.getSelectedItem();
  }

  public void setFilterByDefaultSelect() {
    filterByComboBox.setSelectedIndex( 0 );
  }
}
