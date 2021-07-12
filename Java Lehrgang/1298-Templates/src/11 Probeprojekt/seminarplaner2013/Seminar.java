package seminarplaner2013;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:13
 */
public class Seminar implements Serializable{

	private static final long serialVersionUID = 3733273359039627614L;
	private ArrayList<Kunde> teilnehmer;
	private String ort;
	private String titel;
	private Dozent doz;
	private int maxAnz;
	
	private static int id = 1;

	public int getId() {
		return id;
	}

	public Seminar(){
		this.id = this.id++;
	}

	public ArrayList<Kunde> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(ArrayList<Kunde> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Dozent getDoz() {
		return doz;
	}

	public void setDoz(Dozent doz) {
		this.doz = doz;
	}

	public int getMaxAnz() {
		return maxAnz;
	}

	public void setMaxAnz(int maxAnz) {
		this.maxAnz = maxAnz;
	}

	public String getDetails() {
		String erg = "Titel: " + titel + ", Ort: " + ort + ", Dozent: " + this.doz.getName() + ", Teilnehmer:\n";
		for (int i = 0; i < this.teilnehmer.size(); i++) {
			if (i%3 == 0) {
				erg += "\n";
			}
			erg += "Nr: " + this.teilnehmer.get(i).getKdNr() + " " + this.teilnehmer.get(i).getVorname() + " " + this.teilnehmer.get(i).getName();
		}
		return erg;
	}
	
	public String toString() {
		return "ID: " + this.id + "\tTitel: " + this.titel + "\tOrt: " + this.ort + "\tDozent: " + this.doz + "\t Teilnehmer: (" + this.teilnehmer.size() + "/" + this.maxAnz + ")";
	}
	
}//end Seminar