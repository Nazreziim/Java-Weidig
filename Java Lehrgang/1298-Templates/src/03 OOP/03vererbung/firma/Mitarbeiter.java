package vererbung.firma;

public class Mitarbeiter{
	
	private int persNr;
	private int dabei;
	private double gehalt;
	private String vorname;
	private String nachname;
	private String posten;
	
	public Mitarbeiter(int persNr, int dabei, double gehalt, String vorname, String nachname, String posten){
		this.persNr = persNr;
		this.dabei = dabei;
		this.gehalt = gehalt;
		this.vorname = vorname;
		this.nachname = nachname;
		this.posten = posten;
	}
	public Mitarbeiter(){
		this(-1, 2200, 0.0, "Max", "Mustermann", "ohne");
	}
	
	public Mitarbeiter(int persNr, int dabei, String vorname, String nachname){
		this(persNr,dabei,0.0, vorname,nachname, "ohne");
	}
	
	public void print(){
		System.out.println("Mitarbeiter: "+this.vorname+" "+this.nachname);
		System.out.println("\t\tPosten: "+this.posten);
		System.out.println("\t\tGehalt: "+this.gehalt);
		System.out.println("\t\tDabei seit: "+this.dabei);
	}
	public void setNachname(String name){
		this.nachname=name;
	}
	
	public void setVorname(String name){
		this.vorname=name;
	}
	public void update(String vorname, String nachname){
		this.setNachname(nachname);
		this.setVorname(vorname);
	}
	
	public int getPersNr(){
		return persNr;
	}
}
