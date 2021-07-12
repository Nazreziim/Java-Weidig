package db;

/**
 * This record is thrown if a {@link DBRecord} is about to be created
 * with a record number which is already in use.
 * 
 * @author Lars Gerhard
 *
 */
public class DuplicateKeyException extends Exception {

	private static final long serialVersionUID = -6689165809485807888L;

	/**
	 * Creates a {@link DuplicateKeyException} with no argument by
	 * calling the super constructor.
	 */
	DuplicateKeyException() {
		super();
	}

	/**
	 * Creates a {@link DuplicateKeyException} with an error message
	 * passed as argument by calling the super constructor.
	 * 
	 * @param s the description of the error that has occurred.
	 */
	DuplicateKeyException(String s) {
		super(s);
	}
}
