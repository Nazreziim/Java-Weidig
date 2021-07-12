package wrsv2018schritt1.view;

public enum RSVVZustand {
  MENUE( "Hauptmenü anzeigen." ),
  REGISTRIEREN( "Registrierung einer Rennschnecke starten." ),
  LISTE( "Alle Rennschnecken als Liste darstellen." ),
  BEARBEITEN( "Rennschnecke bearbeiten." ),
  LOESCHEN( "Rennschnecke löschen." ),
  BEENDEN( "Programm beenden" );

  private String beschreibung;

  private RSVVZustand( String beschreibung ) {
    this.beschreibung = beschreibung;
  }

  public String getBeschreibung() {
    return beschreibung;
  }

}
