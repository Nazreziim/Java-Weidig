package aufgabe10;

public class Klassensprecher extends Schueler {

  private int angepassterFaktor;

  public Klassensprecher( String name, int alter, int klassenstufe, int angepassterFaktor ) {
    super( name, alter, klassenstufe );
    this.angepassterFaktor = angepassterFaktor;
  }

  public void setAngepassterFaktor( int angepassterFaktor ) {
    if ( angepassterFaktor >= 3 && angepassterFaktor <= 4 ) {
      this.angepassterFaktor = angepassterFaktor;
    }
  }

  @Override
  public double getBeitrag() {
    return super.getBeitrag() / 5.0 * this.angepassterFaktor;
  }

}
