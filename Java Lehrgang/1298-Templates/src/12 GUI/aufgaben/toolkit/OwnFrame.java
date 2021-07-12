package aufgaben.toolkit;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class OwnFrame extends JFrame {
	
	public OwnFrame(int x, int y){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(x, y);
		
		//Setzen in die Mitte des Bildschirms:
		//Toolkit ist eine Abstrakte-Klasse, für jedes Betriebssytem gibt es eine Implementierung, die man mit
		//getDefaultToolkit bekommt, darüber Grafikinfos des Systems
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((d.width-this.getSize().width)/2, (d.height-this.getSize().height)/2);
		this.add(new OwnPanel());
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		OwnFrame of = new OwnFrame(300,200);
	}
}