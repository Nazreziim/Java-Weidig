package daten;

import java.io.Serializable;
import java.util.Set;




/**
 * @author c-ix-03-11
 * @version 1.0
 * @created 22-Jul-2014 11:56:42
 */
public class Seminar implements Serializable{
	private static final long serialVersionUID = -6432630695061963283L;
	private Dozent dozent;
	private int maxTeilnehmerZahl;
	private Set<Teilnehmer> teilnehmer;
	private String titel;
	private Adresse veranstaltungsort;

	public Seminar(){
		
	}


	@Override
	public String toString() {
		String erg = "";
		String teilnehmerNamen = "";
		if(teilnehmer == null){
		erg =  "Titel: " + titel + "	Dozent: " + dozent.getName() + "," + dozent.getVorname() +"\n"+ veranstaltungsort+"\n"+"Max. Teilnehmer"+maxTeilnehmerZahl ;
		
		}else{
			//Liest die teilnehmerliste aus wenn vorhanden und schreibt die namen in einen String
			for (Teilnehmer t : teilnehmer){
				teilnehmerNamen += t.getName() + ", " + t.getVorname() + "\n";
			}
		erg = 	"Titel: " + titel + "	Dozent: " + dozent.getName()+ ", " + dozent.getVorname() + "\n" + veranstaltungsort+"\n" + "Max. Teilnehmer: " + maxTeilnehmerZahl+ "\n" + teilnehmerNamen;
		}
		return erg;
	}


	public Seminar(Dozent dozent, int maxTeilnehmerZahl,String titel, Adresse veranstaltungsort) {
		super();
		this.dozent = dozent;
		this.maxTeilnehmerZahl = maxTeilnehmerZahl;
		this.titel = titel;
		this.veranstaltungsort = veranstaltungsort;
	}
	
	
	public Dozent getDozent() {
		return dozent;
	}

	public void setDozent(Dozent dozent) {
		this.dozent = dozent;
	}

	public int getMaxTeilnehmerZahl() {
		return maxTeilnehmerZahl;
	}

	public void setMaxTeilnehmerZahl(int maxTeilnehmerZahl) {
		this.maxTeilnehmerZahl = maxTeilnehmerZahl;
	}

	public Set<Teilnehmer> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(Set<Teilnehmer> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Adresse getVeranstaltungsort() {
		return veranstaltungsort;
	}

	public void setVeranstaltungsort(Adresse veranstaltungsort) {
		this.veranstaltungsort = veranstaltungsort;
	}
	


}//end Seminar