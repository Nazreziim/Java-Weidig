package components.version5_colorchooser;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class TabbedPanel extends JPanel implements Observer {
	//Attribute
	private Model m;
	private JCheckBox rot, blau, gruen;
	private JTextArea ta;
	private JScrollPane sp;
	
	private class CheckBoxActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			
			String ac = ((JCheckBox)e.getSource()).getActionCommand();
			if (ac.equals("rotCB")) {
				if (rot.isSelected())
					m.setRot(255);
				else
					m.setRot(0);
			}
			if (ac.equals("blauCB")) {
				if (blau.isSelected())
					m.setBlau(255);
				else
					m.setBlau(0);
			}
			if (ac.equals("gruenCB")) {
				if (gruen.isSelected())
					m.setGruen(255);
				else
					m.setGruen(0);
			}			
		}		
	}
	
	public TabbedPanel(Model m) {
		this.m = m;
		
		JTabbedPane tp = new JTabbedPane();		
		JPanel tab1 = new JPanel();		
		JPanel tab2 = new JPanel();		
		JPanel tab3 = new JPanel();
		
		// Checkboxen erstellen und in ersten Tab legen
		CheckBoxActionListener cbal = new CheckBoxActionListener();

		rot = new JCheckBox("Rot");
		rot.addActionListener(cbal);
		rot.setActionCommand("rotCB");
		gruen = new JCheckBox("Gruen");
		gruen.addActionListener(cbal);
		gruen.setActionCommand("gruenCB");
		blau = new JCheckBox("Blau");
		blau.addActionListener(cbal);
		blau.setActionCommand("blauCB");
		
		tab1.add(rot);
		tab1.add(gruen);
		tab1.add(blau);
		
		// TextArea erstellen und in zweiten Tab legen
		ta = new JTextArea();		
		sp = new JScrollPane(ta);
		sp.setPreferredSize(new Dimension(200,100));

		tab2.add(sp);
		
		
		
		tp.addTab("Tab 1",tab1);
		tp.addTab("Tab 2",tab2);
		tp.addTab("Tab 3",tab3);
		
		this.add(tp);
	}
	@Override
	public void update(Observable o, Object arg) {
		// Update für die Checkboxen
		if (m.getBlau() == 255) {
			blau.setSelected(true);
		} else {
			blau.setSelected(false);
		}		
		if (m.getRot() == 255) {
			rot.setSelected(true);
		} else {
			rot.setSelected(false);
		}		
		if (m.getGruen() == 255) {
			gruen.setSelected(true);
		} else {
			gruen.setSelected(false);
		}
		
		//Update für die TextArea

		ta.append("Rot: " + m.getRot() + " Gruen: " + m.getGruen() + " Blau: "+ m.getBlau() + "\n");
	
		
	}

}
