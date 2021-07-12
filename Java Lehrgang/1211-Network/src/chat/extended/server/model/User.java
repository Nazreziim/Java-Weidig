package chat.extended.server.model;

public class User {
  private static long counter = 0;

  private final long id;
  private String name;
  private String password;

  User( String name, String password ) {
    this.id = ++User.counter;
    this.name = name;
    this.password = password;
  }

  private long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public boolean checkPassword( String password ) {
    return this.password.equals( password );
  }

  public boolean changePassword( String newPassword ) {
    boolean result = false;
    if ( this.checkPassword( newPassword ) ) {
      this.password = newPassword;
      result = true;
    }
    return result;
  }

  @Override
  public boolean equals( Object other ) {
    boolean result = false;
    if ( other != null && other instanceof User && this.id == ( (User) other ).getId() ) {
      result = true;
    }
    return result;
  }

  @Override
  public int hashCode() {
    return (int) ( this.id >>> 32 ^ this.id );
  }

}
