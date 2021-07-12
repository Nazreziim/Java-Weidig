package schritt1OhneGeneric.haustier;


public class BoxHaustier {
  private Haustier inhalt;

  public BoxHaustier( Haustier inhalt ) {
    this.setInhalt( inhalt );
  }

  public Haustier getInhalt() {
    return this.inhalt;
  }

  public void setInhalt( Haustier inhalt ) {
    this.inhalt = inhalt;
  }
}
