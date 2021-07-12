package vererbung.personen;

public abstract class Person{
	String vorname;
	String nachname;
	public Person(String vorname, String nachname){
		this.vorname = vorname;
		this.nachname = nachname;
	}
	public abstract void zahlung();
	
	public void sageName(){
		System.out.println("Ich heiﬂe" + vorname + " " + nachname);
	}
}
