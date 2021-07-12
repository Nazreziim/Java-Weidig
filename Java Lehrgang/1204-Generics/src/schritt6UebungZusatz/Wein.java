package schritt6UebungZusatz;

public class Wein extends Getraenk {
  private String herkunft;

  public String getHerkunft() {
    return herkunft;
  }

  public String toString() {
    return ( "Wein aus " + herkunft );
  }

  public Wein( String origin ) {
    herkunft = origin;
  }
}
