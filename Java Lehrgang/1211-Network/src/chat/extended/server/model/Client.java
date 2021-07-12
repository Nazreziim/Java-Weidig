package chat.extended.server.model;

import java.net.Socket;

public class Client {

  private Thread clientThread;
  private Socket clientSocket;

  public Client( Socket clientSocket ) {
    this.clientSocket = clientSocket;
    this.clientThread = new Thread( new Runnable() {
      @Override
      public void run() {
        // TODO Client Begrüßen
        // Mit Client Arbeiten
        // Wenn Verbindung geschlossen wurde, Client aus der Liste nehmen
        // Thread beenden
      }
    } );
    this.clientThread.start();
  }

  public void close() {
    // TODO Thread beenden und Socket schließen.
  }

}
