package abstrakteKlassen;

public class Main {
	public static void main(String[] args) {
		Ich ich = new Ich();
		
		//Nicht m�glich, da von abstrakten Klassen
		//keine Objekte erstellt werden k�nnen.
		//Mensch mensch = new Mensch();
		
		ich.sprechen();
		
		ich.essen();
		
		ich.trinken(1);
	}
}
