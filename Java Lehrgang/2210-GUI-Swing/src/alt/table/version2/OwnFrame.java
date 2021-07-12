package alt.table.version2;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class OwnFrame extends JFrame {

	public OwnFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTable table = new JTable(new SquareTableModel());

		add(new JScrollPane(table));

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		OwnFrame of = new OwnFrame();
	}
}