package schritt1OhneGeneric.katze;

public class BoxKatze {
  private Katze inhalt;

  public BoxKatze( Katze inhalt ) {
    this.setInhalt( inhalt );
  }

  public Katze getInhalt() {
    return this.inhalt;
  }

  public void setInhalt( Katze inhalt ) {
    this.inhalt = inhalt;
  }

}
