package net.routee.accounts;

import org.json.JSONObject;


/**
 * The Class RouteeAccountBalance.
 */
public class RouteeAccountBalance {

  /** The amount of the available balance. */
  private double balance;

  /** Contains information about the account's selected currency. */
  private Currency currency;

  /**
   * Instantiates a new routee account balance.
   *
   * @param balance the balance
   * @param currency the currency
   */
  public RouteeAccountBalance(double balance, Currency currency) {
    this.balance = balance;
    this.currency = currency;
  }

  /**
   * Instantiates a new routee account balance.
   */
  public RouteeAccountBalance() {

  }

  /**
   * Gets the balance.
   *
   * @return the balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Sets the balance.
   *
   * @param balance the new balance
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }

  /**
   * Gets the currency.
   *
   * @return the currency
   */
  public Currency getCurrency() {
    return currency;
  }

  /**
   * Sets the currency.
   *
   * @param currency the new currency
   */
  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  /**
   * From json.
   *
   * @param jsonResponse the json response
   * @return the routee account balance
   */
  public static RouteeAccountBalance fromJson(JSONObject jsonResponse) {
    RouteeAccountBalance balance = new RouteeAccountBalance();
    balance.setBalance(jsonResponse.getDouble("balance"));
    balance.setCurrency(Currency.fromJson(jsonResponse.getJSONObject("currency")));
    return balance;
  }

}
