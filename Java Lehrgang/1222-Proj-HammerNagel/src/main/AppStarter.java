package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import gui.client.ClientFrame;
import gui.console.ConsoleMainMenu;

/**
 * This is the main class of the application which is only used to
 * call the main method and handle the arguments passed by the user
 * on startup
 * 
 * @author Lars Gerhard
 *
 */
public class AppStarter {

	private Logger log;
	private static final Level logLevel = Level.OFF; 		// Switch to another Level to turn logging on!
	private static final String LOG_FILENAME = "log.txt";	// You may change the name of the logfile here!

	/**
	 * Constructs the application object in dependence of the passed
	 * arguments
	 * 
	 * @param args one of "alone" (Standalone-Mode), "server" (Server-Mode) 
	 * or empty String (Network-Client-Mode)
	 */
	private AppStarter(String[] args) {
		//Logging	
		log = Logger.getLogger("");
		log.setUseParentHandlers(false);
		log.setLevel(logLevel);   
		if (log.getLevel() != Level.OFF) {
			try {
				FileHandler fHandler = new FileHandler(LOG_FILENAME);
				fHandler.setFormatter(new SimpleFormatter());
				log.addHandler(fHandler);
			} catch (SecurityException e1) {
				log.throwing("Main", "Constructor", e1);
				e1.printStackTrace();
			} catch (IOException e1) {
				log.throwing("Main", "Constructor", e1);
				e1.printStackTrace();
			}
		}

		//TODO: implement ConsoleMainMenu
//		new ConsoleMainMenu(); // to activate console ui
		new ClientFrame();
				
	}

	/**
	 * The main entrance point for the application
	 * 
	 * @param args arguments passed by the user
	 */
	public static void main(String[] args) {
		new AppStarter(args);

	}

	/**
	 * Displays a dialog box for a received error message
	 *
	 * @param message the message text to be displayed
	 */
	public static void handleException(String message) {
		JOptionPane alert = new JOptionPane(message, JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION);
		JDialog dialog = alert.createDialog(null, "Error");

		// Center on screen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((d.getWidth() - dialog.getWidth()) / 2);
		int y = (int) ((d.getHeight() - dialog.getHeight()) / 2);
		dialog.setLocation(x, y);

		dialog.setVisible(true);
	}

}
