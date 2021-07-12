package alt.components.version5_colorchooser.models.tablepanel;

import java.awt.Color;

public class NamedColor {
  private String name;
  private Color farbe;

  public NamedColor( String name, Color farbe ) {
    super();
    this.name = name;
    this.farbe = farbe;
  }

  public String getName() {
    return name;
  }

  public Color getFarbe() {
    return farbe;
  }

}
