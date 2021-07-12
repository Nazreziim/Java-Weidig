package alt.aufgaben.toolkit;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class OwnPanel extends JPanel {

	public OwnPanel(){
		this.setPreferredSize(new Dimension(640,480));
	}
	protected void paintComponent( Graphics g){
		super.paintComponents(g);
		
	}

}
