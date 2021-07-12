package verwaltung;

import java.util.LinkedList;

import view.View;
import daten.Adresse;
import daten.Datenhaltung;
import daten.Teilnehmer;
import daten.Seminar;

/**
 * @author c-ix-03-11
 * @version 1.0
 * @created 22-Jul-2014 11:56:53
 */
public class TeilnehmerVerwaltung {

	private static TeilnehmerVerwaltung tvInstance;

	private TeilnehmerVerwaltung(){
		
	}

	/**
	 * Methode erzeugt ein Object von TeilnehmerVerwaltung tvInstance, wenn es noch nicht existiert 
	 * oder leifert das Object von TeilnehmerVerwaltung tvInstance zurück
	 * @return
	 */
	public static TeilnehmerVerwaltung getInstance(){
		if(tvInstance == null)
			return tvInstance = new TeilnehmerVerwaltung();
		else
			return tvInstance;
	}

	/**
	 * 
	 * @param name
	 * @param vorname
	 * @param adr
	 */
	public Teilnehmer teilnehmerHinzufuegen(String name, String vorname, Adresse adr){
		Teilnehmer neuerTeilnehmer = new Teilnehmer(name, vorname, adr);
		
		return neuerTeilnehmer;
	}
	
	/**
	 * Methode zur Änderung des Namens name des Teilnehmer tln
	 * @param tln
	 * @param name
	 */
	public void teilnehmerBearbeitenName(Teilnehmer tln, String name)
	{
		String name_alt = tln.getName();
		tln.setName(name);
		
		View.show("Teilnehmer " + name_alt + " wurde geaendert zu " + tln.getName());
	}
	
	/**
	 * Methode zur Änderung des Vornamens vorname des Teilnehmer tln
	 * @param tln
	 * @param vorname
	 */
	public void teilnehmerBearbeitenVorname(Teilnehmer tln, String vorname){
		String vorname_alt = tln.getVorname();
		tln.setVorname(vorname);
		
		View.show("Teilnehmer " + tln.getName() + vorname_alt + " wurde geaendert zu " + tln.getName() + tln.getVorname());
		
	}
	
	/**
	 * Methode zur Änderung der Adresse adr des Teilnehmers tln
	 * @param tln
	 * @param adr
	 */
	public void teilnehmerBearbeitenAdresse(Teilnehmer tln, Adresse adr)
	{
		tln.setAdresse(adr);
		
		View.show("Adresse wurde geaendert zu: \n" + tln.getAdresse());
		
	}
	/**
	 * Methode fügt einen Teilnehmer tln zu einem Seminar sem hinzu
	 * @param sem
	 * @param tln
	 */
	public void teilnehmerZuSeminarHinzufuegen(Seminar sem, Teilnehmer tln)
	{
		SeminarVerwaltung seminar = SeminarVerwaltung.getInstance();
		
		seminar.seminarTeilnehmerHinzufuegen(tln, sem);
	}

	/**
	 * Bastelt aus der List in der Datenhaltung einen String, der für eine mögliche
	 * Ausgabe zurückgeliefert wird
	 * 
	 * @param daten
	 */
	public void teilnehmerListeAusgeben(Datenhaltung daten){
		LinkedList<String> teilnehmerListe = new LinkedList<>();
		teilnehmerListe.add("Teilnehmerliste");
	
		if(daten.getTeilnehmer() != null)
		{
			for(Teilnehmer t : daten.getTeilnehmer())
			{
				teilnehmerListe.add(t.toString());
			}
			
		}
		
		View.showListe(teilnehmerListe);
		
	}
}//end TeilnehmerVerwaltung