package aufgabe10;

// Von abstrakten Klassen können keine Objekte angelegt werden.
public abstract class Mensch {

  private String name;
  private int alter;

  public Mensch( String name, int alter ) {
    this.name = name;
    this.alter = alter;
  }

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    if ( name != null ) {
      this.name = name;
    }
  }

  public int getAlter() {
    return alter;
  }

  public void setAlter( int alter ) {
    if ( alter >= 0 && alter <= 150 ) {
      this.alter = alter;
    }
  }

  // In abstrakten Klassen können abstrakte Methoden angelegt werden.
  public abstract void essen();

  @Override
  public String toString() {
    return "Name=" + name + ", Alter=" + alter;
  }

}
