package aufgabe13;

public class Auto implements Landfahrzeug {

  private double gewicht;
  private int anzahlRader;

  public Auto( int anzahlRaeder, double gewicht ) {
    this.gewicht = gewicht;
    this.anzahlRader = anzahlRaeder;
  }

  @Override
  public double getGewicht() {
    return this.gewicht;
  }

  @Override
  public int getAnzahlRaeder() {
    return this.anzahlRader;
  }

}
