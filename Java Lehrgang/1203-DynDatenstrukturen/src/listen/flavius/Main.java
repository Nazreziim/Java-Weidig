package listen.flavius;

public class Main {

	public static void main(String[] args) {
		Flavius fla = new Flavius();
		
		// alternativ können die Namen hier auch vom Benutzer eingegeben werden
		fla.aufnahme("Andreas");
		fla.aufnahme("Steve");
		fla.aufnahme("Stefan");
		fla.aufnahme("Frank");
		fla.aufnahme("Tino");
		fla.aufnahme("Norman");
		fla.aufnahme("Marco");
		fla.aufnahme("Lars");
		fla.aufnahme("_");
		
		fla.zaehleAus(3);
	}

}
