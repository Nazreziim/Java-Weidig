package chat.stufe3_2.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

  public static void main( String[] args ) {

    if ( args.length == 3 ) {
      String name = args[ 2 ];
      System.out.println( "Hey " + name + " have fun today." );
      try {
        String[] addrStrings = args[ 0 ].split( "\\." );
        byte[] addrBytes = new byte[ 4 ];
        for ( int i = 0; i < 4; ++i ) {
          byte tmp = (byte) Integer.parseInt( addrStrings[ i ] );
          addrBytes[ i ] = tmp;
        }
        InetAddress addr = InetAddress.getByAddress( addrBytes );

        Socket server = new Socket( addr, Integer.parseInt( args[ 1 ] ) );

        Thread inputThread = new ClientInputThread( server );
        Thread outputThread = new ClientOutputThread( server, name );
        inputThread.start();
        outputThread.start();
      } catch ( UnknownHostException e ) {
        System.err.println( "IPv4 address broken." );
      } catch ( NumberFormatException e ) {
        System.err.println( "The Port has to be an Integer." );
      } catch ( IOException e ) {
        System.err.println( "The Server does not respond" );
      }
    } else {
      System.err.println( "Usage: java chat.simple.clientNamed.Main <IP> <Port> <Name>" );
    }

  }

}
