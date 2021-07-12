package chat.stufe5.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

  public Main() {
    final int MULTICAST_PORT = 666;
    final int PORT = 4444;

    this.createDBTable();

    boolean running = true;
    ChatRoom chat = new ChatRoom();

    try {
      ServerSocket serverSocket = new ServerSocket( PORT );
      serverSocket.setSoTimeout( 1000 );
      BeaconThread beacon = new BeaconThread( PORT, "TestServer", "224.0.11.60", MULTICAST_PORT );
      beacon.start();

      while ( running ) {
        try {
          Socket clientSocket = serverSocket.accept();
          ClientThread clientThread = new ClientThread( chat, clientSocket );
          clientThread.start();
        } catch ( SocketTimeoutException e ) {
          // nichts tun. Bedingung neu prüfen.
        }
      }

      serverSocket.close();
    } catch ( IOException e ) {
      System.err.println( "The Port is not availlable." );
    }
  }

  private void createDBTable() {
    try {
      Class.forName( "org.h2.Driver" );
      Connection adminConn = DriverManager.getConnection( "jdbc:h2:./db/chat", "DBAdmin", "P@ssw0rd" );
      Statement statement = adminConn.createStatement();
      statement.execute(
              "CREATE TABLE IF NOT EXISTS MESSAGES(ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, AUTOR VARCHAR(30), CONTENT VARCHAR(1024))" );
      statement.close();
      adminConn.close();
    } catch ( ClassNotFoundException e1 ) {
      e1.printStackTrace();
    } catch ( SQLException e ) {
      e.printStackTrace();
    }
  }

  public static void main( String... args ) {
    new Main();
  }

}
