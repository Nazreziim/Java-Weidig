package _005Factory;

public class _04TierFactory {

	public static _02Tier getTier(String tierart) {
		_02Tier tier = null;
		switch (tierart) {
		case "Hund":
			tier = new _03Hund();
			break;
		case "Katze":
			tier = new _03Katze();
			break;
		case "Maus":
			tier = new _03Maus();
			// Zum Zeigen von Reflection im nächsten Schritt wird der hier zurückgegebene
			// Name zurückgegeben.
			// System.out.println(tier.getClass().getTypeName());
			break;
		}
		return tier;
	}

}
