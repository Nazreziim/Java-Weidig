package aufgaben.geometrie2;
class Punkt{
	private Double x;
	private Double y;

	Punkt(){
		this.x = new Double(0.0);
		this.y = new Double(0.0);
	}
	Punkt(double x, double y){
		 this.x = x;
		 this.y = y;
	}
	
	public Double getX(){
		return x;
	}
	
	public Double getY(){
		return y;
	}
	public void setY(double y){
		this.y = y;
	}
	public void setX(double x){
		this.x = x;
	}
	public void move(double x, double y){
		this.x = this.x + x;
		this.y = this.y + y;
	}
	public double distance(Punkt p2){
		double c;
		double a = this.y - p2.getY();
		double b = this.x - p2.getX();
		c = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
		return c;		
	}
	
	public void print(){
		System.out.println(this + " x = " + this.getX() + " y = " + getY());
	}
}
