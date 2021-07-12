package mvc_uebung.rot_gruen_blau;


public class View {
	private Model model;
	
	public View(Model model){
		this.model = model;
		this.model.setView(this);
	}
	
	
	public void update(){
		System.out.println();
		
		System.out.println("Der Rot-Anteil betr�gt " + model.getRot() );
		System.out.println("Der Blau-Anteil betr�gt " + model.getBlau() );
		System.out.println("Der Gr�n-Anteil betr�gt " + model.getGr�n() );
		
	}
}
