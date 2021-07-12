package loesung_klausur_2014.aufgabe5;

public class Feldspieler extends Fussballspieler {
	public Feldspieler(String name, int nummer) {
		super(name, nummer);
		this.staerke = (int) (Math.random() * 100);
	}
	
	public Feldspieler(String name, int nummer, int staerke) {
		super(name, nummer);
		this.staerke = staerke;
	}
	
	public Feldspieler(String s){
		this(s, 0);
	}

	public String toString() {
		return super.toString() + " Ich bin ein Feldspieler.";
		
	}





}
