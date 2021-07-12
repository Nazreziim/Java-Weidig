package listen.flavius;

/**
 * Skalve ist die verwaltete Information.
 * 
 * @author whoelzle
 *
 */
public class Sklave {
	// Attribut
	private String name;

	/**
	 * Konstruktor fuer die Klasse.
	 * @param name	Name als String
	 */
	public Sklave(String name) {
		super();
		this.name = name;
	}

	/**
	 * Getter-Methode der Klasse gibt den Namen zurueck.
	 * @return	Name des Sklaven
	 */
	public String getName() {
		return name;
	}

	/**
	 * Ueberladene Methode zur Ausgabe des Sklaven als String.
	 * @return String Name der Klasse.
	 */
	@Override
	public String toString() {
		
		return this.getClass().getSimpleName() +  ": "+ this.getName();
	}
	
	
}
