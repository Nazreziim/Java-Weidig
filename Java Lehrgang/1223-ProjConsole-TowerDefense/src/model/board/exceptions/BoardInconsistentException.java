package model.board.exceptions;

public class BoardInconsistentException extends Exception {

  private static final long serialVersionUID = -8300748204836602727L;

  public BoardInconsistentException( String message ) {
    super( message );
  }

}
