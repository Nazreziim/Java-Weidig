package rmi.client.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrimService extends Remote{
	public boolean isPrim(long i) throws RemoteException;
	
}
