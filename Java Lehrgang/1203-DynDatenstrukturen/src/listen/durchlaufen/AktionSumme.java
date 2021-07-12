package listen.durchlaufen;

public class AktionSumme implements Aktion {

	private int summe;
	
	public AktionSumme() {
		super();
		this.summe = 0;
	}
	
	@Override
	public int aktion(int wert) {
		this.summe += wert;
		return this.summe;
	}

}
