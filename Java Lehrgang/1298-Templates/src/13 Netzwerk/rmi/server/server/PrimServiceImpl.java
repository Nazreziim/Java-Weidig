package rmi.server.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.server.common.PrimService;

public class PrimServiceImpl extends UnicastRemoteObject implements PrimService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public PrimServiceImpl() throws RemoteException{
		
	}
	
	
	@Override
	public boolean isPrim(long primzahl) throws RemoteException {
		boolean istPrim = true;
		double zahl = Math.sqrt(primzahl);
		int i = 2;
		if (primzahl < 2) {
			istPrim = false;
		}
		while (istPrim && i <= zahl) {
			if (primzahl % i == 0) {
				istPrim = false;
			}
			i++;
		}
		return istPrim;
	}
	 

}
