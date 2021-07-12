package ln1wdhlg2018.aufgabe09schach.model.koord;

public class Koordinate {
  /**
   * senkrechte Spielfelder = Linien
   */
  private char linie;
  /**
   * waagerechte Spielfelder = Reihen
   */
  private int reihe;

  public Koordinate( int reihe, char linie ) {
    this.reihe = reihe;
    this.linie = linie;
  }

  public char getLinie() {
    return this.linie;
  }

  public int getReihe() {
    return this.reihe;
  }

  public String toString() {
    return "(" + this.reihe + "|" + this.linie + ")";
  }

  public static int koordChar2Int( char koord ) {
    return koord - 'A' + 1;
  }

  public static int koordInt2Char( int koord ) {
    return koord + 'A' - 1;
  }
}
