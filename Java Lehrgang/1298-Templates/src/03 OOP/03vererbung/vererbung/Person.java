package vererbung;

public abstract class Person {
  private String vorname;
  private String nachname;

  public Person() {
    this.vorname = "Max";
    this.nachname = "Mustermann";
  }

  public Person( String vorname, String nachname ) {
    this.vorname = vorname;
    this.nachname = nachname;
  }
  
  public abstract void zahlung();
}
