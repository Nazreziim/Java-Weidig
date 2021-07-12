package alt.zeichnen.version1_simple;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DrawFrame extends JFrame {
	
	public DrawFrame(int x, int y){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x, y);
		//Setzen in die Mitte des Bildschirms
		//Toolkit ist eine Abstrakte-Klasse, für jedes Betriebssytem gibt es eine Implementierung, die man mit
		//getDefaultToolkit bekommt, darüber Grafikinfos des Systems
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((d.width-this.getSize().width)/2, (d.height-this.getSize().height)/2);
		this.add(new DrawPanel());
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		DrawFrame of = new DrawFrame(640,480);
	}
}