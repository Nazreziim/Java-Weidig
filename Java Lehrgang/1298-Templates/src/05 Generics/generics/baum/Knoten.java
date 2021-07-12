package generics.baum;

import baeume.vorlage.TE;

public class Knoten<T extends Comparable<T>, S> {
	private T key;
	// private S info; noch nicht benutzt!
	public Knoten<T,S> links;
	public Knoten<T,S> rechts;
	
	public Knoten(T key) {		
		this.key = key;
		this.links = null;
		this.rechts = null;
	}
	
	public Knoten<T,S> getLinks() {
		return this.links;
	}
	
	public Knoten<T,S> getRechts() {
		return this.rechts;
	}
	
	public T getKey() {
		return this.key;
	}
	
	public void setKey(T key) {
		this.key = key;
	}
	public void setLinks(Knoten<T,S> k) {
		this.links = k;
	}
	
	public void setRechts(Knoten<T,S> k) {
		this.rechts = k;
	}
	
	// Methode zum sortierten Einfügen eine Schlüssels
	public void addKnoten(T key) {
		if (this.key.compareTo(key) > 0) { // Einfügen links
			if (this.getLinks() == null) {
				// Rekursionsende: links kein Teilbaum -> neuer Knoten links anhängen
				this.setLinks(new Knoten<T,S>(key));
			} else { // Rekursionsschritt: Weiterreichen der Aufgabe an den linken Teilbaum
				this.getLinks().addKnoten(key);
			}
		} else { // Einfügen rechts
			if (this.getRechts() == null) {
				this.setRechts(new Knoten<T,S>(key));				
			} else {
				this.getRechts().addKnoten(key);
			}
		}
	}
	
	// Pre-order Ausgabe: Ich - Links - Rechts
	public void showKnoten() {
		// 1.) Das Element selbst ausgebene
		System.out.print(this.getKey() + ", ");
		
		// 2.) Den linken Teilbaum ausgeben
		if (this.getLinks() != null) {
			this.getLinks().showKnoten();
		}
		
		// 3.) Den rechten Teilbaum ausgeben
		if (this.getRechts() != null) {
			this.getRechts().showKnoten();
		}
		
	}
	
	// In-Order Ausgabe: Links - Ich - Rechts
	public void showKnoten_sortiert() {		
		// 1.) Den linken Teilbaum ausgeben
		if (this.getLinks() != null) {
			this.getLinks().showKnoten_sortiert();
		}
		
		// 2.) Das Element selbst ausgeben	
		System.out.print(this.getKey() + ", ");
		
		// 3.) Den rechten Teilbaum ausgeben
		if (this.getRechts() != null) {
			this.getRechts().showKnoten_sortiert();
		}
		
	}
	// Post-Order Ausgabe: Links - Rechts - Ich
	
	
	/*
	public void dropKnoten(int key) {
		if (this.getKey() == key) { // Rekursionsende: zu löschender Knoten ist this
			//1.) Knoten ist Blatt
			if (this.getLinks() == null && this.getRechts() == null) {
			}
			//2.) Knoten hat einen Nachfolger (links XOR rechts)
			//3.) Knoten hat zwei Nachfolger
		
		} else { // Rekursionsschritt: <= nach links, > nach rechts weiterreichen
		}
	}*/
	
	
	// Methode zum Löschen eines Knoten
	// rekursiv: liefert einen Teilbaum (Knoten) zurück, aus dem das Element mit key entfernt wurde
	public Knoten<T,S> dropKnoten(T key) {
			Knoten<T,S> erg = this;
			if (this.getKey().compareTo(key) == 0) { // Rekursionsende: zu löschender Knoten ist this
				//1.) Knoten ist Blatt: null zurückgeben
				if (this.getLinks() == null && this.getRechts() == null) {
					erg = null;
				}
				
				//2.) Knoten hat einen Nachfolger (links XOR rechts):
				// Ausketten: wenn links leer, Referenz auf rechten Teilbaum
				if (this.getLinks() == null) {
					erg = this.getRechts();
				} 
				if (this.getRechts() == null) {
					erg = this.getLinks();
				}
								
				//3.) Knoten hat zwei Nachfolger
				if (this.getRechts() != null && this.getLinks() != null) {	
					//kleinstes Element im rechten Teilbaum suchen:
					Knoten<T,S> kl_rechts = kleinster_rechts();
					// Den Wert des Elements in den key schreiben
					erg.setKey( kl_rechts.getKey() );
					// Durch Aufruf von dropKnoten, das übernommene Element aus dem rechten Teilbaum löschen
					erg.setRechts(this.getRechts().dropKnoten(kl_rechts.getKey()));				
				}										
			}
			// Rekursionsschritt: <= nach links, > nach rechts weiterreichen
			if (key.compareTo(this.getKey()) < 0) { 
				if(this.getLinks() != null){
					this.setLinks(this.getLinks().dropKnoten(key));
				}
			}
			else{
				if(this.getRechts() != null){
					this.setRechts(this.getRechts().dropKnoten(key));
				}
			}
			return erg;
		
	}
	
	private Knoten<T,S> kleinster_rechts() {
		Knoten<T,S> erg;
		if (this.getLinks() == null) {
			erg = this;
		} else {
			erg = this.getLinks().kleinster_rechts();
		}		
		return erg;
	}

	public int hoehe() {
		int hoehe_l = 0;
		int hoehe_r = 0;
		if (this.getLinks() != null) {
			hoehe_l = this.getLinks().hoehe();
		}
		if (this.getRechts() != null) {
			hoehe_r = this.getRechts().hoehe();
		}
		
		return hoehe_l > hoehe_r ? hoehe_l + 1 : hoehe_r + 1;
	}
	
}
