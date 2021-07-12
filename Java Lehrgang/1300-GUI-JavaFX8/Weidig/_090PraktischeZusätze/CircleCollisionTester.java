package _090PraktischeZus�tze;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import javafx.scene.shape.*;

public class CircleCollisionTester extends Application {

  private ArrayList<Shape> nodes;

  public static void main(String[] args) { launch(args); }

  @Override public void start(Stage primaryStage) {
	//Setzt den Titel der Hauptstage [Fenster]
    primaryStage.setTitle("Drag circles around to see collisions");
    
    //Enh�tlt observableListe welche in der dort angegebenen Reihenfolge rendern wenn dieses aufgerufen wird
    Group root = new Group(); 
    Group root1 = new Group();
    Group root2 = new Group();
    root.getChildren().addAll(root1, root2);
    
    //Ordnet der Szene eine Gruppe zu in der Sie geladen wird
    Scene scene = new Scene(root, 400, 400);

    //Initialisiert die ArrayList leer
    nodes = new ArrayList<>();
    
    //F�gt verschiedene KreisObjekte der List hinzu
    nodes.add(new Circle(50, 50, 30));
    nodes.add(new Circle(90, 60, 30));
    nodes.add(new Circle(40, 200, 30));
    
    //Setzt auf alle Shapes welche in der observableList
    //enthalten sind die Bedingungen f�r das Mausverhalten
    for (Shape block : nodes) {
      setDragListeners(block);
    }
    
    //F�gt alle bearbeiteten Shapes der Gruppe hinzu
    root1.getChildren().addAll(nodes);
    Circle c = new Circle(80, 80, 30);
    nodes.add(c);
    root2.getChildren().add(c);
    setDragListeners(c);
    
    //�bergibt das letzte Element aus der Shape Liste
    checkShapeIntersection(nodes.get(nodes.size() - 1));
    
    //Setzt die Szene
    primaryStage.setScene(scene);
    
    //Zeigte die Hauptstage an
    primaryStage.show();
  }

  //Eine Klasse welche die Variablen x und y als Double h�lt
  class Delta { double x, y; }
  
  //Setzt das entsprechende Mausverhalten
  public void setDragListeners(final Shape block) {
    final Delta dragDelta = new Delta();

    //Verhalten des Shapes wenn die Maustaste gedr�ckt wird
    block.setOnMousePressed(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        // record a delta distance for the drag and drop operation.
    	block.toFront();
    	block.getParent().toFront();
        dragDelta.x = block.getLayoutX() - mouseEvent.getSceneX();
        dragDelta.y = block.getLayoutY() - mouseEvent.getSceneY();
        block.setCursor(Cursor.NONE);
      }
    });
    
    //Verhalten des Shapes wenn die Maustaste losgelassen wird
    block.setOnMouseReleased(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
    	block.toBack();
    	block.getParent().toBack();
        block.setCursor(Cursor.HAND);
      }
    });
    
    //Verhalten wenn die Maus gedr�ckt und gehalten wird
    block.setOnMouseDragged(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        block.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
        block.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
        checkShapeIntersection(block);
      }
    });
  }

  //Pr�ft die Kollision zweier Shapes
  private void checkShapeIntersection(Shape block) {
    boolean collisionDetected = false;
    
    //Iteriert �ber alle Shapes aus der ArrayListe nodes
    for (Shape static_bloc : nodes) {
    	
      //Wenn Die beiden Shapes sich unterscheiden setze gr�n
      if (static_bloc != block) {
        static_bloc.setFill(Color.GREEN);
        //Gibt die Gruppe des ausgew�hlten Blocks aus
        System.out.println(block.getParent().toString());

        //�berschneidung zwischen dem "block" Shape und dem "static_bloc" Shape
        Shape intersect = Shape.intersect(block, static_bloc);
        
        //Falls eine �berschneidung nicht -1 zur�ckgibt
        if (intersect.getBoundsInLocal().getWidth() != -1) {
          //Erkenne dies als Kollision
          collisionDetected = true;
        }
      }
    }

    //Falls eine Kollision erkannt wurde
    if (collisionDetected) {
      //Setze den �bergebenen Block auf blau
      block.setFill(Color.BLUE);
    } else {
      //Setze den �bergebenen Block auf gr�n
      block.setFill(Color.GREEN);
    }
  }

  
}