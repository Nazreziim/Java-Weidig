package aufgabe5;

public class Mitarbeiter {

  private static long counter = 1000;

  private final long PERSONALNUMMER;

  private String vorname;
  private String name;
  private String posten;
  private String eintrittsdatum;
  private double gehalt;

  public Mitarbeiter( String vorname, String name, String posten, String eintrittsdatum, double gehalt ) {
	//final Werte können im Konstruktor einmalig initialisiert werden
    this.PERSONALNUMMER = counter;
    //static Werte können innerhalb der Klasse geändert werden (private)
    ++counter;

    this.vorname = vorname;
    this.name = name;
    this.posten = posten;
    this.eintrittsdatum = eintrittsdatum;
    this.gehalt = gehalt;
  }

  public long getPersonalnummer() {
    return this.PERSONALNUMMER;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return String.format( "%s %s, %s, Eingestellt am %s, Gehalt: %.2f€", this.vorname, this.name, this.posten,
            this.eintrittsdatum, this.gehalt );
  }

}
