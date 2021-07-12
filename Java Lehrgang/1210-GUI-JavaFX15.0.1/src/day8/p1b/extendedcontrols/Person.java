package day8.p1b.extendedcontrols;

import java.time.LocalDate;

public class Person {

  private static long counter = 1;

  private final long ID;

  private String vorname;
  private String name;
  private String email;
  private LocalDate gebDatum;
  private boolean verheiratet;

  public Person( String vorname, String name, String email, LocalDate gebDatum, boolean verheiratet ) {
    this.ID = Person.counter;
    ++Person.counter;

    this.vorname = vorname;
    this.name = name;
    this.email = email;
    this.gebDatum = gebDatum;
    this.verheiratet = verheiratet;
  }

  public static long getCounter() {
    return counter;
  }

  public static void setCounter( long counter ) {
    Person.counter = counter;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname( String vorname ) {
    this.vorname = vorname;
  }

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail( String email ) {
    this.email = email;
  }

  public LocalDate getGebDatum() {
    return gebDatum;
  }

  public void setGebDatum( LocalDate gebDatum ) {
    this.gebDatum = gebDatum;
  }

  public boolean isVerheiratet() {
    return verheiratet;
  }

  public void setVerheiratet( boolean verheiratet ) {
    this.verheiratet = verheiratet;
  }

  public long getID() {
    return ID;
  }

}
