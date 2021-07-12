package loesung_klausur_2014.aufgabe5;

public abstract class Fussballspieler {
	private String name;
	private int nummer;
	protected int staerke; // Zwischen 0 = schwach und 100 = stark
	
	public Fussballspieler(String name, int nr) {
		this.name = name;
		this.nummer = nr; 
	}

	public Fussballspieler(String s) {
		name = s;
		this.nummer = 0;		
	}

	public String toString() {
		return "Mein Name ist " + name + ". Meine Rueckennummer ist " + nummer + ". Meine Staerke ist: " + staerke + ".";
	}
 
	public int getStaerke() {
		return staerke;
	}
	

}
