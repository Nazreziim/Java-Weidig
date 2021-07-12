package zeichnen.version2_clipping;

import java.awt.*;
import javax.swing.*;

public class ClipDemo extends JPanel
{
	protected void paintComponent_( Graphics g ) 
	{
		//super.paintComponent( g );

		//Graphics gcopy = g.create(); // Zum Zurücksetzen später

		// Clipping auf
		
		g.clipRect( 100, 100, 100, 100 );
		g.setColor( Color.ORANGE );
		g.fillRect( 0, 0, 500, 500 );
		g.setColor( Color.BLACK );
		g.drawOval( 150, 100, 100, 100 );

		// Zweiter Clipping-Bereich
		//System.out.println(g.getClipBounds());
		g.clipRect( 0, 0, 500, 500 ); //Ergebnis-Clipping-Bereich ist die Schnittmenge!
		//System.out.println(g.getClipBounds());
		
		// Mit setClip kann mans wieder größer machen
		//g.setClip(20, 20, 40, 40);
		g.setColor( Color.RED );
		g.drawRect( 20, 20, 500, 500 ); // nur das oben bemalte Viereck wird übermalt

		
		
		// Die ursprüngliche Größe zurücksetzen
    
//		gcopy.setColor( Color.YELLOW);
//		gcopy.fillRect( 50, 50, 20, 50 );
//    
//		gcopy.dispose();
	}

	protected void paintComponent( Graphics g ) 
	{
		super.paintComponent( g );

		Rectangle r = g.getClipBounds();
		System.out.println( r );
    
  
		Polygon p = new Polygon(
			new int[]{200,100,300},
			new int[]{100,300,300}, 3
		);
      
		g.setClip( p );
  
		g.setColor( Color.ORANGE );
		g.fillRect( 0, 0, 500, 500 ); //Nur der oben definierte Clipping-Bereich wird bemalt
	}

	//TODO: Übung: FlyingBall
	public static void main( String args[] )
	{
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize ( 400, 400 );
		f.add( new ClipDemo() );
		f.setVisible( true );
	}
}


