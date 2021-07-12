package seminarplaner2012.domain;


/**
 * @author c-ix-03-02
 * @version 1.0
 * @created 04-Mai-2012 09:48:44
 */
public abstract class Person {

	private String name;
	private String vorname;
	private String strasse;
	private String hnr;
	private String plz;
	private String stadt;

	public Person(){
		this.name = "";
		this.vorname = "";
		this.strasse = "";
		this.hnr = "";
		this.plz = "";
		this.stadt = "";
	}
	
	public Person(String name, String vorname, String strasse, String hnr, String plz, String stadt){
		this.name = name;
		this.vorname = vorname;
		this.strasse = strasse;
		this.hnr = hnr;
		this.plz = plz;
		this.stadt = stadt;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public String getStrasse() {
		return strasse;
	}

	public String getHnr() {
		return hnr;
	}

	public String getPlz() {
		return plz;
	}

	public String getStadt() {
		return stadt;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public void setHnr(String hnr) {
		this.hnr = hnr;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	
}