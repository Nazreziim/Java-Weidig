package seminarplaner2012.view;

public class SeminarplanerView {
	public int menue(){
		int erg = -1;
		System.out.println("Seminarplaner");

		System.out.println("1 - Kundenverwaltung");
		System.out.println("2 - Dozentenverwaltung");
		System.out.println("3 - Seminarverwaltung");
		System.out.println("0 - Beenden");
		
		try{
			erg = HilfsMeth.readInt("Welches Menü wollen Sie aufrufen? ");
		}catch(Exception e){
			System.out.println("Sie dürfen nur die Zahlen 0 - 3 eingeben!");
		}
		
		return erg;
	}
}
