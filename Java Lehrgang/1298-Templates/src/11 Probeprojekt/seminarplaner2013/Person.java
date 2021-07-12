package seminarplaner2013;


import java.io.Serializable;

import seminarplaner2013.Adresse;

/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:09
 */
public class Person implements Serializable{

	private static final long serialVersionUID = -1554918503484630331L;
	private String name;
	private String vorname;
	private Adresse adresse;

	public Person(String name,String vorname,Adresse adresse){
			this.name=name;
			this.vorname=vorname;
			this.adresse=adresse;
	}
	
	
	
	//Getter & Setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}//end Person