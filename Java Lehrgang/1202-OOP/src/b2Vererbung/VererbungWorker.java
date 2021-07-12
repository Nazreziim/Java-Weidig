package b2Vererbung;

public class VererbungWorker {

	public static void main(String[] args) {
		
		
		/*----------------
		 *  ARBEITER
		 * -------------------------*/
		 
		//Neues Objekt der Klasse Arbeiter erzeugen (erbt von Person)
		Arbeiter arbeiter = new Arbeiter("Hans","Mueller",30000.21);
		
		//Überweisung anstossen
		arbeiter.zahlung();
		
		//Geerbte Methoden aus Klasse Person aufrufen
		arbeiter.sageName();
		
		
		/*----------------
		 *  PERSON
		 * -------------------------*/
		
		
		//Versuch, ein Objekt der Klasse Person zu instanziieren (abstrakte Klasse, geht nicht!!!)
		//Person person = new Person();
		
		//Downcast des Arbeiter-Objekts in ein Objekt vom Typ Person
		Person person = (Person)arbeiter;
		
		//Aufruf der in Person implementierten Methode
		person.sageName();
		
		//Aufruf der Methode, welche in Klasse Arbeiter implementiert ist
		person.zahlung();
		
		
		
	}//main

}
