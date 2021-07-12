package loesung_klausur_2013;
// Name:
// Dienstgrad:

public class Politiker {
	// Attribute
	private String name;
	private int gebjahr;	
	private Partei partei; 
	
	// Eine Konstante für das aktuelle Jahr und das Grundgehalt
	protected final int akt_jahr = 2013;
	private final double  grundgehalt = 2521.12;
	
	public Politiker(String name, int gebjahr) {
		this(name, gebjahr, null);
	}
	
	public Politiker(String name, int gebjahr, Partei partei) {
		this.name = name;
		this.gebjahr = gebjahr;
		this.partei = partei;
	}


	public double getGehalt() {
		return grundgehalt * Math.pow(1.02, akt_jahr - gebjahr);
	}

	public void setPartei(Partei partei) {
		this.partei = partei;
	}
	
	public String toString() {
		return "Mein Name ist "+ name + ". Ich bin " + (akt_jahr - gebjahr) + " Jahre alt und bin in der Partei " + partei.getName() + ". ";
	}

	
	
}
