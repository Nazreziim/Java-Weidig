package b1Kapselung.aufgabenLsg;

public class PiggyBank {
  private int anzahl1Cents = 0;
  private int anzahl10Cents = 0;
  private int anzahl50Cents = 0;
  private int anzahl1Euros = 0;
  private int maxAnzahl = 0;
  private boolean aufgebrochen = false;

  public void init( int maxAnzahl ) {
    this.anzahl1Cents = 0;
    this.anzahl10Cents = 0;
    this.anzahl50Cents = 0;
    this.anzahl1Euros = 0;
    this.maxAnzahl = maxAnzahl;
    this.aufgebrochen = false;
  }

  public int add1Cents( int anzahl ) {
    int ergebnis = 0;
    if ( this.aufgebrochen ) {
      ergebnis = anzahl;
    } else {
      int coins = this.anzahl1Cents + this.anzahl10Cents + this.anzahl50Cents + this.anzahl1Euros;
      int differenz = this.maxAnzahl - coins;
      if ( anzahl <= differenz ) {
        this.anzahl1Cents += anzahl;
      } else {
        this.anzahl1Cents += differenz;
        ergebnis = anzahl - differenz;
      }
    }
    return ergebnis;
  }

  public int add10Cents( int anzahl ) {
    int ergebnis = 0;
    if ( this.aufgebrochen ) {
      ergebnis = anzahl;
    } else {
      int coins = this.anzahl1Cents + this.anzahl10Cents + this.anzahl50Cents + this.anzahl1Euros;
      int differenz = this.maxAnzahl - coins;
      if ( anzahl <= differenz ) {
        this.anzahl10Cents += anzahl;
      } else {
        this.anzahl10Cents += differenz;
        ergebnis = anzahl - differenz;
      }
    }
    return ergebnis;
  }

  public int add50Cents( int anzahl ) {
    int ergebnis = 0;
    if ( this.aufgebrochen ) {
      ergebnis = anzahl;
    } else {
      int coins = this.anzahl1Cents + this.anzahl10Cents + this.anzahl50Cents + this.anzahl1Euros;
      int differenz = this.maxAnzahl - coins;
      if ( anzahl <= differenz ) {
        this.anzahl50Cents += anzahl;
      } else {
        this.anzahl50Cents += differenz;
        ergebnis = anzahl - differenz;
      }
    }
    return ergebnis;
  }

  public int add1Euro( int anzahl ) {
    int ergebnis = 0;
    if ( this.aufgebrochen ) {
      ergebnis = anzahl;
    } else {
      int coins = this.anzahl1Cents + this.anzahl10Cents + this.anzahl50Cents + this.anzahl1Euros;
      int differenz = this.maxAnzahl - coins;
      if ( anzahl <= differenz ) {
        this.anzahl1Euros += anzahl;
      } else {
        this.anzahl1Euros += differenz;
        ergebnis = anzahl - differenz;
      }
    }
    return ergebnis;
  }

  public boolean isEmpty() {
    return this.anzahl1Cents + this.anzahl10Cents + this.anzahl50Cents + this.anzahl1Euros == 0;
  }

  public boolean isFull() {
    return this.anzahl1Cents + this.anzahl10Cents + this.anzahl50Cents
            + this.anzahl1Euros >= this.maxAnzahl;
  }

  public boolean isBroken() {
    return this.aufgebrochen;
  }

  public int breakPiggy() {
    int ergebnis = this.anzahl1Euros * 100 + this.anzahl50Cents * 50 + this.anzahl10Cents * 10
            + this.anzahl1Cents;
    this.anzahl1Euros = 0;
    this.anzahl1Cents = 0;
    this.anzahl10Cents = 0;
    this.anzahl50Cents = 0;
    this.aufgebrochen = true;
    return ergebnis;
  }

}
