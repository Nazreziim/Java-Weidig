package aufgaben.geometrie;

public class Punkt {
	
	private double x=0;
	private double y;
	private static int zaehler=0; 
	
	//Konstruktor
	public Punkt(double xNeu, double y){
		if(zaehler<100){
			this.x=xNeu;
			this.y=y;
			zaehler++;		
		}else{
			//Abbruch Fehlermeldung ausgeben
		}
	}
	
	protected void finalize(){
		zaehler--;
	}

	public static int getAnzahl(){
		return zaehler;
	}
		
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y; 
	}
	
	public void setX(double x){
		this.x=x;
	}
	
	public void setY(double y){
		this.y=y;
	}
	
	public void verschiebe(double umX, double umY){
		this.x=this.x+umX;
		this.y=this.y+umY;
	}
	
	public void ausgeben(){
		System.out.println("Punkt ("+this.getX()+" / "+this.getY()+")");
	}
	
	
	public double getAbstand(Punkt p){
		double abstand = Math.sqrt(
						Math.pow( (getX()-p.getX()),2)+
						Math.pow( (getY()-p.getY()),2)
						);
		return abstand;
	}
	
}
