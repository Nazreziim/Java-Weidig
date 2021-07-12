package work.model;

import java.time.LocalDateTime;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class FilterCBStrModel< E > extends DefaultComboBoxModel< String >
        implements
          TableModelListener {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final TreeSet< E > set;
  private final int spaltenIndex;

  public FilterCBStrModel( TreeSet< E > set, int spaltenIndex ) {
    super();
    this.set = set;
    this.spaltenIndex = spaltenIndex;
    convSet2String( set );

    selectFirstElement();

  }

  private void selectFirstElement() {

    if ( this.getSize() > 0 ) {
      this.setSelectedItem( this.getElementAt( 0 ) );
    }
  }

  /**
   * Methode konvertiert den jeweiligen Datentyp
   * in die String mit Formatierung
   * @param set
   */
  private void convSet2String( TreeSet< E > set ) {

    this.removeAllElements();
    int idx = 0;
    String inhalt = null;
    
    System.out.println( "CB set size: " + this.set.size() );
    
    for ( E element : set ) {
      if ( element instanceof LocalDateTime ) {
        LocalDateTime ldt = (LocalDateTime) element;
        inhalt = ldt.format( VerlaufTableModel.getDtf() );
      
      } else {
        inhalt = element.toString();
       
      }
      
      this.insertElementAt( inhalt, idx );
     
      
      System.out.println( "FilterModel: " + element );
      idx++;
    }

  }


  @Override
  public void tableChanged( TableModelEvent e ) {
    System.out.println( "source" + e.getSource() + " erster Zeile: " + e.getFirstRow()
            + " letzte Zeile: " + e.getLastRow() + " spalte:" + spaltenIndex );

    if ( e.getSource() instanceof VerlaufTableModel ) {

      int index0 = e.getFirstRow();
      int index1 = e.getLastRow();

      if ( e.getType() == TableModelEvent.INSERT ) {
        boolean isAdded = false;

        VerlaufTableModel vtm = (VerlaufTableModel) e.getSource();

        for ( int row = index0; row <= index1; row++ ) {
          if ( set.add( (E) vtm.getValueAt( row, spaltenIndex ) ) ) {

            if ( !isAdded ) {
              isAdded = true;
            }
          }
        }

        if ( isAdded ) {
          convSet2String( this.set );
          
          // aktualisiert eigenes Listenfeld
          this.fireIntervalAdded( this, index0, index1 );

          if ( getSelectedItem() == null ) {

            SwingUtilities.invokeLater( new Runnable() {

              @Override
              public void run() {
                // als eigenes Event senden
                // nachdem die TableView aktualisiert wurde!
                selectFirstElement();
              }
            } );
          }

        }

      } else if ( e.getType() == TableModelEvent.DELETE ) {
        // loeschen der Eintraege
        if ( index1 < index0 ) {
          set.clear();
          convSet2String( this.set );
          this.fireIntervalRemoved( this, index0, index1 );
        }
      }

    }

  }

}
