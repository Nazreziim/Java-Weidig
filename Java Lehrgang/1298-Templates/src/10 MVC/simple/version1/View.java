package simple.version1;

public class View implements ViewInterface {
	private ModelInterface mdl;
	
	public View(ModelInterface m) {
		this.mdl = m;		
	}
	
	@Override
	public void show() {
		System.out.println("Der Zähler beträgt: " + mdl.getCtr());
	}

}
