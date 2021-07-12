package day5.p1b.events.games.snake.view.model;

import day5.p1b.events.games.snake.model.Game;
import day5.p1b.events.games.snake.model.Position;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Paint;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class GameVM {

  public enum Symbol {
    S, // Snake
    A, // Apple
    E // Empty
  }

  private Game model;
  private Symbol[][] field;

  public GameVM( Game model ) {
    this.model = model;
    initialize();
  }

  private void initialize() {
    this.field = new Symbol[ model.getHeight() ][ model.getWidth() ];
    updateField();
  }

  private void updateField() {
    for ( int heightIdx = 0; heightIdx < this.field.length; ++heightIdx ) {
      for ( int widthIdx = 0; widthIdx < this.field[ heightIdx ].length; ++widthIdx ) {
        Position pos = modelPos2ViewModelPos( heightIdx, widthIdx );
        if ( this.model.getSnake( pos ) != null ) {
          this.field[ heightIdx ][ widthIdx ] = Symbol.S;
        } else if ( this.model.getApple( pos ) != null ) {
          this.field[ heightIdx ][ widthIdx ] = Symbol.A;
        } else {
          this.field[ heightIdx ][ widthIdx ] = Symbol.E;
        }
      }
    }
  }

  private Position modelPos2ViewModelPos( int heightIdx, int widthIdx ) {
    if ( heightIdx < 0 || heightIdx > model.getHeight() - 1 || widthIdx < 0 || widthIdx > model.getWidth() - 1 )
      throw new IllegalArgumentException( "Idx out of range." );

    int modelX = widthIdx; // With transforms to x-coordinate
    int modelY = model.getHeight() - heightIdx - 1; // Height transforms invers to y-coordinate
    Position modelPosition = new Position( modelX, modelY );
    return modelPosition;
  }

  public Group generateGrid( Group group ) {
    this.updateField();
    group.getChildren().clear();

    Scene scene = group.getScene();
    double height = scene.getHeight();
    double width = scene.getWidth();
    double heightPerGrid = height / this.model.getHeight();
    double widthPerGrid = width / this.model.getWidth();
    double border = 1;
    double rectWidth = widthPerGrid - 2 * border;
    double rectHeight = heightPerGrid - 2 * border;

    for ( int heightIdx = 0; heightIdx < this.field.length; ++heightIdx ) {
      for ( int widthIdx = 0; widthIdx < this.field[ heightIdx ].length; ++widthIdx ) {
        double rectX = widthPerGrid * widthIdx + border;
        double rectY = heightPerGrid * heightIdx + border;
        Rectangle rect = new Rectangle( rectX, rectY, rectWidth, rectHeight );
        rect.setArcHeight( rectHeight / 4 );
        rect.setArcWidth( rectWidth / 4 );
        switch ( this.field[ heightIdx ][ widthIdx ] ) {
          case A :
            rect.setFill( Color.ORANGERED );
            break;
          case S :
            Paint snakePaint = new RadialGradient( 0, 0.1, rectX + rectWidth / 2, rectY + rectHeight / 2, rectHeight / 2, false,
                    CycleMethod.REFLECT, new Stop( 0, Color.DARKSEAGREEN ), new Stop( 0.33, Color.SANDYBROWN ),
                    new Stop( 0.66, Color.YELLOWGREEN ), new Stop( 1, Color.FORESTGREEN ) );
            rect.setFill( snakePaint );
            break;
          case E :
            rect.setFill( Color.LAWNGREEN );
        }
        group.getChildren().add( rect );
      }
    }

    return group;
  }

  public Game getModel() {
    return this.model;
  }

}
