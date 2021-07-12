package basic.version3;

public class View {
	private ZahlEinfach model;

	public View(ZahlEinfach model) {
		super();
		this.model = model;
	}
	
	public void ausgabeText() {
		System.out.println( "Die Zahl ist: " + model.getZahl() );
	}
	
	public void ausgabeStern() {
		StringBuilder sb = new StringBuilder( model.getZahl() );
	    for ( int i = 0; i < model.getZahl(); ++i ) {
	      sb.append( '*' );
	    }
	    System.out.println( sb );
	}

}
