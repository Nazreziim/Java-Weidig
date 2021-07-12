package b4Polymorphie;

import java.io.*;

abstract class Stift {
	String schreibfarbe;

	public abstract void gebeSchreibfarbeAus();
}

class Kugelschreiber extends Stift {
	public Kugelschreiber(String e) {
		schreibfarbe = e;
	}

	public void gebeSchreibfarbeAus() {
		System.out.println("Schreibfarbe des Kugelschreibers  ist  "
				+ schreibfarbe + ",\n");
	}
}

class Buntstift extends Stift {
	public Buntstift(String e) {
		schreibfarbe = e;
	}

	public void gebeSchreibfarbeAus() {
		System.out.println("Mein Buntstift hat die Schreibfarbe" + schreibfarbe
				+ ",\n");
	}
}

public class StiftTester {
	public static void main(String[] args) throws IOException {
		/*
		 * Kugelschreiber-Objekt wird einer Variablen, die auf ein Objekt der
		 * Elternklasse "Stift" zeigt, zugewiesen
		 */
		Stift irgendeinStift = new Kugelschreiber("blau");
		/*
		 * Methode "gebeSchreibfarbeAus" der Klasse Kugelschreiber wird
		 * ausgeführt
		 */
		irgendeinStift.gebeSchreibfarbeAus();

		/*
		 * Buntstift-Objekt wird einer Variablen, die auf ein Objekt der
		 * Elternklasse "Stift" zeigt, zugewiesen
		 */
		irgendeinStift = new Buntstift("rot");
		/* Methode "gebeSchreibfarbeAus" der Klasse Buntstift wird ausgeführt */
		irgendeinStift.gebeSchreibfarbeAus();
	}
}