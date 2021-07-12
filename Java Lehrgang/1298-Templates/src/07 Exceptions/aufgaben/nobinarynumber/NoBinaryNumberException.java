package aufgaben.nobinarynumber;

public class NoBinaryNumberException extends RuntimeException{

	private String binzahl;
	private int pos;
	
	
	public NoBinaryNumberException(String arg0) {
		super(arg0);
	}

	public NoBinaryNumberException() {

	}
	
	
	public NoBinaryNumberException(String binzahl, int pos) {
		this.binzahl = binzahl;
		this.pos = pos;		
	}

	
	public String getMessage() {
		return "Keine Binaerzahl: String ist an Position " + pos  + " fehlerhaft";
	}

	@Override
	public void printStackTrace() {
 
		super.printStackTrace();
	}

}
