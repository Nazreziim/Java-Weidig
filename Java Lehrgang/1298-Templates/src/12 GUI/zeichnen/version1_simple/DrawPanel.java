package zeichnen.version1_simple;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {

	protected void paintComponent( Graphics g){
		//Der Aufruf von super.paintComponent() ist immer dann angebracht, 
		//wenn die Oberklasse ihre Inhalte zeichnen soll. 
		//Bei vollständig eigenem Inhalt ist das nicht notwendig.
		super.paintComponents(g);
					
		this.setForeground(new Color(128,0,128));
	    
	    //1.) Zeichnen einer Linie von Punkt (10,10) bis (100,50)
		g.drawLine(10, 10, 100, 50);

		//2.) Zeichnen des Vierecks
		g.drawRect(10,30,10,10);		
		g.fillRect(10,30,10,10);
				
		//3.) 3D-Viereck		
		g.setColor(Color.YELLOW);
		g.draw3DRect(50,50, 50, 50, true);		
		//g.fill3DRect(50,50, 50, 50, true);
		
//		int x =20, y=20, gap=20,w=80,h=80;
//      boolean raised=true;
//      g.setColor(Color.YELLOW);
//      for(int c=0;c<7;c++){
//      	g.draw3DRect(x+c,y+c,w-2*c,h-2*c, raised);
//		    g.draw3DRect(x+c+w+gap,y+c,w-2*c,h-2*c, !raised);
//		    g.fill3DRect(x+c+2*(w+gap),y+c,w-2*c,h-2*c, raised);
//		    g.fill3DRect(x+c+3*(w+gap),y+c,w-2*c,h-2*c,!raised);
//		    
//      }
		
		
		//4.) Zeichnen eines Kreisbogens, der unten rechts offen ist
		g.setColor(new Color(0,0,255));
		g.fillArc(200,200, 50, 50, 0, 270);
		
		//5.) Zeichnen eines Strings
		g.drawString("Hallo Fenster", 200, 400);
		g.setFont(new Font("Serif",Font.BOLD, 14));
		g.drawString("Hallo Serif", 200, 420);
		// Alle Schriftarten im System anzeigen:
		GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		for (Font f : java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
			System.out.println(f.getName());
		}
		// Ausgabe der Breiten der ersten 256 Buchstaben
		int charBreiten[] = g.getFontMetrics(this.getFont()).getWidths();
		for (int i : charBreiten) {
			System.out.println(i);
		}
		g.getFontMetrics(this.getFont()).stringWidth("Hallo"); // Die Breite eines Strings
		// TODO: Übung: String unterstreichen mit einer Methode void drawUnderlinedString(Graphics g, int x, int y, String s)
		 
		//6.)  Ein Polygon zeichnen
		g.setColor(Color.RED);
		int[] pointsX = {100,100,300,300,400,270,100,90};
		int[] pointsY = {150,200,320,350,430,240,100,120};
		//g.drawPolyline(pointsX, pointsY, 8);

		Polygon poly = new Polygon(pointsX,pointsY,8);
		poly.addPoint(30, 180);
		Rectangle bounds = poly.getBounds();
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
		g.drawPolygon(poly);
		// TODO: Übung: Auto zeichnen
		
		 
		 /*
		 g.setColor(Color.MAGENTA);
			
		 Point2D p1 = new Point2D.Double(55.5,60.0);
		 Point2D p2 = new Point2D.Double(100.5,300);
		
		 Line2D l = new Line2D.Double(p1,p2);
		 g2.draw(l);
		 */

	}

}
