package schritt3UebungStack;

public class Mensch implements Comparable< Mensch > {
  private String name;
  private int alter;
  private int groesse;

  public Mensch( String name, int alter, int groesse ) {
    this.setName( name );
    this.setAlter( alter );
    this.setGroesse( groesse );
  }

  public String getName() {
    return this.name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public int getAlter() {
    return this.alter;
  }

  public void setAlter( int alter ) {
    if ( alter >= 0 ) {
      this.alter = alter;
    }
  }

  public int getGroesse() {
    return this.groesse;
  }

  public void setGroesse( int groesse ) {
    this.groesse = groesse;
  }

  @Override
  public String toString() {
    return "Mensch: " + this.name + "\nAlter: " + this.alter + "\nGroesse: " + this.groesse;
  }

  @Override 
  public int compareTo( Mensch other ) { 
    // Nach der Groesse sortieren 
     return this.groesse - other.getGroesse(); 
    // Nach dem Alter sortieren 
//    return this.alter -   other.getAlter(); 
   }

}
