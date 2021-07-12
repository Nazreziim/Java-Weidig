package chat.extended.server.model.exceptions;

public class UserDuplicationException extends Exception {

  private static final long serialVersionUID = 6769397777577419047L;

  public UserDuplicationException() {
    super();
  }

  public UserDuplicationException( String name ) {
    super( "A User with name = " + name + " does already exist." );
  }

}
