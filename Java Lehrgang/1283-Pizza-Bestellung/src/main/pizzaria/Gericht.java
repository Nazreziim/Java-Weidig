/**
 * 
 */
package pizzaria;

/**
 * @author Administrator
 * Diese Klasse verwaltet die vorhandenen Gerichte
 * mit dem Grundpreis.
 */
public class Gericht
{
	// Koonstanten
	public final  static int ANZAHL_PARAMETER = 2;
	
	// Attribute
	private String mName;
	private double mPreis;
	
	// Getter/Setter
	public String getName()
	{
		return this.mName;
	}
	
	public double getPreis()
	{
		return this.mPreis;
	}
	
	// Konstruktor
	/**
	 * Standard-Konstruktor
	 */
	protected Gericht()
	{
		super();
	}
	
	/**
	 * zum Lesen der Gerichte aus Datei: Bestellungen
	 * @param name
	 */
	public Gericht(String name)
	{
		this(name, 0.0);
	}
	
	/**
	 * Zum Einlesen der Sorten.
	 * @param name
	 * @param preis
	 */
	public Gericht(String name, double preis)
	{
		this.mName = name;
		this.mPreis = preis;
	}

	// Methoden
	
	/**
	 * Gibt Kopie eines Gerichts
	 */
	public Gericht clone()
	{
		return new Gericht(this.mName,this.mPreis);
	}
}
