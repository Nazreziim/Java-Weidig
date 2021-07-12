package b1Kapselung.aufgabenLsg;

public class Mitarbeiter {
  private static long anzahl = 0;

  private String vorname;
  private String name;
  private String posten;
  private String eintrittsDatum;
  private double gehalt;
  private final long persNr;

  @Override
  public String toString() {
    String s = vorname + ", " + name + ", " + posten + ", Firmenzugehörig seit " + eintrittsDatum
            + ", Gehalt: " + gehalt;
    return s;
  }

  public Mitarbeiter() {
    this( "", "", "", "", 0.0 );
  }

  public Mitarbeiter( String vorname, String name, double gehalt ) {
    this( vorname, name, "", "", gehalt );
  }

  public Mitarbeiter( String vorname, String name, String posten, String eintrittsDatum,
          double gehalt ) {
    this.vorname = vorname;
    this.name = name;
    this.posten = posten;
    this.eintrittsDatum = eintrittsDatum;
    this.gehalt = gehalt;
    this.persNr = Mitarbeiter.anzahl + 1;
    ++Mitarbeiter.anzahl;
  }

  public long getPersNr() {
    return this.persNr;
  }
}
