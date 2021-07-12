/**
 * 
 */
package pizzaria;

/**
 * @author Administrator
 *
 */
public class Bestellung
{
	public static final PizzaGroesse mGroessenListe[] =  new PizzaGroesse[] 
	    {PizzaGroesse.ErzeugeObjekt(PizzaGroesse.GROESSE.KLEIN),
		 PizzaGroesse.ErzeugeObjekt(PizzaGroesse.GROESSE.MITTEL),
		 PizzaGroesse.ErzeugeObjekt(PizzaGroesse.GROESSE.GROSS),
		 PizzaGroesse.ErzeugeObjekt(PizzaGroesse.GROESSE.FAMILIE)};
	
	public static final Extras  mExtrasListe[] = new Extras[] {new Extras("OHNE",0.0),
															   new Extras("Knoblauch",0.30),
															   new Extras("Käse",0.40),
															   new Extras("Zwiebel",0.30),
															   new Extras("Pilze",0.40)};
	public static final int ANZAHL_PARAMETER = 5;
	public static enum PARAMETERS
	{
		BestellNr, 
		Gericht,
		Groesse,
		Extras,
		Endpreis;
		
		public static PARAMETERS ConvertTo(int param) throws NullPointerException 
		{
			PARAMETERS p[] = PARAMETERS.values();
			
			if (( param >= 0) && (param < ANZAHL_PARAMETER))
			{
				return p[param];
			}
			else
			{
				throw new NullPointerException("Parameterindex nicht vorhanden");
			}
		}
	}
	
	public static final String SEPARATOR =";";
	
	private boolean mWareAbholen;
	private boolean mBereitsKunde;
	private PizzaGroesse mGroesse;
	private Extras mExtras;
	private double mEndpreis;
	private Gericht mGericht;
	private boolean mNeueBestellung;
	private String mParameter[];
	
	
	
	
	/**
	 * Konstruktoren
	 */
	protected Bestellung()
	{
		super();
	}
	
	/**
	 * Konstruktor zum Erstellung eines Menüs
	 * @param gericht
	 * @param groesse
	 * @param extras
	 * @param abholung
	 * @param kunde
	 */
	public Bestellung(Gericht gericht,PizzaGroesse groesse, Extras extras, boolean abholung, boolean kunde)
	{
		this.mGericht = gericht;
		this.mGroesse = groesse;
		this.mExtras = extras;
		this.mWareAbholen = abholung;
		this.mBereitsKunde = kunde;
		this.mNeueBestellung = true;
	}
	
	/**
	 * Konstruktor zum Einlesen aus der Datei
	 * @param gericht
	 * @param groesse
	 * @param extras
	 * @param endpreis
	 */
	public Bestellung(String eingabeFormat) throws NullPointerException
	{
		initParameter(eingabeFormat);
		this.mNeueBestellung = false;
	}
	
	// Getter/Setter
	public double getEndPreis()
	{
		return this.mEndpreis;
	}
	
	public boolean IstNeueBestellung()
	{
		return this.mNeueBestellung;
	}
	
	public String getParameter(PARAMETERS param)
	{
		return mParameter[param.ordinal()].toString();
	}
	// Methoden

	
	/**
	 * 
	 */
	private void initParameter(String eingabe) throws NullPointerException
	{
		mParameter = eingabe.split(";");
		
		if ( mParameter.length == ANZAHL_PARAMETER)
		{
			this.mGericht = new Gericht(mParameter[1]);
			this.mGroesse = getGroesse(mParameter[2]);
			this.mExtras = getExtras(mParameter[3]);
			this.mEndpreis = Double.parseDouble(mParameter[4]);
		}
	}
	
	/**
	 * 
	 * @param groesse
	 * @return
	 * @throws NullPointerException
	 */
	private PizzaGroesse getGroesse(String groesse) throws NullPointerException
	{
		boolean gefunden = false;
		int index = 0;
		PizzaGroesse groPizza = null;
		
		while ( !gefunden && (index < mGroessenListe.length))
		{
			if (mGroessenListe[index].getGroesse().equals(groesse))
			{
				groPizza = mGroessenListe[index];
				gefunden = true;
			}
			index++;
		}	
		if ( groPizza == null )
		{
			throw new NullPointerException("Fehlerhafter Datensatz (Groesse) aus Bestellung entfernt!");
		}
		return groPizza;
	}

	
	private Extras getExtras(String extras) throws NullPointerException
	{
		boolean gefunden = false;
		int index = 0;
		Extras extPizza = null;
		
		while ( !gefunden && (index < mExtrasListe.length))
		{
			if (mExtrasListe[index].getName().equals(extras))
			{
				extPizza = mExtrasListe[index];
				gefunden = true;
			}
			index++;
		}	
		if ( extPizza == null )
		{
			throw new NullPointerException("Fehlerhafter Datensatz (Extras) aus Bestellung entfernt!");
		}
		
		return extPizza;
	}
	
	// Methoden
	public void Berechne()
	{
		if (this.mNeueBestellung)
		{
			this.mEndpreis = this.mGericht.getPreis() + 
							 this.mGroesse.getDiffPreis() + 
							 this.mExtras.getDiffPreis();
			if ( this.mWareAbholen )
			{
				this.mEndpreis -= 0.50;
			}
			if ( this.mBereitsKunde )
			{
				this.mEndpreis -= 0.50;
			}
		}
	}
	
	public String getFormatAusgabe()
	{
		StringBuffer buffer = new StringBuffer(30);
		buffer.append(this.mGericht.getName());
		buffer.append(SEPARATOR);
		buffer.append(this.mGroesse.getGroesse());
		buffer.append(SEPARATOR);
		buffer.append(this.mExtras.getName());
		buffer.append(SEPARATOR);
		buffer.append(this.mEndpreis);
		return buffer.toString();
	}
	
	public String getAusgabeBestellung()
	{
		StringBuffer buffer = new StringBuffer(30);
		buffer.append("Eine ");
		buffer.append(this.mGericht.getName());
		buffer.append("( ");
		buffer.append(this.mGroesse.getGroesse());
		buffer.append(" )");
		if ( !this.mExtras.getName().equals("OHNE"))
		{
			buffer.append(" mit ");
			buffer.append(this.mExtras.getName());
		}
		buffer.append(" zu einem Preis von: ");
		buffer.append(this.mEndpreis);
		buffer.append(" EURO.");
		return buffer.toString();	
	}
}
