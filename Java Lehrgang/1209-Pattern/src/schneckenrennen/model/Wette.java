package schneckenrennen.model;

public class Wette {
  private static long counter = 0L;

  private final long id;
  private String spieler;
  private double wettEinsatz;
  private Rennschnecke schnecke;
  private Rennen rennen;
  private double faktor;

  public Wette( Rennen rennen, Rennschnecke schnecke, double wettEinsatz, String spieler ) {
    this.id = ++Wette.counter;
    this.schnecke = schnecke;
    this.wettEinsatz = Math.abs( wettEinsatz );
    this.spieler = spieler.trim();
    this.rennen = rennen;
  }

  public String getSpieler() {
    return this.spieler;
  }

  public double getWettEinsatz() {
    return this.wettEinsatz;
  }

  public Rennschnecke getRennschnecke() {
    return this.schnecke;
  }

  public long getId() {
    return this.id;
  }

  public Rennen getRennen() {
    return this.rennen;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append( "Wette " + this.id + "\n" );
    sb.append( String.format( "%13s: %s%n", "Spieler", this.spieler ) );
    sb.append( String.format( "%13s: %.2f%n", "Wetteinsatz", this.wettEinsatz ) );
    sb.append( String.format( "%13s: %d%n", "Schnecke", this.schnecke.getId() ) );
    return sb.toString();
  }
}
