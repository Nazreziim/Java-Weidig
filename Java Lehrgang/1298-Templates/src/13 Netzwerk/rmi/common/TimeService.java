package rmi.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TimeService extends Remote {
	public String getTime() throws RemoteException;
	
	public void setTime(String time) throws RemoteException; 

}
