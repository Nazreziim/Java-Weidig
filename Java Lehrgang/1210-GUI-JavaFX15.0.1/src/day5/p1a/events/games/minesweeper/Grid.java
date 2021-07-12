package day5.p1a.events.games.minesweeper;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

/**
 * This class represents the grid of a minesweeper game. You have to pass the number of segments in
 * x and y-direction to build an instance Segments are stored in a simple 2D-array in the
 * background.
 * 
 * @author lgerhard
 *
 */
public class Grid {
  Segment[][] grid_array = null;

  /**
   * Constructor for a Grid instance
   * 
   * @param xSegments number of segments in x-direction
   * @param ySegments number of segments in y-direction
   */
  public Grid( int xSegments, int ySegments ) {
    this.grid_array = new Segment[ xSegments ][ ySegments ];
  }

  /**
   * Adds a passed segment to a certain position in the grid
   * 
   * @param segment the segment to be added
   * @param x x-coordinate
   * @param y y-coordinate
   */
  public void addSegment( Segment segment, int x, int y ) {
    grid_array[ x ][ y ] = segment;

  }

  /**
   * This method generates a List of segments which are located around the passed segment (as long
   * as there are neighbours). Special cases like corners and borders of the grid are handled.
   * 
   * @param segment the segment for which the neighbours shall be found
   * @return a List of segments containing all neighbours
   */
  public List< Segment > getNeighbors( Segment segment ) {
    List< Segment > neighbors = new ArrayList<>();

    List< Pair< Integer, Integer > > deltas = new ArrayList< Pair< Integer, Integer > >();

    // Delta values:
    // -1, -1: left above
    // -1, 0: left
    // -1, 1 : left below
    // 0, -1 : above
    // 0, 1 : below
    // 1, -1 : right above
    // 1, 0 : right
    // 1, 1 : right below
    deltas.add( new Pair< Integer, Integer >( -1, -1 ) );
    deltas.add( new Pair< Integer, Integer >( -1, 0 ) );
    deltas.add( new Pair< Integer, Integer >( -1, 1 ) );
    deltas.add( new Pair< Integer, Integer >( 0, -1 ) );
    deltas.add( new Pair< Integer, Integer >( 0, 1 ) );
    deltas.add( new Pair< Integer, Integer >( 1, -1 ) );
    deltas.add( new Pair< Integer, Integer >( 1, 0 ) );
    deltas.add( new Pair< Integer, Integer >( 1, 1 ) );

    for ( Pair< Integer, Integer > p : deltas ) {
      int neighbourX = segment.getX() + p.getKey();
      int neighbourY = segment.getY() + p.getValue();

      if ( neighbourX >= 0 && neighbourX < GameParams.X_SEGMENTS && neighbourY >= 0 && neighbourY < GameParams.Y_SEGMENTS ) {
        neighbors.add( this.getSegmentAt( neighbourX, neighbourY ) );
      }
    }
    return neighbors;
  }

  /**
   * Returns the segment at the passed position
   * 
   * @param x x-coordinate
   * @param y y-coordinate
   * @return the segment instance for the given coordinates
   */
  public Segment getSegmentAt( int x, int y ) {
    return grid_array[ x ][ y ];
  }
}
