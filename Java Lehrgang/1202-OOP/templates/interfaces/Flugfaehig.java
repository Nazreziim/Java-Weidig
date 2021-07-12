package interfaces;

public interface Flugfaehig {

  public void fliegen();
  
  default public void gleiten() {
    System.out.println( "allgemeines Gleiten" );
  }

}
