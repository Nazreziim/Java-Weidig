package uebung1;

public class NoBinaryNumberException extends RuntimeException {

  private static final long serialVersionUID = -6469896583600339816L;

  public NoBinaryNumberException() {
    super();
  }

  public NoBinaryNumberException( String message, Throwable cause ) {
    super( message, cause );
  }

  public NoBinaryNumberException( String binaryString, int pos ) {
    super( "'" + binaryString + "' is not binary @ Position " + pos + "." );
  }

}
