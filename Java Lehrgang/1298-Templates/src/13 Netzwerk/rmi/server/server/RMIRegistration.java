package rmi.server.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.server.common.PrimService;
import rmi.server.common.TimeService;

public class RMIRegistration {

	
	public static void main(String[] args){
		try {
			LocateRegistry.createRegistry(1235);
			System.setSecurityManager(new RMISecurityManager());
			
			TimeService ts = new TimeServiceImpl();
			//TimeService ts_stub = (TimeService) UnicastRemoteObject.exportObject(ts);
			Registry reg = LocateRegistry.getRegistry();
			//reg.bind("TimeService",ts_stub );
			reg.bind("TimeService",ts );
			
			PrimService ps = new PrimServiceImpl();
			reg.rebind("PrimService", ps);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
