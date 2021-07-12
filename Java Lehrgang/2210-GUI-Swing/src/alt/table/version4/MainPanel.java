package alt.table.version4;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Vector;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private PanelRechts panelLinks;
	private JButton jButton;
	
	public MainPanel(){
		this.setLayout(new BorderLayout());
		panelLinks = new PanelRechts();
		this.add(panelLinks,BorderLayout.CENTER);
		this.jButton = new JButton("add");
		this.add(jButton,BorderLayout.WEST);
	}

	public void refresh(Vector<Vector<String>> strings) {
		panelLinks.refresh(strings);
		
	}

	public void setEventListener(Hashtable<String, ActionListener> eventListener) {
		jButton.addActionListener(eventListener.get("next"));
	}

	public void addModelEventListener(Model model) {
		panelLinks.addModelEventListener(model);
	}
}
