package schritt1OhneGeneric.hund;

public class BoxHund {
  private Hund inhalt;

  public BoxHund( Hund inhalt ) {
    this.setInhalt( inhalt );
  }

  public Hund getInhalt() {
    return this.inhalt;
  }

  public void setInhalt( Hund inhalt ) {
    this.inhalt = inhalt;
  }

}
