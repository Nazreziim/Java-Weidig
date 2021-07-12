package chat.stufe1;

import chat.stufe1.client.S1Client;
import chat.stufe1.server.S1Server;

public class S1ClientServer {

  public static void main( String[] args ) {
    Thread server = new Thread( new Runnable() {
      @Override
      public void run() {
        new S1Server( 80 );
      }
    } );
    server.start();

    try {
      Thread.sleep( 100 );
    } catch ( InterruptedException e ) {
    }

    Thread client = new Thread( new Runnable() {
      @Override
      public void run() {
        new S1Client( "127.0.0.1", 80, "Testnachricht" );
      }
    } );
    client.start();

  }

}
