package überschreiben;

public class Main {
	public static void main(String[] args) {
		//////////////////////////////////////////////
		// ÜBERSCHREIBEN VON toString
		//////////////////////////////////////////////
		ToString toStringObjekt = new ToString();
		
		toStringObjekt.setAlter(10);
		toStringObjekt.setName("Weidig");
		
		//Vor Überschreiben nur die Adresse des Objekts als String
		//Nach Überschreiben den definierten String
		System.out.println(toStringObjekt);
		
		//////////////////////////////////////////////
		// ÜBERSCHREIBEN VON EQUALS
		//////////////////////////////////////////////
		
		Equals equalsObjekt1 = new Equals();
		Equals equalsObjekt2 = new Equals();
		
		//WICHTIG:
		//Attribute wie Strings bzw. welche Objekte darstellen
		//Müssen initialisiert sein, da ansonsten null drinsteht
		//und beim Vergleich eine NullPointerException passiert
		
		equalsObjekt1.setName("Weidig");
		equalsObjekt2.setName("BERND");
		
		//Vor Überschreiben macht er einfach nur obj1 == obj2 --> false da es zwei unterschiedliche Objekte sind
		//Nach Überschreiben überprüft er die Inhalte die angegeben sind --> true da beide dem entsprechenden Inhalt entsprechen
		System.out.println(equalsObjekt1.equals(equalsObjekt2));
	}
}
