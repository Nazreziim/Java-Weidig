package rmi.client.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.client.common.TimeStore;

public class MyTimeStore extends UnicastRemoteObject implements TimeStore {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String time = "";
	
	public MyTimeStore() throws RemoteException{
		this.time = "no time";
	}
	@Override
	public void setTime(String time) throws RemoteException{
		this.time = time;
	}
	@Override
	public String getTime()  throws RemoteException{
		return this.time;
	}

	
}
