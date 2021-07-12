package components.split_frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class SplitFrame extends JFrame {
	JPanel p1, p2, p3;
	JSplitPane s1, s2;
	
	public SplitFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
		s2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true);
		p1 = new JPanel();
		p1.add(new JLabel("Label1"));
		p2 = new JPanel();
		p2.add(new JLabel("Label2"));
		p3 = new JPanel();
		p3.add(new JLabel("Label3"));
		s1.add(p1);
		s1.add(s2);
		s2.add(p2);
		s2.add(p3);
		this.add(s1);
		
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new SplitFrame();
	

	}

}
