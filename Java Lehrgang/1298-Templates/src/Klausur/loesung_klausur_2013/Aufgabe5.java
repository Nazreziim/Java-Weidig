package loesung_klausur_2013;
// Name:
// Dienstgrad:
public class Aufgabe5 {
	static Bundestag bt;
	
	public static void main(String[] args) {
		// Aufgabenteile 1 und 2
		// Unser Vierparteiensystem:
		Partei cdu = new Partei("CDU/CSU", "konservativ");
		Partei linke = new Partei("Die Linke", "links");
		Partei spd = new Partei("SPD");
		spd.setAusrichtung("sozialdemokratisch");
		Partei fdp = new Partei("FDP", "liberal");	
		// Wahlergebnis 2013:			
		cdu.setAnzStimmen(16_225_769);
		spd.setAnzStimmen(12_835_933);
		fdp.setAnzStimmen(1_028_322);
		linke.setAnzStimmen(3_583_050);
		
		Politiker seehofer = new Politiker("Horst Seehofer", 1949, cdu);
		System.out.println(seehofer);
		Politiker steinbrueck = new Politiker("Peer Steinbrueck", 1947);
		steinbrueck.setPartei(spd);
		System.out.println(steinbrueck);
		Minister bruederle = new Minister("Rainer Brüderle", 1945, "Wirtschaft",fdp);
		bruederle.setImAmtSeit(2009);		
		System.out.println(bruederle);
		
		// Aufgabenteil 3
		// Formatierte Ausgabe des Gehalts (5 Stellen vor, 2 Stellen nach dem Komma)
		System.out.printf("Steinbrueck verdient: %5.2f Euro", steinbrueck.getGehalt());
		System.out.printf("Bruederle verdient: %5.2f Euro", bruederle.getGehalt()); 
				
		// Aufgabenteil 4
		// Parteien im Bundestag vorstellen:
		Partei[] parteien= {cdu, fdp, spd, linke};
		bt = new Bundestag(630, parteien);
		System.out.println(bt.getAnzFreieSitze());
	
	}

}
