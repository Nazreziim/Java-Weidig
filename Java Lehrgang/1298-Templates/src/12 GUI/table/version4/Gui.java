package table.version4;

import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JFrame;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;

	public Gui() {
		mainPanel = new MainPanel();
		this.add(mainPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	public void refresh(Vector<Vector<String>> strings) {
		mainPanel.refresh(strings);
	}

	public void setEventListener(Hashtable<String, ActionListener> eventListener) {
		mainPanel.setEventListener(eventListener);
	}

	public void addModelEventListener(Model model) {
		mainPanel.addModelEventListener(model);

	}

}
