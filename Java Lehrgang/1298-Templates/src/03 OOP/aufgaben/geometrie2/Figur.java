package aufgaben.geometrie2;
class Figur{
	private Punkt p1;
	
	public Figur(Punkt p1){
		this.p1 = p1;
	}
	public Figur(){
		this(new Punkt(0.0,0.0));
	}
	public void print(){
		System.out.println("Figur mit den Punkt:");
		p1.print();
	}
	public void move(double x, double y){
		p1.move(x,y);
	}
	public Punkt getP1(){
		return this.p1;
	}
	
	
	
}
