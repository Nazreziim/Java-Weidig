package uebung2.view;

public class ViewSternchen implements View {
  public void ausgabeZahl( Integer zahl ) {
    StringBuilder sb = new StringBuilder( zahl );
    for ( int i = 0; i < zahl; ++i ) {
      sb.append( '*' );
    }
    System.out.println( sb );
  }
}
