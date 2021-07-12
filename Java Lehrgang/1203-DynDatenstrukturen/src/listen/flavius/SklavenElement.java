package listen.flavius;

/**
 * Sklave ist ein Listenelement. Dieses beinhaltet die Information und
 * die Verwaltungsinformation (Hinweis auf das naechste Element)
 * @author whoelzle
 *
 */
public class SklavenElement {
	private Sklave element;
	private SklavenElement next;
	
	/**
	 * Konstruktor der Klasse
	 * @param element	verwaltetes Element
	 */
	public SklavenElement(Sklave element) {
		this(element, null); // Aufruf des Konstruktors mit zwei Uebergabeparameter
	}

	/**
	 * Konstruktor der Klasse
	 * @param element  verwaltetes Element
	 * @param next	   naechstes Sklavenelemetn
	 */
	public SklavenElement(Sklave element, SklavenElement next) {
		this.element = element;
		this.next = next;
	}
	/**
	 * Setter-Methode setzt das Nachfolgeelement.
	 * @param neu neues Listenelement
	 */
	public void setNext(SklavenElement neu) {
		this.next = neu;		
	}

	/**
	 * Getter-Methode gibt das Nachfolgeelement zurueck.
	 * @return SklavenElement 
	 */
	public SklavenElement getNext() {
		return this.next;
	}	
	
	/**
	 * Getter-Methode gibt das Element zurueck.
	 * @return	Sklave 
	 */
	public Sklave getElement() {
		return this.element;
	}
	
	public void add_hinten(SklavenElement neu) {
		if (this.getNext() == null) {
			this.setNext(neu);
		} else {
			this.getNext().add_hinten(neu);
		}
		
	}

	public void schliesse_kreis(SklavenElement start) {
		if (this.getNext() == null) {
			this.setNext(start);
		} else {
			this.getNext().schliesse_kreis(start);
		}		
	}





}
