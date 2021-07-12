package url_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLReader {
  public static void main( String[] args ) {

    try {
      // URL Objekt erstellen
      URL httpPage = new URL( "http://www.it-training.fus" );
      // Stream holen
      BufferedReader in = new BufferedReader( new InputStreamReader( httpPage.openStream() ) );

      // Content holen
      String inputLine;
      while ( ( inputLine = in.readLine() ) != null ) {
        System.out.println( inputLine );
      }

      // Verbindung schlieﬂen
      in.close();
    } catch ( MalformedURLException e ) {
      System.err.println( "URL ist kaputt" );
    } catch ( IOException e ) {
      System.err.println( e );
    }
  }
}
