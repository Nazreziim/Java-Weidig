package loesung_klausur_2013;
import java.util.Arrays;
//Name:
//Dienstgrad:

public class Bundestag {
	private Politiker[] sitze;
	private Partei [] parteien;
	private final int anz_waehler = 43_601_224;
	
	public Bundestag(int anz, Partei[] parteien) {
		sitze = new Politiker[anz];
		this.parteien = parteien;
		sitzverteilung(anz_waehler);		
	}
	
	public int getAnzFreieSitze() {
		int freie_sitze = sitze.length;
		for (Partei p : parteien) {
			freie_sitze -= p.getAnzSitzeBundestag();			
		}
		return freie_sitze;
	}
	
	private void sitzverteilung(int anz_waehler) {
		int zaehler = 0;
		for (Partei p : parteien) {
			if (p != null) {
				// Feststellen wieviele Politiker jede Partei entsenden soll
				int anz = (int)(((float)p.getAnzStimmen() / anz_waehler) * sitze.length);
				p.setAnzSitzeBundestag(anz);
				Politiker[] politiker = p.sendePolitiker();
				
				// Politiker im Bundestag platzieren
				for (Politiker pol : politiker) {
					
					sitze[zaehler] = pol;
					zaehler++;
				}
			}
		}
		
	}

	public String toString() {
		return "Bundestag mit den Parteien: " + Arrays.toString(parteien);
	}


	
	
	

}
