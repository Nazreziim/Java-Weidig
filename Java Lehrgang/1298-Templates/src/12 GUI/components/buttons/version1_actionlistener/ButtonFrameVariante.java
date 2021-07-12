package components.buttons.version1_actionlistener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonFrameVariante extends JFrame {
	JButton button1;
	JButton button2;
	public class OwnActionListen implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			 	System.out.println(e.getActionCommand());
				System.out.println(e.getModifiers());
				System.out.println(e.getWhen());
				System.out.println(e.paramString());
		if(e.getActionCommand().equals("PlusRot")){
			
		}
			button1.setEnabled(!button1.isEnabled());
			button2.setEnabled(!button2.isEnabled());
			
			
		}
		
	}
	public ButtonFrameVariante(int x, int y){
		super("OwnFrame");
		
		this.setLayout(new FlowLayout());
		button1 = new JButton("Hiho");
		button1.setEnabled(false);
		this.getContentPane().add(button1);
		button1.addActionListener(new OwnActionListen());
		button1.setMnemonic('H');
		button1.setActionCommand("PlusRot");
		button1.setVerticalAlignment(AbstractButton.TOP);
		
		button2 = new JButton("Moin");
		button2.setEnabled(true);
		this.getContentPane().add(button2);
		OwnActionListen l = new OwnActionListen();
		button2.addActionListener(l);
		
		this.pack();
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		ButtonFrameVariante f = new ButtonFrameVariante(640, 480);
	}
}
