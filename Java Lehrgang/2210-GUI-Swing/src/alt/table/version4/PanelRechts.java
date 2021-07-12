package alt.table.version4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelRechts extends JPanel {

	private static final long serialVersionUID = 1L;
	private Vector<Vector<String>> strings;
	private Font font;
	private JTable jTable;
	private Vector<String> names;

	public PanelRechts() {
		this.setLayout(new BorderLayout());
		strings = new Vector<Vector<String>>();
		names = new Vector<String>();
		names.add("Spalte1");
		names.add("Spalte2");

		jTable = new JTable();
		setLayout(new BorderLayout());
		this.add(new JLabel("Meine Tabelle"), BorderLayout.NORTH);
		this.add(new JScrollPane(jTable), BorderLayout.CENTER);

	}

	public void refresh(Vector<Vector<String>> strings) {
		this.strings = strings;

	}

	public void addModelEventListener(Model model) {
		jTable.setModel((ModelImpl) model);

	}

}
