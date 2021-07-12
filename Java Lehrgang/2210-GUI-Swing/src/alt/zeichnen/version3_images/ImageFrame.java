package alt.zeichnen.version3_images;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class ImageFrame extends JFrame {

	public ImageFrame(int x, int y){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x, y);
		//Setzen in die Mitte des Bildschirms
		//Toolkit ist eine Abstrakte-Klasse, f�r jedes Betriebssytem gibt es eine Implementierung, die man mit
		//getDefaultToolkit bekommt, dar�ber Grafikinfos des Systems
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((d.width-this.getSize().width)/2, (d.height-this.getSize().height)/2);
		this.add(new ImagePanel());
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		ImageFrame of = new ImageFrame(640,480);
	}

}
