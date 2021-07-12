package _005Factory;

public class _01Main {

	public static void main(String[] args) {
		_02Tier hund = _04TierFactory.getTier("Hund");
		_02Tier katze = _04TierFactory.getTier("Katze");
		_02Tier maus = _04TierFactory.getTier("Maus");
		
		hund.macheGeräusche();
		katze.macheGeräusche();
		maus.macheGeräusche();

	}

}
