package ln1wdhlg2017.oop.a2SchachPaketLSG;

public class Turm extends Figur {

  public Turm( char farbe ) {
    super( farbe );
  }

  @Override
  public boolean bedroht( Koordinate ziel ) {
    boolean bedroht = false;
    if ( ziel != null
            && ( this.getPos().getZeile() == ziel.getZeile()
                    && this.getPos().getSpalte() != ziel.getSpalte() )
            || ( this.getPos().getZeile() != ziel.getZeile()
                    && this.getPos().getSpalte() == ziel.getSpalte() ) ) {
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
    return "Turm" + super.toString();
  }

}
