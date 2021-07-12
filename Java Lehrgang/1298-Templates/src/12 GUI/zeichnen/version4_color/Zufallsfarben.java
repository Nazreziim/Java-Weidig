package zeichnen.version4_color;


import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Zufallsfarben extends JPanel
{
  
  private static final Random r = new Random();

 protected void paintComponent( Graphics g )
  {
   // super.paintComponent( g );

    for ( int y = 12; y < this.getHeight() - 25; y += 30 )
      for ( int x = 12; x < this.getWidth() - 25; x += 30 )
      {
        g.setColor( new Color( r.nextInt( 256 ), r.nextInt( 256 ), r.nextInt( 256 ) ) );
        g.fillOval(x, y, 25, 25);        
        g.setColor( Color.BLACK );
        g.drawOval( x, y, 25, 25 );
      }
  }

  public static void main( String[] args )
  {
    JFrame f = new JFrame( "Zufallsfarben" );
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 300, 300 );
    f.add( new Zufallsfarben() );
    f.setVisible( true );
  }
}