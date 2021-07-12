package alt.table.version1;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {

		String[][] DATA = {{" 1/1987", "195", "Vergleichstest EGA-Karten"}, {" 2/1987", "171", "Schneider PC: Bewährungsprobe"},
				{" 3/1987", "235", "Luxus-Textsyteme im Vergleich"}, {" 4/1987", "195", "Turbo BASIC"},
				{" 5/1987", "211", "640-K-Grenze durchbrochen"}, {" 6/1987", "211", "Expertensysteme"}, {" 7/1987", "199", "IBM Model 30 im Detail"},
				{" 8/1987", "211", "PAK-68: Tuning für 68000er"}, {" 9/1987", "215", "Desktop Publishing"}, {"10/1987", "279", "2,5 MByte im ST"},
				{"11/1987", "279", "Transputer-Praxis"}, {"12/1987", "271", "Preiswert mit 24 Nadeln"}, {" 1/1988", "247", "Schnelle 386er"},
				{" 2/1988", "231", "Hayes-kompatible Modems"}, {" 3/1988", "295", "TOS/GEM auf 68020"}, {" 4/1988", "263", "Projekt Super-EGA"},
				{" 5/1988", "263", "Neuheiten auf der CeBIT 88"}, {" 6/1988", "231", "9600-Baud-Modem am Postnetz"}};

		String[] COLHEADS = {"Ausgabe", "Seiten", "Titelthema"};

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
