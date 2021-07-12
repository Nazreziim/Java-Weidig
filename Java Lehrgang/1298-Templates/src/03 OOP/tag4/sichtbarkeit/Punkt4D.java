package tag4.sichtbarkeit;
//package sichtbarkeit;

public class Punkt4D extends Punkt3D{
	public int a;
	
	//public Punkt4D(){	}  // geht nicht, weil kein annonymer Super-Konstruktor
	
	public Punkt4D(int x, int y, int z, int a){
		super(x,y,z);
	}
	
	public static void main(String[] args){
		//Punkt2D p2 = new Punkt2D(1,2);
		//System.out.println(p2.x + " " + p2.y);
		
		Punkt3D p3 = new Punkt3D(1,2,3);
		//System.out.println(p3.x + " " + p3.y + " " + p3.z); // geht nicht, da z in p3 private ist
		//System.out.println(p3);
		
		
		//Aufruf der kovarianten Methode
		//Punkt2D neu = (Punkt2D) p2.gibPunkt();
		
		System.out.println(p3);
		p3.reset();
		System.out.println(p3);
		
		Punkt3D komisch = new Punkt3D(1,2,3);
		//System.out.println(komisch);
		komisch.tausche();
		//System.out.println(komisch);
		p3.schreibeUrsprung();
	}
	
	/* geht nicht, da final
	public static void schreibeUrsprung() {
		System.out.println("(0,0,0)");
	}
	*/
}
