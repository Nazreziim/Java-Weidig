package beispiele.table;

import javax.swing.table.DefaultTableModel;

public class ExtendedTableModel extends DefaultTableModel {

  public ExtendedTableModel() {
    super();
  }

  public ExtendedTableModel( Object[][] values, Object[] header ) {
    super( values, header );
  }

  @Override
  public Class< ? > getColumnClass( int columnIndex ) {
    return getValueAt( 0, columnIndex ).getClass();
  }

  @Override
  public boolean isCellEditable( int row, int column ) {
    return false;
  }

}
