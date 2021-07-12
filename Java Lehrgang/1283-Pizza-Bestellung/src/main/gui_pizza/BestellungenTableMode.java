/**
 * 
 */
package gui_pizza;

import javax.swing.table.AbstractTableModel;

import pizzaria.Bestellung;
import pizzaria.Bestellung.PARAMETERS;
import pizzaria.Bestellungen;

/**
 * @author user
 *
 */
public class BestellungenTableMode extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Bestellungen mBestellungen = null;

    BestellungenTableMode(String pfad) {
	super();
	mBestellungen = new Bestellungen(pfad);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    @Override
    public int getColumnCount() {
	return Bestellung.ANZAHL_PARAMETER;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.TableModel#getRowCount()
     */
    @Override
    public int getRowCount() {
	return mBestellungen.getCount();
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	return mBestellungen.getBestellung(rowIndex).getParameter(PARAMETERS.ConvertTo(columnIndex));
    }

    public String getColumnName(int column) {
	return PARAMETERS.ConvertTo(column).toString();
    }
}
