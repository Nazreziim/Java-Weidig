package uebung7;

public class Scratchy {
  private static long count;
  private final long id;

  public Scratchy() {
    this.id = Scratchy.count++;
  }

  public long getId() {
    return this.id;
  }
}
