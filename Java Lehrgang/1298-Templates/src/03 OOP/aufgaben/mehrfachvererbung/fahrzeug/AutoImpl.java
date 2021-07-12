package fahrzeug;

public class AutoImpl implements Auto{

	private boolean closed;
	private double gewicht;
	
	public AutoImpl(double gewicht){
		this.gewicht = gewicht;
	}

	public boolean closeLock(boolean b){
		this.closed = b;
		return this.closed;
	}
	
	public double getGewicht(){
		return this.gewicht;
	}
	
}
