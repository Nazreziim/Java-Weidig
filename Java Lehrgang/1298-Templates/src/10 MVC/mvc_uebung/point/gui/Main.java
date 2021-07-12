package mvc_uebung.point.gui;

public class Main {

	public static void main(String[] args){
		Model m = new Model(640,480);
		Control c = new Control(m);
		OwnFrame f = new OwnFrame(m);
		c.letsGo();
	}
}
