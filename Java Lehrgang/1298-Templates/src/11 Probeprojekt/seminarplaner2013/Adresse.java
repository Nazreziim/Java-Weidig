package seminarplaner2013;

import java.io.Serializable;

/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:23
 */
public class Adresse implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6758811350932256152L;
	private String strasse;
	private String plz;
	private String ort;
	private String hnr;

	/**
	 * 
	 * @param strasse
	 * @param postleitzahl
	 * @param ort
	 * @param plz
	 * @param hausnummer
	 */
	public Adresse(String strasse,String postleitzahl,String ort,String hausnummer){
		this.strasse=strasse;
		this.plz=postleitzahl;
		this.ort=ort;
		this.hnr=hausnummer;
	}

//	Getter & Setter
	
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getHnr() {
		return hnr;
	}

	public void setHnr(String hnr) {
		this.hnr = hnr;
	}
	@Override
	public String toString() {
		return(" PLZ : "+plz+" Ort : "+ort+" Strasse : "+strasse+" HausNr : "+hnr);
	}

}//end Adresse