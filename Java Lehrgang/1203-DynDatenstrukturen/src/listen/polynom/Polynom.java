package listen.polynom;

public class Polynom {
	
	private PolyGlied start;
	private int anzahl;
	
	
	/**
	 * Konstruktor der Klasse
	 */
	public Polynom() {
		super();
		this.start = null;
		this.anzahl = 0;
	}

	/**
	 * Methode gibt den hoechsten Exponenten zurueck.
	 * @return int Exponenten
	 */
	private int gebeMaxExponent() {
		return (this.start != null) ? gebeMaxPolyGlied().getExponent() : 0;
	}
	
	/**
	 * Methode gibt das PolyGlied mit dem hoechsten Exponenten zurueck.
	 * @return	PolyGlied 
	 */
	private PolyGlied gebeMaxPolyGlied() {
		PolyGlied polyGlied = null;
		
		for ( PolyGlied hilf = this.start; hilf != null; hilf = hilf.getNaechster()) {
			if( polyGlied == null || 
				(polyGlied != null && polyGlied.getExponent() < hilf.getExponent())) {
				polyGlied = hilf;
			}
		}
		
		return polyGlied;
	}
	
	/**
	 * Methode gibt das PolyGlied mit dem uebergebenen Exponenten zurueck oder
	 * null.
	 * @param exponent	Exponent
	 * @return	PolyGlied   Referenz auf PolyGlied mit dem Exponent oder null falls nicht vorhanden.
	 */
	private PolyGlied gebePolyGlied(int exponent) {
		PolyGlied polyGlied = null;
		PolyGlied hilf = this.start;
		
		while (polyGlied == null && hilf != null) {
			if (hilf.getExponent() == exponent) {
				polyGlied = hilf;
			}
			hilf = hilf.getNaechster();
		}
		
		return polyGlied;
	}
	
	/**
	 * Methode zum vorne Einfuegen eines PolyGlieds in die Liste.
	 * @param exponent		Exponent	
	 * @param koeffizient	Koeffizient
	 */
	private void einfuegenVorne(int exponent, double koeffizient) {
		this.start = new PolyGlied(exponent, koeffizient, this.start);
	}
	
	/**
	 * Aufnahme der Polynomglieder am Ende der Liste.
	 * @param exponent		exponent
	 * @param koeffizient	koeffizient
	 */
	public void einfuegenHinten(int exponent, double koeffizient) {
		
		if ( koeffizient != 0.0) {
			
			if ( this.start == null) {
				einfuegenVorne(exponent, koeffizient);
			}
			else {
				PolyGlied hilf = this.start;
				
				while ( hilf.getNaechster() != null) {
					
					hilf = hilf.getNaechster();
				}
				
				// Einfuegestelle gefunden
				hilf.setNaechster(new PolyGlied(exponent, koeffizient));
			}
			anzahl++;
		}
		
	}
	
	
	/**
	 * Methode fuegt PolyGlieder absteigend sortiert in die Liste ein.
	 * @param exponent		 Exponent des PolyGlieds
	 * @param koeffizient	 Koeffizient des PolyGlieds
	 */
	private void einfuegenSortiert(int exponent, double koeffizient){
		PolyGlied vorgaenger = start;
		PolyGlied nachfolger = start;
		
		// weiterschalten mit Nachschleppen
		while (nachfolger != null && nachfolger.getExponent() > exponent){
			vorgaenger = nachfolger;
			nachfolger = nachfolger.getNaechster();
		}
		
		if (nachfolger != null && nachfolger.getExponent() == exponent ) {
			// kein neues Glied anlegen, Koeffizienten addieren
			nachfolger.setKoeffizient(nachfolger.getKoeffizient() + koeffizient);
		}
		else {
			// Einfuegeposition gefunden
			if (vorgaenger == nachfolger){ // Anfang oder leere Liste
				einfuegenVorne(exponent, koeffizient);
			}
			else{ // sortiert einfuegen mitte und am Ende der Liste
				vorgaenger.setNaechster(new PolyGlied(exponent, koeffizient));
			}
			anzahl++;
		}
	}
	
