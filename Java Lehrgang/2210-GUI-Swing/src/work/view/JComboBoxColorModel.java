package work.view;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;

public class JComboBoxColorModel extends DefaultComboBoxModel< Color > {

  private static final long serialVersionUID = 1L;

  public JComboBoxColorModel() {
    this.addElement( Color.BLACK );
    this.addElement( Color.BLUE );
    this.addElement( Color.CYAN );
    this.addElement( Color.DARK_GRAY );
    this.addElement( Color.GRAY );
    this.addElement( Color.GREEN );
    this.addElement( Color.LIGHT_GRAY );
    this.addElement( Color.MAGENTA );
    this.addElement( Color.ORANGE );
    this.addElement( Color.PINK );
    this.addElement( Color.RED );
    this.addElement( Color.WHITE );
    this.addElement( Color.WHITE );
    this.addElement( Color.YELLOW );
  }

}
