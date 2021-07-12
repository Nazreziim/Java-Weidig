package aufgaben.adressbuch;

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

	}

}
