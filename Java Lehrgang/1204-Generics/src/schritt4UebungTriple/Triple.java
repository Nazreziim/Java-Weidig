package schritt4UebungTriple;

public class Triple< T extends Comparable< T > > {
  private T elem1;
  private T elem2;
  private T elem3;

  public boolean isAscending() {
    return this.elem1.compareTo( this.elem2 ) < 0 && this.elem2.compareTo( this.elem3 ) < 0;
  }

  public boolean isDescending() {
    return this.elem1.compareTo( this.elem2 ) > 0 && this.elem2.compareTo( this.elem3 ) > 0;
  }

  public boolean isOrdered() {
    return this.isAscending() || this.isDescending();
  }

  public boolean allValuesEqual() {
    return this.elem1.compareTo( this.elem2 ) == 0 && this.elem1.compareTo( this.elem3 ) == 0;
  }

  public boolean allValuesDifferent() {
    return this.elem1.compareTo( this.elem2 ) != 0 && this.elem1.compareTo( this.elem3 ) != 0
            && this.elem2.compareTo( this.elem3 ) != 0;
  }

  public T getElem1() {
    return this.elem1;
  }

  public void setElem1( T elem1 ) {
    this.elem1 = elem1;
  }

  public T getElem2() {
    return this.elem2;
  }

  public void setElem2( T elem2 ) {
    this.elem2 = elem2;
  }

  public T getElem3() {
    return this.elem3;
  }

  public void setElem3( T elem3 ) {
    this.elem3 = elem3;
  }
}
