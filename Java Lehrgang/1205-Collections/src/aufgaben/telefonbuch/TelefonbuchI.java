package aufgaben.telefonbuch;

import java.util.HashMap;

public class TelefonbuchI {

	public static void main(String[] args) {
		HashMap<Name, Kontaktdaten> Telefonbuch = new HashMap<>();

		Name n1 = new Name("Adrian", "Weidig");
		Name n2 = new Name("Dominik", "Wente");
		Kontaktdaten k1 = new Kontaktdaten(132, "HIER");
		Kontaktdaten k2 = new Kontaktdaten(9876, "Dort");

		Telefonbuch.put(n1, k1);
		Telefonbuch.put(n2, k2);
		System.out.println(Telefonbuch);

		
		System.out.println(Telefonbuch.get(n1));
		//Funktioniert nicht, da es zwei verschiedene Namensobjekte sind
		System.out.println(Telefonbuch.get(new Name("Adrian", "Weidig"))); 

		Telefonbuch.remove(n2);
		System.out.println(Telefonbuch);
	}

}
