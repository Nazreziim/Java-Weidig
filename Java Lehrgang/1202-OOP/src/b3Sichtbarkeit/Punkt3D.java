package b3Sichtbarkeit;
//package sichtbarkeit;

public class Punkt3D extends Punkt2D{
	
	private int z;
	
	public Punkt3D(int x, int y,int z){
		super(x,y);
		this.z = z;
	}
	
	public void reset(){
		//super.reset(); // geht nicht, da private
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	//soll überschreiben, ist aber falsch geschrieben
	@Override
	protected void tausche(){
		int eimer = this.x;
		this.x = this.y;
		this.y = this.z;
		this.z = eimer;
	}
	
	public String toString(){
		return "(" + this.x + "," + this.y + "," + this.z + ")";
	}
}
