package basic.version2;


public class Main {

	
	public static void ausgabeText(int wert) {
		System.out.println( "Die Zahl ist: " + wert );
	}
	
	public static void ausgabeStern(int wert) {
		StringBuilder sb = new StringBuilder( wert );
	    for ( int i = 0; i < wert; ++i ) {
	      sb.append( '*' );
	    }
	    System.out.println( sb );
	}
	
	public static void main(String[] args) {

		ZahlEinfach model = new ZahlEinfach();

		for (int i = 0; i < 5; ++i) {
			// Daten werden aktualisiert
			model.increment();

			// Ausgaben generieren in unterschiedlicher Form
			// Textausgabe
			ausgabeText( model.getZahl() );
			
			// grafische Ausgabe
			ausgabeStern(model.getZahl());
		}

		// Daten werden aktualisiert
		model.sub(3);
		// Ausgaben generieren in unterschiedlicher Form
		// Textausgabe
		ausgabeText( model.getZahl() );
		// grafische Ausgabe
		ausgabeStern(model.getZahl());

		// Daten werden aktualisiert
		model.add(100);

		// Ausgaben generieren in unterschiedlicher Form
		// Textausgabe
		ausgabeText( model.getZahl() );
		
		// grafische Ausgabe
		ausgabeStern(model.getZahl());

	}

}
