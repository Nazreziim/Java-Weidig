package rmi.server.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.GregorianCalendar;

import rmi.server.common.TimeStore;
import rmi.server.common.TimeService;

public class TimeServiceImpl extends UnicastRemoteObject implements TimeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String getTime() throws RemoteException {
		GregorianCalendar cal = new GregorianCalendar();
		String s = "" + cal.get(Calendar.HOUR_OF_DAY) + ":"
				+ cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
		return s;
	}

	@Override
	public TimeStore storeTime(TimeStore store) throws RemoteException {
		store.setTime(this.getTime());
		return store;
	}

	
}
