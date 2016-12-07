package net.routee.contacts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class RetrieveGroupsPagedResponse.
 */
public class RetrieveGroupsPagedResponse {



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

  /** The total number of groups. */
  int total;


  /** List of all groups retrieved. */
  private ArrayList<Group> Groups;

  /**
   * Instantiates a new retrieve groups paged response.
   *
   * @param total the total
   * @param totalPages the total pages
   * @param last the last
   * @param totalElements the total elements
   * @param first the first
   * @param numberOfElements the number of elements
   * @param size the size
   * @param number the number
   * @param groups the groups
   */
  public RetrieveGroupsPagedResponse(int total, int totalPages, boolean last, int totalElements,
      boolean first, int numberOfElements, int size, int number, ArrayList<Group> groups) {
    this.total = total;
    this.totalPages = totalPages;
    this.last = last;
    this.totalElements = totalElements;
    this.first = first;
    this.numberOfElements = numberOfElements;
    this.size = size;
    this.number = number;
    Groups = groups;
  }

  /**
   * Instantiates a new retrieve groups paged response.
   */
  public RetrieveGroupsPagedResponse() {
    this.Groups = new ArrayList<Group>();
  }


  /**
   * Gets the total.
   *
   * @return the total
   */
  public int getTotal() {
    return total;
  }

  /**
   * Sets the total.
   *
   * @param total the new total
   */
  public void setTotal(int total) {
    this.total = total;
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
   * Gets the groups.
   *
   * @return the groups
   */
  public ArrayList<Group> getGroups() {
    return Groups;
  }

  /**
   * Sets the groups.
   *
   * @param groups the new groups
   */
  public void setGroups(ArrayList<Group> groups) {
    Groups = groups;
  }

  /**
   * Adds the group.
   *
   * @param group the group
   */
  public void addGroup(Group group) {
    if (this.Groups == null) {
      this.Groups = new ArrayList<Group>();
    }
    this.Groups.add(group);
  }

  /**
   * From json.
   *
   * @param result the result
   * @return the retrieve groups paged response
   */
  public static RetrieveGroupsPagedResponse fromJson(JSONObject result) {
    RetrieveGroupsPagedResponse responseObject = new RetrieveGroupsPagedResponse();
    responseObject.setFirst(result.getBoolean("first"));
    responseObject.setLast(result.getBoolean("last"));
    responseObject.setNumber(result.getInt("number"));
    responseObject.setNumberOfElements(result.getInt("numberOfElements"));
    responseObject.setSize(result.getInt("size"));
    responseObject.setTotalElements(result.getInt("totalElements"));
    responseObject.setTotalPages(result.getInt("totalPages"));
    if (result.has("content")) {
      JSONArray array = result.getJSONArray("content");
      for (int i = 0; i < array.length(); i++) {
        JSONObject obj = array.getJSONObject(i);
        responseObject.addGroup(Group.fromJson(obj));

      }
    }
    return responseObject;
  }

}
