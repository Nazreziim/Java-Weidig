package table.version4;

public class Main {
	public static void main(String[] args){
		ModelImpl model = new ModelImpl();
		ViewImpl view = new ViewImpl(model);
		ControlImpl control = new ControlImpl(model, view);
	}
}
