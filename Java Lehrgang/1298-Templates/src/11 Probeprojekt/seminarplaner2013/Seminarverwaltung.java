package seminarplaner2013;


/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:20
 */
public class Seminarverwaltung {

	private Seminarplaner semPlaner;
	private SeminarverwaltungView semVerwView;
	
	public Seminarverwaltung(Seminarplaner s){
		this.semPlaner = s;
		this.semVerwView = new SeminarverwaltungView();
	}

	public void start(){
		int auswahl = this.semVerwView.zeigeMenue();
		switch(auswahl) {
		case 1: 
			this.anlegen();
			break;
		case 2:	
			this.aendern();
			break;
		case 3:	
			this.loeschen();
			break;
		case 4:	
			this.zeigeAlle();
			break;
		case 5:	
			this.zeigeDetails();
			break;
		default:
			this.semPlaner.start();
		}
		
		
	}
	
	private void zeigeDetails() {
		int iD = -1;
		try {
		iD = Integer.parseInt(this.semVerwView.frageNach("Von welchem Seminar sollen die Details angezeigt werden? "));
		} catch(Exception e) {
			
		}
		if (iD >= 0 && iD <= this.semPlaner.getSeminare().size() && this.semPlaner.getSeminare().get(iD) != null) {
			this.semVerwView.zeige(this.semPlaner.getSeminare().get(iD).getDetails());
		}
		this.start();
	}

	private void zeigeAlle() {
		String s = new String();
		for (Seminar seminar : this.semPlaner.getSeminare()) {
			s +="Titel: " + seminar.getTitel() + "\tOrt: " + seminar.getOrt() + "\tDozent: " + seminar.getDoz() + "\tTeilnehmer: (" + seminar.getTeilnehmer().size() + "/" + seminar.getMaxAnz() + ")\n";
		}
		this.semVerwView.zeige(s);
		this.start();
	}

	private void anlegen(){
		Seminar neuesSeminar = new Seminar();
		neuesSeminar.setTitel(semVerwView.frageNach("Wie soll das Seminar heißen?"));
		neuesSeminar.setOrt(semVerwView.frageNach("Wo soll das Seminar stattfinden?"));
		
		String eingabe = semVerwView.frageNach("Geben Sie die Personalnummer des durchführenden Dozenten an.");
		while (eingabe.matches("\\d*")== false){
			
		};
		
		int dozNummer = Integer.parseInt(semVerwView.frageNach("Geben Sie die Personalnummer des durchführenden Dozenten an."));
		
		for (Dozent doz : semPlaner.getDozenten()){
			if (doz.getPersNr() == dozNummer){
				neuesSeminar.setDoz(doz);
				semPlaner.getSeminare().add(neuesSeminar);
				start();
			}
		}
		System.out.println("Dozent gibts nicht Alter!!!");
		start();
	}
	
	private void aendern(){
		int auswahl = Integer.parseInt(semVerwView.frageNach("Geben Sie die Seminarnummer ein."));
		for(Seminar seminar : semPlaner.getSeminare()){
			
			if (seminar.getId() == auswahl){
				auswahl = Integer.parseInt(semVerwView.frageNach("Was soll geändert werden? \n (1)Titel \n (2)Veranstaltungsort \n (3)Dozent \n (4) Teilnehmer hinzufügen \n (0)abbrechen"));
				
				while(auswahl != 1 || auswahl != 2 || auswahl != 3 || auswahl != 0){
					if (auswahl == 1){
						seminar.setTitel(semVerwView.frageNach("Geben Sie einen neuen Titel ein"));
					}
					else if(auswahl == 2){
						seminar.setOrt(semVerwView.frageNach("Geben Sie einen neuen Veranstaltungsort ein"));
					}
					else if(auswahl == 3){
						int num = Integer.parseInt(semVerwView.frageNach("Geben Sie eine neue Personalnummer ein"));
						for (Dozent doz : semPlaner.getDozenten()){
							if (doz.getPersNr() == num){
								seminar.setDoz(doz);
							}
						}
					}
					else if (auswahl == 4){
						auswahl = Integer.parseInt(semVerwView.frageNach("Bitte geben Sie die Kundennummer ein. (0) abbrechen"));
						if (auswahl == 0){
							start();
						}
						else{
							for (Kunde kunde : semPlaner.getKunden()){
								if (kunde.getKdNr() == auswahl)
									seminar.getTeilnehmer().add(kunde);
							}
						}
					}
					else if (auswahl == 0){
						start();
					}
					else{
						System.out.println("Diese Auswahl steht nicht zur verfügung");
					}
				}
			}
		}
		System.out.println("Seminarnummer ungültig");
		start();
	}
	
	private void loeschen(){
		int semNummer = Integer.parseInt(semVerwView.frageNach("Geben Sie die Nummer des Seminares ein, dass Sie LÖSCHEN wollen."));
		
		for(Seminar sem : semPlaner.getSeminare()){
			if (sem.getId() == semNummer){
				int auswahl = Integer.parseInt(semVerwView.frageNach("Sind Sie sicher das Sie das Seminar: " + sem.getTitel() + " löschen wollen? \n (1)ja \n (2)nein"));
				
				while(auswahl != 1 || auswahl != 2 || auswahl != 3 || auswahl != 0){
					if(auswahl == 1){
						for(int i = 0; i < semPlaner.getSeminare().size(); i ++){
							if (semPlaner.getSeminare().get(i).getId() == sem.getId()){
								semPlaner.getSeminare().remove(i);
							}
						}
					}
					else if(auswahl == 2){
						start();
					}
					else{
						System.out.println("Diese Auswahl steht nicht zur verfügung");
					}
				}
			}
		}
		System.out.println("Seminarnummer ungültig");
		start();
	}
}//end Seminarverwaltung