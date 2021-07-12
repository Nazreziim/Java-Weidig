package aufgabe3;

public class PiggyBank {

  private int anzahl1Cent;
  private int anzahl2Cent;
  private int anzahl5Cent;
  private int anzahl10Cent;
  private int anzahl20Cent;
  private int anzahl50Cent;
  private int anzahl1Euro;
  private int anzahl2Euro;

  private int maxAnzahl;
  private boolean gebrochen;

  public void init( int maxAnzahl ) {
    this.maxAnzahl = maxAnzahl;
    this.anzahl1Cent = 0;
    this.anzahl2Cent = 0;
    this.anzahl5Cent = 0;
    this.anzahl10Cent = 0;
    this.anzahl20Cent = 0;
    this.anzahl50Cent = 0;
    this.anzahl1Euro = 0;
    this.anzahl2Euro = 0;
    this.gebrochen = false;
  }

  public int add1Cents( int anzahl ) {
    int rest = 0;
    if ( this.gebrochen || anzahl < 0 ) {
      rest = anzahl;
    } else if ( anzahl < this.platz() ) {
      this.anzahl1Cent += anzahl;
    } else {
      rest = anzahl - this.platz();
      this.anzahl1Cent += anzahl - rest;
    }
    return rest;
  }

  public int add2Cents( int anzahl ) {
    int rest = 0;
    if ( this.gebrochen || anzahl < 0 ) {
      rest = anzahl;
    } else if ( anzahl < this.platz() ) {
      this.anzahl2Cent += anzahl;
    } else {
      rest = anzahl - this.platz();
      this.anzahl2Cent += anzahl - rest;
    }
    return rest;
  }

  public int add5Cents( int anzahl ) {
    int rest = 0;
    if ( this.gebrochen || anzahl < 0 ) {
      rest = anzahl;
    } else if ( anzahl < this.platz() ) {
      this.anzahl5Cent += anzahl;
    } else {
      rest = anzahl - this.platz();
      this.anzahl5Cent += anzahl - rest;
    }
    return rest;
  }

  public int add10Cents( int anzahl ) {
    int rest = 0;
    if ( this.gebrochen || anzahl < 0 ) {
      rest = anzahl;
    } else if ( anzahl < this.platz() ) {
      this.anzahl10Cent += anzahl;
    } else {
      rest = anzahl - this.platz();
      this.anzahl10Cent += anzahl - rest;
    }
    return rest;
  }

  public int add20Cents( int anzahl ) {
    int rest = 0;
    if ( this.gebrochen || anzahl < 0 ) {
      rest = anzahl;
    } else if ( anzahl < this.platz() ) {
      this.anzahl20Cent += anzahl;
    } else {
      rest = anzahl - this.platz();
      this.anzahl20Cent += anzahl - rest;
    }
    return rest;
  }

  public int add50Cents( int anzahl ) {
    int rest = 0;
    if ( this.gebrochen || anzahl < 0 ) {
      rest = anzahl;
    } else if ( anzahl < this.platz() ) {
      this.anzahl50Cent += anzahl;
    } else {
      rest = anzahl - this.platz();
      this.anzahl50Cent += anzahl - rest;
    }
    return rest;
  }

  public int add1Euros( int anzahl ) {
    int rest = 0;
    if ( this.gebrochen || anzahl < 0 ) {
      rest = anzahl;
    } else if ( anzahl < this.platz() ) {
      this.anzahl1Euro += anzahl;
    } else {
      rest = anzahl - this.platz();
      this.anzahl1Euro += anzahl - rest;
    }
    return rest;
  }

  public int add2Euros( int anzahl ) {
    int rest = 0;
    if ( this.gebrochen || anzahl < 0 ) {
      rest = anzahl;
    } else if ( anzahl < this.platz() ) {
      this.anzahl2Euro += anzahl;
    } else {
      rest = anzahl - this.platz();
      this.anzahl2Euro += anzahl - rest;
    }
    return rest;
  }

  public boolean isEmpty() {
    return this.anzahl() == 0;
  }

  public boolean isFull() {
    return this.anzahl() >= this.maxAnzahl;
  }

  public boolean isBroken() {
    return this.gebrochen;
  }

  public int breakPiggy() {
    //@formatter:off
    int geld = this.anzahl1Cent 
            + this.anzahl2Cent * 2
            + this.anzahl5Cent * 5 
            + this.anzahl10Cent * 10
            + this.anzahl20Cent * 20 
            + this.anzahl50Cent * 50 
            + this.anzahl1Euro * 100
            + this.anzahl2Euro * 200;
    //@formatter:on
    this.anzahl1Cent = 0;
    this.anzahl2Cent = 0;
    this.anzahl5Cent = 0;
    this.anzahl10Cent = 0;
    this.anzahl20Cent = 0;
    this.anzahl50Cent = 0;
    this.anzahl1Euro = 0;
    this.anzahl2Euro = 0;
    this.gebrochen = true;
    return geld;
  }

  private int anzahl() {
    //@formatter:off
    return this.anzahl1Cent
            + this.anzahl2Cent 
            + this.anzahl5Cent 
            + this.anzahl10Cent 
            + this.anzahl20Cent 
            + this.anzahl50Cent 
            + this.anzahl1Euro 
            + this.anzahl2Euro;
    //@formatter:on
  }

  private int platz() {
    return this.maxAnzahl - this.anzahl();
  }

}
