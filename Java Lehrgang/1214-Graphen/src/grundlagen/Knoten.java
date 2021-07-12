package grundlagen;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @param <INFOTYP> Infotyp
 * @param <KANTEN_INFOTYP> Kanteninfotyp
 */
class Knoten< INFOTYP, KANTEN_INFOTYP > {

  private List< Kante< KANTEN_INFOTYP, INFOTYP > > kanten;
  private INFOTYP info;
  private int nummer;
  private int markierung;

  public Knoten( int nummer, INFOTYP info, int markierung ) {
    this.nummer = nummer;
    this.markierung = markierung;
    this.info = info;
    this.kanten = new ArrayList< Kante< KANTEN_INFOTYP, INFOTYP > >();
  }

  public INFOTYP getInfo() {
    return info;
  }

  public void setInfo( INFOTYP info ) {
    this.info = info;
  }

  public int getNummer() {
    return nummer;
  }

  public void setNummer( int nummer ) {
    this.nummer = nummer;
  }

  public int getMarkierung() {
    return markierung;
  }

  public void setMarkierung( int markierung ) {
    this.markierung = markierung;
  }

  public List< Kante< KANTEN_INFOTYP, INFOTYP > > getKanten() {
    return kanten;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append( "Knoten [kanten=" );
    builder.append( kanten );
    builder.append( ", info=" );
    builder.append( info );
    builder.append( ", nummer=" );
    builder.append( nummer );
    builder.append( ", markierung=" );
    builder.append( markierung );
    builder.append( "]" );
    return builder.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ( ( info == null ) ? 0 : info.hashCode() );
    result = prime * result + ( ( kanten == null ) ? 0 : kanten.hashCode() );
    result = prime * result + markierung;
    result = prime * result + nummer;
    return result;
  }

  @Override
  public boolean equals( Object obj ) {
    if ( this == obj )
      return true;
    if ( obj == null )
      return false;
    if ( getClass() != obj.getClass() )
      return false;
    Knoten other = (Knoten) obj;
    if ( info == null ) {
      if ( other.info != null )
        return false;
    } else if ( !info.equals( other.info ) )
      return false;
    if ( kanten == null ) {
      if ( other.kanten != null )
        return false;
    } else if ( !kanten.equals( other.kanten ) )
      return false;
    if ( markierung != other.markierung )
      return false;
    if ( nummer != other.nummer )
      return false;
    return true;
  }

}
