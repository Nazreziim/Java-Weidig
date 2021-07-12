package topfSpiel.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class BeaconThread extends Thread {
  private boolean running;
  private DatagramSocket beaconSocket;
  private DatagramPacket packet;

  public BeaconThread( int serverPort, String serverName, String multicastIP, int multicastPort ) {
    this.running = true;
    try {
      this.beaconSocket = new DatagramSocket();
      byte[] nachricht = ( Integer.toString( serverPort ) + "_" + serverName ).getBytes();
      InetSocketAddress multicastAddr = new InetSocketAddress( multicastIP, multicastPort );
      this.packet = new DatagramPacket( nachricht, nachricht.length, multicastAddr );
    } catch ( SocketException e ) {
      System.err.println( "Socket kann nicht erstellt werden." );
      this.running = false;
    }
  }

  @Override
  public void run() {
    while ( this.running ) {
      try {
        this.beaconSocket.send( this.packet );
        Thread.sleep( 500 );
      } catch ( IOException e ) {
        System.err.println( "Paket konnte nicht gesendet werden." );
      } catch ( InterruptedException e ) {
        System.err.println( "Beacon Thread wurde unterbrochen." );
        this.running = false;
      }
    }
  }

  public void shutdown() {
    this.running = false;
  }

}
