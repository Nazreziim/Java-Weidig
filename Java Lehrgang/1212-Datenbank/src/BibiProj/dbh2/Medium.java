package BibiProj.dbh2;

public class Medium {
  public final static int UNDEF_ID = 0;
  public final static int UNDEF_FSK = 0;
  private int id;
  private String name;
  private int fsk;
  
  public Medium( int id, String name, int fsk) {
    this.id = id;
    this.name = name;
    this.fsk = fsk;
  }
  
  /**
   * Konstruktor zum Anlegen
   * @param name
   * @param fsk
   */
  public Medium( String name, int fsk ) {
    this(UNDEF_ID, name, fsk);   
  }

  /**
   * Konstruktor zum Anlegen
   * @param name
   */
  public Medium( String name ) {
    this(UNDEF_ID, name, UNDEF_FSK);   
  }
  
  public String getName() {
    return name;
  }

  public int getFsk() {
    return fsk;
  }

  public int getId() {
    return id;
  }

  public void setId( int id ) {
    this.id = id;
  }

  @Override
  public String toString() {
    return String.format( "Medium:  Id: %d, Name: %s , Fsk: %d", id, name, fsk );
  }
  
}
