package work.model.filter;

import java.time.LocalDateTime;

import work.model.VerlaufTableModel;

public class TimeRowFilter extends AbstractRowFilter<LocalDateTime> {


  public TimeRowFilter( LocalDateTime verglTime, Integer spalte ) {
    super( verglTime, spalte );
  }


  @Override
  public boolean include( Entry< ? extends VerlaufTableModel, ? extends Integer > entry ) {
    boolean isIncluded = false;

    if ( getVerglWert() != null ) {
      LocalDateTime time = (LocalDateTime) entry.getValue( getSpalte());
      isIncluded = time.isEqual( getVerglWert() ) || time.isAfter( getVerglWert() );
    }

    return isIncluded;
  }

}
