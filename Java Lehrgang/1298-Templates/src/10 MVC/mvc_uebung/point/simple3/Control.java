package mvc_uebung.point.simple3;



public class Control {
	private Model model;
	private View view;
	private static int i = 0;
	/**
	 * @param model
	 * @param view
	 */
	public Control(Model model, View view) {
		this.model = model;
		this.model.setControl(this);
		this.view = view;
	}
	
	
	
	public void oneStep() {
		// TODO Auto-generated method stub
		
			i++;
			this.model.move();
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}



	public void iamReady() {

		this.view.update();
		if(i<50){
			this.oneStep();
		}
		
	}



	public void letItStart() {
		this.oneStep();
		
	}
	
}
