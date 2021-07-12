package random;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class RandomTextField extends JTextField implements ActionListener, ChangeListener {
  private static final long serialVersionUID = -8183469094932410075L;
  private SpinnerNumberModel min;
  private SpinnerNumberModel max;
  private Font tfFontDefault;
  private Font tfFontSuccess;
  private Font tfFontFailure;

  public RandomTextField( SpinnerNumberModel min, SpinnerNumberModel max ) {
    super();
    this.min = min;
    this.max = max;
    this.tfFontDefault = this.getFont();
    Map< Attribute, Object > fontAttributes = new HashMap< Attribute, Object >();
    fontAttributes.put( TextAttribute.FOREGROUND, Color.BLACK );
    fontAttributes.put( TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD );
    this.tfFontSuccess = tfFontDefault.deriveFont( fontAttributes );
    fontAttributes.put( TextAttribute.FOREGROUND, Color.RED );
    this.tfFontFailure = tfFontDefault.deriveFont( fontAttributes );
  }

  @Override
  public void actionPerformed( ActionEvent arg0 ) {
    int min = (Integer) this.min.getNumber();
    int max = (Integer) this.max.getNumber();
    if ( max >= min ) {
      int zufall = (int) ( Math.random() * ( max - min ) + min );
      this.setHorizontalAlignment( JTextField.RIGHT );
      this.setFont( this.tfFontSuccess );
      this.setText( Integer.toString( zufall ) );
    } else {
      this.setHorizontalAlignment( JTextField.CENTER );
      this.setFont( this.tfFontFailure );
      this.setText( "Ungültig" );
    }
  }

  @Override
  public void stateChanged( ChangeEvent e ) {
    this.actionPerformed( null );
  }
}
