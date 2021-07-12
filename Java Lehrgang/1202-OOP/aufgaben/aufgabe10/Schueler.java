package aufgabe10;

public class Schueler extends Mensch {

  private final int faktor = 5;

  private int klassenstufe;

  public Schueler( String name, int alter, int klassenstufe ) {
    super( name, alter );
    this.klassenstufe = klassenstufe;
  }

  public int getKlassenstufe() {
    return klassenstufe;
  }

  public void setKlassenstufe( int klassenstufe ) {
    if ( klassenstufe >= 1 && klassenstufe <= 13 ) {
      this.klassenstufe = klassenstufe;
    }
  }

  public double getBeitrag() {
    return 1.0 * this.getAlter() * this.faktor / this.klassenstufe;
  }

  @Override
  public String toString() {
    return super.toString() + ", Klassenstufe=" + klassenstufe + String.format( ", Beitrag=%.2f€", this.getBeitrag() );
  }

  @Override
  public void essen() {
    System.out.println( "Kantine" );
  }

}
