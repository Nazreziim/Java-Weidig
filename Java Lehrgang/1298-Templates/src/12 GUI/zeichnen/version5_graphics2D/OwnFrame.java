package zeichnen.version5_graphics2D;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class OwnFrame extends JFrame {
	
	public OwnFrame(){
		this.setPreferredSize(new Dimension(500, 300));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Setzen in die Mitte des Bildschirms
		//Toolkit ist eine Abstrakte-Klasse, für jedes Betriebssytem gibt es eine Implementierung, die man mit
		//getDefaultToolkit bekommt, darüber Grafikinfos des Systems
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((d.width-this.getSize().width)/2, (d.height-this.getSize().height)/2);
		this.add(new DrawPanel());
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		OwnFrame of = new OwnFrame();
	}
}