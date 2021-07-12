package gui.client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.AppStarter;

/**
 * The main frame for the client-side GUI, consists simply of a TabbedPane 
 * containing separate panels for the list of the contractors extracted from 
 * the database {@link ClientContractorsPanel}) and configurations which 
 * can be made by the user ({@link ClientConfigPanel}). <br>
 * This class also creates the {@link ClientGUIController} which acts as a
 * mediator between the GUI and the client instances.
 * 
 * @author Lars Gerhard
 * @see ClientConfigPanel
 * @see ClientContractorsPanel
 */
public class ClientFrame extends JFrame {

	private static final long serialVersionUID = 5899985547394951510L;
	private ClientGUIController controller;
	private boolean configMode = false;

	/**
	 * A Listener for the event fired when the user wants to close the application either
	 * by a button in menu entry or by clicking the cross on the upper right corner
	 * of the application
	 * 
	 * @author Lars Gerhard
	 * @see ActionListener
	 * @see WindowAdapter
	 */
	private class QuitApplicationActionListener extends WindowAdapter implements ActionListener {
		/**
		 * Handles the event of the File-Quit menu item or the ordinary closing
		 * of the window.
		 * 
		 * @param e the event passed when selecting the menu entry (will be ignored!)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.shutDown();
			System.exit(0);			
		}

		/**
		 * Handles the event of closing the window. 
		 * Calls {@link QuitApplicationActionListener#actionPerformed(ActionEvent)}
		 * with a null value as passed ActionEvent
		 * 
		 * @param e the event passed when closing the window (will be ignored!)
		 */
		@Override
		public void windowClosing(WindowEvent e) {
			actionPerformed(null);

		}		
	}

	/**
	 * A Listener for events fired when switching the tabs of the TabbedPane
	 * 
	 * @author Lars Gerhard
	 */
	private class TabbedPaneChangeListener implements ChangeListener {
		@Override
		/**
		 * This method refreshes the JTable in case the first Tab (which should
		 * contain the table) is selected. In the unlikely case that either the source
		 * of the event was not the JTabbedPane or the first tab does not contain
		 * the ClientContractorsPanel nothing will happen.
		 * 
		 * @param e the ChangeEvent which is sent when the state of JTabbedPane changes
		 */
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() instanceof JTabbedPane) {
				JTabbedPane tp = (JTabbedPane)e.getSource();
				if (tp.getSelectedIndex() == 0) {
					if (tp.getComponentAt(0) instanceof ClientContractorsPanel) {
						((ClientContractorsPanel)tp.getComponentAt(0)).refreshTable();
					}
				}
			}
		}
	}

	/**
	 * Constructs a ClientFrame Window and tries to initialize the {@link ClientGUIController}.
	 * If an exception is thrown while doing this (e.g. when the server location is not
	 * correct or the server is not running) a message box with a description
	 * of the error is shown to the user by using the 
	 * {@link AppStarter#handleException(String)} method. After such a message the
	 * frame will start in "config mode" which means that only the {@link ClientConfigPanel}
	 * is displayed and enables the user to enter valid configuration information.
	 * 
	 */
	public ClientFrame() {

		controller = new ClientGUIController();

		this.setTitle("Hammer & Nagel - Contractor Booking System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display different contents when unable to initialize a controller
		// due to a configuration error
		if (!configMode) {
			SavedConfig.getInstance().addObserver(controller);
			initComponents();
			this.addWindowListener(new QuitApplicationActionListener());
		} else {
			initConfigPanel();
		}

		// Screen centering
		this.setSize(640, 480);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((d.getWidth() - this.getWidth()) / 2);
		int y = (int) ((d.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

		this.setVisible(true);
	}

	/**
	 * Helper method to initialize only the contents of the {@link ClientConfigPanel}
	 */
	private void initConfigPanel() {
		ClientConfigPanel configPanel = new ClientConfigPanel();
		this.add(configPanel);		
	}

	/**
	 * Helper method to initialize the contents of the {@link ClientFrame}
	 */
	private void initComponents() {
		//Menu Bar
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem quitMenuItem = new JMenuItem("Quit");
		quitMenuItem.setMnemonic(KeyEvent.VK_Q);
		quitMenuItem.addActionListener(new QuitApplicationActionListener());
		fileMenu.add(quitMenuItem);
		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);

		//Main Contents: Tabbed Panel
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);

		// Tab Number 1
		tabbedPane.add(new ClientContractorsPanel(controller),"Contractors");

		// Tab Number 2
		ClientConfigPanel configPanel = new ClientConfigPanel();
		tabbedPane.add(configPanel,"Configuration");

		this.add(tabbedPane);	
		tabbedPane.addChangeListener(new TabbedPaneChangeListener()); // must be placed after adding the panel		
	}


}
