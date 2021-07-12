package seminarplaner2012.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HilfsMeth {    
  
    /**
   * Die Funktion fordert den Nutzer dazu auf, einen Byte
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als byte zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie ein byte ein.
     * @throws IOException 
     * @throws NumberFormatException 
   */
  public static byte readByte() throws NumberFormatException, IOException {
    return readByte("Bitte geben Sie ein byte ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ byte
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Byte zur�ck.
 * @throws IOException 
 * @throws NumberFormatException 
   * */
  public static byte readByte(String abfrage) throws NumberFormatException, IOException {

      byte a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(abfrage);
      a = Byte.parseByte(testin.readLine());
      return a;
   
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Short
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als short zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine ganze Zahl vom Typ short ein.
 * @throws IOException 
 * @throws NumberFormatException 
   */
  public static short readShort() throws NumberFormatException, IOException {
    return readShort("Bitte geben Sie eine ganze Zahl vom Typ short ein ");
  }
  /**
   *  Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ short
   *  �ber die Kommandozeile einzugeben, liest diese ein und gibt
   *  sie als short-Integerwert zur�ck.
 * @throws IOException 
 * @throws NumberFormatException 
   */
  public static short readShort(String abfrage) throws NumberFormatException, IOException {  
      short a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(abfrage);
      a = Short.parseShort(testin.readLine()); 
      return a;
    
  }

     /**
   * Die Funktion fordert den Nutzer dazu auf, einen Integer
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als int zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine ganze Zahl vom Typ int ein 
     * @throws IOException 
     * @throws NumberFormatException 
   */
  public static int readInt() throws NumberFormatException, IOException {
    return readInt("Bitte geben Sie eine ganze Zahl vom Typ int ein ");
  }

  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ int
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Integerwert zur�ck.
 * @throws IOException 
 * @throws NumberFormatException 
   */
  public static int readInt(String abfrage) throws NumberFormatException, IOException  {
    
      int a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Integer.parseInt(testin.readLine()); 
      return a;
   
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Long
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als long zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine ganze Zahl vom Typ long ein 
 * @throws IOException 
 * @throws NumberFormatException 
   */
  public static long readLong() throws NumberFormatException, IOException {
    return readLong("Bitte geben Sie eine ganze Zahl vom Typ long ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Zahl vom Typ long
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als long-Integerwert zur�ck. 
 * @throws IOException 
 * @throws NumberFormatException 
   */
  public static long readLong(String abfrage) throws NumberFormatException, IOException {
    
      long a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Long.parseLong(testin.readLine());
      return a;
   
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Float
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als float zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine Zahl vom Typ float ein 
 * @throws IOException 
 * @throws NumberFormatException 
   */
  public static float readFloat() throws NumberFormatException, IOException {
    return readFloat("Bitte geben Sie eine Zahl vom Typ float ein ");
  }
  
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Floatwert zur�ck.  
 * @throws IOException 
 * @throws NumberFormatException 
   */
  public static float readFloat(String abfrage) throws NumberFormatException, IOException {
  
      float a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Float.parseFloat(testin.readLine());
      return a;
  
  }

     /**
   * Die Funktion fordert den Nutzer dazu auf, einen String
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als String zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine Zahl vom Typ double ein 
     * @throws IOException 
     * @throws NumberFormatException 
   */
  public static double readDouble() throws NumberFormatException, IOException {
    return readDouble("Bitte geben Sie eine Zahl vom Typ double ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, eine ganze Gleitkommazahl
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Doublewert zur�ck. 
 * @throws IOException 
 * @throws NumberFormatException 
   * 
   */
  public static double readDouble(String abfrage) throws NumberFormatException, IOException {
    
     double a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Double.parseDouble(testin.readLine());
      return a;
   
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Character
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als char zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie ein Zeichen ein 
 * @throws IOException 
   */
  public static char readChar() throws IOException {
    return readChar("Bitte geben Sie ein Zeichen ein ");
  }
  /**
   * Die Funktion fordert den Nutzer dazu auf, ein Character - Zeichen
   * �ber die Kommandozeile einzugeben, liest diese ein und gibt
   * sie als Char zur�ck. 
 * @throws IOException 
   */
  public static char readChar(String abfrage) throws IOException {
    
      char a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = testin.readLine().charAt(0);
      return a;
   
  }

   /**
   * Die Funktion fordert den Nutzer dazu auf, einen String
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als String zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie eine Zeichenreihe ein  
 * @throws IOException 
   */
  public static String readString() throws IOException {
    return readString("Bitte geben Sie eine Zeichenreihe ein ");
  }
  
  /**
    * Die Funktion fordert den Nutzer dazu auf, eine Zeichenreihe
    * �ber die Kommandozeile einzugeben, liest diese ein und gibt
    * sie als String zur�ck.
 * @throws IOException 
   */
  public static String readString(String abfrage) throws IOException {
    
     String a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = testin.readLine();
      return a;
    
  }
   /**
   * Die Funktion fordert den Nutzer dazu auf, einen Wahrheitswert
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
   * ihn als Boolwert zur�ck. Dabei wird ein Standard - Text vor der Eingabe
   * ausgegeben: Bitte geben Sie true oder false ein 
 * @throws IOException 
   */
  public static boolean readBoolean() throws IOException  {
    return readBoolean("Bitte geben Sie true oder false ein ");
  }
  
  /**
   * Die Funktion fordert den Nutzer dazu auf, einen Wahrheitswert
   * �ber die Kommandozeile einzugeben, liest diesen ein und gibt
     * ihn als Boolwert zur�ck. 
 * @throws IOException 
   */
  public static boolean readBoolean(String abfrage) throws IOException {

     boolean a;
      BufferedReader testin = new BufferedReader(new InputStreamReader(System.in));
      System.out.print(abfrage);
      a = Boolean.valueOf(testin.readLine()).booleanValue();
      return a;
    
  } 
}