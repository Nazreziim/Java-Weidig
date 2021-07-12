package chat.extended.server.model;

import java.util.HashMap;
import java.util.Map;

import chat.extended.server.model.exceptions.UserDuplicationException;

public class UserList {
  private Map< String, User > registeredUsers;

  public UserList() {
    this.registeredUsers = new HashMap< String, User >();
  }

  public boolean containts( String name ) {
    return this.registeredUsers.containsKey( name );
  }

  public User getUser( String name ) {
    return registeredUsers.get( name );
  }

  public User newUser( String name, String password ) throws UserDuplicationException {
    User result = null;
    if ( this.containts( name ) ) {
      throw new UserDuplicationException( name );
    } else {
      result = new User( name, password );
      this.registeredUsers.put( name, result );
    }
    return result;
  }

}
