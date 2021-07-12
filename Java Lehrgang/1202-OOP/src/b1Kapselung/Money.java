package b1Kapselung;

public class Money{
		private int amount;
		/**
		 * Die W‰hrung ist final und wird bei der ersten Zuweisung unver‰nderlich.
		 * Konstanten werden groﬂ geschrieben.
		 */
		private final String CURRENCY;
		
		public Money(int amount, String currency){
			this.amount = amount;
			this.CURRENCY = currency;
		}
		
		public int getAmount(){
			return this.amount;
		}
		public String getCurrency(){
			return this.CURRENCY;
		}
		
		public void setAmount(int amount){
			this.amount = amount;
		}
		
		public boolean isZero(){
			return (this.amount == 0);
		}
		
		public Money add(Money m){
			if(this.CURRENCY.equals(m.CURRENCY)){
				this.amount += m.amount; 
			}
			return this;
		}
		
		public Money subtract(Money m){
			if(this.CURRENCY.equals(m.CURRENCY)){
				this.amount -= m.amount; 
			}
			return this;
		}
		
		public Money multiply(int factor){
			this.amount *= factor;
			return this;
		}
		
		public boolean equals(Object o){
			boolean erg = false;
			if(o instanceof Money){
				Money hilfZeiger = ((Money)o);
				erg = (this.amount == hilfZeiger.amount) && (this.CURRENCY==hilfZeiger.CURRENCY);  
			}
			return erg;
		}
		
		public void print(){
			System.out.println(this.amount + " " + this.CURRENCY);
		}
		
		public String toString(){
			return this.amount+" "+this.CURRENCY;
		}
	
}
