package table.version1;

import java.awt.*;

import javax.swing.*;

public class OwnFrame extends JFrame {

	public OwnFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[][] rowData = {{"Japan", "245"}, {"USA", "240"}, {"Italien", "220"}, {"Spanien", "217"}, {"Türkei", "215"}, {"England", "214"},
				{"Frankreich", "190"}, {"Griechenland", "185"}, {"Deutschland", "180"}, {"Portugal", "170"}};
		String[] columnNames = {"Land", "Durchschnittliche Fernsehdauer pro Tag in Minuten"};

		JTable table = new JTable(rowData, columnNames);

		add(new JScrollPane(table));

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		OwnFrame of = new OwnFrame();
	}
}