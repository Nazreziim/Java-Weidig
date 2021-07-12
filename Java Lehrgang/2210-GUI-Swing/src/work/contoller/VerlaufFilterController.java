package work.contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JComboBox;

import work.model.FilterCBStrModel;
import work.model.Operation;
import work.model.Rechner;
import work.model.VerlaufTableModel;
import work.model.filter.AbstractRowFilter;
import work.model.filter.DoubleRowFilter;
import work.model.filter.OperRowFilter;
import work.model.filter.TimeRowFilter;
import work.view.VerlaufDialog;

public class VerlaufFilterController implements ActionListener {

  private FilterCBStrModel< ? > fcbsm;
  private AbstractRowFilter<?> rowFilter;
  private final VerlaufTableModel tableModel;
  private final VerlaufDialog dialogView;
  private final Rechner rechner;
  
  public VerlaufFilterController(VerlaufDialog verlaufDialog, VerlaufTableModel tableModel, Rechner rechner) {
      this.tableModel = tableModel;
      this.dialogView = verlaufDialog;
      this.rechner = rechner;
  }
  
  
  private < T > FilterCBStrModel< ? > getFilterModel( Class< T > typ, String spaltenIdentifier ) {

    int spaltenIndexModel = dialogView.getTableColumnIndex( spaltenIdentifier );

    // Abmeldung des FilterModel vom TableModel
    if ( this.fcbsm != null ) {
      tableModel.removeTableModelListener( this.fcbsm );
    }

    if ( typ == LocalDateTime.class ) {

      this.fcbsm = new FilterCBStrModel< LocalDateTime >(
              tableModel.getValues( spaltenIndexModel ), spaltenIndexModel );

    } else if ( typ == Operation.class ) {

      this.fcbsm = new FilterCBStrModel< Operation >( tableModel.getValues( spaltenIndexModel ),
              spaltenIndexModel );

    } else if ( typ == Double.class ) {

      this.fcbsm = new FilterCBStrModel< Double >( tableModel.getValues( spaltenIndexModel ),
              spaltenIndexModel );

    } else {
      throw new ClassCastException( "Es existiert kein Filter zu dieser Klasse" );
    }

    // Anmeldung des FilterModel an TabelModel
    tableModel.addTableModelListener( this.fcbsm );

    return this.fcbsm;
  }

  
  @Override
  public void actionPerformed( ActionEvent e ) {

    if ( e.getSource() instanceof JComboBox ) {
      
      JComboBox<String> comboBoxStr = (JComboBox<String>) e.getSource();
      
      if ( comboBoxStr.getName().equals( VerlaufDialog.NAME_FILTER_BY_BOX ) ) {

        String spaltenIdentifier = dialogView.getFilterByBoxSelectItem();

        if ( spaltenIdentifier.equals( dialogView.getTableColumnName( VerlaufTableModel.SPALTE_TIME ) ) ) {
          LocalDateTime time = null;

          dialogView.setModelFilterBox( getFilterModel( LocalDateTime.class, spaltenIdentifier ) );

          String inhalt = dialogView.getFilterBoxSelectItem();

          if ( inhalt != null ) {
            time = LocalDateTime.parse( inhalt, VerlaufTableModel.getDtf() );
          }

          this.rowFilter = new TimeRowFilter( time, dialogView.getTableColumnIndex( spaltenIdentifier ) );

        } else if ( spaltenIdentifier
                .equals( dialogView.getTableColumnName( VerlaufTableModel.SPALTE_OPERATION ) ) ) {
          Operation opr = null;

          dialogView.setModelFilterBox( getFilterModel( Operation.class, spaltenIdentifier ) );

          String inhalt = dialogView.getFilterBoxSelectItem();
          if ( inhalt != null ) {
            opr = Operation.valueOf( inhalt );
          }

          this.rowFilter = new OperRowFilter( opr, dialogView.getTableColumnIndex( spaltenIdentifier ) );

        } else {
          Double wert = null;

          dialogView.setModelFilterBox( getFilterModel( Double.class, spaltenIdentifier ) );

          String inhalt = dialogView.getFilterBoxSelectItem();

          if ( inhalt != null ) {
            wert = Double.valueOf( inhalt );
          }

          this.rowFilter = new DoubleRowFilter( wert, dialogView.getTableColumnIndex( spaltenIdentifier ) );
        }

        dialogView.setTableRowFilter( this.rowFilter );

      } else if ( comboBoxStr.getName().equals( VerlaufDialog.NAME_FILTER_BOX ) ) {

        if ( this.rowFilter != null ) {

          String inhalt = dialogView.getFilterBoxSelectItem();

          if ( inhalt != null ) {
            if ( this.rowFilter instanceof OperRowFilter ) {

              OperRowFilter orf = (OperRowFilter) this.rowFilter;
              Operation opr = Operation.valueOf( inhalt );
              orf.setVerglWert( opr );

            } else if ( this.rowFilter instanceof TimeRowFilter ) {

              TimeRowFilter trf = (TimeRowFilter) rowFilter;
              LocalDateTime time = LocalDateTime.parse( inhalt,
                      VerlaufTableModel.getDtf() );
              trf.setVerglWert( time );

            } else if ( this.rowFilter instanceof DoubleRowFilter ) {

              DoubleRowFilter drf = (DoubleRowFilter) this.rowFilter;
              Double wert = Double.valueOf( inhalt );
              drf.setVerglWert( wert );

            }

            dialogView.setTableRowFilter( this.rowFilter );
          }
        }

      }
    }
    else if ( e.getSource() instanceof JButton  ) {
      JButton button = (JButton) e.getSource();
      
      if ( button.getName().equals( VerlaufDialog.NAME_BTN_CLEAR )) {
        
        rechner.clear();
        dialogView.setFilterByDefaultSelect();
      }
    }

  }


}
