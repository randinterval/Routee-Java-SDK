package net.routee.messaging;

import org.json.JSONObject;



/**
 * The Class QuietHourCountry.
 */
public class QuietHourCountry {

  /**
   * The country code in ISO 3166-1 alpha-2 format (US, GR).
   */
  private String code;

  /** The country name translated in the requested language. */
  private String name;

  /** The country name translated in its native language (for Greece it will be Ελλάδα). */
  private String localeName;

  /** If the country is supported or not. */
  private boolean supported;


  /**
   * Instantiates a new quiet hour country.
   */
  public QuietHourCountry() {

  }

  /**
   * Instantiates a new quiet hour country.
   *
   * @param code the code
   * @param name the name
   * @param localeName the locale name
   * @param supported the supported
   */
  public QuietHourCountry(String code, String name, String localeName, boolean supported) {
    this.code = code;
    this.name = name;
    this.localeName = localeName;
    this.supported = supported;
  }

  /**
   * Gets the code.
   *
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets the code.
   *
   * @param code the new code
   */
  public void setCode(String code) {
    this.code = code;
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
   * Gets the locale name.
   *
   * @return the locale name
   */
  public String getLocaleName() {
    return localeName;
  }

  /**
   * Sets the locale name.
   *
   * @param localeName the new locale name
   */
  public void setLocaleName(String localeName) {
    this.localeName = localeName;
  }

  /**
   * Checks if is supported.
   *
   * @return true, if is supported
   */
  public boolean isSupported() {
    return supported;
  }

  /**
   * Sets the supported.
   *
   * @param supported the new supported
   */
  public void setSupported(boolean supported) {
    this.supported = supported;
  }

  /**
   * From json.
   *
   * @param quietHourJson the quiet hour json
   * @return the quiet hour country
   */
  public static QuietHourCountry fromJson(JSONObject quietHourJson) {
    QuietHourCountry country = new QuietHourCountry();
    country.setCode(quietHourJson.getString("code"));
    country.setName(quietHourJson.getString("name"));
    country.setLocaleName(quietHourJson.getString("localeName"));
    country.setSupported(quietHourJson.getBoolean("supported"));
    return country;
  }

}
