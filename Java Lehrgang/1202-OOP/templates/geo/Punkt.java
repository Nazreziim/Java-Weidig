package geo;

/**
 * Diese Klasse repräsentiert einen Punkt im 2dimensionaen Koordinatensystem.<br>
 * Diese Klasse dient zur Veranschaulichung von Objektorientierung und der 
 * Sichtbarkeit der verschiedenen Inhalte in Verbindung mit der Klasse:
 * {@link PunktTest}
 * 
 * @author Mönch V1
 * @author Weidig V2
 * @see PunktTest
 * @version V2
 *
 */
public class Punkt {

  // Attribute / Eigenschaften
  private int x;
  private int y;
  
  /**
   * nicht privates Attribut --> package sichtbar
   */
  int a;
  
  public int b;
  
  /**
   * protected attribut
   */
  protected int c;
  public static int d;

  public Punkt() {
    // Konstruktoraufruf (muss als erstes passieren)
    this( 0, 0 );
  }

  // ausdrücklicher Konstruktor
  /**
   * Konstruktor mit 2 Koordinaten
   * 
   * @see Punkt
   * 
   * @param x x-Koordinate
   * @param y y-Koordinate
   */
  public Punkt( int x, int y ) {
    this.x = x;
    this.y = y;
  }

  /**
   * Methode mit Rückgabewert.
   * 
   * @return der Rückgabewert.
   */
  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  @Override
  public String toString() {
    return "Punkt(" + this.x + "," + this.y + ")";
  }

}
