package schritt3UebungStack;

public class Rennschnecke {
  private String name;
  private String rasse;
  private double vMax;
  private double weg;

  public Rennschnecke( String name, String rasse, double vMax ) {
    this.name = name;
    this.rasse = rasse;
    this.vMax = vMax;
    this.weg = 0.0;
  }

  public void krieche() {
    this.weg += Math.random() * this.vMax;
  }

  @Override
  public String toString() {
    return String.format( "Rennschnecke:%n%12s: %s%n%12s: %s%n%12s: %.2f%n%12s: %.2f", "Name",
            this.name, "Rasse", this.rasse, "vMax", this.vMax, "Weg (gesamt)", this.weg );
  }

  public String getName() {
    return this.name;
  }

  public double getWeg() {
    return this.weg;
  }

  @Override
  public boolean equals( Object o ) {
    boolean equal = false;
    if ( o != null && o instanceof Rennschnecke ) {
      equal = this.name.equals( ( (Rennschnecke) o ).getName() );
    }
    return equal;
  }
}
