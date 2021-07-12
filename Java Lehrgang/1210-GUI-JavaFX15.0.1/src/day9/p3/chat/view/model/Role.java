package day9.p3.chat.view.model;

public enum Role {
  ADMINISTRATOR( "Administrator", "Admin" ),
  MODERATOR( "Moderator", "Mod" ),
  USER( "User", "User" );

  private String text;
  private String abbreviation;

  private Role( String text, String abbreviation ) {
    this.text = text;
    this.abbreviation = abbreviation;
  }

  public String getText() {
    return this.text;
  }

  public String getAbbreviation() {
    return this.abbreviation;
  }

}
