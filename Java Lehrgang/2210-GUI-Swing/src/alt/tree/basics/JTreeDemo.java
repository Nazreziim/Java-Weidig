package alt.tree.basics;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class JTreeDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Hallo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Wurzel");
		for (int nodeCnt = 0; nodeCnt < 4; nodeCnt++) {
			DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode("Knoten " + nodeCnt);
			root.add(dmtn);

			for (int leafCnt = 1; leafCnt < 4; leafCnt++)
				dmtn.add(new DefaultMutableTreeNode("Blatt " + (nodeCnt * 3 + leafCnt)));
		}

		JTree tree = new JTree(root);
		frame.add(new JScrollPane(tree));
		frame.pack();
		frame.setVisible(true);

		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				TreePath path = e.getNewLeadSelectionPath();
				System.out.println(path);
			}
		});
	}
}
