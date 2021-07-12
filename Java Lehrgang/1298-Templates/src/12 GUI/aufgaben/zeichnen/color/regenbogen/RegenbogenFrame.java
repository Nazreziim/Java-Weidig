package aufgaben.zeichnen.color.regenbogen;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class RegenbogenFrame extends JFrame {
	
	public RegenbogenFrame(int x, int y){
		this.setTitle("Regenbogen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x, y);
		//Setzen in die Mitte des Bildschirms
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((d.width-this.getSize().width)/2, (d.height-this.getSize().height)/2);
		
		this.add(new RegenbogenPanel(x,y,0));
		this.setVisible(true);
	}

	
	public static void main(String[] args){
		RegenbogenFrame rf = new RegenbogenFrame(1024,768);
	}
}