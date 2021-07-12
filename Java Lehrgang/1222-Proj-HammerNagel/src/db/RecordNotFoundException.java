package db;

/**
 * This exception is thrown if a record does not exist or is marked
 * as deleted in the database file.
 * 
 * @author Lars Gerhard
 *
 */
public class RecordNotFoundException extends Exception {
	private static final long serialVersionUID = 9172845648588845215L;

	/**
	 * Creates a {@link RecordNotFoundException} with no argument
	 * by calling the super constructor
	 */
	RecordNotFoundException() {
		super();
	}

	/**
	 * Creates a {@link RecordNotFoundException} with a description
	 * passed as parameter by calling the super constructor.
	 * 
	 * @param s the description of the error
	 */
	RecordNotFoundException(String s) {
		super(s);
	}
}
