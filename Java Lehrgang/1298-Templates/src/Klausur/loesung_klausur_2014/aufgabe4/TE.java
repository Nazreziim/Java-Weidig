package loesung_klausur_2014.aufgabe4;

public class TE{
  public int key;
  TE pL;
  TE pR;

  public TE(int key){
    this.key = key;
  }
  
  public void insert(int key){
    if(key <= this.key){
      if(this.pL != null){
        this.pL.insert(key);
      }
      else{
        this.pL = new TE(key);
      }
    }
    else{
      if(this.pR != null){
        this.pR.insert(key);
      }
      else{
        this.pR = new TE(key);
      }
    }
  }
  
   public int countInner(){
          int erg = 0;
          if(this.pL == null && this.pR == null) {
          }
          else{
            if(this.pL != null){
                     erg = this.pL.countInner();

            }
            if(this.pR != null){
                 erg += this.pR.countInner();

            }
            erg = erg + 1;
          }
          return erg;
  }
  
  public boolean check(int x){
         boolean erg = false;
         if(this.key == x){
                     return true;
         }
         if(this.pL == null && this.pR == null){
                    return false;
         }
         else{
            if(this.pL != null){
                       erg = erg || pL.check(x);
            }
            if(this.pR != null){
                       erg = erg || pR.check(x);
            }
         }
         return erg;
  }
  public boolean checkDouble(){
          boolean test = false;
          if(this.pL != null){
                     test = this.pL.check(this.key)||  this.pL.checkDouble();

          }
          if(this.pR != null){
                test = test || this.pR.check(this.key)||  this.pR.checkDouble();

          }
          return test;
  }
  
  public void print_pretty(){
    int hoehe = this.hoehe();
    int breite = this.breite();
    String[][] ausgabe = new String[hoehe+1][];

    for(int i = 0 ; i < ausgabe.length ; i++){
      ausgabe[i] = new String[breite];
      for(int j = 0 ; j < ausgabe[i].length ; j++){
        ausgabe[i][j] = "";
      }
    }

    this.print_pretty_hilf(0,0,ausgabe);

    for(int i = 0 ; i <= hoehe ; i++){
            String str = "";
            for(int j = 0 ; j < breite ; j++){
                    if(ausgabe[i][j].equals("")){
                                                 str += "  ";
                    }
                    else{
                         str += ausgabe[i][j];
                    }
            }
            System.out.println(str);
            System.out.println();
    }
  }



  /**
  * @param eigeneTiefe - gibt die Tiefe des this-Objekte im Baum, und somit die Zeile im Array ausgabe, an
  * @param spalte  - gibt die Spaltenposition der übergeordneten Ebene an.
  *                  Denn geht man nach rechts in einem Baum, muss auf die Spalte die Spalte der vorgänger Ebene dazu genommen werden.
  * @param ausgabe - String-Array, in das die Ausgabe geschrieben wird. Dies muss soviel Zeilen wie die Höhe des Baumes + 1 und soviel
                     Spalten, wie die Breite des Baumes haben.
  */
  private void print_pretty_hilf(int eigeneTiefe,int spalte,String[][] ausgabe){
    int index = 0;
    //Linke Teilbaum drucken
    if(pL != null){
       //Linksrum hat die Position der Aktuellen Ebene keine Auswirkung auf die nächste Ebene, deshalb wird Spalte einfach übergeben
       pL.print_pretty_hilf(eigeneTiefe+1,spalte,ausgabe);
       //Der Teilbaum braucht Platz, deshalb wird auf den Index die Breite hinzuaddiert
       index += pL.breite();
    }
    else{
         //Links gibt es nur einen Nullpointer, der hier ausgegeben wird
         ausgabe[eigeneTiefe+1][index+spalte] = "_/";
         //Wichtig der Nullpointer braucht natürlich eine Stelle Platz, deswegen index+1
         index+=1;
    }
    //Nun noch zum Index(Breite linker Baum) die Verschiebung durch die Überebene hinzufügen
    index += spalte;
    ausgabe[eigeneTiefe][index] = "" + this.key;


    if(pR != null){
          //Drucken des rechten Teilbaumes, dieser muss natürlich um die horizontale Position der aktuellen Ebene verschoben werden,
          //deshalb spalte für die nächste Ebene ist mindestens index dieser Ebene + 1
       pR.print_pretty_hilf(eigeneTiefe+1,index+1,ausgabe);
    }

    else{
         //Drucken des Nullpointers links
         index+=1;
         ausgabe[eigeneTiefe+1][index] = "\\_";

    }

  }
    public int hoehe(){
    int l = 0;
    int r = 0;
    if(pL != null){
      l = pL.hoehe();
    }
    if(pR != null){
      r = pR.hoehe();
    }
    int erg = Math.max(l,r) + 1;
    return erg;
  }

  private int anzKnoten(){
    int l = 0;
    int r = 0;
    if(pL != null){
      l = pL.anzKnoten();
    }
    if(pR != null){
      r = pR.anzKnoten();
    }
    int erg = l + r + 1;
    return erg;
  }


  private int anzNull(){
    int erg = 0;
    if(pL != null){
          erg += pL.anzNull();
    }
    else{
          erg++;
    }
    if(pR != null){
      erg += pR.anzNull();
    }
    else{
          erg++;
    }
    return erg;
  }

  public int breite(){
         return  this.anzKnoten() + this.anzNull();
  }

public boolean isBalancedTree() {
	int lHoehe=0;
	int rHoehe=0;
	if (pL != null) {
		lHoehe = pL.hoehe();
	}
	if (pR != null) {
		rHoehe = pR.hoehe();
	}
	if (Math.abs(lHoehe-rHoehe) <= 1) {
		return true;
	} else {
		return false;
	}
}
}