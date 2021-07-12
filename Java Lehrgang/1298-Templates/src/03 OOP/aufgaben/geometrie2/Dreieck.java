package aufgaben.geometrie2;
class Dreieck extends Figur{
	
	public Punkt p2;
	public Punkt p3;
	
	public Dreieck(Punkt p1, Punkt p2, Punkt p3){
		super(p1);
		this.p2 = p2;
		this.p3 = p3;
	}
	public Dreieck(){
		this(new Punkt(), new Punkt(), new Punkt());
	}
	
	public void print(){
		System.out.println("Dreieck: mit ID");
		this.getP1().print();
		p2.print();
		p3.print();
	}
	public void move(double x, double y){
		super.move(x,y);
		this.moveHilfe(x,y);
		p3.move(x,y);
	}
	private void moveHilfe(double x, double y){
		p2.move(x,y);
	}
}
