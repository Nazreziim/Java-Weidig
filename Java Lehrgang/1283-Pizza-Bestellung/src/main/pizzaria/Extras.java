/**
 * 
 */
package pizzaria;

/**
 * @author Administrator
 *
 */
public class Extras
{
	// Attribute
	private String mName;
	private double mDiffPreis;
	
	// Konstruktoren
	protected Extras()
	{
		super();
	}
	public Extras(String name, double diffPreis)
	{
		this.mName = name;
		this.mDiffPreis = diffPreis;
	}
	
	// Getter/Setter
	public String getName()
	{
		return this.mName;
	}
	
	public double getDiffPreis()
	{
		return this.mDiffPreis;
	}
}
