package exceptions;

public class DummerUserException extends Exception {
	public DummerUserException() {
		super();
	}
	
	public DummerUserException(String msg) {
		super(msg);
	}
}
