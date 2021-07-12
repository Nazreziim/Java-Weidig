/**
 * 
 */
package pizzaria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class Gerichte
{
	// Attribute
	private List<Gericht> mListe = new ArrayList<Gericht>();
	
	
	
	// Konstruktor
	protected Gerichte()
	{
		
	}
	
	public Gerichte(String pfadName)
	{
		EinlesenGerichte(pfadName);
	}
	
	// Methoden
	public int getAnzahlGerichte()
	{
		return mListe.size();
	}
	
	public Gericht getGericht(int index)
	{
		if ( (index >= 0) && (index < mListe.size()))
		{
			return mListe.get(index).clone();
		}
		else
		{
		   return null;
		}
	}
	
	public int getIndexOf(String name)
	{
		int ergebnis = -1;
		boolean gefunden = false;
		int index = 0;
		
		while ( !gefunden && (index < mListe.size()))
		{
			if (mListe.get(index).getName().equals(name))
			{
				ergebnis = index;
				gefunden = true;
			}
			index++;
		}	
		
		return ergebnis;
	}
	
	private void EinlesenGerichte(String pfadName)
	{
		java.io.BufferedReader br = null;
		java.io.FileReader fr = null;
		String zeile;
		String parameter[];
		
		try 
		{
			fr = new java.io.FileReader(pfadName);
			br = new java.io.BufferedReader(fr);
			
			while ((zeile = br.readLine())!= null)
			{
				parameter = zeile.split(Bestellung.SEPARATOR);

				if (parameter.length == Gericht.ANZAHL_PARAMETER)
				{
					this.mListe.add(new Gericht(parameter[0], Double.parseDouble(parameter[1])));
				}
			}
		}catch (IOException e) {}
		finally
		{
			try
			{
				br.close();
			}catch (IOException e) {}
			catch (NullPointerException e) {}
			try
			{
				fr.close();
			}catch (IOException e) {}
			catch (NullPointerException e) {}
		}
	}
}
