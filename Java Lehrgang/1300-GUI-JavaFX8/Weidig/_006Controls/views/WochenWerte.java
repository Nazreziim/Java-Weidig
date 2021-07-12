package _006Controls.views;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WochenWerte {
	private StringProperty tag;
	private DoubleProperty wert;

	public WochenWerte(String tag, double wert) {
		this.tag = new SimpleStringProperty(tag);
		this.wert = new SimpleDoubleProperty(wert);
	}

	public StringProperty getTag() {
		return tag;
	}

	public void setTag(StringProperty tag) {
		this.tag = tag;
	}

	public DoubleProperty getWert() {
		return wert;
	}

	public void setWert(DoubleProperty wert) {
		this.wert = wert;
	}

}
