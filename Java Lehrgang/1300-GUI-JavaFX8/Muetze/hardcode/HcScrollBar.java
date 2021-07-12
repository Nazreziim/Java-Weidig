/**
 * Ersteller: Aaron
 * Datum: 22.06.2021
 */
package hardcode;

import javafx.scene.Node;
import javafx.scene.control.ScrollBar;

/**
 * @category TODO Model/View/Controller
 * @since 0.0.1
 * @since 22.06.2021
 * @author Aaron
 *
 */
public class HcScrollBar extends HcTemplate {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	protected Node getNode() {
		return new ScrollBar();
	}

}
