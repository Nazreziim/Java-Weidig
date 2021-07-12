package aufgaben.geometrie2;
public class Kreis extends Figur{
	private double radius;
	
	public Kreis(double radius, Punkt p1){
		super(p1);
		this.radius = radius;
	}
	
	public Kreis(double radius, double x, double y){
		this(radius,new Punkt(x,y));
	}
	
	public double distance(Punkt p2){
		double dist = this.getP1().distance(p2) - this.radius;
		if(dist<0){
			dist=0;
		}
		return dist;
	}
	
	public void print(){
		System.out.println("Kreis: mit ID");
		//this.getP1().print();
		System.out.println((this.getP1()).getX().doubleValue());
		System.out.println("Radius:" + this.radius);

	}

}
