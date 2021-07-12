package work.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

import javax.swing.ComboBoxModel;
import javax.swing.table.AbstractTableModel;

public class VerlaufTableModel extends AbstractTableModel implements PropertyChangeListener {

    public static final int SPALTE_TIME        = 0;
    public static final int SPALTE_OP1         = 1;
    public static final int SPALTE_OPERATION   = 2;
    public static final int SPALTE_OP2         = 3;
    public static final int SPALTE_ERGEBNIS    = 4;
  
    private final Rechner rechner;
    private static final  String[] columns;
	
	private static final  DateTimeFormatter dtf;
	private static final  Class<?>[] classTyp;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
	  dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	  columns = new String[] { "Time", "Op1", "Operation", "Op2", "Ergebnis" };
	  classTyp = new Class<?> [] { LocalDateTime.class, Double.class, Operation.class, Double.class, Double.class};
	}
	
	public VerlaufTableModel(Rechner rechner) {
		this.rechner = rechner;
		this.rechner.addVerlaufListener( this );
		
	}
	
	public static DateTimeFormatter getDtf() {
    return dtf;
  }


  @Override
	public Class<?> getColumnClass(int columnIndex) {
      return classTyp[columnIndex];
	}

	@Override
	public int getRowCount() {
		return rechner.size();
	}

	@Override
	public int getColumnCount() {

		return columns.length;
	}

	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public Object getValueAt(int row, int column) {
		Rechnung rechnung = rechner.get(row);
		Object value = null;
		switch (column) {
		case SPALTE_TIME:
			value = rechnung.getTimestamp();
			break;
		case SPALTE_OP1:
			value = rechnung.getOp1();
			break;
		case SPALTE_OPERATION:
			value = rechnung.getOperation();
			break;
		case SPALTE_OP2:
			value = rechnung.getOp2();
			break;
		case SPALTE_ERGEBNIS:
			value = rechnung.getErg();
			break;
		default:
		}
		return value;
	}

	
	public < T > TreeSet< T > getValues( int spaltenIndexModel ) {
	    TreeSet< T > timeNames = new TreeSet< T >();

	    for ( int i = 0; i < getRowCount(); i++ ) {
	      
	      timeNames.add( (T) getValueAt( i, spaltenIndexModel ) );
	    }
	    return timeNames;
	  }
	
	
	// 
	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (evt.getPropertyName().equals("addVerlauf") && evt.getNewValue() instanceof Rechnung) {
			int zeile = getRowCount() - 1;
			System.out.println("zeile" + zeile);
			this.fireTableRowsInserted(zeile, zeile);
			
		} else if (evt.getPropertyName().equals("clearVerlauf") && evt.getOldValue() instanceof Integer) {

			this.fireTableRowsDeleted(0, (Integer) evt.getOldValue() - 1);
		}
	}

  public  String[] getColumnNames() {
    String[] columnNames = new String[ getColumnCount() ];
    for ( int i = 0; i < columnNames.length; i++ ) {
      columnNames[ i ] = getColumnName( i );
    }
    return columnNames;
  }

}
