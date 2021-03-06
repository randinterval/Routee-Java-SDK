package net.routee.contacts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class Contact.
 */
public class Contact {

  /** List that contains the contact's labels with their respective values. */
  private ArrayList<Label> labels;

  /** List of all contact groups (tags) that this contact belongs to. */
  private ArrayList<Group> groups;

  /** The identification of the contact. */
  private String contactId;

  /** The e-mail address of the contact. */
  private String email;

  /** The first name of the contact. */
  private String firstName;

  /** The last name of the contact. */
  private String lastName;

  /** The mobile number of the contact. */
  private String mobile;

  /** The country information of the contact. */
  private String country;

  /** Indicates whether the contact is treated as vip or not. */
  private boolean vip;

  /** List of all the services for which the contact has been blacklisted. */
  private ArrayList<String> blacklistedServices;

  /**
   * Instantiates a new contact.
   *
   * @param labels the labels
   * @param groups the groups
   * @param contactId the contact id
   * @param email the email
   * @param firstName the first name
   * @param lastName the last name
   * @param mobile the mobile
   * @param vip the vip
   * @param country the country
   */
  public Contact(ArrayList<Label> labels, ArrayList<Group> groups, String contactId, String email,
      String firstName, String lastName, String mobile, boolean vip, String country) {
    this.setContactId(contactId);
    this.labels = labels;
    this.groups = groups;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.mobile = mobile;
    this.vip = vip;
    this.country = country;
  }


  /**
   * Instantiates a new contact.
   */
  public Contact() {

  }

  /**
   * Adds the label.
   *
   * @param label the label
   */
  public void addLabel(Label label) {
    if (this.labels == null) {
      this.labels = new ArrayList<Label>();
    }
    this.labels.add(label);
  }

  /**
   * Adds the group.
   *
   * @param group the group
   */
  public void addGroup(Group group) {
    if (this.groups == null) {
      this.groups = new ArrayList<Group>();
    }
    this.groups.add(group);
  }


  /**
   * Gets the labels.
   *
   * @return the labels
   */
  public ArrayList<Label> getLabels() {
    return labels;
  }

  /**
   * Sets the labels.
   *
   * @param labels the new labels
   */
  public void setLabels(ArrayList<Label> labels) {
    this.labels = labels;
  }

  /**
   * Gets the email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email the new email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name.
   *
   * @param firstName the new first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name.
   *
   * @param lastName the new last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the mobile.
   *
   * @return the mobile
   */
  public String getMobile() {
    return mobile;
  }

  /**
   * Sets the mobile.
   *
   * @param mobile the new mobile
   */
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  /**
   * Checks if is vip.
   *
   * @return true, if is vip
   */
  public boolean isVip() {
    return vip;
  }

  /**
   * Sets the vip.
   *
   * @param vip the new vip
   */
  public void setVip(boolean vip) {
    this.vip = vip;
  }



  /**
   * Gets the groups.
   *
   * @return the groups
   */
  public ArrayList<Group> getGroups() {
    return groups;
  }



  /**
   * Sets the groups.
   *
   * @param groups the new groups
   */
  public void setGroups(ArrayList<Group> groups) {
    this.groups = groups;
  }


  /**
   * Gets the contact id.
   *
   * @return the contact id
   */
  public String getContactId() {
    return contactId;
  }


  /**
   * Sets the contact id.
   *
   * @param contactId the new contact id
   */
  public void setContactId(String contactId) {
    this.contactId = contactId;
  }

  /**
   * Gets the country.
   *
   * @return the country
   */
  public String getCountry() {
    return country;
  }


  /**
   * Sets the country.
   *
   * @param country the new country
   */
  public void setCountry(String country) {
    this.country = country;
  }


  /**
   * Gets the blacklisted services.
   *
   * @return the blacklisted services
   */
  public ArrayList<String> getBlacklistedServices() {
    return blacklistedServices;
  }


  /**
   * Sets the blacklisted services.
   *
   * @param blacklistedServices the new blacklisted services
   */
  public void setBlacklistedServices(ArrayList<String> blacklistedServices) {
    this.blacklistedServices = blacklistedServices;
  }

  /**
   * Adds the blacklisted service.
   *
   * @param service the service
   */
  public void addBlacklistedService(String service) {
    if (this.blacklistedServices == null) {
      this.blacklistedServices = new ArrayList<String>();
    }
    this.blacklistedServices.add(service);
  }

  /**
   * From JSON.
   *
   * @param result the result
   * @return the contact
   */
  public static Contact fromJSON(JSONObject result) {
    Contact resultContact = new Contact();
    resultContact.setContactId(result.getString("id"));
    resultContact.setVip(result.getBoolean("vip"));
    resultContact.setLastName(result.getString("lastName"));
    resultContact.setFirstName(result.getString("firstName"));
    if (result.has("email")) {
      resultContact.setEmail(result.getString("email"));
    }
    resultContact.setMobile(result.getString("mobile"));
    if (result.has("country")) {
      resultContact.setCountry(result.getString("country"));
    }
    if (result.has("labels")) {
      JSONArray labelsArray = result.getJSONArray("labels");
      for (int i = 0; i < labelsArray.length(); i++) {
        JSONObject labelJson = labelsArray.getJSONObject(i);
        resultContact.addLabel(Label.fromJson(labelJson));
      }
    }
    if (result.has("blacklistedServices")) {
      JSONArray blacklistedServicesArray = result.getJSONArray("blacklistedServices");
      for (int i = 0; i < blacklistedServicesArray.length(); i++) {
        String service = blacklistedServicesArray.getString(i);
        resultContact.addBlacklistedService(service);
      }
    }
    JSONArray groupsArray = result.getJSONArray("groups");
    for (int i = 0; i < groupsArray.length(); i++) {
      Group group = new Group();
      group.setName(groupsArray.getString(i));
      resultContact.addGroup(group);
    }
    return resultContact;
  }

  /**
   * To json.
   *
   * @return the string
   */
  public String toJson() {
    JSONObject jsonBody = new JSONObject();
    ArrayList<Label> labels = this.getLabels();
    if (labels != null) {
      for (int i = 0; i < labels.size(); i++) {
        Label label = labels.get(i);
        JSONObject jsonLabel = new JSONObject();
        jsonLabel.put("name", label.getName());
        jsonLabel.put("value", label.getValue());
        if (label.getValue() != null) {
          if (label.getType().equals("Text")) {
            jsonLabel.put("value", label.getValue());
          } else {
            jsonLabel.put("value", Integer.parseInt(label.getValue()));
          }
        }
        jsonBody.append("labels", jsonLabel);
      }
    }
    jsonBody.put("email", this.getEmail());
    jsonBody.put("firstName", this.getFirstName());
    jsonBody.put("lastName", this.getLastName());
    jsonBody.put("mobile", this.getMobile());
    jsonBody.put("vip", this.isVip());
    return jsonBody.toString();
  }

}
