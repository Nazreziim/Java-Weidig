package _090PraktischeZusätze;

import javafx.animation.*;
import javafx.application.*;
import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.*;
import javafx.util.Duration;

class Delta {
	double x;
	double y;
}

public class TDTest extends Application {
	private int hitcount = 0;
	private int runde = 0;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		PathTransition pt = new PathTransition();

		Circle aCircle = new Circle();
		aCircle.setRadius(10);
		// aCircle.setFill(Color.TRANSPARENT);
		aCircle.setStroke(Color.RED);
		// aCircle.setStrokeWidth(5);

		Line line = new Line();
		line.setStartX(100);
		line.setStartY(10);
		line.setEndX(100);
		line.setEndY(500);
		line.setStrokeWidth(10);

		Circle turmRadius = new Circle();
		turmRadius.setStroke(Color.YELLOW);
		// turmRadius.setStrokeWidth(10);
		// turmRadius.setFill(Color.TRANSPARENT);
		turmRadius.setRadius(40);
		turmRadius.setLayoutX(120);
		turmRadius.setLayoutY(300);
		enableDrag(turmRadius);

		// KOLLISIONSVERHALTEN
		aCircle.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
			@Override
			public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {

				// hitcount <= 1 --> 2 Treffer möglich // hitcounter == 0 --> 1 Treffer möglich
				// etc.
				if (((Path) Shape.intersect(aCircle, turmRadius)).getElements().size() > 0 && hitcount <= 1) {
					System.out.println("Hit!");
					hitcount++;
					System.out.println(hitcount);
					// PERMANENT: Wenn er außerhalb des turmRadius ist
				} else if (((Path) Shape.intersect(aCircle, turmRadius)).getElements().size() <= 0) {
					hitcount = 0;
				}
			}
		});
		///

		// PFADGENERIERUNG
		// Startposition
		MoveTo moveTo = new MoveTo(100, 10);
		// von MoveTo zur angegebenen Linie
		LineTo lineTo = new LineTo(100, 500);

		Path path = new Path(moveTo, lineTo);

		pt.setNode(aCircle);
		pt.setPath(path);
		pt.setDuration(new Duration(1000));
		// HIN UND HER OHNE JE DAS ENDE ZU ERREICHEN
//		pt.setCycleCount(Animation.INDEFINITE);
//		pt.setAutoReverse(true);

		// VERHALTEN WENN DIE ANIMATION ZU ENDE IST
		pt.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Path path = new Path();

				if (runde == 0) {
					System.out.println("Am Ende von Runde " + (runde + 1));
					path = new Path(new MoveTo(100, 500), new LineTo(100, 10));
					runde++;
				} else if (runde == 1) {
					System.out.println("Am Ende von Runde " + (runde + 1));
					path = new Path(new MoveTo(100, 10), new LineTo(100, 500));
					runde--;
				}

				pt.setPath(path);
				pt.play();
			}
		});

		pane.getChildren().add(line);
		pane.getChildren().add(turmRadius);
		pane.getChildren().add(aCircle);
		pane.getChildren().add(Shape.intersect(turmRadius, aCircle));
		Scene scene = new Scene(pane);

		primaryStage.setScene(scene);
		primaryStage.setHeight(800);
		primaryStage.setWidth(500);
		primaryStage.show();
		pt.play();
	}

	public Path reversePath(Path path) {
		ObservableList<PathElement> tmp = path.getElements();
		FXCollections.reverse(tmp);
		tmp.set(0, (MoveTo) tmp.get(tmp.size()));
		System.out.println("GEDREHT" + tmp);

		Path tmpPath = new Path(tmp);

		return tmpPath;
	}

	private void enableDrag(final Circle circle) {
		final Delta dragDelta = new Delta();
		circle.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				dragDelta.x = circle.getCenterX() - mouseEvent.getX();
				dragDelta.y = circle.getCenterY() - mouseEvent.getY();
				circle.getScene().setCursor(Cursor.MOVE);
			}
		});
		
		//WENN DIE MAUS LOSGELASSEN WIRD DEAKTIVIERE SEIN VERHALTEN
		circle.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				circle.getScene().setCursor(Cursor.DEFAULT);
				disableDrag(circle);
			}
		});
		circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				circle.setCenterX(mouseEvent.getX() + dragDelta.x);
				circle.setCenterY(mouseEvent.getY() + dragDelta.y);
			}
		});
		circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {
					circle.getScene().setCursor(Cursor.HAND);
				}
			}
		});
		circle.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {
					circle.getScene().setCursor(Cursor.DEFAULT);
				}
			}
		});
	}

	// DEAKTIVIERT DIE BEWEGUNG DES TURMS
	private void disableDrag(final Circle circle) {
		circle.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {

			}
		});
		circle.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {

			}
		});
		circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {

			}
		});
		circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {

				}
			}
		});
		circle.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {

				}
			}
		});
	}

}
