package ln1wdhlg2017.oop.a3BestellungLSG;

public class Moebel extends Artikel {
  private String farbe;

  public Moebel( String farbe ) {
    this.farbe = farbe;
  }
  
  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " " + this.farbe;
  }



}
