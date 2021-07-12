package wrsv2018schritt1.model;

public class Rennschnecke {

  private static long counter = 0L;

  private final long ID;
  private String name;
  private double geschwindigkeit;
  private boolean versichert;

  public Rennschnecke( String name, double geschwindigkeit, boolean versichert ) {
    this.ID = counter++;
    this.name = name;
    this.geschwindigkeit = geschwindigkeit;
    this.versichert = versichert;
  }

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public double getGeschwindigkeit() {
    return geschwindigkeit;
  }

  public void setGeschwindigkeit( double geschwindigkeit ) {
    this.geschwindigkeit = geschwindigkeit;
  }

  public boolean isVersichert() {
    return versichert;
  }

  public void setVersichert( boolean versichert ) {
    this.versichert = versichert;
  }

  public long getID() {
    return ID;
  }

  @Override
  public String toString() {
    return "Rennschnecke [ID=" + ID + ", name=" + name + ", geschwindigkeit=" + geschwindigkeit
            + ", versichert=" + versichert + "]";
  }

}
