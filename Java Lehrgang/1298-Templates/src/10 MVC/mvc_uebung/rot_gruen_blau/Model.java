package mvc_uebung.rot_gruen_blau;



public class Model {

	private int rot = 0;
	private int gr�n = 0;
	private int blau = 0;
	private View view;
	
	public Model(){
	}
	
	public void setView(View view) {
		this.view = view;
		
	}

	public int getGr�n() {
		return gr�n;
	}

	public void setGr�n(int gr�n) {
		this.gr�n = gr�n%256;
		if(this.gr�n < 0){
			this.gr�n = 0;
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
