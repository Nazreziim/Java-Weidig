package chat;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import chat.client.Client;
import chat.client.ServerScreener;
import chat.model.Message;
import chat.model.ServerInformation;
import javafx.collections.ListChangeListener;

public class ClientMain {

  public static void main( String[] args ) throws InterruptedException {

    ServerScreener screener = new ServerScreener( "224.0.11.60", 1002 );

    screener.getServerList().addListener( new ListChangeListener< ServerInformation >() {

      @Override
      public void onChanged( Change< ? extends ServerInformation > change ) {
        System.out.println( "SERVER:-------------------------------------------" );
        for ( ServerInformation si : change.getList() ) {
          System.out.println( si );
        }
        System.out.println( "--------------------------------------------------" );
      }

    } );

    Thread screenerThread = new Thread( screener );
    screenerThread.start();

    TimeUnit.SECONDS.sleep( 2 );

    ServerInformation[] si = (ServerInformation[]) screener.getServerList().toArray( new ServerInformation[ 0 ] );
//    Client client = new Client( "kim", si[ 0 ].getIp(), si[ 0 ].getPort() );
    Client client = new Client( "kim4", "127.0.0.1", si[ 0 ].getPort() );
    client.connect();
    client.getUserList().addListener( new ListChangeListener< String >() {
      @Override
      public void onChanged( Change< ? extends String > change ) {
        System.out.println( "USER:---------------------------------------------" );
        for ( String s : change.getList() ) {
          System.out.println( s );
        }
        System.out.println( "--------------------------------------------------" );
      }
    } );
    client.getMessageList().addListener( new ListChangeListener< Message >() {
      @Override
      public void onChanged( Change< ? extends Message > c ) {
        System.out.println( "MESSAGES:-----------------------------------------" );
        for ( Message m : c.getList() ) {
          System.out.println( m );
        }
        System.out.println( "--------------------------------------------------" );
      }
    } );

    String msg = null;
    Scanner sc = new Scanner( System.in );
    do {

      msg = sc.nextLine();
      client.sendMessage( msg );

    } while ( msg == null || !msg.equals( "BYE" ) );

    client.disconnect();

    screener.stop();

  }

}
