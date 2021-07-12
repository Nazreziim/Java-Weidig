package basic.version1;

public class Main {

	public static void main(String[] args) {

		ZahlEinfach model = new ZahlEinfach();

		for (int i = 0; i < 5; ++i) {
			// Daten werden aktualisiert
			model.increment();

			// Ausgaben generieren in unterschiedlicher Form
			// Textausgabe
			System.out.println( "Die Zahl ist: " + model.getZahl() );
			// grafische Ausgabe
			StringBuilder sb = new StringBuilder( model.getZahl() );
		    for ( int j = 0; j < model.getZahl(); ++j ) {
		      sb.append( '*' );
		    }
		    System.out.println( sb );
		}

		// Daten werden aktualisiert
		model.sub(3);
		// Ausgaben generieren in unterschiedlicher Form
		// Textausgabe
		System.out.println( "Die Zahl ist: " + model.getZahl() );
		// grafische Ausgabe
		StringBuilder sb = new StringBuilder( model.getZahl() );
	    for ( int i = 0; i < model.getZahl(); ++i ) {
	      sb.append( '*' );
	    }
	    System.out.println( sb );

		// Daten werden aktualisiert
		model.add(100);

		// Ausgaben generieren in unterschiedlicher Form
		// Textausgabe
		System.out.println( "Die Zahl ist: " + model.getZahl() );
		// grafische Ausgabe
		sb = new StringBuilder( model.getZahl() );
	    for ( int i = 0; i < model.getZahl(); ++i ) {
	      sb.append( '*' );
	    }
	    System.out.println( sb );

	}

}
