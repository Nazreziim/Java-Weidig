package simple.version1;

public class AndereView implements ViewInterface {

	private ModelInterface mdl;
	
	public AndereView(ModelInterface m) {
		this.mdl = m;
	}
	
	
	@Override
	public void show() {
		for (int i=0; i < this.mdl.getCtr(); i++) {
			System.out.print("#");
		}
		System.out.print("\n");

	}

}
