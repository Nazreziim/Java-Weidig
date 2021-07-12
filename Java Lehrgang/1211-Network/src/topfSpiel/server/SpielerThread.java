package topfSpiel.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SpielerThread extends Thread {
  private Socket clientSocket;
  private SpielThread parent;
  private PrintWriter out;
  private boolean running;
  private boolean amZug;

  public SpielerThread( Socket clientSocket, SpielThread parent ) {
    this.clientSocket = clientSocket;
    this.parent = parent;
    try {
      this.out = new PrintWriter( this.clientSocket.getOutputStream(), true );
    } catch ( IOException e ) {
      System.err.println( "No OutputStream from Server: " + this.clientSocket + " availlable." );
    }
    this.running = true;
    this.amZug = false;
  }

  @Override
  public void run() {

    try ( BufferedReader in = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) ); ) {
      String inputLine;
      while ( this.running ) {
        while ( ( inputLine = in.readLine() ) != null ) {
          System.out.println( clientSocket + ": " + inputLine );
          if ( this.amZug ) {
            try {
              int eingabe = Integer.parseInt( inputLine );
              if ( eingabe < 1 || eingabe > 5 ) {
                throw new NumberFormatException();
              } else {
                parent.eingabeSenden( eingabe );
              }
            } catch ( NumberFormatException e ) {
              this.out.println( "Falsche Eingabe." );
            }
          } else {
            this.out.println( "Sie sind nicht am Zug." );
          }
        }
      }
      clientSocket.close();
    } catch ( IOException e ) {
      System.err.println( "No InputStream from Server: " + this.clientSocket + " availlable." );
    }
  }

  public void send( String message ) {
    this.out.println( message );
  }

  public void shutdown() {
    this.running = false;
  }

  public void amZug( boolean b ) {
    this.amZug = b;
  }

}
