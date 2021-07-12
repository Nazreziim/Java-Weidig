package listen.durchlaufen;

public class AktionGroesstesElement implements Aktion {

	private int maxWert = Integer.MIN_VALUE;
	
	@Override
	public int aktion(int wert) {
		if ( maxWert < wert){
			maxWert = wert;
		}		
		return maxWert;
	}

}
