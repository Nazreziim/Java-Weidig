package chat.stufe2;

import chat.stufe2.client.S2Client;
import chat.stufe2.server.S2Server;

public class S2ClientServer {
  public static void main( String... strings ) {
    Thread server = new Thread( new Runnable() {
      @Override
      public void run() {
        new S2Server( 80 );
      }
    } );
    server.start();

    Thread client = new Thread( new Runnable() {
      @Override
      public void run() {
        new S2Client( "127.0.0.1", 80, "Stufe1_2 Client Server Test" );
      }
    } );
    client.start();
  }
}
