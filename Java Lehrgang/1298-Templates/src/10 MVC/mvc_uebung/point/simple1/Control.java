package mvc_uebung.point.simple1;

public class Control {

	private Model model;
	private View view;
	
	public Control(Model model, View view){
		this.view = view;
		this.model = model;
	}
	
	public void letsGo(){
		for(int i = 0 ; i < 100; i++){
			this.model.move();
			this.view.update();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
