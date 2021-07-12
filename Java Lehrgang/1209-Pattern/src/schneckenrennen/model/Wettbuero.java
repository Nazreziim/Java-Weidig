package schneckenrennen.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wettbuero {

  private Map< Rennen, List< Wette > > mapRennenListeWetten;

  public Wettbuero() {
    this.mapRennenListeWetten = new HashMap< Rennen, List< Wette > >();
  }

  public void wetteAnnehmen( Wette w ) {
    if ( !this.mapRennenListeWetten.containsKey( w.getRennen() ) ) {
      this.mapRennenListeWetten.put( w.getRennen(), new ArrayList< Wette >() );
    }
    this.mapRennenListeWetten.get( w.getRennen() ).add( w );
  }

  public void wetteStornieren( Wette w ) {
    if ( this.mapRennenListeWetten.containsKey( w.getRennen() ) ) {
      this.mapRennenListeWetten.get( w.getRennen() ).remove( w );
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append( "Wettbüro:\n" );
    for ( Rennen r : this.mapRennenListeWetten.keySet() ) {
      sb.append( "/--Rennen: " + r.getName() );
      for ( Wette w : this.mapRennenListeWetten.get( r ) ) {
        sb.append( w );
      }
      sb.append( "\\--------" );
    }
    return sb.toString();
  }

}
