package _005EventsUndBindings;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class _02Binding {
	public static void main(String[] args) {

		/************ DoubleBinding *************/
		DoubleProperty a = new SimpleDoubleProperty(0);
		DoubleProperty b = new SimpleDoubleProperty(0);
		DoubleProperty c = new SimpleDoubleProperty(0);
		DoubleProperty d = new SimpleDoubleProperty(0);

		DoubleBinding db = new DoubleBinding() {

			{
				super.bind(a, b, c, d);
			}

			// Wird aufgerufen sobald sich einer der gebindeten Werte ändert
			@Override
			protected double computeValue() {
				return (a.get() + b.get() + c.get() + d.get());
			}
		};

		System.out.println(db.get());
		a.set(5);
		System.out.println(db.get());
		b.set(5);
		System.out.println(db.get());
		c.set(5);
		System.out.println(db.get());
		d.set(5);
		System.out.println(db.get());

		// Beachte: JavaFX.beans --> Bindings sind für Synchronisation zwischen Nodes /
		// Controls gedacht. Können aber auch ganz normal genutzt werden. Das Nutzen
		// externer Libraries ist gängig, auch wenn sie zweckentfremdet werden.
		
		//Gem. .ppt gibt es viele Möglichkeiten der Bindings
	}
}
