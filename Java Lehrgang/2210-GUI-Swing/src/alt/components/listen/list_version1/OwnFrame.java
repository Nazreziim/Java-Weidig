package alt.components.listen.list_version1;

import java.awt.*;

import javax.swing.*;

public class OwnFrame extends JFrame {

	public OwnFrame(int x, int y) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.setLayout(new FlowLayout(10));
		String[] listData = { "Shinguz", "Glapum'tianer", "Suffus", "Zypanon",
				"Tschung" };
		
		JList jList = new JList(listData);
		this.add(jList);

		
		//Nutzen eines DefaultListModels zum Aufbau einer Liste
		DefaultListModel listData2 = new DefaultListModel();
		listData2.addElement("Mickey Maus");
		listData2.addElement("Pluto");
		listData2.addElement("Donald Duck");
		listData2.addElement("Dagobert Duck");
		listData2.addElement("Daniel Düsentrieb");
		
		JList jList2 = new JList(listData2);
		this.add(jList2);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		OwnFrame of = new OwnFrame(300, 200);
	}
}