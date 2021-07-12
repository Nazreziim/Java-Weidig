package loesung_klausur_2013;

public class Tree{
       TE root;
       
       /*
         Platz fuer Ihre Methoden checkDouble und countInnerNodes
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
       public boolean checkDouble(){
              if(this.root == null){

                           return false;
              }
              else{
                   return this.root.checkDouble();
              }
       }
}