	/**
	 * Methode gibt die Polynomglieder der Liste aus.
	 */
	public void drucke() {
		PolyGlied hilf = this.start;
		int aktPoly = 1;
		
		while (hilf != null) {
			// Aktion
			System.out.printf("%.1f", hilf.getKoeffizient() );
			
			if ( hilf.getExponent() > 0) {
				System.out.print(" x");
			}
			
			if ( hilf.getExponent() > 1) {
				System.out.printf("^%d", hilf.getExponent() );
			}
			
			if (aktPoly < anzahl) {
				System.out.print(" + ");
			}
			
			aktPoly++;
			// weiterschalten
			hilf = hilf.getNaechster();
		}
		System.out.println();
	}
	
	/**
	 * Methode berechnet das Polynom aus den Listenelementen (PolyGlieder).
	 * @param x		x-Wert fuer die Berechnung
	 * @return	    double Ergebnis des Polynoms.
	 */
	public double auswerte(double x) {
		double erg = 0.0;
		PolyGlied hilf = this.start;
		
		while (hilf != null) {
			// Aktion
			erg = erg + hilf.getKoeffizient() *  Math.pow(x, hilf.getExponent());
			// weiterschalten
			hilf = hilf.getNaechster();
		}
		return erg;
	}
	
	
	/**
	 * Methode addiert zwei Polynome miteinander. 
	 * 
	 * @param poly1	Polynom 1 (Liste aus PolyGlieder)
	 * @param poly2 Polynom 2 (Liste aus PolyGlieder)
	 * @return	Polynom 	Ergebnisliste
	 */
	public static Polynom add(Polynom poly1, Polynom poly2) {
		Polynom erg = new Polynom();
		final int MIN_EXPONENT = 0;
		int maxExponent = 0;
		int aktExponent = 0;
		double koeff1 = 0.0;
		double koeff2 = 0.0;
		
		PolyGlied aktPolyGlied1 = null;
		PolyGlied aktPolyGlied2 = null;
		
		if ( poly1 != null && poly2 != null ) {
			
			if ( poly1.gebeMaxExponent() > poly2.gebeMaxExponent() ) {
				maxExponent = poly1.gebeMaxExponent();
			}
			else {
				maxExponent = poly2.gebeMaxExponent();
			}
		
			aktExponent = maxExponent;
			
			while (aktExponent >= MIN_EXPONENT) {
				koeff1 = 0.0;
				koeff2 = 0.0;
				
				aktPolyGlied1 = poly1.gebePolyGlied(aktExponent);
				
				if (aktPolyGlied1 != null) {
					koeff1 = aktPolyGlied1.getKoeffizient();
				}
				
				aktPolyGlied2 = poly2.gebePolyGlied(aktExponent);
				
				if (aktPolyGlied2 != null) {
					koeff2 = aktPolyGlied2.getKoeffizient();
				}
				
				if (aktPolyGlied1 != null || aktPolyGlied2 != null) {
					erg.einfuegenHinten(aktExponent, koeff1 + koeff2);
				}
								
				aktExponent--;
			}			
			
		}
		return erg;
	}
	

	/**
	 * Methode multipliziert zwei Polynome miteinander.
	 * @param poly1	Polynom 1 (Liste aus PolyGlieder)
	 * @param poly2 Polynom 2 (Liste aus PolyGlieder)
	 * @return	Polynom 	Ergebnisliste
	 */
	public static Polynom mult(Polynom poly1, Polynom poly2) {
		Polynom erg = new Polynom();
		
		for ( PolyGlied hilf1 = poly1.start; hilf1 != null; hilf1 = hilf1.getNaechster() ) {
			
						
			for (PolyGlied hilf2 = poly2.start; hilf2 != null; hilf2 = hilf2.getNaechster() ) {
							
				erg.einfuegenSortiert(hilf1.getExponent() + hilf2.getExponent(), hilf1.getKoeffizient() * hilf2.getKoeffizient());
			}
					
		}
		
		return erg;
	}
}
