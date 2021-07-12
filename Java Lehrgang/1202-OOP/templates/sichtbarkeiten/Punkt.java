package sichtbarkeiten;

public class Punkt {

  // Attribute / Eigenschaften
  private int x;
  private int y;
  int a;
  public int b;
  protected int c;
  public static int d;

  public Punkt() {
    // Konstruktoraufruf (muss als erstes passieren)
    this( 0, 0 );
  }
  
  // ausdrücklicher Konstruktor
  public Punkt( int x, int y ) {
    this.x = x;
    this.y = y;
  }
  
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
