package table.version2;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame implements TableData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
		setTitle("Beispieltabelle");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JTable table = new JTable(DATA, COLHEADS);
		Container cp = getContentPane();
		cp.add(new JLabel("Alte c\'t-Ausgaben:"), BorderLayout.NORTH);
		cp.add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		Main frame = new Main();
		frame.setLocation(100, 100);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}
