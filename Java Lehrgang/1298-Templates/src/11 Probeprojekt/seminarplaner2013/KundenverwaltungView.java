package seminarplaner2013;


public class KundenverwaltungView extends View {

	public KundenverwaltungView(){

	}

	
	public int zeigeMenue(){
		this.clearScreen();
		System.out.println("#################### Kundenverwaltung ######################");
		System.out.println("Was wollen Sie nun tun??");
		System.out.println("1. Alle Kunden anzeigen.");
		System.out.println("2. Einen Kunden loeschen.");
		System.out.println("3. Einen Kunden aendern.");
		System.out.println("4. Einen neuen Kunden anlegen");
		System.out.println("0. Abbrechen");
		
		return HilfsMeth.readInt("");
	}

	/**
	 * Diese Methode bekommt einen Text, der über die View ausgegeben werden soll und
	 * den Nutzer dazu auffordert eine bestimmte Eingabe zu machen. Diese Eingabe wird
	 * als return-Wert zurückgeliefert.
	 * 
	 * @param frage
	 */
	public String frageNach(String frage){
		return HilfsMeth.readString(frage);
	}


	public String frageNachNeeded(String string) {
		String tmp="";
			tmp=HilfsMeth.readString(string);
			if(tmp.length()==0){
				System.out.println("Du Depp!! Du Musst da schon was eingeben!..Nochmal bitte!");
				tmp=frageNachNeeded(string);
			}
			return tmp;
	}
}//end KundenverwaltungView