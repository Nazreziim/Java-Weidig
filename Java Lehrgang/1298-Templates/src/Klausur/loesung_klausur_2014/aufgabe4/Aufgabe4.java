package loesung_klausur_2014.aufgabe4;

public class Aufgabe4{


  public static void main(String[] args){
    Tree tree = new Tree();

    for (int i = 0; i < 3; i++){
      // zufällige Werte einfügen
      tree.insert((int)(Math.random()*100));
    }
    tree.root.print_pretty();
    System.out.println("Der Baum ist balanciert: " + tree.isBalancedTree());
    System.out.println("Der Baum hat " + tree.countInnerNodes() + " innere Knoten");
  }
}

