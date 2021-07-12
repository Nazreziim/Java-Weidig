package ln1wdhlg2017.oop.a2SchachPaketLSG;

public class Koenig extends Figur {

  public Koenig( char farbe ) {
    super( farbe );
  }

  @Override
  public boolean bedroht( Koordinate ziel ) {
    boolean bedroht = false;
    if ( ziel != null
            && !( this.getPos().getZeile() == ziel.getZeile()
                    && this.getPos().getSpalte() == ziel.getSpalte() )
            && Math.abs( this.getPos().getZeile() - ziel.getZeile() ) <= 1
            && Math.abs( this.getPos().getSpalte() - ziel.getSpalte() ) <= 1 ) {
      bedroht = true;
    }
    return bedroht;
  }

  @Override
  public ZugListe getZuege() {
    ZugListe liste = new ZugListe();
    for ( int z = 0; z < 8; ++z ) {
      for ( int s = 0; s < 8; ++s ) {
        Koordinate k = new Koordinate( z, s );
        if ( this.bedroht( k ) ) {
          liste.add( k );
        }
      }
    }
    return liste;
  }

  @Override
  public String toString() {
    return "Koenig" + super.toString();
  }

}
