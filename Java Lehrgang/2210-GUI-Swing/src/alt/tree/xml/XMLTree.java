package alt.tree.xml;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class XMLTree {

	public static void main(String[] args) {
		JTree tree = new JTree(new XMLTreeModel("./src/woche0/gui/tree/xml/tree.xml"));
		
		JFrame frame = new JFrame("XML-Dokument");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Wurzel");

		frame.add(new JScrollPane(tree));
		frame.setSize(new Dimension(800,600));
		frame.setVisible(true);
	}
}
