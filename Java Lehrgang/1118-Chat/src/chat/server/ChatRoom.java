package chat.server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import chat.model.Message;

public class ChatRoom {

  private PropertyChangeSupport pcs;

  private List< Message > messages;

  private Set< String > currentUsers;

  public ChatRoom() {
    this.messages = Collections.synchronizedList( new LinkedList<>() );
    this.currentUsers = Collections.synchronizedSet( new TreeSet<>() );
    this.pcs = new PropertyChangeSupport( this );
  }

  public void sendMessage( Message msg ) {
    System.out.println( "ChatRoom: " + msg );
    this.messages.add( msg );
    this.pcs.firePropertyChange( "Messages", null, msg );
  }

  public void addUser( String userName ) {
    if ( this.currentUsers.add( userName ) ) {
      this.pcs.firePropertyChange( "Users", null, userName );
    }
  }

  public void removeUser( String userName ) {
    if ( this.currentUsers.remove( userName ) ) {
      this.pcs.firePropertyChange( "Users", userName, null );
    }
  }

  public List< Message > getMessages() {
    return Collections.unmodifiableList( messages );
  }

  public Set< String > getCurrentUsers() {
    return Collections.unmodifiableSet( this.currentUsers );
  }

  public void addPropertyChangeListener( PropertyChangeListener listener ) {
    this.pcs.addPropertyChangeListener( listener );
  }

  public void removePropertyChangeListener( PropertyChangeListener listener ) {
    this.pcs.removePropertyChangeListener( listener );
  }

  public void addPropertyChangeListenerUsers( PropertyChangeListener listener ) {
    this.pcs.addPropertyChangeListener( "Users", listener );
  }

  public void removePropertyChangeListenerUsers( PropertyChangeListener listener ) {
    this.pcs.removePropertyChangeListener( "Users", listener );
  }

  public void addPropertyChangeListenerMessages( PropertyChangeListener listener ) {
    this.pcs.addPropertyChangeListener( "Messages", listener );
  }

  public void removePropertyChangeListenerMessages( PropertyChangeListener listener ) {
    this.pcs.removePropertyChangeListener( "Messages", listener );
  }

}
