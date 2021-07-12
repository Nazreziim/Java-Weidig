package _08MVCBeispiele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class MonsterModel extends Rectangle {

	//Um ein Binding auf dieses Leben zu setzen
	IntegerProperty leben;

	public MonsterModel() {
		Image bild = new Image("_08MVCBeispiele/monster.gif");
		this.setFill(new ImagePattern(bild));
		this.setWidth(bild.getWidth());
		this.setHeight(bild.getHeight());
		this.setLayoutX(722);
		this.setLayoutY(261);
		this.leben = new SimpleIntegerProperty(100);

	}

	public int getLeben() {
		return leben.get();
	}

	public void setLeben(int leben) {
		this.leben.set(leben);
	}

	public IntegerProperty getLebenProperty() {
		return leben;
	}

	public void setLebenProperty(IntegerProperty leben) {
		this.leben = leben;
	}
}
