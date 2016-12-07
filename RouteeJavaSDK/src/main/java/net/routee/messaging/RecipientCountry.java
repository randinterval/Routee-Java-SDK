package net.routee.messaging;



/**
 * The Class RecipientCountry.
 */
public class RecipientCountry {

  /** The country of the recipient. */
  private String country;

  /** The number. */
  private String number;


  /**
   * Instantiates a new recipient country.
   *
   * @param country the country
   * @param number the number
   */
  public RecipientCountry(String country, String number) {
    this.country = country;
    this.number = number;
  }

  /**
   * Instantiates a new recipient country.
   */
  public RecipientCountry() {

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
   * Gets the number.
   *
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * Sets the number.
   *
   * @param number the new number
   */
  public void setNumber(String number) {
    this.number = number;
  }

}
