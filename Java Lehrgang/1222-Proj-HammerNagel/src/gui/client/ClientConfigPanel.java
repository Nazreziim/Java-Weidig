package gui.client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class represents the Configuration Panel, which 
 * allows the user to change the location of the db-file.
 * Consists of a simple JLabel, an non-editable JTextField 
 * to display the (current) path, and one button connected
 * to the FileChooser-Dialog
 *  
 * @author Lars Gerhard
 */
class ClientConfigPanel extends JPanel {

	private static final long serialVersionUID = 5383136703621633781L;

	/**
	 * Creates an instance of ClientConfigPanel dynamically with the appropriate
	 * contents for local and network clients
	 * 
	 * @param runMode one of <code>CLIENT_STANDALONE</code> or <code>CLIENT_NETWORK</code>
	 * @see ClientGUIMode
	 */
	ClientConfigPanel() {
		
		initContentStandalone();			

	}

	/**
	 * Initialization of the contents for local mode
	 */
	private void initContentStandalone() {
		JLabel label = new JLabel("Database-Location:");

		final JTextField dbPathField = new JTextField("LOC");
		dbPathField.setEditable(false);
		dbPathField.setText(SavedConfig.getInstance().getProperty(SavedConfig.DB_PATH));

		final JButton chgButton = new JButton("Change");
		chgButton.setMnemonic(java.awt.event.KeyEvent.VK_C);
		chgButton.addActionListener(new ActionListener() {			
			/**
			 * This method is called when the ActionListener which is bound to
			 * the change button is pressed. It sets the <code>DB_PATH</code>
			 * property in the {@link SavedConfig} object by opening a file
			 * chooser dialog
			 * @param e the event received by the ActionListener
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser(dbPathField.getText());
				fc.setFileFilter(new FileNameExtensionFilter("DB-Files","db"));
				int fcReturn = fc.showOpenDialog(chgButton);
				if (fcReturn == JFileChooser.APPROVE_OPTION) {
					File file  = fc.getSelectedFile();
					SavedConfig.getInstance().setProperty(SavedConfig.DB_PATH, file.getPath());					
					dbPathField.setText(file.getPath());
				}
			}
		});

		this.setLayout(new FlowLayout());
		this.add(label);
		this.add(dbPathField);
		this.add(chgButton);
	}

}
