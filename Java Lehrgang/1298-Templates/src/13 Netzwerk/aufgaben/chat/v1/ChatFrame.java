package aufgaben.chat.v1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChatFrame extends JFrame implements Observer {
	private ChatModel cm;
	public final static String statusMessages[] = {
			" Error! Could not connect!", " Disconnected", " Disconnecting...",
			" Connecting...", " Connected" };

	// GUI-Komponenten
	private static JFrame mainFrame = null;
	private static JTextArea chatText = null;
	private static JTextField chatLine = null;
	public static JPanel statusBar = null;
	public static JLabel statusField = null;
	public static JTextField statusColor = null;
	public static JTextField ipField = null;
	public static JTextField portField = null;
	public static JRadioButton hostOption = null;
	public static JRadioButton guestOption = null;
	public static JButton connectButton = null;
	public static JButton disconnectButton = null;

	private class ChatActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = chatLine.getText();
			if (!s.equals("")) {
				chatText.append("OUTGOING: " + s + "\n"); // Nicht thread-safe!
				// appendToChatBox("OUTGOING: " + s + "\n");
				chatLine.selectAll();
				// Send the string
				cm.setSendString(s);
				// sendString(s);

			}
		}
	}

	private class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Begin connect
			if (e.getActionCommand().equals("connect")) {
				cm.setConnectionStatus(cm.BEGIN_CONNECT);
				//changeStatus(cm.BEGIN_CONNECT, true);
			}

			// Disconnect
			if (e.getActionCommand().equals("disconnect")) {
				cm.setConnectionStatus(cm.DISCONNECTING);
				//changeStatus(cm.DISCONNECTING, true);
			}
//
//			 if (cm.getConnectionStatus() != cm.DISCONNECTED) {
//				 changeStatus(cm.NULL, true);
//			 } else {
//			 Cannot supply host IP if host option is chosen
			if (e.getActionCommand().equals("host")) {
				ipField.setEnabled(false);
				ipField.setText("localhost");
				cm.setHostIP("localhost");
				cm.setServer(true);
			}

			if (e.getActionCommand().equals("guest")) {				
				cm.setServer(false);
				ipField.setEnabled(true);
			}
