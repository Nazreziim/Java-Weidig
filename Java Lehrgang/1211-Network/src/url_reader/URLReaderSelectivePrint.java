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

public class URLReaderSelectivePrint {

  public static void main( String[] args ) {
    try {
      // Proxy Adresse anlegen
      SocketAddress proxyAddr = new InetSocketAddress( "172.16.63.250", 3128 );
      // Proxy erstellen
      Proxy proxy = new Proxy( Proxy.Type.HTTP, proxyAddr );

      // URL Objekt mit Zieladresse erstellen
      URL httpPage = new URL( "https://isbndb.com/book/9783426511855" );

      // URL Connection über Proxy holen
      URLConnection connection = httpPage.openConnection( proxy );
      // InputStream öffnen
      BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
      // auslesen
      String inputLine;
      int start = 0;
      int ende = 0;
      final String SUCH_ANFANG = "<td>";
      final String SUCH_ENDE = "</td>";

      while ( ( inputLine = in.readLine() ) != null ) {
        start = 0;
        ende = 0;

        if ( inputLine.contains( "<th>Full Title</th>" ) //
                || inputLine.contains( "<th>ISBN</td>" ) //
                || inputLine.contains( "<th>ISBN13</th>" ) //
                || inputLine.contains( "<th>Publisher</th>" ) //
                || inputLine.contains( "<th>Publish Date</th>" ) //
        ) {
          start = inputLine.lastIndexOf( SUCH_ANFANG );
          if ( start == -1 ) {
            start = inputLine.lastIndexOf( "<th>" );
          }
          ende = inputLine.lastIndexOf( SUCH_ENDE );
          // System.out.println( inputLine );
          System.out.println( inputLine.substring( start + SUCH_ANFANG.length(), ende ) );

        }
      }
      // schließen
      in.close();

    } catch ( MalformedURLException e ) {
      System.err.println( "URL falsch." );
    } catch ( IOException e ) {
      System.err.println( "Ressource nicht verfügbar." );
    }
  }

}
