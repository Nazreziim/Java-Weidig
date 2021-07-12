package aufgaben.santa;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Hauptklasse des Santa-Clause-Problems (ein Thread)
 * beschrieben unter: http://www.youtube.com/watch?v=pqO6tKN2lc4
 * 
 * Diese Version arbeitet komplett ohne Synchronisationshilfsmittel, da:
 * 1.) Santa die komplette Steuerung des Ablaufs übernimmt! Insbesondere werden alle Counter nur von Santa
 * 		verwaltet - was hier eine Synchronisation unnötig macht!
 * 2.) Rendeer und Elf beide mit künstlichen Wartezeiten versehen sind, um so Deadlocks vermeiden.
 * 
 * 
 * TODO: 
 * Synchronisierung der noch verbliebenen gemeinsam genutzten Ressourcen: 
 * 1.)	Rendeer.onVacation - Schreibzugriffe in Rendeer.run, Santa.uhitchSleigh() -> Rendeer.getUnhitched()
 * 2.)  Elf.hasAProblem - Elf.run(), Santa.helpElves() -> Elf.solveProblem()
 * 3.)  Die Behandlung wartender Elfen ist nicht fair - wenn eine Elfe ein Problem hat
 * 		und der Puffer für die Hilfe von Santa (elves_needing_help) voll ist, dann kann
 * 		es sein, dass sich beim Leeren des Puffers andere Elfen vordrängeln. 
 *  	
 * 
 * @author LGerhard
 * @version 2013-10-11
 *
 */
public class Santa extends Thread {
	
	//Problem-Parameter
	private static final int RENDEER_NUMBER = 9;
	private static final int ELVES_NUMBER = 10;
	private static final int ELVES_TO_BE_HELPED = 3;
	private final int NUMBER_OF_YEARS; 
	
	//Container
	private List<Rendeer> rendeers = new ArrayList<Rendeer>();
	private List<Elf> elves = new ArrayList<Elf>();
	private List<Elf> elves_needing_help = new ArrayList<Elf>();
	
	/**
	 * Konstruktor - hier erfolgen die Aufrufe zum Erzeugen von Elfen und Rentieren.
	 * Außerdem wird der Santa-Thread gestartet
	 */
	public Santa(int number_of_years) {
		this.NUMBER_OF_YEARS = number_of_years;
		this.start();
		createRendeer();
		createElves();
	}

	/**
	 * Hilfsmethode, die entsprechend der Prorammparameter Elfen erzeugt
	 */
	private void createElves() {
		for (int i=0; i < ELVES_NUMBER; i++) {
			elves.add(new Elf());
		}
		
	}

	/**
	 * Hilfsmethode, die entsprechend der Prorammparameter Rentiere erzeugt
	 */
	private void createRendeer() {
		for (int i=0; i < RENDEER_NUMBER; i++) {
			Rendeer r = new Rendeer();
			rendeers.add(r);
		}
	}

	public void run() {
		for(int y = 0 ; y < NUMBER_OF_YEARS; y++) {
		//while(true) {
			System.out.println("Santa: Zzzzzzzzzzzz.....");
			gotoSleep(5000);
			
			// Zähle, wieviele Rentiere aus dem Urlaub zurück sind
			int rendeers_back_from_vacation = 0;			
			for (Rendeer r : rendeers) {
				if (!r.isOnVacation()) {
					rendeers_back_from_vacation++;
				}
			}
			
			
			// Prüfe alle Elfen, ob sie Hilfe benötigen - falls ja
			// können diese in die entsprechende Liste übernommen werden
			// (bis zur vorgegebenen Obergrenze)
			for (int i=0; i < elves.size(); i++) {
				Elf e = elves.get(i);
				if (e.hasAProblem() && elves_needing_help.size() < ELVES_TO_BE_HELPED) {
					elves.remove(e);
					elves_needing_help.add(e);	
					// System.out.println("Elf " + e.getElfId() + " in die Hilfeschlage!");
				}
			}
						
			// Alle Rentiere aus dem Urlaub zurück
			if (rendeers_back_from_vacation == RENDEER_NUMBER ) {				
				prepSleigh();
				System.out.println("Santa: Es ist Weihnachten! Los gehts - Geschenke verteilen!");
				System.out.println("Santa: Vielen Dank für die Hilfe, liebe Rentiere - bis nächstes Jahr");
				unhitchSleigh();
				
			}
			
			// Es warten genügend Elfen, um Santa zu wecken
			if (elves_needing_help.size() == ELVES_TO_BE_HELPED) {
				helpElves();
			}
			
		}
		
	}
	
	/**
	 * Methode, um den Elfen zu helfeen ihre Probleme zu lösen
	 */
	private void helpElves() {
		System.out.println("Santa: Ich helfe den Elfen!");
		// String aufbauen, der die Nummern der bedienten Elfen enthält
		String elve_numbers = "";
		for (Elf e : elves_needing_help) {
			elve_numbers += e.getElfId();
			if (elves.indexOf(e) < ELVES_TO_BE_HELPED - 1) {
				elve_numbers += ", ";
			}	
		}
		
		// Die Probleme der Elfen lösen:
		for (int i = 0; i < elves_needing_help.size(); i++) {
			Elf e = elves_needing_help.remove(0);
			e.solveProblem();	
			elves.add(e);
		}
		System.out.println("Santa: Ich habe den Elfen " + elve_numbers + " geholfen.");									
	}

	/**
	 * Methode zum einspannen der Rentiere - ruft auf jedem getHitched() auf
	 */
	private void prepSleigh() {
		System.out.println("Santa: Rentiere einspannen!");
		for (Rendeer r : rendeers) {
			r.getHitched();
		}
		System.out.println("Santa: Alle Rentiere eingespannt!");		
	}

	/**
	 * Methode, mit der alle Rentiere wieder aus dem Schlitten ausgespannt werden
	 */
	private void unhitchSleigh() {
		System.out.println("Santa: Rentiere ausspannen!");
		for (Rendeer r : rendeers) {
				r.getUnhitched();
		}
		System.out.println("Santa: Alle Rentiere ausgespannt!");		
	}
	
	/**
	 * Diese Methode schickt den Santa-Thread schlafen
	 * TODO: Durch das Pausieren werden Deadlocks möglichst vermieden - sollte also auch ohne gehen!
	 * @param long millis - Die Mindestdauer in Millisekunden
	 */
	private void gotoSleep(long millis) {
		try {
			Thread.sleep((long)(Math.random() * millis));
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
	}
	
}
