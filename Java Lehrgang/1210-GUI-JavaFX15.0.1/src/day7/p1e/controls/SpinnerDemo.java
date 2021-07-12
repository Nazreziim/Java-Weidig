package day7.p1e.controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Example usage of a ListView
 */
public class SpinnerDemo extends Application {

  /**
   * Start the Application
   * 
   * @param args Command line arguments.
   */
  public static void main( String[] args ) {
    Application.launch( args );
  }

  @Override
  public void start( Stage primaryStage ) throws Exception {
    primaryStage.setTitle( "SpinnerDemo" );

    Text information = new Text( "Info" );

    ChangeListener< Number > numberEH = new ChangeListener< Number >() {
      @Override
      public void changed( ObservableValue< ? extends Number > observable, Number oldValue, Number newValue ) {
        information.setText( "Auswahl: " + newValue );
      }
    };

    Spinner< Integer > intSpinner = new Spinner<>( 0, 10, 0 );
    Spinner< Integer > intSpinnerStep = new Spinner< Integer >( 0, 10, 0, 2 );
    Spinner< Double > doubleSpinner = new Spinner< Double >( 0.0, 10.0, 0.0 );
    Spinner< Double > doubleSpinnerStep = new Spinner< Double >( 0.0, 10.0, 0.0, 0.5 );
    intSpinner.valueProperty().addListener( numberEH );
    intSpinnerStep.valueProperty().addListener( numberEH );
    doubleSpinner.valueProperty().addListener( numberEH );
    doubleSpinnerStep.valueProperty().addListener( numberEH );

    ObservableList< String > stringList = FXCollections.observableArrayList( "Eins", "Zwei", "Drei", "Vier", "Fünf" );
    Spinner< String > stringSpinner = new Spinner<>( stringList );
    stringSpinner.valueProperty().addListener( new ChangeListener< String >() {
      @Override
      public void changed( ObservableValue< ? extends String > observable, String oldValue, String newValue ) {
        information.setText( "Auswahl: " + newValue );
      }
    } );

    VBox vBox = new VBox( 5 );
    vBox.setPadding( new Insets( 5 ) );
    vBox.getChildren().add( intSpinner );
    vBox.getChildren().add( intSpinnerStep );
    vBox.getChildren().add( doubleSpinner );
    vBox.getChildren().add( doubleSpinnerStep );
    vBox.getChildren().add( stringSpinner );
    vBox.getChildren().add( information );

    Scene scene = new Scene( vBox, 250, 500 );
    primaryStage.setScene( scene );
    primaryStage.show();

  }

}
