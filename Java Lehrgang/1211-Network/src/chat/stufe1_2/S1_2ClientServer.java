package chat.stufe1_2;

import chat.stufe1_2.client.S1_2Client;
import chat.stufe1_2.server.S1_2Server;

public class S1_2ClientServer {
  public static void main( String... strings ) {
    Thread server = new Thread( new Runnable() {
      @Override
      public void run() {
        new S1_2Server( 80 );
      }
    } );
    server.start();

    Thread client = new Thread( new Runnable() {
      @Override
      public void run() {
        new S1_2Client( "127.0.0.1", 80, "Stufe1_2 Client Server Test" );
      }
    } );
    client.start();
  }
}
