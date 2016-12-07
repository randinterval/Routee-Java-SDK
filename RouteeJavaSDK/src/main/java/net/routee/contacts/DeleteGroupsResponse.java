package net.routee.contacts;

import org.json.JSONObject;


/**
 * The Class DeleteGroupsResponse.
 */
public class DeleteGroupsResponse {

  /**
   * Instantiates a new delete groups response.
   *
   * @param name the name
   * @param deletedContacts the deleted contacts
   */
  public DeleteGroupsResponse(String name, boolean deletedContacts) {
    this.name = name;
    this.deletedContacts = deletedContacts;
  }

  /**
   * Instantiates a new delete groups response.
   */
  public DeleteGroupsResponse() {

  }

  /** The name of the group that was deleted. */
  private String name;

  /** Indicates whether the contacts contained in the groups were also deleted or not. */
  private boolean deletedContacts;


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
   * Checks if is deleted contacts.
   *
   * @return true, if is deleted contacts
   */
  public boolean isDeletedContacts() {
    return deletedContacts;
  }

  /**
   * Sets the deleted contacts.
   *
   * @param deletedContacts the new deleted contacts
   */
  public void setDeletedContacts(boolean deletedContacts) {
    this.deletedContacts = deletedContacts;
  }

  /**
   * From json.
   *
   * @param jsonGroup the json group
   * @return the delete groups response
   */
  public static DeleteGroupsResponse fromJson(JSONObject jsonGroup) {
    DeleteGroupsResponse responseGroup = new DeleteGroupsResponse();
    responseGroup.setName(jsonGroup.getString("name"));
    responseGroup.setDeletedContacts(jsonGroup.getBoolean("deletedContacts"));
    return responseGroup;
  }


}
