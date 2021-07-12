package observer.version1;

public class View implements Observer{
	private Model model;
	
	public View(Model model){
		this.model=model;
		model.addObserver(this);
	}
	
	public void update(){
		System.out.println(model.getZaehler());
	}
}
