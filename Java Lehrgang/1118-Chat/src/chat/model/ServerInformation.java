package chat.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ServerInformation {

  private SimpleStringProperty serverNameProperty;
  private SimpleStringProperty ipProperty;
  private SimpleIntegerProperty portProperty;
  private SimpleIntegerProperty userCountProperty;

  public ServerInformation( String serverName, String ip, int port, int userCount ) {
    this.serverNameProperty = new SimpleStringProperty( this, "serverName" );
    this.ipProperty = new SimpleStringProperty( this, "ip" );
    this.portProperty = new SimpleIntegerProperty( this, "port" );
    this.userCountProperty = new SimpleIntegerProperty( this, "userCount" );
    this.setServerName( serverName );
    this.setIp( ip );
    this.setUserCount( userCount );
    this.setPort( port );
  }

  public SimpleStringProperty serverNameProperty() {
    return this.serverNameProperty;
  }

  public String getServerName() {
    return this.serverNameProperty.getValueSafe();
  }

  public void setServerName( String serverName ) {
    this.serverNameProperty.setValue( serverName );
  }

  public SimpleStringProperty ipProperty() {
    return this.ipProperty;
  }

  public String getIp() {
    return this.ipProperty.getValueSafe();
  }

  public void setIp( String ipPort ) {
    this.ipProperty.setValue( ipPort );
  }

  public SimpleIntegerProperty portProperty() {
    return this.portProperty;
  }

  public int getPort() {
    return this.portProperty.get();
  }

  public void setPort( int port ) {
    this.portProperty.setValue( port );
  }

  public SimpleIntegerProperty userCountProperty() {
    return this.userCountProperty;
  }

  public int getUserCount() {
    return this.userCountProperty.get();
  }

  public void setUserCount( int user ) {
    this.userCountProperty.setValue( user );
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ( ( ipProperty == null ) ? 0 : ipProperty.get().hashCode() );
    result = prime * result + ( ( portProperty == null ) ? 0 : portProperty.get() );
    result = prime * result + ( ( serverNameProperty == null ) ? 0 : serverNameProperty.get().hashCode() );
    return result;
  }

  @Override
  public boolean equals( Object obj ) {
    if ( this == obj )
      return true;
    if ( obj == null )
      return false;
    if ( getClass() != obj.getClass() )
      return false;
    ServerInformation other = (ServerInformation) obj;
    if ( ipProperty == null ) {
      if ( other.ipProperty != null )
        return false;
    } else if ( !ipProperty.get().equals( other.ipProperty.get() ) )
      return false;
    if ( portProperty == null ) {
      if ( other.portProperty != null )
        return false;
    } else if ( portProperty.get() != other.portProperty.get() )
      return false;
    if ( serverNameProperty == null ) {
      if ( other.serverNameProperty != null )
        return false;
    } else if ( !serverNameProperty.get().equals( other.serverNameProperty.get() ) )
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "ServerInformation [ serverName=" + getServerName() + ", ip=" + getIp() + ", port=" + getPort() + ", userCount="
            + getUserCount() + " ]";
  }

}
