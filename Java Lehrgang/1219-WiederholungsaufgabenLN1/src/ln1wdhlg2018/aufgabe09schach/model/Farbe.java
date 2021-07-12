package ln1wdhlg2018.aufgabe09schach.model;

public enum Farbe {

  WEISS( "weiss", 'w' ), SCHWARZ( "schwarz", 's' );

  private String farbe;
  private char abk;

  private Farbe( String farbe, char abk ) {
    this.farbe = farbe;
    this.abk = abk;
  }

  public char getAbk() {
    return this.abk;
  }

  public String toString() {
    return this.farbe;
  }

}
