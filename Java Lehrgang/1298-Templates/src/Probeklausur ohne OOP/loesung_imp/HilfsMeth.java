package loesung_imp;

import java.io.*;

public class HilfsMeth {    
  
    /**
   * Die Funktion fordert den Nutzer dazu auf, einen Byte
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als byte zurück. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie ein byte ein.
   */
  public static byte readByte() {
    return readByte("Bitte geben Sie ein byte ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ byte
   * über die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Byte zurück.
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
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als short zurück. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine ganze Zahl vom Typ short ein.
   */
  public static short readShort() {
    return readShort("Bitte geben Sie eine ganze Zahl vom Typ short ein ");
  }
  /**
   *  Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ short
   *  über die Kommandozeile einzugeben, liest diese ein und gibt
   *  sie als short-Integerwert zurück.
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
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als int zurück. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine ganze Zahl vom Typ int ein 
   */
  public static int readInt() {
    return readInt("Bitte geben Sie eine ganze Zahl vom Typ int ein ");
  }

  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ int
   * über die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Integerwert zurück.
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
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als long zurück. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine ganze Zahl vom Typ long ein 
   */
  public static long readLong() {
    return readLong("Bitte geben Sie eine ganze Zahl vom Typ long ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ long
   * über die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als long-Integerwert zurück. 
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
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als float zurück. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine Zahl vom Typ float ein 
   */
  public static float readFloat() {
    return readFloat("Bitte geben Sie eine Zahl vom Typ float ein ");
  }
  
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
   * über die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Floatwert zurück.  
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
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als String zurück. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine Zahl vom Typ double ein 
   */
  public static double readDouble() {
    return readDouble("Bitte geben Sie eine Zahl vom Typ double ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
   * über die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Doublewert zurück. 
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
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als char zurück. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie ein Zeichen ein 
   */
  public static char readChar() {
    return readChar("Bitte geben Sie ein Zeichen ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, ein Character - Zeichen
   * über die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Char zurück. 
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
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als String zurück. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine Zeichenreihe ein  
   */
  public static String readString() {
    return readString("Bitte geben Sie eine Zeichenreihe ein ");
  }
  
  /**
    * Die Funktion fordert den Nutzer dazu auf, eine Zeichenreihe
    * über die Kommandozeile einzugeben, liest diese ein und gibt
    * sie als String zurück.
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
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als Boolwert zurück. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie true oder false ein 
   */
  public static boolean readBoolean()  {
    return readBoolean("Bitte geben Sie true oder false ein ");
  }
  
  /**
   * Die Funktion fordert den Nutzer dazu auf, einen Wahrheitswert
   * über die Kommandozeile einzugeben, liest diesen ein und gibt
     * ihn als Boolwert zurück. 
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