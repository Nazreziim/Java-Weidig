package client.local;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import client.Client;
import db.DBRecord;
import db.Data;
import db.RecordNotFoundException;


/**
 * A class which has direct access to the {@link Data} class. Instances of the class can
 * be used directly (as a local client created by the {@code ClientGUIController}). <br>
 * Thread safety is necessary when booking (or releasing) contractors because an instance of
 * this class may be used in server mode where multiple client requests can be performed at
 * the same time.
 * 
 * @author Lars Gerhard
 * @see Client
 */
public class LocalClient extends Client {

	// Reference to the Data object
	private Data d;

	// A lock to prohibit multiple client instances writing contractors data
	private static Lock lock = new ReentrantLock();
	
	private Logger log = Logger.getLogger("client.local"); 

	/**
	 * Creates a local client and the necessary Data object for direct file access
	 * 
	 * @param dbPath the path of the db file
	 */
	public LocalClient(String dbPath) {
		this.d = new Data(dbPath);
	}

	/**
	 * {@inheritDoc}
	 * This is done by calling the {@link Data#readRecord(long)} method
	 * and handling the possible {@link RecordNotFoundException}.
	 * 
	 * @return a String array containing the contractors data fields,
	 * null if a {@link RecordNotFoundException} has been thrown.
	 */
	@Override
	public String[] getContractor(Long no)  {		
		try {
			return d.readRecord(no);
		} catch (RecordNotFoundException e) {
			log.info("RecordNotFoundException while searching contractors: " + e.getMessage());
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * This is done by calling the {@link Data#getCache()} method and converting the
	 * received {@link DBRecord} elements to String[].
	 */
	@Override
	public Set<String[]> getAllContractors() {
		HashSet<String[]> erg = new HashSet<String[]>();
		for (DBRecord rec : d.getCache()) {
			erg.add(rec.toStringArray());
		}
		return erg;
	}

	/**
	 * {@inheritDoc}
	 * This is done in four steps:
	 * <ol>
	 * <li>Lookup the one and only matching contractor by calling {@link Data#findByCriteria(String[])}
	 * <li>Lock the found record by calling {@link Data#lockRecord(long)}
	 * <li>Update the record with the Customer ID passed as parameter by
	 * calling {@link Data#updateRecord(long, String[], long)}.
	 * <li>Unlocking the record in every case - even if a {@link RecordNotFoundException} or a 
	 * {@link SecurityException} has been thrown during the update.
	 * </ol>
	 * A {@link ReentrantLock} is used to secure the actual booking process.
	 */
	@Override
	public boolean bookContractor(String[] bookMe, String custID) {
		log.entering("LocalClient", "bookContractor");
		boolean erg = false;
		if (lock.tryLock()) {
			long[] found = d.findByCriteria(bookMe);
			try {
				if (found.length == 1) {
					long cookie = 0L;
					cookie = d.lockRecord(found[0]);
					bookMe[bookMe.length - 1] = custID;				
					d.updateRecord(found[0], bookMe, cookie);				
					erg = true;
					d.unlock(found[0], cookie);	
				} 
			} catch (RecordNotFoundException e) {
				log.info("RecordNotFoundException thrown: "+e.getMessage());				
			} catch (SecurityException e) {
				log.info("SecurityException thrown: " + e.getMessage());
			} finally {
				lock.unlock();
			}
			log.exiting("LocalClient", "bookContractor");
		}
		return erg;			
	}

	/**
	 * {@inheritDoc}
	 * This is done by a local call to {@link LocalClient#bookContractor(String[], String)}
	 * with an 8-spaces empty String passed as customer ID.
	 */	
	@Override
	public boolean releaseContractor(String[] releaseMe) {
		return bookContractor(releaseMe, "        ");
	}

}
