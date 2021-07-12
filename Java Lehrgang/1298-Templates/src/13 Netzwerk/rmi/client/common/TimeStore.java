package rmi.client.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TimeStore extends Remote{
	public void setTime(String time) throws RemoteException;
	public String getTime()  throws RemoteException;
}
