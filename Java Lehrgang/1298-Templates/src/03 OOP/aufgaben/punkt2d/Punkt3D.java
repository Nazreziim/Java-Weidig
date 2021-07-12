package aufgaben.punkt2d;


class Punkt3D extends Punkt2D{
	public int z;
	
	public Punkt3D(){
		this(0,0,0);
	}
	
	public Punkt3D(int x, int y){
		super(x,y);
		this.z = 0;
	}
	
	public Punkt3D(int x, int y, int z){
		super(x,y);
		this.z = z;
	}
	
	public boolean equals(Object obj){
		boolean erg = false;
		if(obj instanceof Punkt3D){
			Punkt3D kuh = (Punkt3D) obj;
			erg = ( kuh.z == this.z && super.equals(obj));			
		}
		return erg;
	}	
	
	public String toString() {
		return "(" + this.x + "," + this.y + "," + this.z + ")";
	}
	
}
