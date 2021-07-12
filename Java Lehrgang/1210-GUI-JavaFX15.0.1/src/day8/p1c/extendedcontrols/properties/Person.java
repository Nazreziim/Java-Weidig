package day8.p1c.extendedcontrols.properties;

import java.time.LocalDate;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {

  private static long counter = 1;

  private final long ID;

  private SimpleStringProperty firstNameProperty;
  private SimpleStringProperty familyNameProperty;
  private SimpleStringProperty emailProperty;
  private SimpleObjectProperty< LocalDate > birthdayProperty;
  private SimpleBooleanProperty marriedProperty;

  public Person( String firstName, String familyName, String email, LocalDate birthday, boolean married ) {
    this.ID = Person.counter;
    ++Person.counter;

    this.firstNameProperty = new SimpleStringProperty( this, "firstName" );
    this.firstNameProperty.setValue( firstName );
    this.familyNameProperty = new SimpleStringProperty( this, "familyName" );
    this.familyNameProperty.setValue( familyName );
    this.emailProperty = new SimpleStringProperty( this, "email" );
    this.emailProperty.setValue( email );
    this.birthdayProperty = new SimpleObjectProperty< LocalDate >( this, "birthday" );
    this.birthdayProperty.setValue( birthday );
    this.marriedProperty = new SimpleBooleanProperty( this, "married" );
    this.marriedProperty.setValue( married );
  }

  public SimpleStringProperty firstNameProperty() {
    return this.firstNameProperty;
  }

  public SimpleStringProperty familyNameProperty() {
    return this.familyNameProperty;
  }

  public SimpleStringProperty emailProperty() {
    return this.emailProperty;
  }

  public SimpleObjectProperty< LocalDate > birthdayProperty() {
    return this.birthdayProperty;
  }

  public SimpleBooleanProperty marriedProperty() {
    return this.marriedProperty;
  }

  public long getID() {
    return this.ID;
  }

  public String getFirstName() {
    return this.firstNameProperty.getValue();
  }

  public String getFamilyName() {
    return this.familyNameProperty.getValue();
  }

  public String getEmail() {
    return this.emailProperty.getValue();
  }

  public LocalDate getBirthday() {
    return this.birthdayProperty.getValue();
  }

  public boolean isMarried() {
    return this.marriedProperty.getValue();
  }

  public void setFirstName( String firstName ) {
    this.firstNameProperty.setValue( firstName );
  }

  public void setFamilyName( String familyName ) {
    this.familyNameProperty.setValue( familyName );
  }

  public void setEmail( String email ) {
    this.emailProperty.setValue( email );
  }

  public void setBirthday( LocalDate birthday ) {
    this.birthdayProperty.setValue( birthday );
  }

  public void setMarried( boolean married ) {
    this.marriedProperty.setValue( married );
  }
}