//		 }

		}
	}

	private class TextFocusListener implements FocusListener {

		public void focusLost(FocusEvent e) {
			if (e.getComponent().getName().equals("portField")) {
				// should be editable only when disconnected
				if (cm.getConnectionStatus() != cm.DISCONNECTED) {
					cm.setConnectionStatus(cm.NULL);
					//changeStatus(cm.NULL, true);
				} else {
					int temp = 0;
					try {
						temp = Integer.parseInt(portField.getText());
						cm.setPort(temp);
					} catch (NumberFormatException nfe) {
						portField.setText((new Integer(cm.getPort()))
								.toString());
						mainFrame.repaint();
					}
				}
			}

			if (e.getComponent().getName().equals("ipField")) {
				ipField.selectAll();
				// Should be editable only when disconnected
				if (cm.getConnectionStatus() != cm.DISCONNECTED) {
					cm.setConnectionStatus(cm.NULL);
					//changeStatus(cm.NULL, true);
				} else {
					cm.setHostIP(ipField.getText());
				}
			}
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Konstruktor der Klasse ChatFrame
	 * @param cm - Das zugrunde liegende Model
	 */
	public ChatFrame(ChatModel cm) {
		this.cm = cm;
		JPanel mainPane = initMainPane();
		// Mainframe erstellen
		mainFrame = new JFrame("TCP Chat");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setContentPane(mainPane);
		mainFrame.setSize(mainFrame.getPreferredSize());
		mainFrame.setLocation(200, 200);
		mainFrame.pack();
		mainFrame.setVisible(true);

	}

	/**
	 * Hilfsmethode zur Erstellung eine Haupt-Panels
	 * @return Das fertig bestückte Haupt-Panel
	 */
	private JPanel initMainPane() {
		// Statusbar
		statusField = new JLabel();
		statusField.setText(statusMessages[cm.DISCONNECTED]);
		statusColor = new JTextField(1);
		statusColor.setBackground(Color.red);
		statusColor.setEditable(false);
		statusBar = new JPanel(new BorderLayout());
		statusBar.add(statusColor, BorderLayout.WEST);
		statusBar.add(statusField, BorderLayout.CENTER);

		//Option-Panel
		JPanel optionsPane = initOptionsPane();

		// Chat-Panel
		JPanel chatPane = new JPanel(new BorderLayout());
		chatText = new JTextArea(10, 20);
		chatText.setLineWrap(true);
		chatText.setEditable(false);
		chatText.setForeground(Color.blue);
		JScrollPane chatTextPane = new JScrollPane(chatText,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatLine = new JTextField();
		chatLine.setEnabled(false);
		chatLine.addActionListener(new ChatActionListener());
		chatPane.add(chatLine, BorderLayout.SOUTH);
		chatPane.add(chatTextPane, BorderLayout.CENTER);
		chatPane.setPreferredSize(new Dimension(200, 200));

		// Main-Panel zusammenführen und zurückgeben
		JPanel mainPane = new JPanel(new BorderLayout());
		mainPane.add(statusBar, BorderLayout.SOUTH);
		mainPane.add(optionsPane, BorderLayout.WEST);
		mainPane.add(chatPane, BorderLayout.CENTER);
		return mainPane;
	}

	/**
	 * Hilfsmethode für die Erstellung des OptionPanel
	 * 
	 * @return Das fertige Panel
	 */
	private JPanel initOptionsPane() {
		// Das Optionen-Panel
		JPanel optionsPane = new JPanel(new GridLayout(4, 1));

		// Textfeld für IP-Adresse
		TextFocusListener textFocListener = new TextFocusListener();
		JPanel tmpPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		tmpPanel.add(new JLabel("Host IP:"));
		ipField = new JTextField(10);
		ipField.setName("ipField");
		ipField.setText(cm.getHostIP());
		ipField.setEnabled(false);
		ipField.addFocusListener(textFocListener);
		tmpPanel.add(ipField);
		optionsPane.add(tmpPanel);

		// Textfeld für den Port
		tmpPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		tmpPanel.add(new JLabel("Port:"));
		portField = new JTextField(10);
		portField.setName("portField");
		portField.setEditable(true);
		portField.setText((new Integer(cm.getPort())).toString());
		portField.addFocusListener(textFocListener);
		tmpPanel.add(portField);
		optionsPane.add(tmpPanel);

		// RadioButtons für Host/Client-Auswahl
		ButtonActionListener buttonListener = new ButtonActionListener();
		ButtonGroup bg = new ButtonGroup();
		hostOption = new JRadioButton("Host", true);
		hostOption.setMnemonic(KeyEvent.VK_H);
		hostOption.setActionCommand("host");
		hostOption.addActionListener(buttonListener);
		guestOption = new JRadioButton("Guest", false);
		guestOption.setMnemonic(KeyEvent.VK_G);
		guestOption.setActionCommand("guest");
		guestOption.addActionListener(buttonListener);
		bg.add(hostOption);
		bg.add(guestOption);
		tmpPanel = new JPanel(new GridLayout(1, 2));
		tmpPanel.add(hostOption);
		tmpPanel.add(guestOption);
		optionsPane.add(tmpPanel);

		// Connect/disconnect buttons
		JPanel buttonPane = new JPanel(new GridLayout(1, 2));
		connectButton = new JButton("Connect");
		connectButton.setMnemonic(KeyEvent.VK_C);
		connectButton.setActionCommand("connect");
		connectButton.addActionListener(buttonListener);
		connectButton.setEnabled(true);
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setMnemonic(KeyEvent.VK_D);
		disconnectButton.setActionCommand("disconnect");
		disconnectButton.addActionListener(buttonListener);
		disconnectButton.setEnabled(false);
		buttonPane.add(connectButton);
		buttonPane.add(disconnectButton);
		optionsPane.add(buttonPane);

		return optionsPane;
	}

	
	/**
	 * Eine Methode zum Verändern der Anzeigeelemente, wenn sich der
	 * Verbindungsstatus ändert
	 * 
	 * @param newConnectStatus
	 *            - Neuer Status (aus statusMessages)
	 * @param noError
	 *            - Soll ein Fehler angezeigt werden? - dann false!
	 */
	@Deprecated
	private void changeStatus(int newConnectStatus, boolean noError) {
		// Status verändern
		if (newConnectStatus != cm.NULL) {
			cm.setConnectionStatus(newConnectStatus);
		}

		// Falls kein Fehler angezeigt werden soll, passende Meldung in
		// Statusbar anzeigen
		if (noError) {
			statusField.setText(statusMessages[cm.connectionStatus]);
		}
		// Sonst: Fehlermeldung
		else {
			statusField.setText(statusMessages[cm.NULL]);
		}

		// Call the run() routine (Runnable interface) on the
		// current thread
		// tcpObj.run();
	}

	
	
	/**
	 * Update-Methode, die vom Obserable-Objekt aufgerufen wird. Hier werden je nach Verbindungsstatus, alle nötigen GUI-
	 * Elemente entsprechend verändert und mit "Leben" aus dem Model befüllt - außerdem wird ein repaint-Aufruf
	 * getätigt
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO: Warum werden die Konstanten aus ChatModel nicht als Konstanten im Switch-Verteiler verstanden?

		switch (cm.getConnectionStatus()) {
		case 1:
			connectButton.setEnabled(true);
			disconnectButton.setEnabled(false);
			ipField.setEnabled(true);
			portField.setEnabled(true);
			hostOption.setEnabled(true);
			guestOption.setEnabled(true);
			chatLine.setText("");
			chatLine.setEnabled(false);			
			statusColor.setBackground(Color.red);
			break;

		case 2:
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(false);
			ipField.setEnabled(false);
			portField.setEnabled(false);
			hostOption.setEnabled(false);
			guestOption.setEnabled(false);
			chatLine.setEnabled(false);
			statusColor.setBackground(Color.orange);
			break;

		case 4:
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(true);
			ipField.setEnabled(false);
			portField.setEnabled(false);
			hostOption.setEnabled(false);
			guestOption.setEnabled(false);
			chatLine.setEnabled(true);
			statusColor.setBackground(Color.green);
			break;

		case 3:
			connectButton.setEnabled(false);
			disconnectButton.setEnabled(false);
			ipField.setEnabled(false);
			portField.setEnabled(false);
			hostOption.setEnabled(false);
			guestOption.setEnabled(false);
			chatLine.setEnabled(false);
			chatLine.grabFocus();
			statusColor.setBackground(Color.orange);
			break;
		}

		ipField.setText(cm.getHostIP());
		portField.setText(new Integer(cm.getPort()).toString());
		hostOption.setSelected(cm.isServer());
		guestOption.setSelected(!cm.isServer());
		statusField.setText(statusMessages[cm.getConnectionStatus()]);
		chatText.append(cm.getTextReceived());

		this.repaint();

	}

}
