package grundlagen;

/**
 * 
 * @param <INFOTYP> Infotyp
 * @param <KNOTEN_INFOTYP> Knoteninfotyp
 */
class Kante< INFOTYP, KNOTEN_INFOTYP > {

  private INFOTYP info;
  private int markierung;
  private Knoten< KNOTEN_INFOTYP, INFOTYP > zielKnoten;

  public Kante( INFOTYP info, int markierung, Knoten< KNOTEN_INFOTYP, INFOTYP > zielKnoten ) {
    this.info = info;
    this.markierung = markierung;
    this.zielKnoten = zielKnoten;
  }

  public INFOTYP getInfo() {
    return info;
  }

  public void setInfo( INFOTYP info ) {
    this.info = info;
  }

  public int getMarkierung() {
    return markierung;
  }

  public void setMarkierung( int markierung ) {
    this.markierung = markierung;
  }

  public Knoten< KNOTEN_INFOTYP, INFOTYP > getZielKnoten() {
    return zielKnoten;
  }

  public void setZielKnoten( Knoten< KNOTEN_INFOTYP, INFOTYP > zielKnoten ) {
    this.zielKnoten = zielKnoten;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append( "Kante [info=" );
    builder.append( info );
    builder.append( ", markierung=" );
    builder.append( markierung );
    builder.append( ", zielKnoten=" );
    builder.append( zielKnoten );
    builder.append( "]" );
    return builder.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ( ( info == null ) ? 0 : info.hashCode() );
    result = prime * result + markierung;
    result = prime * result + ( ( zielKnoten == null ) ? 0 : zielKnoten.hashCode() );
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
    Kante other = (Kante) obj;
    if ( info == null ) {
      if ( other.info != null )
        return false;
    } else if ( !info.equals( other.info ) )
      return false;
    if ( markierung != other.markierung )
      return false;
    if ( zielKnoten == null ) {
      if ( other.zielKnoten != null )
        return false;
    } else if ( !zielKnoten.equals( other.zielKnoten ) )
      return false;
    return true;
  }

}
