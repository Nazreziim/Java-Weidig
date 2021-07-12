/**
 * Ersteller: Aaron
 * Datum: 22.06.2021
 */
package hardcode;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @category TODO Model/View/Controller
 * @since 0.0.1
 * @since 22.06.2021
 * @author Aaron
 *
 */
public abstract class HcTemplate extends Application {

	protected abstract Node getNode();

	@Override
	public void start(Stage stage) throws Exception {
		stage.setWidth(960);
		stage.setHeight(540);
		stage.setScene(new Scene(new BorderPane(getNode())));
		stage.setTitle(this.getClass().getSimpleName());
		stage.show();
	}

}
