/**
 * Ersteller: Aaron
 * Datum: 22.06.2021
 */
package fxml;

import java.io.IOException;

import hardcode.HcTemplate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * @category Model
 * @since 0.0.1
 * @since 22.06.2021
 * @author Aaron
 *
 */
public class FxTemplate extends HcTemplate {

	private final String fxmlNameInSameDirectory;

	public FxTemplate() {
		fxmlNameInSameDirectory = this.getClass().getSimpleName();
	}

	@Override
	protected Node getNode() {
		try {
			return (Node) FXMLLoader.load(this.getClass().getResource(fxmlNameInSameDirectory + ".fxml"));
		} catch (final IOException e) {
			return new Pane();
		}
	}

}
