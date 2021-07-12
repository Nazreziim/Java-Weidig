package templates;



public class Template07KontrollstrukturSwitch1 {
	
	public static void main(String[] args) {
		//FINAL ist wichtig, da hier �berpr�ft wird ob
		//ein identischer Typ ("Mai" --> "Mai" z.B.)
		//bereits vorhanden ist. Final sorgt daf�r,
		//dass der Typ unver�nderlich bleibt.
		//N�her bei OOP
		final String Mai = "Mai"; // ist auch moeglich! 
		String monat = HilfsMeth.readString("Monat: ");
		int tage = 0;
		
		switch (monat)
		{
			case "Januar":
			case "M�rz":
			case  Mai:
			case "Juli":
			case "August":
			case "Oktober":
			case "Dezember":
				tage = 31;
				break;
			case "Februar":
				tage = 28;
				break;
			case "April":
			case "Juni":
			case "September":
			case "November":
				tage = 30;
				break;
			default:
				tage = 0;
		}
		
		// Ausgabeteil
		if (tage != 0){
			System.out.println("Der Monat: "+ monat + " hat " +  tage + " Tage."); 
		}
		else{
			System.out.println("Kein gueltiger Monat");
		}
	}
}

