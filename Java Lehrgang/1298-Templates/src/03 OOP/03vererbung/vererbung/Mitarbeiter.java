package vererbung;

public class Mitarbeiter extends Person {

  public double gehalt;

  public Mitarbeiter() {
    gehalt = 0.0;
  }

  public Mitarbeiter( String vorname, String nachname ) {
    this( vorname, nachname, 0.0 );
  }

  public Mitarbeiter( String vorname, String nachname, double gehalt ) {
    // this.vorname = vorname;
    // this.nachname = nachname;
    super( vorname, nachname );
    this.gehalt = gehalt;
  }

  @Override
  public void zahlung() {
    // TODO Auto-generated method stub

  }
}
