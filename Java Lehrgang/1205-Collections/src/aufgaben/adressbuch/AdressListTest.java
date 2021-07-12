package aufgaben.adressbuch;

import java.util.Collections;
import java.util.Comparator;

public class AdressListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AdressList ad = new AdressList();
		
		ad.insert(new Kontakt("Gerhard","Lars","123455","Tutzinger Str.", "46"));
		ad.insert(new Kontakt("Borkowitz","Daniel","3341475","Tutzingerstr.", "49"));
		ad.insert(new Kontakt("Gerhard","ars","2655","Tutzinger Str.", "46"));
		ad.insert(new Kontakt("Palm","Wolfgang","2651","Tutzinger Str.", "46/26"));
		ad.printAdr();
		ad.delete(new Kontakt("Gerhard","ars","2655","Tutzinger Str.", "46"));
		ad.printAdr();
		
		System.out.println();
		Kontakt such = ad.sucheAdr("Gerhard","Lars");
		if (such != null){
			such.printKontakt();
		}
		System.out.println();
		
		AdressList ad1 = new AdressList(new ComparatorTelefonNr());
		ad1.insert(new Kontakt("Gerhard","Lars","123455","Tutzinger Str.", "46"));
		ad1.insert(new Kontakt("Borkowitz","Daniel","3341475","Tutzingerstr.", "49"));
		ad1.insert(new Kontakt("Gerhard","ars","2655","Tutzinger Str.", "46"));
		ad1.insert(new Kontakt("Palm","Wolfgang","2651","Tutzinger Str.", "46/26"));
		ad1.printAdr();
		
		AdressList ad2 = new AdressList(Collections.reverseOrder(new ComparatorTelefonNr()));
		ad2.insert(new Kontakt("Gerhard","Lars","123455","Tutzinger Str.", "46"));
		ad2.insert(new Kontakt("Borkowitz","Daniel","3341475","Tutzingerstr.", "49"));
		ad2.insert(new Kontakt("Gerhard","ars","2655","Tutzinger Str.", "46"));
		ad2.insert(new Kontakt("Palm","Wolfgang","2651","Tutzinger Str.", "46/26"));
		ad2.printAdr();
		
		
	}

}
