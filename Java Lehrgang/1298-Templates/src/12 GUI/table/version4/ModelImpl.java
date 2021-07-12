package table.version4;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ModelImpl extends Observable implements Model, TableModel{
	private Vector<Vector<String>> strings;
	private TableModelListener l;
	
	
	public ModelImpl(){
		strings = new Vector<Vector<String>>();
	}

	public void addObserver2(Observer obs) {
		this.addObserver(obs);
	}

	public Vector<Vector<String>> getVector() {
		return strings;
	}

	public void addString(String string1, String string2) {
		Vector<String> eintrag = new Vector<String>();
		eintrag.add(string1);
		eintrag.add(string2);
		strings.add(eintrag);
		setChanged();
		notifyObservers();
		l.tableChanged(new TableModelEvent(this));
	}

	public void addTableModelListener(TableModelListener l) {
		this.l=l;
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return 2;
	}

	public String getColumnName(int columnIndex) {
		String ausgabe="";
		if(columnIndex==0){
			ausgabe="index";
		}else{
			ausgabe="wert";
		}
		return ausgabe;
	}

	public int getRowCount() {
		
		return strings.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return strings.elementAt(rowIndex).elementAt(columnIndex);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

	public void removeTableModelListener(TableModelListener l) {
		//lassen wir aus vereinfachten Gründen weg
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		strings.elementAt(rowIndex).setElementAt((String)(aValue), columnIndex) ;
	}
	
	
}
