package chat.extended.server.model;

import java.util.HashSet;
import java.util.Set;

public class ClientList {

  private Set< Client > clients;

  public ClientList() {
    this.clients = new HashSet< Client >();
  }

  public int getSize() {
    return this.clients.size();
  }

  public boolean contains( Client client ) {
    return this.clients.contains( client );
  }

  public boolean add( Client client ) {
    boolean result = false;
    if ( !this.contains( client ) ) {
      this.clients.add( client );
      result = true;
    }
    return result;
  }

  public boolean remove( Client client ) {
    return this.clients.remove( client );
  }

}
