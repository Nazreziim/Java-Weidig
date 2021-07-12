package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

  private String serverName;
  private int port;
  private SynchBox< Integer > userCount;

  private String mcAddress;
  private int mcPort;

  private boolean running;

  public Server( String serverName, int port, String mcAddress, int mcPort ) {

    this.serverName = serverName;
    this.userCount = new SynchBox<>( 0 );
    this.setPort( port );

    this.mcAddress = mcAddress;
    this.mcPort = mcPort;

    this.running = false;

  }

  @Override
  public void run() {

    if ( this.running ) {
      throw new IllegalStateException( "Server is already running, or something went wrong." );
    }
    this.running = true;

    // Thread Pool of the Server (for Beacon and Clients)
    ExecutorService threadPool = Executors.newCachedThreadPool();

    // UDP Server Beacon Runnable
    ServerBeacon beacon = new ServerBeacon( this.mcAddress, this.mcPort, this.serverName, this.port, this.userCount );
    // UDP Server Beacon execution
    threadPool.execute( beacon );

    // ChatRooms
    List< ChatRoom > chatrooms = new LinkedList<>();
    ChatRoom defaultChatRoom = new ChatRoom();
    chatrooms.add( defaultChatRoom );

    try ( ServerSocket serverSocket = new ServerSocket( port ); ) {

      serverSocket.setSoTimeout( 100 ); // Timeout 100ms

      while ( running ) {

        // Auf eingehende Verbindung warten
        try {
          Socket client = serverSocket.accept(); // Timeout 100ms

          this.userCount.set( this.userCount.get() + 1 );

          System.out.println( "Verbindung zu " + client.getInetAddress() + " hergestellt." );
          ClientRunnable r = new ClientRunnable( client, chatrooms );
          threadPool.execute( r );

        } catch ( SocketTimeoutException e ) {
          // ServerSocket::accept() timeout.
          // Ist notwendig, damit der Thread weiterhin reagieren kann.
        }
      }

    } catch ( IOException e ) {
      e.printStackTrace();
    }

    // Stop Threads
    // beacon Thread
    beacon.stop();
    // Thread Pool
    threadPool.shutdown();

  }

  private void setPort( int port ) {
    if ( port < 0 && port > 65535 ) {
      throw new IllegalArgumentException( "Port out of range. (0..65535)" );
    }
    this.port = port;
  }

  public void stop() {
    this.running = false;
  }

  public int getUserCount() {
    return this.userCount.get();
  }

}
