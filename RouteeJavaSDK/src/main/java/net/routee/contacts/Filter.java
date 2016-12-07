package net.routee.contacts;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class Filter.
 */
public class Filter {

  /** The name of the field to filter. */
  private String fieldName;

  /** The exact value that the specified field must match. */
  private String searchTerm;


  /**
   * Instantiates a new filter.
   *
   * @param fieldName the field name
   * @param searchTerm the search term
   */
  public Filter(String fieldName, String searchTerm) {
    this.fieldName = fieldName;
    this.searchTerm = searchTerm;
  }

  /**
   * Instantiates a new filter.
   */
  public Filter() {

  }

  /**
   * Gets the field name.
   *
   * @return the field name
   */
  public String getFieldName() {
    return fieldName;
  }

  /**
   * Sets the field name.
   *
   * @param fieldName the new field name
   */
  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  /**
   * Gets the search term.
   *
   * @return the search term
   */
  public String getSearchTerm() {
    return searchTerm;
  }

  /**
   * Sets the search term.
   *
   * @param searchTerm the new search term
   */
  public void setSearchTerm(String searchTerm) {
    this.searchTerm = searchTerm;
  }

  /**
   * To json.
   *
   * @return the string
   */
  public String toJson() {

    JSONArray array = new JSONArray();
    JSONObject obj = new JSONObject();
    obj.put("fieldName", this.fieldName);
    obj.put("searchTerm", this.searchTerm);
    array.put(obj);
    return array.toString();
  }
}
