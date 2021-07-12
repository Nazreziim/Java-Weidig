package schulverwaltung;

import java.util.ArrayList;

/**
 * Die Klasse verwaltet eine Schulklasse.
 * Sie beinhaltet die Jahrgangsstufe mit Klassenname
 * sowie die Schueler und den Klassenlehrer.
 * @author user
 *
 */
public class Schulklasse {
	public final static int MAX_GROESSE = 27;
	
	private ArrayList<Schueler> schuelerVerw;
	private Lehrer klassenLehrer;
	private int jahrgangsstufe; 
	private char klassenName; // a, b,c ...
	
	
	/**
	 * Konstruktor
	 * @param jahrgangsstufe
	 * @param klassenName
	 */
	public Schulklasse(int jahrgangsstufe, char klassenName){
		this.jahrgangsstufe = jahrgangsstufe;
		this.klassenName = klassenName;
		this.schuelerVerw = new ArrayList<Schueler>(MAX_GROESSE);
	}

	/**
	 * Gibt die Anahl der Schueler der Klasse zurueck.
	 * @return
	 */
	public int getAnzahlSchueler(){
		return schuelerVerw.size();
	}
	
	/*
	 * Gibt die Schueler der Klasse zurueck.
	 */
	public ArrayList<Schueler> getSchueler() {
		return this.schuelerVerw;
	}
	
	/**
	 * Gibt den Klassenlehrer zurueck.
	 * @return
	 */
	public Lehrer getKlassenlehrer() {
		return this.klassenLehrer;
	}
	
	/**
	 * Setzt den Klassenlehrer fuer die Klasse
	 * @param lehrer
	 */
	public void setKlassenlehrer(Lehrer lehrer) {
		this.klassenLehrer = lehrer;
	}
	/**
	 * Gibt die Jahrgangsstufe der Klasse zurueck.
	 * @return
	 */
	public int getJahrgangsstufe() {
		return this.jahrgangsstufe;
	}
	
	/**
	 * Gibt den KlassenNamen (a,b,c..) zurueck.
	 * @return
	 */
	public char getKlasseName() {
		return this.klassenName;
	}

	/**
	 * Fuegt einen Schueler der Schulklasse hinzu.
	 * @param schueler
	 */
	public void hinzufuegenSchueler(Schueler schueler){
		schuelerVerw.add(schueler);
	}
	
	/**
	 * Gibt die Anzahl der bestandenen Schueler zurueck.
	 * @return
	 */
    public int anzahlBestandeneSchueler(){
    	int anzahl = 0;
    	for (Schueler s : this.schuelerVerw){
    		if (s.isSchuljahrBestanden()){
    			anzahl++;
    		}
    	}
    	return anzahl;
    }
    
	@Override
	public String toString() {

		/*
		 * Testausgabe aller Schueler
		 */
		// System.out.println(schuelerVerw.toString());
		
		return String.format("Jahrgangsstufe: %02d Klasse: %c Anzahl Schueler: %02d Lehrer: %s ",
							 this.jahrgangsstufe, this.klassenName, this.getAnzahlSchueler(), this.klassenLehrer );
		
	}

}
