package url_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

public class URLReaderProxy {
  public static void main( String[] args ) {

    try {
      // Proxy hinzufügen
      SocketAddress proxyAddr = new InetSocketAddress( "172.16.63.250", 3128 );
      Proxy proxy = new Proxy( Proxy.Type.HTTP, proxyAddr );

      // URL Objekt erstellen
      URL httpPage = new URL( "http://www.google.de" );
      // Verbindung über Proxy aufbauen
      URLConnection connection = httpPage.openConnection( proxy );
      // InputStream holen
      BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );

      // Content holen
      String inputLine;
      while ( ( inputLine = in.readLine() ) != null ) {
        System.out.println( inputLine );
      }

      // Verbindung schließen
      in.close();
    } catch ( MalformedURLException e ) {
      System.err.println( "URL ist kaputt" );
    } catch ( IOException e ) {
      System.err.println( e );
    }
  }
}
