package basic.version4;


public class ViewDezimal  {

  private ZahlEinfach model;

  public ViewDezimal( ZahlEinfach model ) {
    this.model = model;
  }

  public void ausgabe() {
    System.out.println( "Die Zahl ist: " + model.getZahl() );
  }

}
