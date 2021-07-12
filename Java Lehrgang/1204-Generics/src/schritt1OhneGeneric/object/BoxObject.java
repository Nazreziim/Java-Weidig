package schritt1OhneGeneric.object;

public class BoxObject {
  private Object inhalt;

  public BoxObject( Object inhalt ) {
    this.setInhalt( inhalt );
  }

  public Object getInhalt() {
    return this.inhalt;
  }

  public void setInhalt( Object inhalt ) {
    this.inhalt = inhalt;
  }
}
