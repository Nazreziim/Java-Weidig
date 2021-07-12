package analyse;


public class AnalyseOOP {
	
	private String kreuzundquer = "kreuz";
	
	private AnalyseOOP nachfolger = this;
		
	public AnalyseOOP() {
		this.nachfolger = null;		
	}

	public AnalyseOOP(String name) {
		this.nachfolger = new AnalyseOOP();
	}
	
	public boolean setNachfolger(AnalyseOOP a4) {
		this.nachfolger = a4;
		return this.nachfolger == a4;
	}
	
	public String toString() {
		return this.kreuzundquer + " " + this.nachfolger;
	}
	
	public static void main(String args[] ) {
		AnalyseOOP a4 = new AnalyseOOP("Hallo Welt");
		AnalyseOOP a5 = new AnalyseOOP("Hallo Welt");
		a5.setNachfolger(a4);
		System.out.println(a5);
	}
}
