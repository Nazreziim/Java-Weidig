package ln1wdhlg2017.oop.a2SchachPaketLSG;

public class Koordinate {
  private int spalte;
  private int zeile;

  public Koordinate( int zeile, int spalte ) {
    this.setZeile( zeile );
    this.setSpalte( spalte );
  }

  public int getSpalte() {
    return this.spalte;
  }

  public void setSpalte( int spalte ) {
    this.spalte = spalte;
  }

  public int getZeile() {
    return this.zeile;
  }

  public void setZeile( int zeile ) {
    this.zeile = zeile;
  }

  @Override
  public boolean equals( Object o ) {
    boolean equals = false;
    if ( o != null && o instanceof Koordinate ) {
      Koordinate k = (Koordinate) o;
      equals = this.spalte == k.getSpalte() && this.zeile == k.getZeile();
    }
    return equals;
  }
}
