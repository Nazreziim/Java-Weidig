package db;

/**
 * This interface defines all the methods which has to implemented
 * by a class that wants to access the database file. <br>
 * This interface was provided by Oracle as stated in the 
 * instructions. The only changes that have been made are
 * the javadoc comments!
 * 
 * @author Oracle instructions
 */
public interface DBAccess
{
	/**
	 * Reads a record from the file. Returns an array where each
	 * element is a record value.
	 * 
	 * @param recNo the number of the record to be read
	 * @return a String array containing the data of the read record
	 * @throws RecordNotFoundException if the record number has not 
	 * been found or if the record is set as deleted
	 */
	public String [] readRecord(long recNo)
			throws RecordNotFoundException;


	/**
	 * Modifies the fields of a record. The new value for field n 
	 * appears in data[n]. Throws SecurityException
	 * if the record is locked with a cookie other than lockCookie.
	 * 
	 * @param recNo the number of the record to be updated
	 * @param data the new data which should be written to the record
	 * @param lockCookie the locking cookie which is needed no edit
	 * the records contents
	 * @throws RecordNotFoundException if the record number has not 
	 * been found or if the record is set as deleted
	 * @throws SecurityException if the locking cookie is wrong.
	 */
	public void updateRecord(long recNo, String[] data, long lockCookie)
			throws RecordNotFoundException, SecurityException;

	/**
	 * Deletes a record, making the record number and associated disk
	 * storage available for reuse. 
	 * Throws SecurityException if the record is locked with a cookie
	 * other than lockCookie.
	 * 
	 * @param recNo the number of the record to be deleted
	 * @param lockCookie the locking cookie which is needed no gain
	 * access to the record
	 * @throws RecordNotFoundException if the record number has not 
	 * been found or if the record is set as deleted
	 * @throws SecurityException if the locking cookie is wrong.
	 */
	public void deleteRecord(long recNo, long lockCookie)
			throws RecordNotFoundException, SecurityException;


	/** Returns an array of record numbers that match the specified
	 * criteria. Field n in the database file is described by
	 * criteria[n]. A null value in criteria[n] matches any field
	 * value. A non-null  value in criteria[n] matches any field
	 * value that begins with criteria[n]. (For example, "Fred"
	 * matches "Fred" or "Freddy".)
	 * 
	 * @param criteria A String array containing the search criteria
	 * @return A long array with all record numbers that match the
	 * passed criteria
	 */
	public long[] findByCriteria(String[] criteria);

	/** Creates a new record in the database (possibly reusing a
	 * deleted entry). Inserts the given data, and returns the record
	 * number of the new record. 
	 * 
	 * @param data a String array containing the data for the record
	 * that is about to be created
	 * @return the number of the new record as a long value
	 * @throws DuplicateKeyException if the record number is already
	 * by another record
	 */
	public long createRecord(String [] data)
			throws DuplicateKeyException;


	/** Locks a record so that it can only be updated or deleted by this client.
	 * Returned value is a cookie that must be used when the record is unlocked,
	 * updated, or deleted. If the specified record is already locked by a different
	 * client, the current thread gives up the CPU and consumes no CPU cycles until
	 * the record is unlocked.
	 * 
	 * @param recNo the number of the record to be locked
	 * @return the generated locking cookie as a long value
	 * @throws RecordNotFoundException if the record could not be found or is set
	 * as deleted
	 */
	public long lockRecord(long recNo)
			throws RecordNotFoundException;


	/** Releases the lock on a record. Cookie must be the cookie
	 * returned when the record was locked; otherwise throws SecurityException. 
	 * 
	 * @param recNo the number of the record to be unlocked
	 * @param cookie the locking cookie which is was generated when locking
	 * the record
	 * @throws SecurityException if the locking cookie which has been passed
	 * does not match.
	 */
	public void unlock(long recNo, long cookie)
			throws SecurityException;


}