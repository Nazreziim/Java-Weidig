package day9.p3.chat.view.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

  private SimpleStringProperty nameProperty;
  private SimpleObjectProperty< Role > roleProperty;

  public User( String name, Role role ) {
    this.nameProperty = new SimpleStringProperty( this, "name", name );
    this.roleProperty = new SimpleObjectProperty< Role >( this, "role", role );
  }

  public SimpleStringProperty nameProperty() {
    return this.nameProperty;
  }

  public String getName() {
    return this.nameProperty.getValueSafe();
  }

  public void setName( String name ) {
    this.nameProperty.setValue( name );
  }

  public SimpleObjectProperty< Role > roleProperty() {
    return this.roleProperty;
  }

  public Role getRole() {
    return this.roleProperty.getValue();
  }

  public void setRole( Role role ) {
    this.roleProperty.setValue( role );
  }

  @Override
  public String toString() {
    return "User [ name=" + this.nameProperty.get() + ", role=" + this.roleProperty.get() + " ]";
  }

}
