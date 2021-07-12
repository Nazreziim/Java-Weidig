package topfSpiel;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

import topfSpiel.client.ClientInputThread;
import topfSpiel.client.ClientOutputThread;

public class ClientMain {

  public static void main( String[] args ) {
    final int MULTICAST_PORT = 666;
    boolean connected = false;

    if ( args.length == 1 ) {
      String name = args[ 0 ];
      try {
        MulticastSocket mcSocket = new MulticastSocket( MULTICAST_PORT );
        mcSocket.joinGroup( InetAddress.getByAddress( new byte[]{ (byte) 224, 0, 11, 60 } ) );
        byte[] buff = new byte[ 2048 ];
        DatagramPacket packet;
        String[] infos;
        Socket serverSocket = null;
        while ( !connected ) {
          packet = new DatagramPacket( buff, buff.length );
          mcSocket.receive( packet );
          InetAddress serverAddr = packet.getAddress();
          System.out.println( new String( buff ) );
          infos = new String( buff ).split( "_" );
          System.out.println( "Infos: " + infos[ 0 ] );
          int serverPort = Integer.parseInt( infos[ 0 ] );
          String serverName = infos[ 1 ];
          System.out.println(
                  "Server " + serverName.trim() + " on " + serverAddr.getHostAddress() + ":" + serverPort + " is availlable." );

          serverSocket = new Socket( serverAddr, serverPort );
          if ( serverSocket != null ) {
            connected = true;
          }
        }

        Thread inputThread = new ClientInputThread( serverSocket );
        Thread outputThread = new ClientOutputThread( serverSocket, name );
        inputThread.start();
        outputThread.start();

      } catch ( IOException e1 ) {
        System.err.println( "Multicast Socket kann nicht erstellt werden." );
      } catch ( NumberFormatException e ) {
        System.err.println( "The Port has to be an Integer." );
        e.printStackTrace();
      }
    } else {
      System.err.println( "Usage: java topfSpiel.ClientMain <Name>" );
    }
  }
}
