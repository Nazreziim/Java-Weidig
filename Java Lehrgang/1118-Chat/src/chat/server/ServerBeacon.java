package chat.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;

public class ServerBeacon implements Runnable {

  private String serverName;
  private int port;
  private SynchBox< Integer > userCount;

  private boolean running;
  private InetSocketAddress mcAddress;

  public ServerBeacon( String mcAddress, int mcPort, String serverName, int port, SynchBox< Integer > userCount ) {
    this.serverName = serverName;
    this.port = port;
    this.userCount = userCount;
    this.mcAddress = new InetSocketAddress( mcAddress, mcPort );
    this.running = false;
  }

  @Override
  public void run() {

    if ( this.running ) {
      throw new IllegalStateException( "ServerBeacon already running, or something went wrong." );
    }
    this.running = true;

    try ( DatagramSocket socket = new DatagramSocket(); ) {

      String serverPortName = Integer.toString( this.port ) + "_:_" + this.serverName + "_:_";
      byte[] nachricht = null;
      DatagramPacket p = null;

      while ( this.running ) {

        nachricht = ( serverPortName + Integer.toString( this.userCount.get() ) ).getBytes();
        p = new DatagramPacket( nachricht, nachricht.length, this.mcAddress );
        socket.send( p );
        System.out.println( p );

        TimeUnit.MILLISECONDS.sleep( 500 );

      }

    } catch ( SocketException e ) {
      e.printStackTrace();
    } catch ( IOException e ) {
      e.printStackTrace();
    } catch ( InterruptedException e ) {
      e.printStackTrace();
    }

  }

  public void stop() {
    this.running = false;
  }

}
