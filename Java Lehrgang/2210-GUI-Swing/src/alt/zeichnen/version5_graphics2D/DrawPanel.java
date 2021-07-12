package alt.zeichnen.version5_graphics2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {

	protected void paintComponent( Graphics g){
		//Der Aufruf von super.paintComponent() ist immer dann angebracht, 
		//wenn die Oberklasse ihre Inhalte zeichnen soll. 
		//Bei vollständig eigenem Inhalt ist das nicht notwendig.

		super.paintComponents(g);		
		
		//Weichzeichnen mit Geometriefiguren
		Graphics2D g2 = (Graphics2D) g; // Damit sind alle 2D-Funktionalitäten da!
		g.setColor(Color.DARK_GRAY);
		
		//1.) Line
		g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); 
		g2.draw( new Line2D.Double( 10.0, 10.0, 400.0,250.0) ); 
		
		 
		 		 
		 /*
		 g.setColor(Color.MAGENTA);
			
		 Point2D p1 = new Point2D.Double(55.5,60.0);
		 Point2D p2 = new Point2D.Double(100.5,300);
		
		 Line2D l = new Line2D.Double(p1,p2);
		 g2.draw(l);
		 */
		 
		 // 2.) Polygone
		 int[] pointsX = {100,100,300,300,400,250,60,80};
		 int[] pointsY = {150,200,320,350,400,250,60,80};
		 Polygon poly = new Polygon(pointsX,pointsY,8);
		 g2.drawPolygon(poly);

		 
		 
		 // 3.) Kreisbögen
		 Shape arc = new Arc2D.Double( 250, 100, 60, 60, 30, 120, Arc2D.PIE );
		 g2.draw(arc);
		 
		 // 4.) Kubische Kurven (Bezier-Kurven) mit zwei Endpkt. & Kontrollpkt.
		 g2.draw(new QuadCurve2D.Double(300 , 150, 400, 200, 300, 300));
		 
		 // 5.) Area mit Addition, Subtraktion, Schnitt, XOR
		 Shape s1 = new Rectangle(250, 350, 150, 100);
		 Shape s2 = new Ellipse2D.Double(270, 370, 250, 150);
		 Area a1 = new Area(s1);
		 Area a2 = new Area(s2);
		 a1.subtract(a2);
		 g2.draw(a1);
		 
		 // 6.) Pfade
		 GeneralPath p = new GeneralPath();
		 p.moveTo( 10f, 200f ); // bewegt den Zeichenstift
		 // gibt auch noch curveTo(), quadTo()
		 p.lineTo( 100f, 200f );// zeichnen einer Linie 
		 g2.setColor( Color.BLACK );
		 g2.draw( p );
		 
		 
		 // 7. ) Strokes	
		 // Wie funktioniert Weichzeichnen?
		 // Pixel in der Umgebung verändern (z.B. in Grau) - dadurch "dickere" Linien, aber ohne Treppeneffekte
		 g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); 
		 g2.setStroke( new BasicStroke( 20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER ) ); 
		 g2.drawLine( 30, 50, 200, 50 );    
		 g2.setStroke( new BasicStroke( 20, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER ) );
		 g2.drawLine( 30, 150, 200, 150 );
		 g2.setStroke( new BasicStroke( 20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER ) ); 
		 g2.drawLine( 30, 100, 200, 100 ); 
		 
		 /* 
		 //Linienverbindungen
		 BasicStroke stroke = new BasicStroke( 20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL ); 
		 g2.setStroke( stroke ); 
		 Path2D shape = new GeneralPath(); 
		 shape.moveTo( 25, 25 ); 
		 shape.lineTo( 50, 100 ); 
		 shape.lineTo( 75, 25 ); 
		 g2.draw( shape );
		 stroke = new BasicStroke( 20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER ); 
		 g2.setStroke( stroke ); 
		 shape = new GeneralPath(); 
		 shape.moveTo( 25+100, 25 ); 
		 shape.lineTo( 50+100, 100 ); 
		 shape.lineTo( 75+100, 25 ); 
		 g2.draw( shape );
		 stroke = new BasicStroke( 20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND );
		 g2.setStroke( stroke );
		 shape = new GeneralPath();
		 shape.moveTo( 25+200, 25 );
		 shape.lineTo( 50+200, 100 ); 
		 shape.lineTo( 75+200, 25 );
		 g2.draw( shape );
		 */
		 
		 // 8.) Affine Transformation 
		 // - Translation - Verschiebung - translate()
		 // - Rotation -  rotate()
		 // - Skalierung - scale()
		 // - Scherung - Verzerrung entlang einer Koord. achse - shear()
		 AffineTransform trans = new AffineTransform();
		 trans.rotate(35, 5.5);
		 g2.setTransform(trans);
		 g2.fill( new Rectangle2D.Float(150, 100, 60,60));
		
		
	}

}
