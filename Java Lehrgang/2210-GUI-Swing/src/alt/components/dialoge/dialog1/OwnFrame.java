package alt.components.dialoge.dialog1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class OwnFrame extends JFrame {
	JDialog dialog;
	
	private class OwnActionListener implements ActionListener{
		public JTextArea text;
		
		public void actionPerformed(ActionEvent e) {
			
			dialog.setSize(new Dimension(200,100));
			dialog.add(new JLabel("Dialog"));
			//zeigen Unterschied Modal, nicht Modal
			dialog.setModal(true); // hier welchseln
			dialog.setVisible(true);
			
		}
		
	}
	public OwnFrame(int x, int y){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog = new JDialog(this, "Unser Dialog");
		
		//this.setSize(x, y);
		//Layout später
		this.setLayout(new FlowLayout());
		
		//Erzeugen der Buttons
		JButton button = new JButton("OK");
		//Button zum Frame hinzu
		this.add(button);
		JButton button2 = new JButton("Exit");
		
		this.add(button2);
		OwnActionListener al = new OwnActionListener();
		//Setzen des Action Listener
		button.addActionListener(al);
		button2.addActionListener(al);
		
		//Vergößert Fenster auf benötigten Platz für alle Elemente
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		OwnFrame of = new OwnFrame(100,100);
	}
}