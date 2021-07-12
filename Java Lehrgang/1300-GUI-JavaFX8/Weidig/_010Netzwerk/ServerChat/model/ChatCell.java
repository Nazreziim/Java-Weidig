package _010Netzwerk.ServerChat.model;

import javafx.scene.control.ListCell;

public class ChatCell extends ListCell<Nachricht> {
	@Override
	protected void updateItem(Nachricht item, boolean empty) {
		// TODO Auto-generated method stub
		super.updateItem(item, empty);
		
		//Falls es entweder leer ist oder item null ist
		if(empty || item == null) {
			setText(null);
			setGraphic(null);
		} else {
			setText(item.getSenderName() + " sagt: " + item.getInhalt());
			setGraphic(null);
		}
	}
}
