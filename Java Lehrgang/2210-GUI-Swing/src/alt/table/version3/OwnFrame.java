package alt.table.version3;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class OwnFrame extends JFrame {

	public class OwnRenderer implements TableCellRenderer {

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			// Label erzeugen
			JLabel label = new JLabel(value.toString());

			// Label undurchsichtig
			label.setOpaque(true);

			// eigener Rahmen
			Border b = BorderFactory.createEmptyBorder(1, 1, 1, 1);
			label.setBorder(b);
			// Schriftart, der für Tabelle festgelegt ist
			label.setFont(table.getFont());

			// Farben einstellen
			label.setForeground(table.getForeground());
			label.setBackground(table.getBackground());

			// Farben setzen für Fokusierte Zellen
			if (hasFocus) {
				label.setBackground(Color.CYAN);
				label.setForeground(Color.white);
			}
			// Farben für selektierte Zellen
			else if (isSelected) {
				label.setBackground(Color.LIGHT_GRAY);
			}

			else {
				if (column == 1) {
					Long val = (Long) value;
					if (val % 2 == 0) {
						label.setBackground(Color.red);
					} else if (val % 3 == 0) {
						label.setBackground(Color.orange);
					} else {
						label.setBackground(Color.green);
					}
				}
			}

			return label;
		}
	}

	public OwnFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTable table = new JTable(new SquareTableModel());
		table.setDefaultRenderer(Object.class, new OwnRenderer());
		add(new JScrollPane(table));

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		OwnFrame of = new OwnFrame();
	}
}