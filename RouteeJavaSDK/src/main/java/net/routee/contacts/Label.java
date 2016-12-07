package net.routee.contacts;

import org.json.JSONObject;


/**
 * The Class Label.
 */
public class Label {


  /** The name of the label. */
  private String name;

  /** The type of the label. Supported types are: Text or Number. */
  private String type;

  /** The value of the label. */
  private String value;

  /**
   * Instantiates a new label.
   */
  public Label() {}

  /**
   * Instantiates a new label.
   *
   * @param name the name
   * @param type the type
   * @param value the value
   */
  public Label(String name, String type, String value) {
    super();
    this.name = name;
    this.type = type;
    this.value = value;
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
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(String type) {
    this.type = type;
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

  /**
   * From json.
   *
   * @param labelJson the label json
   * @return the label
   */
  public static Label fromJson(JSONObject labelJson) {
    Label label = new Label();
    if (labelJson.has("name")) {
      label.setName(labelJson.getString("name"));
    }
    if (labelJson.has("type")) {
      label.setType(labelJson.getString("type"));
    }
    if (labelJson.has("value")) {
      Object aObj = labelJson.get("value");
      if (aObj instanceof Integer) {
        label.setValue(String.valueOf(aObj));
      } else {
        label.setValue((String) aObj);
      }
    }
    return label;
  }

  /**
   * To json.
   *
   * @return the string
   */
  public String toJson() {
    JSONObject labelJson = new JSONObject();
    labelJson.put("name", this.getName());
    labelJson.put("type", this.getType());
    if (this.value != null) {
      if (type.equals("Text")) {
        labelJson.put("value", this.value);
      } else {
        labelJson.put("value", Integer.parseInt(this.value));
      }
    }
    return labelJson.toString();
  }

}
