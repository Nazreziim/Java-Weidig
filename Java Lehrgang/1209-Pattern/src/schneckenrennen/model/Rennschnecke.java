package schneckenrennen.model;

/**
 * 
 * @author kmoench
 *
 */
public class Rennschnecke {
  private static long counter = 0;

  private final long id;
  private String name;
  private String rasse;
  private double vMax;

  public Rennschnecke( String name, String rasse, double vMax ) {
    this.id = ++Rennschnecke.counter;
    this.name = name;
    this.rasse = rasse;
    this.vMax = vMax;
  }

  /**
   * Weg in einer Zeiteinheit zurücklegen.
   * 
   * @return Weg, welcher in der aktuellen Zeiteinheit zurückgelegt wird.
   */
  public double krieche() {
    return this.vMax * Math.random();
  }

  public String getName() {
    return this.name;
  }

  public long getId() {
    return this.id;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append( "Rennschnecke " + this.id + "\n" );
    sb.append( String.format( "%7s: %s%n", "Name", this.name ) );
    sb.append( String.format( "%7s: %s%n", "Rasse", this.rasse ) );
    sb.append( String.format( "%7s: %.3f%n", "vMax", this.vMax ) );
    return sb.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) ( id ^ ( id >>> 32 ) );
    result = prime * result + ( ( name == null ) ? 0 : name.hashCode() );
    result = prime * result + ( ( rasse == null ) ? 0 : rasse.hashCode() );
    return result;
  }

  @Override
  public boolean equals( Object o ) {
    boolean equal = false;
    if ( o != null && o instanceof Rennschnecke ) {
      equal = this.id == ( (Rennschnecke) o ).getId();
    }
    return equal;
  }

}
