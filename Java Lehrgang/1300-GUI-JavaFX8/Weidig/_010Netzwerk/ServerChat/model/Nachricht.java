package _010Netzwerk.ServerChat.model;

import java.io.Serializable;

public class Nachricht implements Serializable{
	private static final long serialVersionUID = -1330826653624998401L;
	private String senderName;
	private String inhalt;

	public Nachricht(String senderName, String inhalt) {
		this.senderName = senderName;
		this.inhalt = inhalt;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getInhalt() {
		return inhalt;
	}

}
