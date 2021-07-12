package alt.components.version5_colorchooser.models.tablepanel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ColorTableModel extends AbstractTableModel {

  private static final long serialVersionUID = 1L;

  private final String[] columnNames;
  private List< NamedColor > colorList;

  public ColorTableModel() {
    super();
    this.columnNames = new String[]{ "Farbe", "Rot", "Gruen", "Blau" };
    this.colorList = new ArrayList< NamedColor >();
    initList();
  }

  private void initList() {
    this.colorList.add( new NamedColor( "Schwarz", Color.BLACK ) );
    this.colorList.add( new NamedColor( "Blau", Color.BLUE ) );
    this.colorList.add( new NamedColor( "Cyan", Color.CYAN ) );
    this.colorList.add( new NamedColor( "Grau", Color.GRAY ) );
    this.colorList.add( new NamedColor( "Magenta", Color.MAGENTA ) );
    this.colorList.add( new NamedColor( "Orange", Color.ORANGE ) );
    this.colorList.add( new NamedColor( "Pink", Color.PINK ) );
    this.colorList.add( new NamedColor( "Rot", Color.RED ) );
    this.colorList.add( new NamedColor( "Weiss", Color.WHITE ) );
    this.colorList.add( new NamedColor( "Gelb", Color.YELLOW ) );
  }

  @Override
  public int getRowCount() {
    return this.colorList.size();
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public String getColumnName( int column ) {
    return this.columnNames[ column ];
  }

  @Override
  public boolean isCellEditable( int row, int column ) {
    return true;
  }

  @Override
  public Object getValueAt( int row, int column ) {
    NamedColor aktuelleFarbe = colorList.get( row );
    String erg = null;
    switch ( column ) {
      case 0 :
        erg = aktuelleFarbe.getName();
        break;
      case 1 :
        erg = Integer.toString( aktuelleFarbe.getFarbe().getRed() );
        break;
      case 2 :
        erg = Integer.toString( aktuelleFarbe.getFarbe().getGreen() );
        break;
      case 3 :
        erg = Integer.toString( aktuelleFarbe.getFarbe().getBlue() );
        break;
    }
    return erg;
  }

  @Override
  public void setValueAt( Object aValue, int row, int column ) {
    String name = this.colorList.get( row ).getName();
    Color color = this.colorList.get( row ).getFarbe();
    int rot = color.getRed();
    int gruen = color.getGreen();
    int blau = color.getBlue();
    int farbwert = -1;

    if ( column == 0 && aValue.getClass() == String.class ) {
      name = (String) aValue;
    } else if ( aValue.getClass() == String.class ) {
      try {
        farbwert = Integer.parseInt( (String) aValue );
      } catch ( NumberFormatException e ) {
      }
    }

    if ( column == 1 ) {
      rot = farbwert;
    } else if ( column == 2 ) {
      gruen = farbwert;
    } else if ( column == 3 ) {
      blau = farbwert;
    }

    this.colorList.set( row, new NamedColor( name, new Color( rot, gruen, blau ) ) );
    fireTableCellUpdated( row, column );
  }

  public int addColor() {
    int sizeOld = this.colorList.size();
    this.colorList.add( new NamedColor( "default", Color.BLACK ) );
    fireTableRowsInserted( sizeOld, sizeOld );
    return sizeOld;
  }

  public void removeColor( int row ) {
    this.colorList.remove( row );
    fireTableRowsDeleted( row, row );
  }

  public Color getColorAtRow( int row ) {
    return this.colorList.get( row ).getFarbe();
  }

  public int getRow( int rot, int gruen, int blau ) {
    int ergebnis = -1;
    boolean gefunden = false;
    for ( int i = 0; i < this.colorList.size() && !gefunden; ++i ) {
      Color tmp = this.colorList.get( i ).getFarbe();
      if ( tmp.getRed() == rot && tmp.getGreen() == gruen && tmp.getBlue() == blau ) {
        ergebnis = i;
        gefunden = true;
      }
    }
    return ergebnis;
  }

}
