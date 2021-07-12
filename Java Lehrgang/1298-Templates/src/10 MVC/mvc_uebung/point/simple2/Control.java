package mvc_uebung.point.simple2;



public class Control {
	private Model model;
	private View view;
	
	/**
	 * @param model
	 * @param view
	 */
	public Control(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	
	
	public void letItStart() {
		// TODO Auto-generated method stub
		for(int i=0;i<50;i++){
			this.model.move();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
