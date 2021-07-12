package client;

import java.util.Set;

import db.DBRecord;

/**
 * This class contains all the methods any client should implement.
 * 
 * @author Lars Gerhard
 */
public abstract class Client {
		
	/**
	 * Reads the data of one single data record. 
	 * 
	 * @param no the number of the record to be read
	 * @return the record data as a String array filled in the order as 
	 * stated in the db-schema description 
	 */
	public abstract String[] getContractor(Long no) ;

	/**
	 * Reads all records data out of the database an adds them to
	 * a set. 
	 * 
	 * @return a Set of String[] containing all data of the {@link DBRecord}
	 * objects currently in the database.
	 */
	public abstract Set<String[]> getAllContractors();
	
	/**
	 * Responsible for the booking of a record in the database. 
	 * 
	 * @param bookMe the data of the contractor to be booked in an array ordered
	 * like stated in the structure of the database
	 * @param custID the customer ID of the future "owner" of the contractor.
	 * This ID should normally be an 8-digit-number (as a String)
	 * @return true if booking was successful, false else
	 */
	public abstract boolean bookContractor(String[] bookMe, String custID);

	/**
	 * This method should handle the process of "unbooking" (or releasing)
	 * a contractor, which means that the owner attribute should be reset
	 * to an empty value. 
	 * 
	 * @param releaseMe the contractor data to be released passed as a String array
	 * ordered like stated in the structure of the database 
	 * @return true if the release was successful, false else
	 */
	public abstract boolean releaseContractor(String[] releaseMe);

	/**
	 * Empty implementation of a method which should be called 
	 * when the client is about to close down. It may contain
	 * necessary steps for example for disconnecting a network connection. An
	 * implementing class may not need to implement this method, if there are no
	 * special steps necessary (eg. when running in "standalone" mode). 
	 */
	public void shutDown() {
	}

}
