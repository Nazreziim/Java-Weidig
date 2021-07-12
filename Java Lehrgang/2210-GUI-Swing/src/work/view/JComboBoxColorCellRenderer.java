package work.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class JComboBoxColorCellRenderer extends DefaultListCellRenderer {
  @Override
  public Component getListCellRendererComponent( JList< ? > list, Object value, int index,
          boolean isSelected, boolean cellHasFocus ) {
    if ( value instanceof Color ) {
      Color tmp = (Color) value;
      String ausgabe = String.format( "r=%03d,g=%03d,b=%03d", tmp.getRed(), tmp.getGreen(),
              tmp.getBlue() );
      value = ausgabe;
    }
    return super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
  }
}
