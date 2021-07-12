package db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * This class represents generally speaking any kind of records which can be stored in
 * a database. It can be seen as one single record entry. Therefore it consists of multiple
 * <code>[key, value]</code> pairs naming field names (or columns) of the table as "key" and the corresponding
 * content of the cell in the column as value (e.g. ["name","Fred &amp; Nobby"]). This kind
 * of structure can of course be used to store information about contractors, clients or any
 * other kind of pair-formatable information.<br>
 * In addition every {@link DBRecord} offers a boolean flag to indicate its deleted
 * state (accessible via getter / setter methods). As a consequence, deleted records are not
 * really deleted but only set on this state via the flag. Furthermore, an automatically 
 * generated key which makes a record unique identifiable is contained in every record. <br>
 * Objects of the class are serializable as it may be necessary to transfer them via network
 * to a server. 
 *  
 * @author Lars Gerhard
 * @see Serializable
 */
public class DBRecord implements Serializable{
	/** Version number for the class used for serialization */
	private static final long serialVersionUID = -5318071985794394373L;
	private static int number = 0;
	private int key;
	private LinkedHashMap<String,String> contents; //automated sorting is necessary
	private boolean deleted;
	
	/**
	 * Constructs a new {@link DBRecord} object with a predefined number of fields
	 * 
	 * @param fields the number of initial fields (can grow by inserting more entries)
	 * @param deleted the initial state of deletion (should be false in most cases)
	 */
	public DBRecord(int fields, boolean deleted) {
		key = number++;
		this.deleted = deleted;
		contents = new LinkedHashMap<>(fields);
	}
	
	/**
	 * Encapsulation of {@link LinkedHashMap#put(Object, Object)} method.
	 * 
	 * @param name The name of the record entry ("field").
	 * @param value The corresponding value for the given name.
	 * @return Either null if there was no value for the given name or the former
	 *  value if there was one (following the implementation of 
	 *  {@link LinkedHashMap#put(Object, Object)})
	 */
	public String addEntry(String name, String value) {
		return contents.put(name, value);
	}
	
	/**
	 * Getter for the records key
	 * 
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * Getter for the deleted flag of a record
	 * 
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * Setter for the deleted flag of a record
	 * 
	 * @param deleted true if the flag should be set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/** 
	 * Converts the record in a {@link String} representation. If the
	 * <code>deleted</code> flag is set, the String starts with a "!".
	 * 
	 * @return String value of the record
	 */
	@Override
	public String toString() {
		return (deleted ? "!" : " ") + "DBRecord Nr. " + key + " [contents=" + contents + "]";
	}
	
	/**
	 * Converts the values of the contents in the record to a String-array
	 * 
	 * @return Array containing all values as Strings
	 */
	public String[] toStringArray() {
		return new ArrayList<String>(contents.values()).toArray(new String[0]);		
	}
	
	/**
	 * A getter for all field names of a record. It wraps the {@link LinkedHashMap#keySet()} 
	 * method.
	 * 
	 * @return A set containing all field names of the {@link DBRecord} in the 
	 * order they have been inserted
	 * @see LinkedHashMap#keySet()
	 */
	public Set<String> getFieldNames() {
		return contents.keySet();
	}	
}
