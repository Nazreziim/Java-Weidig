package loesung_klausur_2014.aufgabe5;

public class Torwart extends Fussballspieler {
	public Torwart(String name, int nr) {
		super(name, nr);
		int zufall = (int) (Math.random() * 100 + 20);
		if (zufall <= 100) {
			this.staerke = zufall;
		} else {
			this.staerke = 100;
		}
	}
	

	public String toString() {
		return super.toString() + " Ich bin Torwart! ";
	}



}
