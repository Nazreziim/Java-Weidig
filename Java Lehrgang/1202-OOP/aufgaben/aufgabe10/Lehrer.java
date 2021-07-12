package aufgabe10;

public class Lehrer extends Mensch {

  private String fach;

  public Lehrer( String name, int alter, String fach ) {
    super( name, alter );
    this.fach = fach;
  }

  public String getFach() {
    return fach;
  }

  public void setFach( String fach ) {
    if ( fach != null ) {
      this.fach = fach;
    }
  }

  @Override
  public String toString() {
    return super.toString() + ", Fach=" + fach;
  }

  @Override
  public void essen() {
    System.out.println( "Lehrerzimmer" );
  }

}
