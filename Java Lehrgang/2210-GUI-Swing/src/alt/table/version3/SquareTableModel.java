package alt.table.version3;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class SquareTableModel extends AbstractTableModel {
	public Vector<Long> number = new Vector<Long>();

	public SquareTableModel() {
		for (Long i = new Long(0); i < this.getRowCount(); i++) {
			number.add(i);
		}
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public Object getValueAt(int row, int col) {
		if (col == 0) {
			return number.get(row);
		} else if (col == 1) {
			return (number.get(row) * number.get(row));
		} else {
			return (Math.sin(number.get(row)));
		}
	}
	/*
	 * Ab hier wichtig für Änderbare Tabellen.
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return columnIndex == 0;
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {

		try {
			number.set(rowIndex, Long.parseLong((String) value));
		} catch (NumberFormatException e) {

		}
		// Informieren über Veränderung der Tabelle
		this.fireTableRowsUpdated(rowIndex, rowIndex);
	}

	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		if (column == 0) {
			return "Zahl";
		} else if (column == 1) {
			return "Quadrat";
		} else {
			return "Sinus";
		}
	}
}