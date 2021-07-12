package listen.flavius;

public class Flavius {
	private SklavenList liste;
	
	/**
	 * Konstruktor der Klasse
	 */
	public Flavius() {
		this.liste = new SklavenList();
	}
	
	/**
	 * Methode zur Aufnahme der Namen
	 * @param name	Name des Sklaven
	 */
	public void aufnahme(String name) {
		if (name != "_") {
			Sklave neu = new Sklave(name);
			liste.einfuegenHinten(neu);
		}else {
			liste.schliesseKreis();
		}
	}

	
	/**
	 * Methode ermittelt den Ueberlebenden.
	 * @param anz_silben Anzahl der Silben > 1
	 */
	public void zaehleAus(int anzSilben) {
		Sklave sklave = null;
		
		if ( !liste.istLeer() && anzSilben > 1 ) {
			
			System.out.println("Start bei: " + liste.gebeAktuellesElement());
		
			// Wenn der next-Zeiger auf dasselbe Element zeigt, ist nur noch einer übrig
			while (!liste.istBeendet()) {
				
				sklave = liste.entferneElement(anzSilben).getElement();
				
				System.out.println(sklave.getName() + " stirbt.");

			}
			
			System.out.println(liste.gebeSieger().getName() + " ueberlebt.");	
			
		}
		else {
			if (anzSilben <= 1) {
				System.out.println("Die Anzahl der Silben muss > 1 sein!");
			}
			else {
				System.out.println("Es sind keine Elemente in der Liste vorhanden!");
			}
		}
	}
	
}
