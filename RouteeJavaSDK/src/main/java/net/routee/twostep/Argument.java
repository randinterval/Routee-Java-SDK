package net.routee.twostep;



/**
 * If the template is for example '@@name your code is @@pin' and the argument has a property name:
 * 'Nick' the message will be 'Nick your code is 4232'. Note that if the template contains a @@
 * placeholder and a value is not present in the arguments property it will stay as is.
 * 
 */
public class Argument {

  /** The name. */
  String name;

  /** The value. */
  String value;


  /**
   * Instantiates a new argument.
   *
   * @param name the name
   * @param value the value
   */
  public Argument(String name, String value) {
    this.name = name;
    this.value = value;
  }

  /**
   * Instantiates a new argument.
   */
  public Argument() {

  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value the new value
   */
  public void setValue(String value) {
    this.value = value;
  }

}
