/**
 * 
 */
package pizzaria;

/**
 * @author Administrator
 *
 */
public class PizzaGroesse
{	
	// Attributte 
	private String mGroesse;
	private double mDiffpreis;
	/**
	 * Anzahl der Elemente des Array's MUSS mit dem enum GROESSE abgestimmt sein!
	 */
	private final static String mName[] = { "klein", "mittel", "groß", "Familie" };
	/**
	 * Anzahl der Elemente des Array's MUSS mit dem enum GROESSE abgestimmt sein!
	 */
	private final static double mOffsetPreis[] = new double[] { -0.50, 0.0, 0.75, 1.50 };
	/**
	 * 
	 * @author Administrator
	 *
	 */
	public enum GROESSE { KLEIN,
						  MITTEL, 
						  GROSS, 
						  FAMILIE };
	
	// Konstruktoren
	/**
	 * Standard-Konstruktor, nicht in Verwendung.
	 */
	protected PizzaGroesse()
	{
		super();
	}
	
	/**
	 * Erstellt ein Pizza Größenobjekt.
	 * @param groesse
	 * @param diffPreis
	 */
	private PizzaGroesse(String groesse, double diffPreis)
	{
		this.mGroesse = groesse;
		this.mDiffpreis = diffPreis;
	}
	
	// Getter/Setter

	/**
	 * Gibt den Differenzpreis zurück.
	 */
	public double getDiffPreis()
	{
		return this.mDiffpreis;
	}
	
	/**
	 * Gibt den Name der Pizzagröße zurück.
	 * @return
	 */
	public String getGroesse()
	{
		return this.mGroesse;
	}
	
	// Klassen-Methoden
	public static PizzaGroesse ErzeugeObjekt(GROESSE typ)
	{
		return new PizzaGroesse(PizzaGroesse.mName[typ.ordinal()], PizzaGroesse.mOffsetPreis[typ.ordinal()]);
	}
}
