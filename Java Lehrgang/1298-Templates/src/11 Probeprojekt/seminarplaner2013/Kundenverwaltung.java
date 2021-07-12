package seminarplaner2013;

/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:14
 */
import java.util.*;
public class Kundenverwaltung {

	private Seminarplaner semPlaner;
	private KundenverwaltungView kdVerwView;

	/**
	 * 
	 * @param semPlaner der SeminarPlaner mit allen Listen
	 */
	public Kundenverwaltung(Seminarplaner semPlaner){
		this.semPlaner=semPlaner;
		this.kdVerwView=new KundenverwaltungView();
	}



	public void start(){
		
		int choice =kdVerwView.zeigeMenue();
		switch (choice){
		case 0:
			semPlaner.start();
			break;
		case 1:
			kundenListeAnzeigen();
			start();
			break;
		case 2:
			kundeLoeschen();
			start();
			break;
		case 3:
			kundeAendern();
			start();
			break;
		case 4:
			kundeHinzufuegen();
			start();
			break;
		default:
			semPlaner.start();
		break;
		}
	}

	/**
	 * Hier kann ein neuer Kunde hinzugefügt werden
	 */
	private void kundeHinzufuegen(){
		
		String name=kdVerwView.frageNachNeeded("Geben sie den Nachnamen ein : ");
		String vorname=kdVerwView.frageNachNeeded("Geben sie den Vorname ein : ");
		String ort=kdVerwView.frageNach("Geben sie den Ort ein : ");
		String plz=kdVerwView.frageNach("Geben sie die PLZ  ein : ");
		String strasse=kdVerwView.frageNach("Geben sie die Strasse ein : ");
		String hausnr=kdVerwView.frageNach("Geben sie die Hausnummer ein : ");
		
		this.semPlaner.getKunden().add(new Kunde(name,vorname,new Adresse(strasse, plz, ort, hausnr)));
		System.out.println("Kunde hinzugefügt!");
		
		
	}

	private void kundeAendern(){
		Kunde zuBearbeitenderKunde=kundeAuswaehlen();
		if(zuBearbeitenderKunde!=null){
		int choice=Integer.valueOf(kdVerwView.frageNach("Was soll geaendert werden? \n"
														+ "0. Abbrechen\n"
														+ "1. Name : "+zuBearbeitenderKunde.getName()+"\n"
														+ "2. Vorname : "+zuBearbeitenderKunde.getVorname()+"\n"
														+ "3. Ort : "+zuBearbeitenderKunde.getAdresse().getOrt()+"\n"
														+ "4. PLZ : "+zuBearbeitenderKunde.getAdresse().getPlz()+"\n"
														+ "5. Strasse : "+zuBearbeitenderKunde.getAdresse().getStrasse()+"\n"
														+ "6. HausNr. : "+zuBearbeitenderKunde.getAdresse().getHnr()));
		switch (choice){
		case 0:
			semPlaner.start();
			break;
		case 1:
			zuBearbeitenderKunde.setName(kdVerwView.frageNachNeeded("Geben Sie den neuen Namen ein :"));
			System.out.println("Daten geaendert!");
			break;
		case 2:
			zuBearbeitenderKunde.setVorname(kdVerwView.frageNachNeeded("Geben Sie den neuen Vornamen ein :"));
			System.out.println("Daten geaendert!");
			break;
		case 3:
			zuBearbeitenderKunde.getAdresse().setOrt(kdVerwView.frageNachNeeded("Geben Sie den neuen Ort ein :"));
			System.out.println("Daten geaendert!");
			break;
		case 4:
			zuBearbeitenderKunde.getAdresse().setPlz(kdVerwView.frageNachNeeded("Geben Sie die neue PLZ ein :"));
			System.out.println("Daten geaendert!");
			break;
		case 5:
			zuBearbeitenderKunde.getAdresse().setStrasse(kdVerwView.frageNachNeeded("Geben Sie die neue Strasse ein :"));
			System.out.println("Daten geaendert!");
			break;
		case 6:
			zuBearbeitenderKunde.getAdresse().setHnr(kdVerwView.frageNachNeeded("Geben Sie die neue Hausnummer ein :"));
			System.out.println("Daten geaendert!");
			default:
				semPlaner.start();
				break;
				
		}
		try{
			
		}catch(Exception e){
			System.out.println("Falsche Eingabe..Geben Sie eine Nummer ein!");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			kundeAendern();
		}}
		

	}

	private void kundeLoeschen(){
		Kunde k=kundeAuswaehlen();
		if(k!=null){
			for(int i=0;i<semPlaner.getKunden().size();i++){
				if(semPlaner.getKunden().get(i).getKdNr()==k.getKdNr()){
					semPlaner.getKunden().remove(i);
					System.out.println("Kunde geloescht");
				}
			}
		}
		
	}

	private void kundenListeAnzeigen(){
		String kundenuebersicht="";
		for(Kunde k:this.semPlaner.getKunden()){
			System.out.println(kundenuebersicht+=k.toString()+"\n");
		}
	}

	private Kunde kundeAuswaehlen(){
		Kunde k=null;
		kundenListeAnzeigen();
		int choice=Integer.valueOf(kdVerwView.frageNach("Geben Sie die Personalnummer an."));
		for(int i=0;i<semPlaner.getKunden().size();i++){
			if(semPlaner.getKunden().get(i).getKdNr()==choice){
				k=semPlaner.getKunden().get(i);
			}
		}
		return k;
	}
}//end Kundenverwaltung