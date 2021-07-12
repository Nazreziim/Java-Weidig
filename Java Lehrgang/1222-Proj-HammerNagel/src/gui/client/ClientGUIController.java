package gui.client;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import client.Client;
import client.local.LocalClient;

/**
 * This class provides the linking functionality between the different kinds of clients
 * (which all derive from the abstract {@link Client} class) and the {@link ContractorsTableModel}
 * which is used by the GUI to provide the JTable with contents. Instantiation of this class 
 * should happen at a point where all the necessary information of the Swing elements (especially the
 * JTable) is visible. 
 * This class implements the {@link Observer} interface as it has to be informed about
 * changes made by the user in the configuration tab (this information will be stored 
 * in {@link SavedConfig} which is the corresponding {@link Observable} object).
 * 
 * @author Lars Gerhard
 * @see Client
 * @see ContractorsTableModel
 * @see Observer
 *
 */
class ClientGUIController implements Observer {

	private Client client;

	private Logger logger = Logger.getLogger("gui");

	/**
	 * Creates a GUIController object and starts the initialization of the {@link Client}.
	 * 
	 */
	ClientGUIController() {
		client = initClient();
	}

	/**
	 * Helper method to correctly initialize the {@link Client} object
	 * of this class according to the received {@link ClientGUIMode} parameter
	 * of the constructor. The appropriate properties for {@link LocalClient}
	 * and {@link SocketClient} are read from the {@link SavedConfig} singleton
	 * and passed to the constructors of these classes.<br>
	 * The described exception can only be thrown when initializing a 
	 * {@link SocketClient}.
	 * 
	 * @return An initialized {@link Client} object or null an error occurred.
	 * {@link ClientGUIMode#CLIENT_NETWORK} or {@link ClientGUIMode#CLIENT_STANDALONE}
	 */
	private Client initClient()  {
		Client ret;
		SavedConfig config = SavedConfig.getInstance();
		ret = new LocalClient(config.getProperty(SavedConfig.DB_PATH));
		return ret;
	}

	/**
	 * Retrieves the information of all contractors in the database
	 * (located either on the same machine or on the server for a network client)
	 * 
	 * @return a new {@link ContractorsTableModel} containing all contractors
	 * @see ContractorsTableModel
	 */
	public ContractorsTableModel getContractorsFromDB() {
		ContractorsTableModel erg = new ContractorsTableModel();
		Set<String[]> contr = client.getAllContractors();
		for (String[] rec : contr) {
			erg.addContractor(rec);			
		}
		return erg;
	}

	/**
	 * This method sets the db path property in the variable client objects by 
	 * reinitialzing the {@link Client}. Params as defined in
	 * {@link Observer} remain unused. <br>
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg){
		logger.log(Level.INFO,"GUI Configuration updated: " +
				"DB_PATH = " + SavedConfig.getInstance().getProperty(SavedConfig.DB_PATH));


		client = initClient();

	}

	/**
	 * Tries to book the selected contractor for the customer with the given id
	 * 
	 * @param bookMe all extracted values of the contractor
	 * @param custID the 8 digit id of the customer who wants to book the contractor
	 * @return true if booking was successful
	 */
	boolean bookContractor(String[] bookMe, String custID) {
		return client.bookContractor(bookMe, custID);
	}

	/**
	 * Tries to release the selected contractor (= "unbooking")
	 * 
	 * @param releaseMe all extracted values of the contractor
	 * @return true if the release was successful
	 */
	boolean releaseContractor(String[] releaseMe) {
		return client.releaseContractor(releaseMe);
	}

	/**
	 * Responsible for shutting down a clients instance. Can be initiated
	 * by the user for example by closing the window.
	 */
	void shutDown() {
		client.shutDown();
	}

}
