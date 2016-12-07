package net.routee.messaging;



/**
 * The Class RecipientGroup.
 */
public class RecipientGroup {

  /** The group name. */
  private String groupName;

  /** The number. */
  private String number;


  /**
   * Instantiates a new recipient group.
   *
   * @param groupName the group name
   * @param number the number
   */
  public RecipientGroup(String groupName, String number) {
    this.groupName = groupName;
    this.number = number;
  }

  /**
   * Instantiates a new recipient group.
   */
  public RecipientGroup() {

  }

  /**
   * Gets the group name.
   *
   * @return the group name
   */
  public String getGroupName() {
    return groupName;
  }

  /**
   * Sets the group name.
   *
   * @param groupName the new group name
   */
  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  /**
   * Gets the number.
   *
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * Sets the number.
   *
   * @param number the new number
   */
  public void setNumber(String number) {
    this.number = number;
  }

}
