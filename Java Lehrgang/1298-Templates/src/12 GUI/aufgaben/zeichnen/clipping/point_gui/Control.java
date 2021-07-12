package aufgaben.zeichnen.clipping.point_gui;

public class Control {

	private Model model;
	
	public Control(Model model){
		this.model = model;
	}
	
	public void letsGo(){
		for(int i = 0 ; i < 10000; i++){
			this.model.move();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
