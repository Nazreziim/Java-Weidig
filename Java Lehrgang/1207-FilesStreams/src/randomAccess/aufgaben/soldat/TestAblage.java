package randomAccess.aufgaben.soldat;

import java.io.File;
import java.util.*;

public class TestAblage {

	public static void main(String[] args) {
		Soldat s1 = new Soldat("Schulze", "Sebastian", "030484-S-XXXXX", "Hptm");
		Soldat s2 = new Soldat("Gerhard", "Lars", "211183-G-XXXXX", "Hptm");
		List<Soldat> s_liste = new ArrayList<Soldat>();
		s_liste.add(s1);
		s_liste.add(s2);
		String dateiname = "./src/dateien/soldaten.dta";
		
		Ablage.speichern(s_liste, new File(dateiname));
		

	}

}
