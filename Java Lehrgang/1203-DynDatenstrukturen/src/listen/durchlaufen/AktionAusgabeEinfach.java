package listen.durchlaufen;

public class AktionAusgabeEinfach implements Aktion {

	@Override
	public int aktion(int wert) {
		System.out.println("Wert ist " + wert);
		return wert;
	}

}
