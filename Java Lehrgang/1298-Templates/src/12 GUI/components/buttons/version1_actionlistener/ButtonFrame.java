package components.buttons.version1_actionlistener;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class ButtonFrame extends JFrame {
	private class OwnActionListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			//Unterscheiden über e.getActionCommand() welcher Knopf gedrückt wurde
			if(e.getActionCommand().equals("OK")){
				JOptionPane.showMessageDialog((JButton)e.getSource(), "Ok gedrückt", "Action", JOptionPane.INFORMATION_MESSAGE);
			}
			else{

				System.exit(0);
			}
			
		}
		
	}
	public ButtonFrame(int x, int y){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		ButtonFrame of = new ButtonFrame(100,100);
	}
}