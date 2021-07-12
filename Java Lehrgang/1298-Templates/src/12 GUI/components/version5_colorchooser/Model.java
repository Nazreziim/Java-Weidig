package components.version5_colorchooser;


import java.util.Observable;



public class Model extends Observable{

	private int rot = 0;
	private int gruen = 0;
	private int blau = 0;
	
	public Model(){
	}
	

	public int getGruen() {
		return gruen;
	}

	public void setGruen(int gruen) {
		this.gruen = gruen%256;
		if(this.gruen < 0){
			this.gruen = 0;
		}
		this.setChanged();
		this.notifyObservers();
	}

	public int getBlau() {
		return blau;
	}

	public void setBlau(int blau) {
		this.blau = blau%256;
		if(this.blau < 0){
			this.blau = 0;			
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void setRot(int rot) {
		this.rot = rot%256;
		if(this.rot < 0){
			this.rot = 0;
			
		}
		this.setChanged();
		this.notifyObservers();
	}

	public int getRot() {
		return rot;
	}


	
	
	
}
