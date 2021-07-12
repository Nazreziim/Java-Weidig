package loesung_klausur_2014.aufgabe4;

public class Tree{
       TE root;
       
       /*
         Platz fuer Ihre Methoden countInnerNodes
       */

       public void insert(int key){
        if(root != null){
          root.insert(key);
        }
        else{
          root = new TE(key);
        }
       }
       public int countInnerNodes(){
              if(this.root == null){

                           return 0;
              }
              else{
                   return this.root.countInner()-1;
              }
       }
       
	public boolean isBalancedTree() {
		if (this.root == null) {
			return true; 
		} else {
			return this.root.isBalancedTree();
		}
	}
}