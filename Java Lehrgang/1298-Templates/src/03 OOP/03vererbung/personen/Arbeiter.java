package vererbung.personen;



public class Arbeiter extends Person{
	public double gehalt;
	
	public Arbeiter(String vorname, String nachname, double gehalt){
		super(vorname, nachname);
		this.gehalt = gehalt;
	}
	
	public void zahlung(){
		System.out.println("Überweisen Sie " + gehalt);
	}

}
