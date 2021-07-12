package chat;

import java.util.Scanner;

import chat.server.Server;

public class ServerMain {

  public static void main( String[] args ) {

    Server chatServer = new Server( "Hsl 103 Chat", 1001, "224.0.11.60", 1002 );
    Thread chatServerThread = new Thread( chatServer );
    chatServerThread.start();

    Scanner sc = new Scanner( System.in );
    sc.nextLine();

    chatServer.stop();

  }

}
