package view.console;

import model.CreepEnum;

public abstract class CreepView {

  private static final String[] normalCreep = { "-/\\-", "-\\/-" };
  private static final String[] fastCreep = { "+/\\+", "+\\/+" };
  private static final String[] heavyCreep = { "//\\\\", "\\\\//" };

  public static String getLine( CreepEnum creepEnum, int line ) {
    if ( line < 0 || line > 1 )
      throw new IllegalArgumentException( "Line must be in range of 0 .. 1." );
    String str = null;
    switch ( creepEnum ) {
      case NORMAL :
        str = normalCreep[ line ];
        break;
      case FAST :
        str = fastCreep[ line ];
        break;
      case HEAVY :
        str = heavyCreep[ line ];
        break;
    }
    return str;
  }

}
