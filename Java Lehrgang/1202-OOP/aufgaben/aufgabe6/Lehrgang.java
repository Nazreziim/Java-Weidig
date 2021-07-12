package aufgabe6;

public class Lehrgang {

  private final long TRAININGS_ID;
  private final String NAME;

  private int durchgang;
  private int durchlauf;
  private int dauer;
  private String startDatum;
  private String endDatum;

  private int teilnehmer = 0;

  public Lehrgang( long trainingsId, String name, int durchgang, int durchlauf, int dauer, String startDatum, String endDatum ) {
    this.TRAININGS_ID = trainingsId;
    this.NAME = name;
    this.durchgang = durchgang;
    this.durchlauf = durchlauf;
    this.dauer = dauer;
    this.startDatum = startDatum;
    this.endDatum = endDatum;
  }

  @Override
  public String toString() {
    return String.format(
            "Training:%n  ID: %s%n  Name: %s%n  Durchgang: %d%n  Durchlauf: %d%n  Dauer: %d%n  Startdatum: %s%n  Enddatum: %s%n  Teilnehmer: %d",
            this.TRAININGS_ID, this.NAME, this.durchgang, this.durchlauf, this.dauer, this.startDatum, this.endDatum,
            this.teilnehmer );
  }

}
