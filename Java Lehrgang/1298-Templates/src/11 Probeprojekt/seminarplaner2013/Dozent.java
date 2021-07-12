package seminarplaner2013;



/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:10
 */
public class Dozent extends Person {

	private static int count = 0;
	private int persNr;
	private String fachGebiet;

	public Dozent(String name, String vorname, Adresse adresse, String fachgebiet){
		super(name, vorname, adresse);
		this.persNr = ++count;
		this.fachGebiet = fachgebiet;
	}
	
	public int getPersNr(){
		
		return this.persNr;
	}
	
	public String getFachgebiet(){
		return this.fachGebiet;
	}
	
	public void setFachgebiet(String s){
		this.fachGebiet = s;
	}
	
	public String toString(){
		
		return "Dozent: " + this.getName() + ", " + this.getVorname() + ", Adresse: "
			    + this.getAdresse().toString() + ", Fachgebiet: " 
				+ this.getFachgebiet() + ", PersNr: " + this.getPersNr();
		
	}
	
	
}//end Dozent