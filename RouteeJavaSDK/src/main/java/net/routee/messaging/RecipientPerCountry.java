package net.routee.messaging;



/**
 * The total recipients per country. The key refers to the country.
 */
public class RecipientPerCountry {

  /** The country code. */
  private String countryCode;

  /** The count. */
  private int count;

  /**
   * Instantiates a new recipient per country.
   *
   * @param countryCode the country code
   * @param count the count
   */
  public RecipientPerCountry(String countryCode, int count) {
    this.countryCode = countryCode;
    this.count = count;
  }

  /**
   * Instantiates a new recipient per country.
   */
  public RecipientPerCountry() {

  }

  /**
   * Gets the country code.
   *
   * @return the country code
   */
  public String getCountryCode() {
    return countryCode;
  }

  /**
   * Sets the country code.
   *
   * @param countryCode the new country code
   */
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  /**
   * Gets the count.
   *
   * @return the count
   */
  public int getCount() {
    return count;
  }

  /**
   * Sets the count.
   *
   * @param count the new count
   */
  public void setCount(int count) {
    this.count = count;
  }

}
