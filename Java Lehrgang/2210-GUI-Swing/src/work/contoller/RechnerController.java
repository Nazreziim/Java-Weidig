package work.contoller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import work.model.Rechner;
import work.model.Rechnung;

public class RechnerController implements PropertyChangeListener{

  private final PropertyChangeSupport changeSupport;
  private final Rechner rechner;
  
  
  public RechnerController(Rechner rechner ) {
    super();
    this.rechner = rechner;
    this.changeSupport = new PropertyChangeSupport( this );
  }


  @Override
  public void propertyChange( PropertyChangeEvent evt ) {
      
    // 3.3 Controller hoert auf die Nachricht des KalkulationsPanels,
    // da dieser angemeldet ist.( siehe Anmeldung in MainFrame )
    if ( evt.getPropertyName().equals( "button" ) && evt.getNewValue() instanceof Rechnung ) {
       Rechnung rechnung = (Rechnung) evt.getNewValue();
       Rechnung erg = null;
       double wert1 = rechnung.getOp1();
       double wert2 = rechnung.getOp2();
       
       // 3.4 Controller loest die Berechnung im Model (Rechner) an.
       // und bekommt das Ergebnis zurueck.
       switch (rechnung.getOperation()) {
         case ADD:
           erg = rechner.add( wert1, wert2 );
           break;
         case SUB:
           erg = rechner.sub(  wert1, wert2);
           break;
         case MULT:
           erg = rechner.mult( wert1, wert2);
           break;
         case DIV:
           erg = rechner.div( wert1, wert2);
           break;
           default:
             
       }
      
       // 3.5 Controller sendet das Ergebnis an alle Interessenten (KalkulatorPanel).
       // (angemeldet am ErgebnisListener, siehe MainFrame)
       this.changeSupport.firePropertyChange( "Controller", null, erg);
          
    }
  }
  
  
    
  public void addErgebnisListener(PropertyChangeListener l) {
      this.changeSupport.addPropertyChangeListener( l );
  }
  
  public void removeErgebnisListener(PropertyChangeListener l) {
    this.changeSupport.removePropertyChangeListener( l );
  }
  
}
