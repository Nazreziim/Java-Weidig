package verwaltung;

import java.util.Iterator;
import java.util.LinkedList;

import view.View;
import daten.Adresse;
import daten.Datenhaltung;
import daten.Dozent;
import daten.Seminar;
import daten.Teilnehmer;


/**
 * @author O. Schulz & B. Schuh
 * @version 1.0
 * @created 22-Jul-2014 11:56:48
 */
public class SeminarVerwaltung {

	private static SeminarVerwaltung svInstance;

	private SeminarVerwaltung(){
		
	}

	// Implementierung als Singleton
	
	public static SeminarVerwaltung getInstance(){
		if (svInstance != null){
			return svInstance;
		}
		else{
			return svInstance = new SeminarVerwaltung();
		}
	}

	/**
	 * 
	 * @param zuAenderndesSeminar
	 * @param titel
	 * 
	 */
	public void seminarBearbeiten(Seminar zuAenderndesSeminar, String titel){
		String alt = zuAenderndesSeminar.getTitel();
		zuAenderndesSeminar.setTitel(titel);
		View.show("Seminar " + alt + " wurde geändert in " + titel);
	}

	/**
	 * 
	 * @param zuAenderndesSeminar
	 * @param veranstaltungsort
	 */
	public void seminarBearbeiten(Seminar zuAenderndesSeminar, Adresse veranstaltungsort){
		zuAenderndesSeminar.setVeranstaltungsort(veranstaltungsort);
		View.show("Seminar " + zuAenderndesSeminar.getTitel() + " wurde verlegt nach " + veranstaltungsort.toString());
	}

	/**
	 * 
	 * @param zuAenderndesSeminar
	 * @param maxTeilnehmerAnzahl
	 */
	public void seminarBearbeiten(Seminar zuAenderndesSeminar, int maxTeilnehmerAnzahl){
		zuAenderndesSeminar.setMaxTeilnehmerZahl(maxTeilnehmerAnzahl);
		View.show("Seminar " + zuAenderndesSeminar.getTitel() + " kann jetzt maximal " + maxTeilnehmerAnzahl + " enthalten");
	}

	/**
	 * 
	 * @param zuAenderndesSeminar
	 * @param dozent
	 */
	public void seminarBearbeiten(Seminar zuAenderndesSeminar, Dozent dozent){
		zuAenderndesSeminar.setDozent(dozent);
		View.show("Seminar " + zuAenderndesSeminar.getTitel() + " wird jetzt geleitet von " + dozent.toString());
	}

	/**
	 * 
	 * @param titel
	 * @param veranstaltungsort
	 * @param anzahl
	 * @param dozent
	 */
	public Seminar seminarHinzufuegen(String titel, Adresse veranstaltungsort, int anzahl, Dozent dozent){
			Seminar erg = new Seminar(dozent, anzahl, titel, veranstaltungsort);
			MasterVerwaltung.getInstance().addSeminar(erg);
//			View.show("Seminar" + titel + "wurde hinzugefügt");
		return erg;
	}

	/**
	 * Ausgeben aller Seminare als Liste, es wird je Seminar nur der titel ausgegeben.
	 * 
	 * @param daten
	 */
	public void seminarListeAusgeben(Datenhaltung daten){
		LinkedList<String> erg = new LinkedList<String>();
		erg.add("Seminarliste");
		if (daten.getSeminare() != null){
		Iterator<Seminar> it = daten.getSeminare().iterator();
		while (it.hasNext()){
			erg.add(it.next().getTitel());
		}
		View.showListe(erg);
		}else{
			View.show("Es gibt noch keine Seminare" );
		}		
	}

	/**
	 * 
	 * @param neuerTeilnehmer
	 * @param zielSeminar
	 */
	public void seminarTeilnehmerHinzufuegen(Teilnehmer neuerTeilnehmer, Seminar zielSeminar){
		zielSeminar.getTeilnehmer().add(neuerTeilnehmer);
		View.show("Teilnehmer" +  neuerTeilnehmer.toString() +  " wurde zu Seminar" + zielSeminar.getTitel() + " hinzugefügt");
		
	}

	/**
	 * 
	 * @param zuLoeschenderTeilnehmer
	 * @param zielSeminar
	 */
	public void seminarTeilnehmerLoeschen(Teilnehmer zuLoeschenderTeilnehmer, Seminar zielSeminar){
		String alt = zuLoeschenderTeilnehmer.toString();
		zielSeminar.getTeilnehmer().remove(zuLoeschenderTeilnehmer);
		View.show("der Teilnehmer " + alt + " wurde aus Seminar " + zielSeminar.getTitel() + "gelöscht");
	}
}//end SeminarVerwaltung