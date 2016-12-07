package net.routee.contacts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 * The Class RetrieveContactsResponse.
 */
public class RetrieveContactsResponse {


  /** The number of total pages. */
  private int totalPages;

  /** Indicates Whether the current page is the last one. */
  private boolean last;

  /** The total amount of elements for the current search. */
  private int totalElements;

  /** Indicates Whether the current page is the first one. */
  private boolean first;

  /** The number of elements currently on this page. */
  private int numberOfElements;

  /** The requested page size. */
  private int size;

  /** The requested page number. */
  private int number;

  /** List of All Contacts that have been retrieved. */
  private ArrayList<Contact> contacts;


  /**
   * Instantiates a new retrieve contacts response.
   */
  public RetrieveContactsResponse() {

  }

  /**
   * Instantiates a new retrieve contacts response.
   *
   * @param totalPages the total pages
   * @param last the last
   * @param totalElements the total elements
   * @param first the first
   * @param numberOfElements the number of elements
   * @param size the size
   * @param number the number
   * @param contacts the contacts
   */
  public RetrieveContactsResponse(int totalPages, boolean last, int totalElements, boolean first,
      int numberOfElements, int size, int number, ArrayList<Contact> contacts) {
    this.totalPages = totalPages;
    this.last = last;
    this.totalElements = totalElements;
    this.first = first;
    this.numberOfElements = numberOfElements;
    this.size = size;
    this.number = number;
    this.contacts = contacts;
  }

  /**
   * Gets the total pages.
   *
   * @return the total pages
   */
  public int getTotalPages() {
    return totalPages;
  }

  /**
   * Sets the total pages.
   *
   * @param totalPages the new total pages
   */
  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  /**
   * Checks if is last.
   *
   * @return true, if is last
   */
  public boolean isLast() {
    return last;
  }

  /**
   * Sets the last.
   *
   * @param last the new last
   */
  public void setLast(boolean last) {
    this.last = last;
  }

  /**
   * Gets the total elements.
   *
   * @return the total elements
   */
  public int getTotalElements() {
    return totalElements;
  }

  /**
   * Sets the total elements.
   *
   * @param totalElements the new total elements
   */
  public void setTotalElements(int totalElements) {
    this.totalElements = totalElements;
  }

  /**
   * Checks if is first.
   *
   * @return true, if is first
   */
  public boolean isFirst() {
    return first;
  }

  /**
   * Sets the first.
   *
   * @param first the new first
   */
  public void setFirst(boolean first) {
    this.first = first;
  }

  /**
   * Gets the number of elements.
   *
   * @return the number of elements
   */
  public int getNumberOfElements() {
    return numberOfElements;
  }

  /**
   * Sets the number of elements.
   *
   * @param numberOfElements the new number of elements
   */
  public void setNumberOfElements(int numberOfElements) {
    this.numberOfElements = numberOfElements;
  }

  /**
   * Gets the size.
   *
   * @return the size
   */
  public int getSize() {
    return size;
  }

  /**
   * Sets the size.
   *
   * @param size the new size
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Gets the number.
   *
   * @return the number
   */
  public int getNumber() {
    return number;
  }

  /**
   * Sets the number.
   *
   * @param number the new number
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * Gets the contacts.
   *
   * @return the contacts
   */
  public ArrayList<Contact> getContacts() {
    return contacts;
  }

  /**
   * Sets the contacts.
   *
   * @param contacts the new contacts
   */
  public void setContacts(ArrayList<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Adds the contact.
   *
   * @param contact the contact
   */
  public void addContact(Contact contact) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<Contact>();
    }
    this.contacts.add(contact);
  }

  /**
   * From json.
   *
   * @param result the result
   * @return the retrieve contacts response
   */
  public static RetrieveContactsResponse fromJson(JSONObject result) {
    RetrieveContactsResponse responseContacts = new RetrieveContactsResponse();
    responseContacts.setFirst(result.getBoolean("first"));
    responseContacts.setLast(result.getBoolean("last"));
    responseContacts.setNumber(result.getInt("number"));
    responseContacts.setNumberOfElements(result.getInt("numberOfElements"));
    responseContacts.setSize(result.getInt("size"));
    responseContacts.setTotalPages(result.getInt("totalPages"));
    if (result.has("content")) {
      JSONArray contactsArray = result.getJSONArray("content");
      for (int i = 0; i < contactsArray.length(); i++) {
        JSONObject contactJSON = contactsArray.getJSONObject(i);
        responseContacts.addContact(Contact.fromJSON(contactJSON));
      }
    }
    return responseContacts;
  }

}
