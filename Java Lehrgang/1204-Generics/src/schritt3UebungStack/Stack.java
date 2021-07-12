package schritt3UebungStack;

public class Stack< T extends Comparable< T > > {

  private StackElement< T > stack;

  /**
   * Ein neues Element auf den Stack legen.
   * 
   * @param elem
   */
  public void push( T elem ) {
    this.stack = new StackElement< T >( elem, this.stack );
  }

  /**
   * Das oberste Element zurückgeben.
   * 
   * @return Das oberste Element.
   */
  public T top() {
    T result = null;
    if ( !this.isEmpty() ) {
      result = this.stack.getInhalt();
    }
    return result;
  }

  /**
   * Das oberste Element zurückgeben und vom Stack entfernen.
   * 
   * @return Das oberste Element.
   */
  public T pop() {
    T result = this.top();
    if ( !this.isEmpty() ) {
      this.stack = this.stack.next();
    }
    return result;
  }

  /**
   * Ist der Stack leer?
   * 
   * @return true, falls leer, andernfalls false.
   */
  public boolean isEmpty() {
    return this.stack == null;
  }

  /**
   * Das größte Element des Stacks zurückgeben.
   * 
   * @return Das größte Element des Stacks.
   */
  public T getMax() {
    return this.stack.getMax( null );
  }

}
