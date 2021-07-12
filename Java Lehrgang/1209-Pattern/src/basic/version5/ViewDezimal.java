package basic.version5;


public class ViewDezimal  implements View {

  private ZahlEinfach model;

  public ViewDezimal( ZahlEinfach model ) {
    this.model = model;
  }

  public void ausgabe() {
    System.out.println( "Die Zahl ist: " + model.getZahl() );
  }

}
