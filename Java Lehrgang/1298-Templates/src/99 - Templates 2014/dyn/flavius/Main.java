public class Main {

	public static void main(String[] args) {
		Flavius fla = new Flavius();
		
		// alternativ können die Namen hier auch vom Benutzer eingegeben werden
		for(int i=0; i<=40; i++) {
			fla.nimm_auf("Person " + i);
		}
		fla.nimm_auf("_");
		
		fla.zaehle_aus(3);
	}

}

