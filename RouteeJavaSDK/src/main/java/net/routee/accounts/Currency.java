package net.routee.accounts;

import org.json.JSONObject;


/**
 * Contains information about the account's selected currency.
 */
public class Currency {


  /** The currency code in ISO 4217 format. */
  private String code;

  /** The currency name in english. */
  private String name;

  /** The sign of the currency. */
  private String sign;

  /**
   * Instantiates a new currency.
   *
   * @param code the code
   * @param name the name
   * @param sign the sign
   */
  public Currency(String code, String name, String sign) {
    this.code = code;
    this.name = name;
    this.sign = sign;
  }

  /**
   * Instantiates a new currency.
   */
  public Currency() {

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
   * Gets the sign.
   *
   * @return the sign
   */
  public String getSign() {
    return sign;
  }

  /**
   * Sets the sign.
   *
   * @param sign the new sign
   */
  public void setSign(String sign) {
    this.sign = sign;
  }

  /**
   * From json.
   *
   * @param jsonCurrency the json currency
   * @return the currency
   */
  public static Currency fromJson(JSONObject jsonCurrency) {
    Currency currency = new Currency();
    currency.setCode(jsonCurrency.getString("code"));
    currency.setName(jsonCurrency.getString("name"));
    currency.setSign(jsonCurrency.getString("sign"));
    return currency;
  }


}
