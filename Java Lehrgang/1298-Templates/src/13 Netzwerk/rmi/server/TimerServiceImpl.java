package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.GregorianCalendar;

import rmi.common.TimeService;

public class TimerServiceImpl extends UnicastRemoteObject implements TimeService {


	private static final long serialVersionUID = 3993391423129153469L;
	private String time;
	
	public TimerServiceImpl() throws RemoteException {
		super();	
	}

	@Override
	public String getTime() throws RemoteException {
		GregorianCalendar cal = new GregorianCalendar();
		String erg = "" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":"
				+ cal.get(Calendar.SECOND);
		time = erg;
		return erg;
	}

	@Override
	public void setTime(String time) throws RemoteException {
		this.time = time;

	}

}
