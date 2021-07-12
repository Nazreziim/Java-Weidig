package alt.tree.basics;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class JTreeWithModel {

	public static void main(String[] args) {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(12, 13));
		points.add(new Point(2, 123));
		points.add(new Point(23, 13));
		JTree tree = new JTree(new PointModel(points));

		JFrame frame = new JFrame("Hallo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Wurzel");
		for (int nodeCnt = 0; nodeCnt < 4; nodeCnt++) {
			DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode("Knoten " + nodeCnt);
			root.add(dmtn);
			for (int leafCnt = 1; leafCnt < 4; leafCnt++)
				dmtn.add(new DefaultMutableTreeNode("Blatt " + (nodeCnt * 3 + leafCnt)));
		}

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