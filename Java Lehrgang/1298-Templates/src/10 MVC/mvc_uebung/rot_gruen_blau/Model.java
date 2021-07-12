package mvc_uebung.rot_gruen_blau;



public class Model {

	private int rot = 0;
	private int grün = 0;
	private int blau = 0;
	private View view;
	
	public Model(){
	}
	
	public void setView(View view) {
		this.view = view;
		
	}

	public int getGrün() {
		return grün;
	}

	public void setGrün(int grün) {
		this.grün = grün%256;
		if(this.grün < 0){
			this.grün = 0;
		}
		this.view.update();
	}

	public int getBlau() {
		return blau;
	}

	public void setBlau(int blau) {
		this.blau = blau%256;
		if(this.blau < 0){
			this.blau = 0;
		}
		this.view.update();
	}

	public void setRot(int rot) {
		this.rot = rot%256;
		if(this.rot < 0){
			this.rot = 0;
		}
		this.view.update();
	}

	public int getRot() {
		return rot;
	}

	
	
	
}
