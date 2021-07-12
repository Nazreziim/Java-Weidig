/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package einsortieren.meindatenbankclient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dborkowitz
 */
public class MyModel extends AbstractTableModel {

    Vector<Vector<String>> set;
    Vector<String> columns;

    public MyModel() {
        set = new Vector();
        columns = new Vector<String>();

    }

    public int getRowCount() {
        return set.size();
    }

    public int getColumnCount() {
        return columns.size();
    }

    public void setSet(ResultSet result) throws SQLException {
        set.clear();
        columns.clear();
        for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
            columns.add(result.getMetaData().getColumnName(i));

        }

        this.fireTableStructureChanged();
        initializeEntries(result);
    }

    public void setSet(String spaltenNamen, ResultSet result) throws SQLException {
        set.clear();
        columns.clear();
        columns.add(spaltenNamen);
        this.fireTableStructureChanged();
        initializeEntries(result);
    }

    private void initializeEntries(ResultSet result) throws SQLException {
        while (result.next()) {
            Vector<String> zeile = new Vector<String>();
            for (int i = 1; i <= this.getColumnCount(); i++) {
                zeile.add(result.getString(i));
            }
            this.set.add(zeile);
        }

        this.fireTableDataChanged();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.set.get(rowIndex).get(columnIndex);

    }

    @Override
    public String getColumnName(int column) {
        if (columns.size() == 0) {
            return super.getColumnName(column);
        }
        return columns.get(column);
    }

    public void clear() {
        this.columns.clear();
        this.set.clear();
        this.fireTableStructureChanged();
        this.fireTableDataChanged();
    }
}
