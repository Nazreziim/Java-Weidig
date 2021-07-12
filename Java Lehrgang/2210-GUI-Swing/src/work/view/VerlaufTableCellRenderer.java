package work.view;

import java.awt.Component;
import java.time.LocalDateTime;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import work.model.VerlaufTableModel;

public class VerlaufTableCellRenderer extends DefaultTableCellRenderer {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
	    String wert = "---";
		
		if ( value instanceof LocalDateTime ) {
			LocalDateTime ldt = (LocalDateTime) value;
			wert = ldt.format(VerlaufTableModel.getDtf());
		}
		
		JLabel label = (JLabel) super.getTableCellRendererComponent( table, wert, isSelected, hasFocus, row, column );
		
		label.setHorizontalAlignment( SwingConstants.CENTER  );
		return label;
	}

}
