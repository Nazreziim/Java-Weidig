package alt.tree.basics;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class JTreeMeinTag extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2627774779785060655L;

	public JTreeMeinTag() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Wurzel");
//
//        DefaultMutableTreeNode letter = new DefaultMutableTreeNode("Buchstaben");
//        DefaultMutableTreeNode letterA = new DefaultMutableTreeNode("A");
//        DefaultMutableTreeNode letterB = new DefaultMutableTreeNode("B");
//        DefaultMutableTreeNode letterC = new DefaultMutableTreeNode("C");
//        letter.add(letterA);
//        letter.add(letterB);
//        letter.add(letterC);
//        DefaultMutableTreeNode digits = new DefaultMutableTreeNode("Zahlen");
//        root.add(letter);
//        root.add(digits);

        OwnTreeModel model = new OwnTreeModel("Mein Tag");
        model.put("Mein Tag", "Aufstehen", "Arbeit", "Schlafen");
        model.put("Aufstehen", "Aufwecken", "Waschen", "Anziehen");
        model.put("Aufwecken");
        model.put("Waschen");
        model.put("Anziehen");

        model.put("Arbeit", "Unterrichten", "Sport", "Org");
        model.put( "Unterrichten");
        model.put("Sport");
        model.put("Org");

        model.put("Schlafen");

        JTree tree = new JTree(model);
        this.add(tree);
        pack();
        setVisible(true);
    }

    private class OwnTreeModel implements TreeModel {

        private Map<String, String[]> values = new HashMap<String, String[]>();
        private String root;

        public OwnTreeModel(String root) {
            this.root = root;
        }

        public Object getRoot() {
            return this.root;
        }

        public Object getChild(Object parent, int index) {
            return this.values.get(parent)[index];
        }

        public int getChildCount(Object parent) {
            System.out.println("Test");
            return this.values.get(parent).length;
        }

        public boolean isLeaf(Object node) {
            return getChildCount(node) == 0;
        }

        public int getIndexOfChild(Object parent, Object child) {
            String[] children = this.values.get(parent);
            int erg = -1;
            for (int i = 0; i < children.length; i++) {
                if (children[i].equals(child)) {
                    erg = i;
                }
            }
            return erg;
        }

        public void valueForPathChanged(TreePath path, Object newValue) {
        }

        public void addTreeModelListener(TreeModelListener l) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void removeTreeModelListener(TreeModelListener l) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void put(String parent, String... children) {
            this.values.put(parent, children);

        }
    }

    public static void main(String[] args) {
        new JTreeMeinTag();
    }
}
