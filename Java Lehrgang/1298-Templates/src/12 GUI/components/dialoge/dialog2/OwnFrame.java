package components.dialoge.dialog2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class OwnFrame extends JFrame {
	OwnDialog dialog;
	JTextArea text;
	
	private class OwnActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			dialog.setModal(true);
			dialog.setVisible(true);
			if(dialog.ok){
				text.setText("Guten Tag "+dialog.getAnrede()+" "+dialog.getVorname()+" "+dialog.getName()+".\nWillkommen in unserem kleinen Programm");
			}
			else{
				text.setText("Sorry, Sie haben abgebrochen");
			}			
		}
	}
	public OwnFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(700,400));
		dialog = new OwnDialog(this);
		
		//Layout später
		this.setLayout(new GridLayout(2,0));
		
		//Erzeugen der Buttons
		JButton button = new JButton("Angaben");
		
		OwnActionListener al = new OwnActionListener();
		//Setzen des Action Listener
		button.addActionListener(al);
		this.add(button);
		
		text = new JTextArea(100,50);
		this.add(text);
		
		//Vergößert Fenster auf benötigten Platz für alle Elemente
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		OwnFrame of = new OwnFrame();
	}
}