package alt.events.mouseevents;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CanvasmitMouseEvent extends Canvas implements MouseMotionListener {
  private Color c;
  private Font f;

  // Konstruktordefinition
  public CanvasmitMouseEvent() {
    c = Color.red;
    f = new Font( "Arial", Font.BOLD, 16 );
    addMouseMotionListener( this );
  }

  // Zugriffsmethoden
  public void defFarbe( Color c ) {
    this.c = c;
  }

  public void defSchrift( Font f ) {
    this.f = f;
  }

  // Die Methoden des MouseMotionListener implementieren
  public void mouseDragged( MouseEvent e ) {
    // Den Graphikkontext der Canvas für das Malen mit der Maus
    // ermitteln
    Graphics g = getGraphics();
    g.setFont( f );
    g.setColor( c );
    g.drawString( "Die Farbe ist: " + c.toString(), 0, 0 );
    // Die Koordinaten des Mausklicks mit den Methoden der Klasse
    // MouseEvent lesen und ein Rechteck an dieser Stelle malen
    int x = e.getX();
    int y = e.getY();
    g.fillRect( x, y, 3, 3 );
  }

  public void mouseMoved( MouseEvent e ) {
  };
}
