package loesung_klausur_2013;

public class Aufgabe4{


  public static void main(String[] args){
    Tree tree = new Tree();

    for (int i = 0; i < 20; i++){
      // zufällige Werte einfügen
      tree.insert((int)(Math.random()*100));
    }
    tree.root.print_pretty();
    System.out.println("Es gibt " + tree.countInnerNodes() + " Innere Knoten");

    if (tree.checkDouble()){
      System.out.println("enthaelt doppelte Werte!");
    }else{
      System.out.println("nur Unikate");
    }
  }
}

