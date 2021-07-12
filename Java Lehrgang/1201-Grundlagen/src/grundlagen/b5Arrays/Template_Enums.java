package grundlagen.b5Arrays;

public class Template_Enums {

	public enum Farben {ROT, GRUEN, BLAU, WEISS, SCHWARZ;

		public static Farben value(int i) {
			
			Farben farbe = null;
			
			if ( i >= 0 && i < Farben.values().length) {
				farbe = Farben.values()[i];
			}
					
			return farbe;
		}
	}
	
	public enum Wochentage { Montag, Dienstag, Mittwoch, Donnerstag, Freitag, Samstag, Sonntag }
	
	
	public static void main(String[] args) {
		
		 System.out.println("Ausgabe aller Farben:");
		 
		 for ( Farben farbe : Farben.values()){
			 System.out.println(farbe.toString());
		 }
		 
		 System.out.println( "Position im Aufzaehlungstypen: " + Farben.BLAU.ordinal() );
		 
		 Farben farbe = Farben.valueOf(HilfsMeth.readString("Geben Sie eine Farbe ein:").toUpperCase());

		 switch (farbe){
		 	case ROT:
			 // Aktion
		 		System.out.println("Sie haben die Farbe: rot gewaehlt");		 		
			 break;
		 	case GRUEN:
		 	case BLAU:
		 		System.out.println("Sie haben die Farbe: gruen oder blau gewaehlt");
		 		break;
		 	case WEISS:
		 	case SCHWARZ:
		 		System.out.println("Sie haben die Farbe: weiss oder schwarz gewaehlt");
		 		break;
		 }
		 
		 System.out.println("Sie haben die Farbe: " + Farben.value(farbe.ordinal()).toString() + " gewaehlt");
		 // Index: 10 ist ungueltig
		 System.out.println("Sie haben die Farbe: " + Farben.value(10) + " gewaehlt");
		 	 
	}
}
