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
public class Bestellungen
{
	// Attribute
	private List<Bestellung> mListe = new ArrayList<Bestellung>();
	
	// Konstruktoren
	protected Bestellungen()
	{
		
	}
	/**
	 * Konstruktor für das Einlesen der vorhandenen Bestellungen
	 * @param pfadName Pfad zur Bestellungen-Datei.
	 */
	public Bestellungen(String pfadName)
	{
		EinlesenBestellungen(pfadName);
	}
	
	// Methoden 
	/*
	 * Bestellung hinzufügen.
	 */
	public void Add(Bestellung bestellung)
	{
		this.mListe.add(bestellung);
		
	}
		
	public int getCount()
	{
		return this.mListe.size();
	}
	
	public Bestellung getBestellung(int index)
	{
		return this.mListe.get(index);
	}
	
	private void EinlesenBestellungen(String pfadName)
	{
		java.io.BufferedReader br = null;
		java.io.FileReader fr = null;
		String zeile;
		
		try 
		{
			fr = new java.io.FileReader(pfadName);
			br = new java.io.BufferedReader(fr);
			
			while ((zeile = br.readLine())!= null)
			{
				try
				{
					this.mListe.add(new Bestellung(zeile));
				}
				catch (NullPointerException e)
				{
					System.out.println("Fehlerhafte Daten aus Bestellung entfernt!\n" + zeile);
				}
			}
		}
		catch (IOException e) {}
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
	
	public void SchreibenBestellungen(String pfadName)
	{
		java.io.FileWriter fw = null;
		java.io.BufferedWriter bwr = null;
		Integer anzahl = 1;
		
		try 
		{
			fw = new java.io.FileWriter(pfadName, false);	// true: Anfügemodus
			bwr = new java.io.BufferedWriter(fw);
			for(Bestellung item: this.mListe)
			{
				bwr.write(anzahl.toString());
				bwr.write(Bestellung.SEPARATOR);
				bwr.write(item.getFormatAusgabe());
				bwr.newLine();			// Betriebssystem unabhängiger Zeilenumbruch!	
				anzahl++;
			}
		} 
		catch (IOException e)
		{
			// e.printStackTrace();
		}
		finally
		{
			try
			{
				bwr.close();	// schreibt erst jetzt alle gepufferten Daten 
								// in die Datei (effektiver,da Daten gesammelt werden!)
			}catch (IOException e) {}
			try
			{
				fw.close();			
			}catch (IOException e) {}		
		}
	}
	
	/**
	 * Ausgabe der Bestellungen in Abhängigkeit des Parameters.
	 * @param nurNeueBestellungen true, nur neue Bestellungen,
	 * ansonsten alle bereits getätige Bestellungen.
	 */
	public void AusgabeDerBestellungen( boolean nurNeueBestellungen )
	{
		if (nurNeueBestellungen)
		{
			System.out.println("Neue Bestellungen!");
		}
		else
		{
			System.out.println("Bereits getätigte Bestellungen!");
		}
		System.out.println();
		
		for(Bestellung item: this.mListe)
		{
			if ( ( !nurNeueBestellungen ) || 
				 ( nurNeueBestellungen && item.IstNeueBestellung() ) )
			{
				System.out.println(item.getAusgabeBestellung());
			}
				
		}
		System.out.println();
	}
	/**
	 * Ausgabe aller Bestellungen
	 */
	public void AusgabeDerBestellungen()
	{
		AusgabeDerBestellungen(false);
	}
}