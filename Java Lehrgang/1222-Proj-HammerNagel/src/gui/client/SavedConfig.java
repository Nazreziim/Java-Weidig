package gui.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Observable;
import java.util.Properties;
import java.util.logging.Logger;


/**
 * This class stores the properties that can be set in the {@link ClientConfigPanel}.
 * It manages read and write operations to the config file on the hard disk to make
 * it possible to reload a setup after the restart of the application. The default
 * name of the config-file is <code>settings.ini</code>.
 * The SavedConfig class extends the Observable inteface as it is necessary for other
 * classes (like the {@link ClientGUIController}) to be informed about changes in the current
 * configuration.
 * 
 * @author Lars Gerhard
 * @see Observable
 */
public class SavedConfig extends Observable {

	//Global variables for file access
	private static final String BASE_DIR = System.getProperty("user.dir");
	private static final String CONFIG_FILENAME = "config.ini";

	private static File propFile = new File(BASE_DIR, CONFIG_FILENAME);

	//Global variables for the properties
	private Properties prop = null;

	public static final String DB_PATH = "dbPath";

	// Global instance for the singleton pattern
	private static SavedConfig instance;

	// Logging
	private Logger log;

	/**
	 * Creates the SavedConfig instance. As there should only be one instance
	 * this constructor is declared private. Tries to load a previously saved
	 * configuration. If none is found the path of the db-file is set to
	 * <code>.\data.db</code>.
	 */
	private SavedConfig() {
		log = Logger.getLogger("hammernagel.gui");
		//		log.setUseParentHandlers(true);
		prop = loadFromFile();
		if (prop == null) {
			prop = new Properties();
			prop.setProperty(DB_PATH, System.getProperty("user.dir")+"\\data.db");
			saveToFile();
		}
	}

	/**
	 * Getter for the singleton instance of SavedConfig
	 * 
	 * @return the instance
	 */
	public static SavedConfig getInstance() {
		if (instance == null) {
			instance = new SavedConfig();
		}
		return instance;
	}


	/**
	 * Saves all the properties to a file for reuse after a restart of the 
	 * application
	 */
	private void saveToFile() {		
		try {
			synchronized (propFile) {
				if (propFile.exists()) {
					propFile.delete();
				}
				propFile.createNewFile();
				OutputStream out = new FileOutputStream("config.ini");
				prop.store(out, "Hammer & Nagel Configuration");				
				out.close();
			}			
		} catch (FileNotFoundException e) {
			log.severe("Properties file not found: " + propFile.getName() + "\n" + e.getMessage());			
		} catch (IOException e) {
			log.severe("IOException for properties file " + propFile.getName() + "\n" + e.getMessage());
		}
		log.exiting("SavedConfig", "saveToFile");
	}

	/**
	 * Tries to load all the properties from the properties-file on the disk
	 * 
	 * @return Instance of <code>Properties</code> or null
	 * @see Properties
	 */
	private Properties loadFromFile() {
		Properties loadedProp = null;
		if (propFile.exists() && propFile.canRead()) {
			synchronized(propFile) {
				InputStream in = null;
				try {
					in = new FileInputStream(propFile);
					loadedProp = new Properties();
					loadedProp.load(in);
					in.close();
				} catch (FileNotFoundException e) {
					log.severe("Properties file not found: " + propFile.getName() + "\n" + e.getMessage());		
				} catch (IOException e) {
					log.severe("IOException for properties file " + propFile.getName() + "\n" + e.getMessage());
				}
			}
		}
		log.exiting("SavedConfig", "loadFromFile");
		return loadedProp;
	}

	/**
	 * Getter for a properties value
	 * 
	 * @param propName the name of the property
	 * @return the corresponding value for the property, null if property does not exist
	 */
	public String getProperty(String propName) {
		return prop.getProperty(propName);
	}

	/**
	 * Sets a new property or updates an old one and immediately saves the new value to
	 * the properties file. 
	 * 
	 * @param propName the name of the property
	 * @param propValue the value which should be stored for the property
	 */
	public void setProperty(String propName, String propValue) {
		prop.setProperty(propName, propValue);
		saveToFile();
		this.setChanged();
		this.notifyObservers();

	}

}
