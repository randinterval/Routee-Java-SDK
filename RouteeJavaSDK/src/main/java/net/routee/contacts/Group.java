package net.routee.contacts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class Group.
 */
public class Group {

  /** The name of the group. */
  private String name;

  /**
   * Defines the way that the group should be populated. If not set (or set to 'None') the group
   * will be empty. If it's set to 'Filtered' the group will be populated based on the filters
   * provided. If it's set to 'All', the group will include all the contacts of the account.
   */
  private String strategy;

  /** The size of the group. */
  private int size;

  /**
   * The filters to apply and create the group from their result.
   */
  private ArrayList<Filter> filters;

  /**
   * Instantiates a new group.
   *
   * @param name the name
   * @param strategy the strategy
   * @param filters the filters
   */
  public Group(String name, String strategy, ArrayList<Filter> filters) {
    this.name = name;
    this.strategy = strategy;
    this.filters = filters;
  }


  /**
   * Instantiates a new group.
   */
  public Group() {
    this.filters = new ArrayList<Filter>();
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
   * Gets the strategy.
   *
   * @return the strategy
   */
  public String getStrategy() {
    return strategy;
  }

  /**
   * Sets the strategy.
   *
   * @param strategy the new strategy
   */
  public void setStrategy(String strategy) {
    this.strategy = strategy;
  }

  /**
   * Gets the filters.
   *
   * @return the filters
   */
  public ArrayList<Filter> getFilters() {
    return filters;
  }

  /**
   * Sets the filters.
   *
   * @param filters the new filters
   */
  public void setFilters(ArrayList<Filter> filters) {
    this.filters = filters;
  }

  /**
   * Adds the filter.
   *
   * @param filter the filter
   */
  public void addFilter(Filter filter) {
    if (this.filters == null) {
      this.filters = new ArrayList<Filter>();
    }
    this.filters.add(filter);
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
   * @param number the new size
   */
  public void setSize(int number) {
    this.size = number;
  }

  /**
   * From json.
   *
   * @param jsonResponse the json response
   * @return the group
   */
  public static Group fromJson(JSONObject jsonResponse) {
    Group groupResponse = new Group();
    if (jsonResponse.has("name")) {
      groupResponse.setName(jsonResponse.getString("name"));
    }
    if (jsonResponse.has("size")) {
      groupResponse.setSize(jsonResponse.getInt("size"));
    }
    if (jsonResponse.has("strategy")) {
      groupResponse.setStrategy(jsonResponse.getString("strategy"));
    }
    return groupResponse;
  }

  /**
   * To json.
   *
   * @return the string
   */
  public String toJson() {
    JSONObject jsonBody = new JSONObject();
    jsonBody.put("name", this.getName());
    if (this.getStrategy() != null) {
      jsonBody.put("strategy", this.getStrategy());
    }
    if (this.getFilters() != null) {
      ArrayList<Filter> filters = this.getFilters();
      JSONArray jsonArray = new JSONArray();
      for (int i = 0; i < filters.size(); i++) {
        JSONObject obj = new JSONObject();
        obj.put("fieldName", filters.get(i).getFieldName());
        obj.put("searchTerm", filters.get(i).getSearchTerm());
      }
      jsonBody.put("filters", jsonArray);
    }
    return jsonBody.toString();
  }



}
