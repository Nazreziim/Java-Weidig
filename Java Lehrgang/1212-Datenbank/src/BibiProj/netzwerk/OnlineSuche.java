package BibiProj.netzwerk;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

public class OnlineSuche {

  private BuchEintrag buchEintrag;

  public OnlineSuche( String isbn ) {
    super();
    
    try {
      // Proxy Adresse anlegen
      SocketAddress proxyAddr = new InetSocketAddress( "172.16.63.250", 3128 );
      // Proxy erstellen
      Proxy proxy = new Proxy( Proxy.Type.HTTP, proxyAddr );

      // URL Objekt mit Zieladresse erstellen
       URL httpPage = new URL( String.format("https://isbndb.com/book/%s", isbn));
      
      // URL Connection �ber Proxy holen
      URLConnection connection = httpPage.openConnection( proxy );
      // InputStream �ffnen
      this.buchEintrag = new BuchEintrag( connection.getInputStream() );

    } catch ( MalformedURLException e ) {
      System.err.println( "URL falsch." );
    } catch ( IOException e ) {
      System.err.println( "Ressource nicht verf�gbar." );
    }
  }

  public BuchEintrag getBuchEintrag() {
    return buchEintrag;
  }
    
}
