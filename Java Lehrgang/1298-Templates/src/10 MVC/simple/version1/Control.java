package simple.version1;

public class Control {
	private ModelInterface mdl;
	private ViewInterface v;
	
	public Control(ModelInterface m, ViewInterface v) {
		this.mdl = m;
		this.v = v;		
	}
	
	public void letsGo() {
		for (int i=0; i<100; i++) {
			this.mdl.inkr();
			this.v.show();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
