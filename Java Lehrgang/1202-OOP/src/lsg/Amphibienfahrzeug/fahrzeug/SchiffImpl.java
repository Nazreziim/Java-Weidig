package lsg.Amphibienfahrzeug.fahrzeug;

public class SchiffImpl implements Schiff{

	private boolean gangwayClosed;
	private double gewicht;
	
	public SchiffImpl(double gewicht){
		this.gewicht = gewicht;
	}
	
	public boolean closeGangway(boolean b){
		this.gangwayClosed = b;
		return this.gangwayClosed;
	}	
	
	public double getGewicht(){
			return this.gewicht;
	}
}
