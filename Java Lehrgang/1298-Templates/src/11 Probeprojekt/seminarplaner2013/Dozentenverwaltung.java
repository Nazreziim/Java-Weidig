package seminarplaner2013;

import seminarplaner2013.DozentenverwaltungView;
/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:17
 */
public class Dozentenverwaltung {

	private Seminarplaner semPlaner;
	private DozentenverwaltungView dozVerwView;

	public Dozentenverwaltung(){

	}

	
	public Dozentenverwaltung(Seminarplaner s){
		this.semPlaner = s;
		this.dozVerwView= new DozentenverwaltungView();
	}

	public void start(){
		
		
		/**
		 * Anzeigen des Auswahlmenues der DozVerwaltung
		 */
		DozentenverwaltungView dozVerwView = new DozentenverwaltungView();
		int erg = dozVerwView.zeigeMenue();
		switch (erg){
			case 1: 
				dozentHinzufuegen();
				start();
			break;
			case 2: 
				dozentAendern();
				start();
			break;
			case 3: 
				dozentLoeschen();
				start();
			break;
			case 4: 
				dozentAuswaehlen();
				start();
			break;
			case 0:	
				semPlaner.start(); 
			break;
			default:
				
		}
	}
	private void dozentHinzufuegen(){

		String vorname = dozVerwView.frageNach("Gib den Vornamen ein: ");
		String name = dozVerwView.frageNach("Gib den Name ein: ");
		String strasse = dozVerwView.frageNach("Gib die Straße ein: ");
		String hsnr = dozVerwView.frageNach("Gib die Hausnummer ein: ");
		String plz = dozVerwView.frageNach("Gib die PLZ ein: ");
		String ort = dozVerwView.frageNach("Gib den Ort ein: ");
		String fachgebiet = dozVerwView.frageNach("Gib das Fachgebiet ein: ");
		//Dozent erstellen
		Adresse adrneu = new Adresse(strasse, hsnr, plz, ort);
		Dozent dozneu = new Dozent(vorname, name, adrneu, fachgebiet);
		
		//Dozent anlegen
		semPlaner.getDozenten().add(dozneu);
		System.out.println("Neuer Dozent wurde angelegt");
		this.start();
		
	}
	
	
	private Dozent dozentAuswaehlen(){
		int indexdoz = 0;
		// PersNr des Dozenten holen
		if(semPlaner.getDozenten().size() != 0){
			int chooseddoz = dozVerwView.zeigeListe(semPlaner.getDozenten());
			
			for(Dozent doz : semPlaner.getDozenten()){
				if(doz.getPersNr() == chooseddoz){
					//Index des Dozenten aus der ArrayList holen
					indexdoz = semPlaner.getDozenten().indexOf(doz);			
				}
			}
		}
		else{
			System.out.println("Liste ist leer");
			this.start();
		}
		
		//Dozent mit zuvor geprüftem Index zurückgeben
		return semPlaner.getDozenten().get(indexdoz) ;
	}
	
	private void dozentLoeschen(){
		
		semPlaner.getDozenten().remove(dozentAuswaehlen());
		this.start();
	}
	
	private void dozentAendern(){
		int changeattribute = 0;
		Dozent dozchange = dozentAuswaehlen();
		Adresse adressechange = dozchange.getAdresse();
		changeattribute = dozVerwView.frageNachAendern("Was wollen sie ändern: \n"
				+ "1. Vorname \n"
				+ "2. Name \n"
				+ "3. Straße \n"
				+ "4. Hausnummer /\n"
				+ "5. Plz \n"
				+ "6. Ort \n"
				+ "7. Fachgebiet");
		
		switch(changeattribute){
			case 1: dozchange.setName(dozVerwView.frageNach("Geben Sie den Namen ein"));
			System.out.println("Der Name wurde geändert");
			break;
			case 2: dozchange.setVorname(dozVerwView.frageNach("Geben Sie den Vornamen ein"));
			System.out.println("Der Vorname wurde geändert");
			break;
			case 3:
				adressechange.setStrasse(dozVerwView.frageNach("Geben Sie die Straße ein"));
				System.out.println("Die Strasse wurde geändert");
				dozchange.setAdresse(adressechange);
			break;
			case 4:
				adressechange.setHnr(dozVerwView.frageNach("Geben Sie die Hausnummer ein"));
				System.out.println("Die Hausnummer wurde geändert");
				dozchange.setAdresse(adressechange);
			break;
			case 5:
				adressechange.setPlz(dozVerwView.frageNach("Geben Sie die Plz ein"));
				System.out.println("Die Plz wurde geändert");
				dozchange.setAdresse(adressechange);
			break;
			case 6:
				adressechange.setOrt(dozVerwView.frageNach("Geben Sie den Ort ein"));
				System.out.println("Der Ort wurde geändert");
				dozchange.setAdresse(adressechange);
			break;
			case 7:
				dozchange.setFachgebiet(dozVerwView.frageNach("Geben Sie das Fachgebiet ein"));
				System.out.println("Das Fachgebiet wurde geändert");
			break;
			default:
				start();
		}
	}
}//end Dozentenverwaltung