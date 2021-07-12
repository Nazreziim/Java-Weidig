package observer.version1;

public class Control {
	private Model model;
	private View view;
	
	public Control(Model model, View view){
		this.model=model;
		this.view=view;
	}
	
	public void begin(){
		int anzahl = HilfsMeth.readInt("Anzahl der Erhoehungen?");
		for(int i=0;i<anzahl;i++){
			model.erhoehe();
		}
	}
	
}
