package aufgaben.chat.v3;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame {
	private JTextField ipField; 
	private JTextField portField;
	private JTextArea messages;
	private JTextField messageForOthers;
	private Socket clientSocket;
	private JButton connectButton;
	private JButton disconnectButton;
	private Thread workThread;
	
	public Client() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(480, 320));
		this.setLayout(new GridLayout(1, 2));
		
		JPanel connection = new JPanel();
		connection.setLayout(new GridLayout(3, 1));
		
		this.ipField = new JTextField("10.0.26.14");
		connection.add(this.ipField);
		this.portField = new JTextField("3214");
		connection.add(this.portField);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));
		ButtonActionListener bal = new ButtonActionListener();
		
		this.connectButton = new JButton("connect");
		this.connectButton.setActionCommand("connect");
		this.connectButton.addActionListener(bal);
		buttonPanel.add(this.connectButton);
		
		this.disconnectButton = new JButton("disconnect");
		this.disconnectButton.setActionCommand("disconnect");
		this.disconnectButton.addActionListener(bal);
		this.disconnectButton.setEnabled(false);
		buttonPanel.add(this.disconnectButton);
		
		connection.add(buttonPanel);
		this.add(connection);
		
		
		JPanel communication = new JPanel();
		communication.setLayout(new GridLayout(2, 1));
		this.messages = new JTextArea();
		communication.add(new JScrollPane(this.messages));
		
		this.messageForOthers = new JTextField("hier Text eingeben");
		this.messageForOthers.addActionListener(new TextFieldActionListener());
		this.messageForOthers.addFocusListener(new TextFieldFocusListener());
		communication.add(this.messageForOthers);
		
		this.add(communication);
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new Client();
	}
	
	private class TextFieldFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			messageForOthers.setText("");
		}
	}
	
	
	private class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton) {
				JButton button = (JButton)e.getSource();
				if (button.getActionCommand().equalsIgnoreCase("connect")) {
					connectToServer();
				} else if (button.getActionCommand().equalsIgnoreCase("disconnect")){
					disconnectFromServer();
				}
			}
		}
	}
	
	private class TextFieldActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (clientSocket != null && e.getSource() instanceof JTextField) {
				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
					bw.write(((JTextField)e.getSource()).getText()+"\n");
					bw.flush();
					((JTextField)e.getSource()).setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void connectToServer() {
		if (this.clientSocket == null) {
			try {
				this.clientSocket = new Socket(this.ipField.getText(), Integer.parseInt(this.portField.getText()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.ipField.setEnabled(false);
		this.portField.setEnabled(false);
		this.connectButton.setEnabled(false);
		this.disconnectButton.setEnabled(true);
		
		this.startToWork();
	}

	private void startToWork() {
		//alten workThread beenden wäre nice
		this.workThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					if (clientSocket != null) {
						try {
							BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
							String s = "";
							if (br.ready()) {
								s += br.readLine();
							}
							if (s.length() > 0) {
								messages.append(s+"\n");
							}
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		this.workThread.start();
	}

	public void disconnectFromServer() {
		if (clientSocket != null) {
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
				bw.write("disconnect\n");
				bw.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		this.clientSocket = null;
		this.ipField.setEnabled(true);
		this.portField.setEnabled(true);
		this.connectButton.setEnabled(true);
		this.disconnectButton.setEnabled(false);
	}
}
