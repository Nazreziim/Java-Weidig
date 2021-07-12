package aufgaben;

public class ArrayReiseunternehmen {

	enum Aktionen {BUCHEN, STORNO, NEU, UEBERSICHT, ENDE}
	enum Wochentage {MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SAMSTAG, SONNTAG}
	
	public static void main(String[] args) {

		final int MAX_PLAETZE = 40;
		int[] bus = {0, 0, 0, 0, 0, 0, 0};
		int anzahlPlaetze = 0;
		Aktionen aktion = Aktionen.ENDE;
		Wochentage tag   = Wochentage.MONTAG;
		
		/*
		 *  Menueauswahl 
		 */
		
		do{
			System.out.println("Menueauswahl");
			System.out.println("============");
			for ( Aktionen uebersicht : Aktionen.values()){
				System.out.println(uebersicht.toString());
			}
			
			aktion = Aktionen.valueOf(HilfsMeth.readString("Waehlen Sie eine Aktion aus: "));
			
			
			switch (aktion){
				case BUCHEN:
					
					tag = Wochentage.valueOf(HilfsMeth.readString("Waehlen Sie einen Wochentag aus: "));
					anzahlPlaetze = HilfsMeth.readInt("Wie viele Plaetze wollen Sie buchen? ");
					
					if (bus[tag.ordinal()] + anzahlPlaetze <= MAX_PLAETZE){
						bus[tag.ordinal()] += anzahlPlaetze;
					}
					else{
						System.out.printf("Es koennen nur noch %d Plaetze fuer %s gebucht werden\n", MAX_PLAETZE - bus[tag.ordinal()], tag.toString() );
					}
					
					break;
					
				case STORNO:
					tag = Wochentage.valueOf(HilfsMeth.readString("Waehlen Sie einen Wochentag aus: "));
					anzahlPlaetze = HilfsMeth.readInt("Wie viele Plaetze wollen Sie stornieren? ");
					
					if (bus[tag.ordinal()] - anzahlPlaetze >= 0){
						bus[tag.ordinal()] -= anzahlPlaetze;
					}
					else{
						System.out.printf("Es koennen nur noch %d Plaetze fuer %s storniert werden.\n", bus[tag.ordinal()], tag.toString() );
					}
					
					break;
					
				case NEU:
					tag = Wochentage.valueOf(HilfsMeth.readString("An welchem Wochentag soll der Bus neu initialisiert werden? "));
					bus[tag.ordinal()] = 0;	
					break;
				
				case UEBERSICHT:
					tag = Wochentage.valueOf(HilfsMeth.readString("Waehlen Sie einen Wochentag aus: "));
					System.out.printf("Am %s sind %d Plaezte schon gebucht.\n", tag.toString(), bus[tag.ordinal()]);
					break;
					
				default:
			}
			
			System.out.println();
			
		}while( aktion != Aktionen.ENDE);
	}

}
