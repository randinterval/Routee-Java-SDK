package net.routee.accounts;

import org.json.JSONObject;


/**
 * The Class to Store Bank Information Retrieved from Routee API.
 */
public class Bank {


  /** The name of the bank. */
  private String name;

  /** The address of the bank. */
  private String address;

  /** The number of our bank account. */
  private String number;

  /** The iban of our bank account. */
  private String iban;

  /** The currency that will be used when sending money to this bank account. */
  private String currency;

  /** The minimum amount of money to send to this bank account. */
  private double minAmount;

  /** The country of the bank. */
  private String country;

  /** The swift code of the bank. */
  private String swiftCode;

  /**
   * Instantiates a new bank.
   *
   * @param name the name
   * @param address the address
   * @param number the number
   * @param iban the iban
   * @param currency the currency
   * @param minAmount the min amount
   * @param country the country
   * @param swiftCode the swift code
   */
  public Bank(String name, String address, String number, String iban, String currency,
      double minAmount, String country, String swiftCode) {
    this.name = name;
    this.address = address;
    this.number = number;
    this.iban = iban;
    this.currency = currency;
    this.minAmount = minAmount;
    this.country = country;
    this.swiftCode = swiftCode;
  }

  /**
   * Instantiates a new bank.
   */
  public Bank() {

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
   * Gets the address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets the address.
   *
   * @param address the new address
   */
  public void setAddress(String address) {
    this.address = address;
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

  /**
   * Gets the iban.
   *
   * @return the iban
   */
  public String getIban() {
    return iban;
  }

  /**
   * Sets the iban.
   *
   * @param iban the new iban
   */
  public void setIban(String iban) {
    this.iban = iban;
  }

  /**
   * Gets the currency.
   *
   * @return the currency
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Sets the currency.
   *
   * @param currency the new currency
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * Gets the min amount.
   *
   * @return the min amount
   */
  public double getMinAmount() {
    return minAmount;
  }

  /**
   * Sets the min amount.
   *
   * @param minAmount the new min amount
   */
  public void setMinAmount(double minAmount) {
    this.minAmount = minAmount;
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
   * Gets the swift code.
   *
   * @return the swift code
   */
  public String getSwiftCode() {
    return swiftCode;
  }

  /**
   * Sets the swift code.
   *
   * @param swiftCode the new swift code
   */
  public void setSwiftCode(String swiftCode) {
    this.swiftCode = swiftCode;
  }

  /**
   * From json.
   *
   * @param bankJson the bank json
   * @return the bank
   */
  public static Bank fromJson(JSONObject bankJson) {
    Bank bank = new Bank();
    bank.setName(bankJson.getString("name"));;
    bank.setAddress(bankJson.getString("address"));
    bank.setNumber(bankJson.getString("number"));
    bank.setIban(bankJson.getString("iban"));
    bank.setSwiftCode(bankJson.getString("swiftCode"));
    bank.setCurrency(bankJson.getString("currency"));
    bank.setMinAmount(bankJson.getDouble("minAmount"));
    bank.setCountry(bankJson.getString("country"));
    return bank;
  }

}
