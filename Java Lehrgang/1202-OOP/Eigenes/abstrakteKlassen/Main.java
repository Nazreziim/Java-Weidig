package abstrakteKlassen;

public class Main {
	public static void main(String[] args) {
		Ich ich = new Ich();
		
		//Nicht möglich, da von abstrakten Klassen
		//keine Objekte erstellt werden können.
		//Mensch mensch = new Mensch();
		
		ich.sprechen();
		
		ich.essen();
		
		ich.trinken(1);
	}
}
