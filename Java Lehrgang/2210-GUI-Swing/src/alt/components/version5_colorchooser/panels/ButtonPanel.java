package alt.components.version5_colorchooser.panels;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import alt.components.version5_colorchooser.models.Model;


/**
 * Dieses Panel enthält Buttons zur Steuerung der Farbanteile und behandelt die durch
 * sie ausgelösten ActionEvents
 * 
 * @author LGerhard
 *
 */
public class ButtonPanel extends JPanel {
	private Model m;
	
	private class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {	
						
			String ac = e.getActionCommand();
			if (ac.equals("redPlus")) {
				m.setRot(m.getRot() + 5);
			} else if(ac.equals("redMinus")) {
				m.setRot(m.getRot() - 5);
			} else if (ac.equals("greenPlus")) {
				m.setGruen(m.getGruen() + 5);
			} else if (ac.equals("greenMinus")) {
				m.setGruen(m.getGruen() - 5);
			}  else if (ac.equals("bluePlus")) {
				m.setBlau(m.getBlau() + 5);
			} else if (ac.equals("blueMinus")) {
				m.setBlau(m.getBlau() - 5);
			}
		}
	}
	
	public ButtonPanel(Model m) {
		this.m = m;
		this.setLayout(new GridLayout(3,	3));
		
		// Buttons
		JButton redPlus = new JButton("+");
		JButton redMinus = new JButton("-");
		JButton greenPlus = new JButton("+");
		JButton greenMinus = new JButton("-");
		JButton bluePlus = new JButton("+");
		JButton blueMinus = new JButton("-");
		
		// ActionCommands
		redPlus.setActionCommand("redPlus");
		redMinus.setActionCommand("redMinus");
		greenPlus.setActionCommand("greenPlus");
		greenMinus.setActionCommand("greenMinus");
		bluePlus.setActionCommand("bluePlus");
		blueMinus.setActionCommand("blueMinus");

		
		// Actionlistener erstellen und an Buttons anhängen
		ButtonActionListener bal = new ButtonActionListener();
		redPlus.addActionListener(bal);
		redMinus.addActionListener(bal);
		greenPlus.addActionListener(bal);
		greenMinus.addActionListener(bal);
		bluePlus.addActionListener(bal);
		blueMinus.addActionListener(bal);
		
		// Panel-Inhalt zusammenstöpseln
		this.add(new JLabel("Rot: "));
		this.add(redPlus);
		this.add(redMinus);
		this.add(new JLabel("Grün: "));
		this.add(greenPlus);
		this.add(greenMinus);
		this.add(new JLabel("Blau: "));
		this.add(bluePlus);
		this.add(blueMinus);
		
	}
	
	
}
