/**
 * Ersteller: Aaron
 * Datum: 22.06.2021
 */
package hardcode;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

/**
 * @category TODO Model/View/Controller
 * @since 0.0.1
 * @since 22.06.2021
 * @author Aaron
 *
 */
public class HcToolBar extends HcTemplate {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	protected Node getNode() {
		return new ToolBar(new Button("HIER STEHT GANZ VIEL LANGER BUTTONTEXT"),new Button("HIER STEHT GANZ VIEL LANGER BUTTONTEXT"),new Button("HIER STEHT GANZ VIEL LANGER BUTTONTEXT"),new Button("HIER STEHT GANZ VIEL LANGER BUTTONTEXT"),new Button("HIER STEHT GANZ VIEL LANGER BUTTONTEXT"),new Button("HIER STEHT GANZ VIEL LANGER BUTTONTEXT"),new Button("HIER STEHT GANZ VIEL LANGER BUTTONTEXT"));
	}

}
