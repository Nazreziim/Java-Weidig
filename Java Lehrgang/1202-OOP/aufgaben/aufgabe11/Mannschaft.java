package aufgabe11;

public class Mannschaft {

  // private Torwart torwart;
  // private Verteidiger[] verteidigung;
  // private Angreifer[] angriff;

  private Spieler[] mannschaft;

  public Mannschaft() {
    this.mannschaft = new Spieler[ 11 ];
    this.mannschaft[ 0 ] = new Torwart();
    for ( int i = 1; i < 5; i++ ) {
      this.mannschaft[ i ] = new Verteidiger();
    }
    for ( int i = 5; i < this.mannschaft.length; i++ ) {
      this.mannschaft[ i ] = new Angreifer();
    }
    // this.torwart = new Torwart();
    //
    // this.verteidigung = new Verteidiger[ 4 ];
    // for ( int i = 0; i < this.verteidigung.length; ++i ) {
    // this.verteidigung[ i ] = new Verteidiger();
    // }
    //
    // this.angriff = new Angreifer[ 6 ];
    // for ( int i = 0; i < this.angriff.length; ++i ) {
    // this.angriff[ i ] = new Angreifer();
    // }
  }

  public void training() {
    for ( Spieler s : this.mannschaft ) {
      s.training();
    }
    // this.torwart.training();
    //
    // for ( int i = 0; i < this.angriff.length; ++i ) {
    // this.angriff[ i ].training();
    // }
    //
    // for ( int i = 0; i < this.verteidigung.length; ++i ) {
    // this.verteidigung[ i ].training();
    // }

  }

}
