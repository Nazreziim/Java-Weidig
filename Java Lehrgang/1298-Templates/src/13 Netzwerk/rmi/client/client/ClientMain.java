package rmi.client.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import rmi.client.common.PrimService;
import rmi.client.common.TimeService;
import rmi.client.common.TimeStore;

public class ClientMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "rmi://10.0.26.53:1099/TimeService";
		String url2 = "rmi://10.0.26.53:1099/PrimService";
		
		try {
			System.setSecurityManager(new RMISecurityManager());
			TimeService ts = (TimeService) Naming.lookup(url);
			System.out.println(ts.getTime());
			
			TimeStore store = new MyTimeStore();
			System.out.println(store.getTime());
			ts.storeTime(store);
			System.out.println(store.getTime());
			PrimService ps = (PrimService)Naming.lookup(url2);
			System.out.println(ps.isPrim(1234321215));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
