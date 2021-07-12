package b3Sichtbarkeit;
//package sichtbarkeit;

public abstract class Punkt2D {
	
	protected int x;  //nur in anderen Paketen nicht sichtbar; vererbbar
	
	int y; //paketsichtbar und nicht vererbt
	
	public Punkt2D(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	private void reset(){
		this.x = 0;
		this.y = 0;
	}
	
	protected void tausche(){
		int eimer = this.y;
		this.y = this.x;
		this.x = eimer;
	}
	
	// finale und statische Methode
	final static protected void schreibeUrsprung(){
		System.out.println("(0,0)");
	}
	
	// kovariante Rückgabe
	public Object gibPunkt(){
		return this;
	}
}
