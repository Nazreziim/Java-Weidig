package beispiel02;

public class ThreadStarten {

  public static void main( String[] args ) {
    Thread dateThread = new DateThread();
    dateThread.start();

  }

}
