package components.version5_colorchooser;


import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ListPanel extends JPanel implements Observer{
	// Attribute
	private JList list;
	private DefaultListModel listModel;
	private Model model;
	
	// Listener
	private class ListListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// Model aus dem Frame holen - natürlich gefährlich! 
			Component c = (Component)e.getSource();			
			while ((c = c.getParent()) != null) {
				System.out.println(c.getName());
				if (c instanceof MainFrame) {
					break;
				}
			}
			model = ((MainFrame)c).getModel();
			
			
			String colorText = (String)((JList)e.getSource()).getSelectedValue();			
			if ( !e.getValueIsAdjusting() && colorText != null) {
				if (colorText.equals("RED")){
					model.setRot(Color.RED.getRed());
					model.setGruen(Color.RED.getGreen());
					model.setBlau(Color.RED.getBlue());
				}
				else if (colorText.equals("BLUE")){
					model.setRot(Color.BLUE.getRed());
					model.setGruen(Color.BLUE.getGreen());
					model.setBlau(Color.BLUE.getBlue());
				}
				else if (colorText.equals("LIGHT_GRAY")){
					model.setRot(Color.LIGHT_GRAY.getRed());
					model.setGruen(Color.LIGHT_GRAY.getGreen());
					model.setBlau(Color.LIGHT_GRAY.getBlue());
				}
				else if (colorText.equals("MAGENTA")){
					model.setRot(Color.MAGENTA.getRed());
					model.setGruen(Color.MAGENTA.getGreen());
					model.setBlau(Color.MAGENTA.getBlue());
				}
				else if (colorText.equals("ORANGE")){
					model.setRot(Color.ORANGE.getRed());
					model.setGruen(Color.ORANGE.getGreen());
					model.setBlau(Color.ORANGE.getBlue());
				}
				else if (colorText.equals("PINK")){
					model.setRot(Color.PINK.getRed());
					model.setGruen(Color.PINK.getGreen());
					model.setBlau(Color.PINK.getBlue());
				}
				else if (colorText.equals("CYAN")){
					model.setRot(Color.CYAN.getRed());
					model.setGruen(Color.CYAN.getGreen());
					model.setBlau(Color.CYAN.getBlue());
				}
			}
		}
	}
	
	public ListPanel() {
		//this.model = m;
		//this.model.addObserver(this);

		
		
		// ListModel erstellen
		listModel = new DefaultListModel();
		this.setPreferredSize(new Dimension(200,200));
		this.listModel.addElement("RED");
		this.listModel.addElement("BLUE");
		this.listModel.addElement("LIGHT_GRAY");
		this.listModel.addElement("MAGENTA");
		this.listModel.addElement("ORANGE");
		this.listModel.addElement("PINK");
		this.listModel.addElement("CYAN");
		
	
		// Liste erstellen
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListListener());
		list.setPreferredSize(new Dimension(200,200));
		JScrollPane pane = new JScrollPane(list);
		this.add(pane);
		
		
	}

	// Hilfsmethode um mit GridBagConstraint ein Element zum Container
	// hinzuzufügen
//	private static void addComponent(Container cont, GridBagLayout gbl,
//			Component c, int x, int y, int width, int height, double weightx,
//			double weighty) {
//		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.gridx = x;
//		gbc.gridy = y;
//		gbc.gridwidth = width;
//		gbc.gridheight = height;
//		gbc.weightx = weightx;
//		gbc.weighty = weighty;
//		gbl.setConstraints(c, gbc);
//		cont.add(c);
//	}

	@Override
	public void update(Observable o, Object arg) {
		this.list.clearSelection();
		
	}

}
