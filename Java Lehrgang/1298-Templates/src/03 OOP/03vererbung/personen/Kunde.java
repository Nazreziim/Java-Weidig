package vererbung.personen;


public class Kunde extends Person{
	public double rechnungsBetrag;
	
	public Kunde(String vorname, String nachname, double rechnungsBetrag){
		super(vorname, nachname);
		this.rechnungsBetrag = rechnungsBetrag;
	}
	
	public void zahlung(){
		System.out.println("Ich überweise " + rechnungsBetrag);	
	}


}
