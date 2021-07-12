package work.model.filter;

import work.model.Operation;
import work.model.VerlaufTableModel;

public class OperRowFilter extends AbstractRowFilter<Operation> {

  public OperRowFilter( Operation verglOper, Integer spalte ) {
    super( verglOper, spalte );
  }


  @Override
  public boolean include( Entry< ? extends VerlaufTableModel, ? extends Integer > entry ) {
    boolean isIncluded = true;

    if ( getVerglWert() != null ) {
      Operation oper = (Operation) entry.getValue( getSpalte() );
      isIncluded = oper.ordinal() >= getVerglWert().ordinal();
    }

    return isIncluded;
  }

}
