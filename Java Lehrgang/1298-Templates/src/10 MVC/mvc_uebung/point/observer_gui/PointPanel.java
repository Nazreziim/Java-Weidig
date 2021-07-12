package mvc_uebung.point.observer_gui;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PointPanel extends JPanel {
	Point p;
	
	public PointPanel(){			
		this.setBackground(Color.yellow);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);		
		
		g.fillRect(p.x*10, p.y*10, 5, 5);		
	}


	public void setPoint(Point p) {
		this.p = p;		
	}




}
