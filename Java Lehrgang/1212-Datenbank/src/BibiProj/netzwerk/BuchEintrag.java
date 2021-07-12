package BibiProj.netzwerk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BuchEintrag {
 
  private String titel;
  private String isbn;
  private String isbn13;
  private String publisher;
  private String publish_date;
    
  
  public String getTitel() {
    return titel;
  }


  public String getIsbn() {
    return isbn;
  }


  public String getIsbn13() {
    return isbn13;
  }


  public String getPublisher() {
    return publisher;
  }


  public String getPublish_date() {
    return publish_date;
  }


  public BuchEintrag( InputStream inStr ) {
    super();
    
    String inputLine;
    int start = 0;
    int ende = 0;
    final String SUCH_ANFANG = "<td>";
    final String SUCH_ENDE = "</td>";
    
    try (BufferedReader in = new BufferedReader(
                            new InputStreamReader( inStr) ); ) {
      while ( ( inputLine = in.readLine() ) != null ) {
        start = 0;
        ende = 0;
        
        if ( inputLine.contains( "<th>Full Title</th>" ) ) {
             start = inputLine.lastIndexOf( SUCH_ANFANG );
             if (start == -1) {
               start = inputLine.lastIndexOf( "<th>" );
             }
             ende = inputLine.lastIndexOf( SUCH_ENDE );
            //System.out.println( inputLine );
             
             
             this.titel = inputLine.substring( start + SUCH_ANFANG.length(), ende );         
        }
        else if ( inputLine.contains( "<th>ISBN</td>" ) ) {
                start = inputLine.lastIndexOf( SUCH_ANFANG );
                if (start == -1) {
                  start = inputLine.lastIndexOf( "<th>" );
                }
                ende = inputLine.lastIndexOf( SUCH_ENDE );
               //System.out.println( inputLine );
                                
                this.isbn = inputLine.substring( start + SUCH_ANFANG.length(), ende );         
           }
        else if ( inputLine.contains( "<th>ISBN13</th>" ) ) {
                start = inputLine.lastIndexOf( SUCH_ANFANG );
                if (start == -1) {
                  start = inputLine.lastIndexOf( "<th>" );
                }
                ende = inputLine.lastIndexOf( SUCH_ENDE );
               //System.out.println( inputLine );
                
                
                this.isbn13 = inputLine.substring( start + SUCH_ANFANG.length(), ende );         
           }
        else if ( inputLine.contains( "<th>Publisher</th>" ) ) {
                start = inputLine.lastIndexOf( SUCH_ANFANG );
                if (start == -1) {
                  start = inputLine.lastIndexOf( "<th>" );
                }
                ende = inputLine.lastIndexOf( SUCH_ENDE );
               //System.out.println( inputLine );
                               
                this.publisher = inputLine.substring( start + SUCH_ANFANG.length(), ende );         
           }
        else if ( inputLine.contains( "<th>Publish Date</th>" )) {
                start = inputLine.lastIndexOf( SUCH_ANFANG );
                if (start == -1) {
                  start = inputLine.lastIndexOf( "<th>" );
                }
                ende = inputLine.lastIndexOf( SUCH_ENDE );
               //System.out.println( inputLine );
                
                
                this.publish_date = inputLine.substring( start + SUCH_ANFANG.length(), ende );         
           }
        
        
      }
    } catch ( IOException e ) {
      System.err.println( "Ressource nicht verfügbar." );
    }
 
  }


  @Override
  public String toString() {
    return "BuchEintrag [titel=" + titel + ", isbn=" + isbn + ", isbn13=" + isbn13 + ", publisher="
            + publisher + ", publish_date=" + publish_date + "]";
  }
  
  
}
