package loesung_imp;

import java.io.*;

public class HilfsMeth {    
  
    /**
   * Die Funktion fordert den Nutzer dazu auf, einen Byte
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als byte zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie ein byte ein.
   */
  public static byte readByte() {
    return readByte("Bitte geben Sie ein byte ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ byte
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Byte zur�ck.
   * */
  public static byte readByte(String abfrage) {

    try {
      byte a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(abfrage);
      a = Byte.parseByte(testin.readLine());
      return a;
    }
    catch (IOException e) {return 42;}
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Short
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als short zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine ganze Zahl vom Typ short ein.
   */
  public static short readShort() {
    return readShort("Bitte geben Sie eine ganze Zahl vom Typ short ein ");
  }
  /**
   *  Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ short
   *  �ber die Kommandozeile einzugeben, liest diese ein und gibt
   *  sie als short-Integerwert zur�ck.
   */
  public static short readShort(String abfrage) {  
    try {
      short a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(abfrage);
      a = Short.parseShort(testin.readLine()); 
      return a;
    }
    catch (IOException e) {return 42;}
  }

     /**
   * Die Funktion fordert den Nutzer dazu auf, einen Integer
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als int zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine ganze Zahl vom Typ int ein 
   */
  public static int readInt() {
    return readInt("Bitte geben Sie eine ganze Zahl vom Typ int ein ");
  }

  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ int
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Integerwert zur�ck.
   */
  public static int readInt(String abfrage)  {
    
    try {
      int a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Integer.parseInt(testin.readLine()); 
      return a;
    }
    catch (IOException e) {return 42;}
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Long
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als long zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine ganze Zahl vom Typ long ein 
   */
  public static long readLong() {
    return readLong("Bitte geben Sie eine ganze Zahl vom Typ long ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ long
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als long-Integerwert zur�ck. 
   */
  public static long readLong(String abfrage) {
    
    try {
      long a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Long.parseLong(testin.readLine());
      return a;
    }
    catch (IOException e) {return 42;}
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Float
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als float zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine Zahl vom Typ float ein 
   */
  public static float readFloat() {
    return readFloat("Bitte geben Sie eine Zahl vom Typ float ein ");
  }
  
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Floatwert zur�ck.  
   */
  public static float readFloat(String abfrage) {
  
    try {
      float a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Float.parseFloat(testin.readLine());
      return a;
    }
    catch (IOException e) {return 42.0f;}
  }

     /**
   * Die Funktion fordert den Nutzer dazu auf, einen String
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als String zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine Zahl vom Typ double ein 
   */
  public static double readDouble() {
    return readDouble("Bitte geben Sie eine Zahl vom Typ double ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Doublewert zur�ck. 
   * 
   */
  public static double readDouble(String abfrage) {
    
    try {
      double a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Double.parseDouble(testin.readLine());
      return a;
    }
    catch (IOException e) {return 42.0;}
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Character
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als char zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie ein Zeichen ein 
   */
  public static char readChar() {
    return readChar("Bitte geben Sie ein Zeichen ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, ein Character - Zeichen
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Char zur�ck. 
   */
  public static char readChar(String abfrage) {
    
    try {
      char a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = testin.readLine().charAt(0);
      return a;
    }
    catch (IOException e) {return 'f';}
  }

   /**
   * Die Funktion fordert den Nutzer dazu auf, einen String
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als String zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine Zeichenreihe ein  
   */
  public static String readString() {
    return readString("Bitte geben Sie eine Zeichenreihe ein ");
  }
  
  /**
    * Die Funktion fordert den Nutzer dazu auf, eine Zeichenreihe
    * �ber die Kommandozeile einzugeben, liest diese ein und gibt
    * sie als String zur�ck.
   */
  public static String readString(String abfrage) {
    
    try {
      String a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = testin.readLine();
      return a;
    }
    catch (IOException e) {return "IO-Fehler";}
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Wahrheitswert
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als Boolwert zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie true oder false ein 
   */
  public static boolean readBoolean()  {
    return readBoolean("Bitte geben Sie true oder false ein ");
  }
  
  /**
   * Die Funktion fordert den Nutzer dazu auf, einen Wahrheitswert
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
     * ihn als Boolwert zur�ck. 
   */
  public static boolean readBoolean(String abfrage) {

    try {
      boolean a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Boolean.valueOf(testin.readLine()).booleanValue();
      return a;
    }
    catch (IOException e) {return false;}
  } 
}