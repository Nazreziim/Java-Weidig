package work.model.filter;

import work.model.VerlaufTableModel;

public class DoubleRowFilter extends AbstractRowFilter<Double> {
  
  
  public DoubleRowFilter( Double verglWert, Integer spalte ) {
    super(verglWert, spalte);
  }

  @Override
  public boolean include( Entry< ? extends VerlaufTableModel, ? extends Integer > entry ) {
    boolean isIncluded = false;
    
    if (getVerglWert() != null) {
      Double wert = (Double) entry.getValue(getSpalte());
      isIncluded = wert >= getVerglWert();
    }
    
    return isIncluded;
  }

}
