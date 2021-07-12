package chat.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.Iterator;

import chat.model.ServerInformation;
import chat.server.ServerBeacon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * ServerScreener looks for ServerInformation from ServerBeacons.
 * 
 * @author 11248307
 * @see ServerInformation
 * @see ServerBeacon
 */
public class ServerScreener implements Runnable {

  private int mcPort;
  private String mcAddress;
  private ObservableList< ServerInformation > serverList;

  private boolean running;

  /**
   * Create the ServerScreener with specified multicast IP-Adress and (UDP) Port.
   * 
   * @param mcAddress IP-Adress for multicast
   * @param mcPort UDP-Port for multicast
   */
  public ServerScreener( String mcAddress, int mcPort ) {
    this.mcAddress = mcAddress;
    this.setMcPort( mcPort );
    this.serverList = FXCollections.synchronizedObservableList( FXCollections.observableList( new ArrayList<>() ) );
    this.running = false;
  }

  /**
   * Cycle of the ServerScreener. <br>
   * Start in a Thread(Pool).
   */
  @Override
  public void run() {
    if ( this.running ) {
      throw new IllegalStateException( "ServerScreener already running, or something went wrong." );
    }
    this.running = true;

    // Create multicast Socket
    try ( MulticastSocket mcSocket = new MulticastSocket( this.mcPort ); ) {

      // Join multicast Group
      mcSocket.joinGroup( InetAddress.getByName( this.mcAddress ) );

      // Buffer for received Messages
      byte[] buffer = new byte[ 2048 ];
      DatagramPacket pkg = new DatagramPacket( buffer, buffer.length );

      while ( this.running ) {
        // Receive message
        mcSocket.receive( pkg );
        String udpMessage = new String( buffer );

        try {

          // split message
          String[] udpMessageSplit = udpMessage.trim().split( "_:_" );
          // correct format?
          if ( udpMessageSplit.length == 3 ) {
            String ip = pkg.getAddress().toString().substring( 1 );
            String serverName = udpMessageSplit[ 1 ];
            int port = Integer.parseInt( udpMessageSplit[ 0 ] );
            int userCount = Integer.parseInt( udpMessageSplit[ 2 ] );
            ServerInformation si = new ServerInformation( serverName, ip, port, userCount );
            Iterator< ServerInformation > siIt = this.serverList.iterator();
            boolean found = false;
            while ( siIt.hasNext() && !found ) {
              ServerInformation tmp = siIt.next();
              if ( tmp != null && tmp.equals( si ) ) {
                tmp.setUserCount( userCount );
                found = true;
              }
            }
            if ( !found ) {
              this.serverList.add( si );
            }
          }
        } catch ( NumberFormatException e ) {
          System.err.println( "Port or UserCount not parsable." );
        }
      }

    } catch ( IOException e ) {
      e.printStackTrace();
    }

  }

  /**
   * Stop the serverscreener from looking for server beacons.
   */
  public void stop() {
    this.running = false;
  }

  private void setMcPort( int mcPort ) {
    if ( mcPort < 0 && mcPort > 65535 ) {
      throw new IllegalArgumentException( "Port out of range. (0..65535)" );
    }
    this.mcPort = mcPort;
  }

  /**
   * Returns an observable List of found Servers.
   * 
   * @return observable List of found servers.
   */
  public ObservableList< ServerInformation > getServerList() {
    return this.serverList;
  }

}
