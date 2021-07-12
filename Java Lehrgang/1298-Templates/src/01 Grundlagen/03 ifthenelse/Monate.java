package ifthenelse;

public class Monate {
	public static void main(String[] args) {
		int eingabe = HilfsMeth.readInt("Monat: ");
		int tage = 0;
		switch (eingabe) {
			case 1 : {
					tage = 31;
					break;
				}
			case 2 :
				tage = 28;
				break;	
			case 3 :
				tage = 31;
				break;
			case 4 :
				tage = 30;
				break;
			case 5 :
				tage = 31;
				break;
			case 6 : tage = 30; break;
			case 7 :
				tage = 31;
				break;
			case 8 :
				tage = 31;
				break;
			case 9 :
				tage = 30;
				break;
			case 10 :
				tage = 31;
				break;
			case 11 :
				tage = 30;
				break;
			case 12 :
				tage = 31;
				break;
			default : 
				System.out.println("Ungültige Eingabe");
		}
		System.out.println(tage);
	}
}

