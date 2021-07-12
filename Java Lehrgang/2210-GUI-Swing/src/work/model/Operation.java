package work.model;

public enum Operation {
  ADD( '+' ), SUB( '-' ), MULT( '*' ), DIV( '/' );

  private final char operation;

  private Operation( char operation ) {
    this.operation = operation;
  }

  public char getOperation() {
    return this.operation;
  }
}
