package seminarplaner2013;

import java.io.Serializable;

/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:07
 */
public class Kunde extends Person{

	public static int id=0;
	
	private int kdNr;


	/**
	 * 
	 * @param name 		Nachname der Person
	 * @param vorname	Vorname der Person
	 * @param adresse	Adresse der Person
	 */
	public Kunde(String name,String vorname,Adresse adresse){
		super(name,vorname,adresse);
		this.kdNr=id+=1;					
	}
	
	
	
	public int getKdNr() {
		return kdNr;
	}

	public void setKdNr(int kdNr) {
		this.kdNr = kdNr;
	}



	@Override
	public String toString() {
		return ("KundenNr :"+ kdNr+ " Nachname :"+ this.getName()+" Vorname : "+this.getVorname()+ " Adresse :"+this.getAdresse().toString());
	}
	
	
}//end Kunde