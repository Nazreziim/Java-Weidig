package listen.flavius;

public class Main {

	public static void main(String[] args) {
		Flavius fla = new Flavius();
		
		// alternativ können die Namen hier auch vom Benutzer eingegeben werden
		fla.nimm_auf("Andreas");
		fla.nimm_auf("Steve");
		fla.nimm_auf("Stefan");
		fla.nimm_auf("Frank");
		fla.nimm_auf("Tino");
		fla.nimm_auf("Norman");
		fla.nimm_auf("Marco");
		fla.nimm_auf("Lars");
		fla.nimm_auf("_");
		
		fla.zaehle_aus(3);
	}

}
