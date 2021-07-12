package day7.p1c.controls.separated;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Example class to hold the data of a ListView
 */
public class ListViewData {

  /**
   * The observable list. To allow the ListView to be informed about changes in this list, we have
   * to set this list as the model of the ListView.
   */
  private ObservableList< String > list;

  public ListViewData() {
    this.list = FXCollections.< String >observableArrayList();

    this.list.add( "Item 1" );
    this.list.add( "Item 2" );
    this.list.add( "Item 3" );
  }

  public void add( String item ) {
    this.list.add( item );
  }

  public boolean remove( String item ) {
    return this.list.remove( item );
  }

  public String get( int idx ) {
    return this.list.get( idx );
  }

  public ObservableList< String > getList() {
    return this.list;
  }

}
