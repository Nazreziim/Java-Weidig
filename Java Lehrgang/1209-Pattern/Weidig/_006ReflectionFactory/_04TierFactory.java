package _006ReflectionFactory;

public class _04TierFactory {

	public static _02Tier getTier(String tierart) {
		_02Tier tier = null;
		// ACHTUNG: Der Wert bei Class.forName muss der exakte Namen der Klasse sein
		// sonst wird eine unten angegebene Exception geworfen.
		
		//IF IST NUR FÜR MÖGLICHKEIT 4 WICHTIG
		if (tierart != null) {
			try {
				tier = (_02Tier) Class.forName("_006ReflectionFactory."+tierart).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return tier;

	}

}
