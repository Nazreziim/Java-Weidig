public class Baum {
	Knoten wurzel;
	
	public Baum() {
		this.wurzel = null;
	}
	
	public String toString() {
		if(this.wurzel == null)
			return "Leerer Baum";
		
		return this.wurzel.toString();
	}
	
	public void add(int wert) {
		if(this.wurzel == null)
			this.wurzel = new Knoten(wert);
		else
			this.wurzel.addKnoten(wert);
	}
	
	public int hoehe() {
		if(this.wurzel == null)
			return 0;
		else
			return this.wurzel.hoeheKnoten();
	}
	
	public void loesche(int wert) {
		if(this.wurzel != null)
			this.wurzel = this.wurzel.loescheKnoten(wert);
	}
}
