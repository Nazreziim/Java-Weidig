package aufgaben.zeichnen.clipping.point_gui;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PointPanel extends JPanel {
	Point p;
	int zaehler=0;
	
	public PointPanel(){			
		this.setBackground(Color.yellow);		
	}
	
	protected void paintComponent(Graphics g){
		/*
			// 1.) Clipping-Region nur auf den (neuen) Punkt
			g.setClip(p.x*10, p.y*10, 10, 10);			
			// Die Riesenkeule: Alles Schwarz!!!
			g.fillRect(0, 0, this.getWidth(),this.getHeight());
			*/
			
			// 2.) Clipping Region auf den Punkt und seine 8 möglichen Nachbarn
			int x = p.x * 10;
			int y = p.y * 10;
			int width = 0;
			int height = 0;
			if (x == 0) {
				width = 20;
			} else {
				x = x - 10;
				width = 30;
			}
			
			if (y == 0) {
				height = y + 20;
			} else {
				y = y - 10;
				height = 30;
			}
			g.setClip(x,y,width,height);
			//Löschen der Clipping-Region
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			g.fillRect(p.x*10, p.y*10, 10, 10);
	}


	public void setPoint(Point p) {
		this.p = p;		
	}




}
