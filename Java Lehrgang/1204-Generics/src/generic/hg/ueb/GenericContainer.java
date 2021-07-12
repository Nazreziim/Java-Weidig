package generic.hg.ueb;

public class GenericContainer <C>{

	private C content;
	private GenericContainer <C> next;
	private GenericContainer <C> prev;
	private GenericContainer <C> last;
	private GenericContainer <C> first;
	
	
	//Konstruktor
	public GenericContainer () {
		super();
	}


	//Getter / Setter
	public C getContent() {
		return content;
	}


	public void setContent(C content) {
		this.content = content;
	}
	
	
	public GenericContainer<C> getNext() {
		return next;
	}


	public void setNext(GenericContainer<C> next) {
		this.next = next;
	}


	public GenericContainer<C> getPrev() {
		return prev;
	}


	public void setPrev(GenericContainer<C> prev) {
		this.prev = prev;
	}


	public GenericContainer<C> getLast() {
		return last;
	}


	public void setLast(GenericContainer<C> last) {
		this.last = last;
	}


	public GenericContainer<C> getFirst() {
		return first;
	}


	public void setFirst(GenericContainer<C> first) {
		this.first = first;
	}
	
	
	
	
}
