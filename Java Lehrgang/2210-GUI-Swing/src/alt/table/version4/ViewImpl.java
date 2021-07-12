package alt.table.version4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class ViewImpl implements View,Observer{
	
	private Gui gui;
	private Model model;
	private Control control;
	
	public ViewImpl(Model model) {
		this.model = model;
		gui = new Gui();
		model.addObserver2(this);
		
		Hashtable<String, ActionListener> eventListener = new Hashtable<String, ActionListener>();
		eventListener.put("next", nextHandler);
		gui.setEventListener(eventListener);
		gui.addModelEventListener(model);
	}

	public void setControl(ControlImpl impl) {
		this.control=impl;
		
	}

	public void update(Observable o, Object arg) {
		gui.refresh(model.getVector());
	}
	
	ActionListener nextHandler = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			control.addString();
			
		}
		
	};
}
