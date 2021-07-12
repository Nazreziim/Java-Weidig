package rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.common.TimeService;

public class RMIRegistration {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
//			System.setSecurityManager(new RMISecurityManager());
			
			TimeService ts = new TimerServiceImpl();
			
			// Registrierung des Remote-Objects
			Registry reg = LocateRegistry.getRegistry();
			reg.bind("timeService", ts);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
