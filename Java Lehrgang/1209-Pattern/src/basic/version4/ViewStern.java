package basic.version4;


public class ViewStern {

  private ZahlEinfach model;

  public ViewStern( ZahlEinfach model ) {
    this.model = model;
  }

  public void ausgabe() {
    StringBuilder sb = new StringBuilder( model.getZahl() );
    for ( int i = 0; i < model.getZahl(); ++i ) {
      sb.append( '*' );
    }
    System.out.println( sb );
  }

}
