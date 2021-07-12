package work.model.filter;

import javax.swing.RowFilter;

import work.model.VerlaufTableModel;

public abstract class AbstractRowFilter<T> extends RowFilter< VerlaufTableModel, Integer > {
    private final Integer spalte;
    private T verglWert;

    public AbstractRowFilter( T verglWert, Integer spalte ) {
      super();
      this.spalte = spalte;
      this.verglWert = verglWert;
    }

    public Integer getSpalte() {
      return spalte;
    }

    public void setVerglWert( T verglWert ) {
      this.verglWert = verglWert;
    }

    public T getVerglWert() {
      return verglWert;
    }
    
}
