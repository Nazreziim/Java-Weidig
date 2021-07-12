package aufgabe13;

public class Schiff implements Wasserfahrzeug {

  private double gewicht;
  private double tiefgang;

  public Schiff( double gewicht, double tiefgang ) {
    this.tiefgang = tiefgang;
    this.gewicht = gewicht;
  }

  @Override
  public double getGewicht() {
    return this.gewicht;
  }

  @Override
  public double getTiefgang() {
    return this.tiefgang;
  }

}
