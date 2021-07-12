public class PiggyBank {
  private int cent1 = 0;
  private int cent10 = 0;
  private int cent50 = 0;
  private int euro1 = 0;
  private int maxStuecke = 0;
  private boolean gebrochen = false;

  public void init( int maxStuecke ) {
    this.cent1 = 0;
    this.cent10 = 0;
    this.cent50 = 0;
    this.euro1 = 0;
    this.maxStuecke = maxStuecke;
    this.gebrochen = false;
  }

  public int add1Cents( int cent1 ) {
    int ergebnis = 0;
    int coins = this.cent1 + this.cent10 + this.cent50 + this.euro1;
    int differenz = this.maxStuecke - coins;
    if ( cent1 <= differenz ) {
      this.cent1 += cent1;
    } else {
      this.cent1 += differenz;
      ergebnis = cent1 - differenz;
    }
    return ergebnis;
  }

  public int add10Cents( int cent10 ) {
    int ergebnis = 0;
    int coins = this.cent1 + this.cent10 + this.cent50 + this.euro1;
    int differenz = this.maxStuecke - coins;
    if ( cent10 <= differenz ) {
      this.cent10 += cent10;
    } else {
      this.cent10 += differenz;
      ergebnis = cent10 - differenz;
    }
    return ergebnis;
  }

  public int add50Cents( int cent50 ) {
    int ergebnis = 0;
    int coins = this.cent1 + this.cent10 + this.cent50 + this.euro1;
    int differenz = this.maxStuecke - coins;
    if ( cent50 <= differenz ) {
      this.cent50 += cent50;
    } else {
      this.cent50 += differenz;
      ergebnis = cent50 - differenz;
    }
    return ergebnis;
  }

  public int add1Euro( int euro1 ) {
    int ergebnis = 0;
    int coins = this.cent1 + this.cent10 + this.cent50 + this.euro1;
    int differenz = this.maxStuecke - coins;
    if ( euro1 <= differenz ) {
      this.euro1 += euro1;
    } else {
      this.euro1 += differenz;
      ergebnis = euro1 - differenz;
    }
    return ergebnis;
  }

  public boolean isEmpty() {
    return this.cent1 + this.cent10 + this.cent50 + this.euro1 == 0;
  }

  public boolean isFull() {
    return this.cent1 + this.cent10 + this.cent50 + this.euro1 >= this.maxStuecke;
  }

  public boolean isBroken() {
    return this.gebrochen;
  }

  public int breakPiggy() {
    int ergebnis = this.euro1 * 100 + this.cent50 * 50 + this.cent10 * 10 + this.cent1;
    this.euro1 = 0;
    this.cent1 = 0;
    this.cent10 = 0;
    this.cent50 = 0;
    this.gebrochen = true;
    return ergebnis;
  }

}
