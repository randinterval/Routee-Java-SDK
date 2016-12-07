package net.routee.accounts;

import org.json.JSONObject;


/**
 * Class to Store Transaction Actions.
 */
public class Action {

  /**
   * The id of the action.
   */
  private String id;

  /**
   * 
   * Actions can be applied to transactions and affect the balance of the account depending on the
   * transaction status.
   * 
   * Paid
   * 
   * Transaction status is "Pending": no change in balance. Transaction status is "Pending Not
   * Credited": balance top up by amount of the action.
   * 
   * Credit Only when transaction is "Pending Not Credited" transactions. Balance top up by amount
   * of the action. ChangeStatus Only when transaction status is "Pending". Balance top up by
   * remaining amount of the transaction. Remove Only when transaction status is "Completed" or
   * "Pending". Decreases balance by amount of the action. Refund Only when transaction status is
   * "Completed" or "Pending". Balance top up by amount of the action.
   */
  private String type;

  /** The amount of the action. */
  private double amount;

  /** The date that the action was created. */
  private String date;

  /** The balance the account had before the action was processed. */
  private double balanceBefore;

  /**
   * The balance of the account after the action, see action type to see how the balance might be
   * affected.
   */
  private double balanceAfter;

  /**
   * The status of the action (Pending, Completed).
   */
  private String status;



  /**
   * Instantiates a new action.
   *
   * @param id the id
   * @param type the type
   * @param amount the amount
   * @param date the date
   * @param balanceBefore the balance before
   * @param balanceAfter the balance after
   * @param status the status
   */
  public Action(String id, String type, double amount, String date, double balanceBefore,
      double balanceAfter, String status) {
    this.id = id;
    this.type = type;
    this.amount = amount;
    this.date = date;
    this.balanceBefore = balanceBefore;
    this.balanceAfter = balanceAfter;
    this.status = status;
  }

  /**
   * Instantiates a new action.
   */
  public Action() {

  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public final String getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public final void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public final String getType() {
    return type;
  }

  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public final void setType(String type) {
    this.type = type;
  }

  /**
   * Gets the amount.
   *
   * @return the amount
   */
  public final double getAmount() {
    return amount;
  }

  /**
   * Sets the amount.
   *
   * @param amount the new amount
   */
  public final void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Gets the date.
   *
   * @return the date
   */
  public final String getDate() {
    return date;
  }

  /**
   * Sets the date.
   *
   * @param date the new date
   */
  public final void setDate(String date) {
    this.date = date;
  }

  /**
   * Gets the balance before.
   *
   * @return the balance before
   */
  public final double getBalanceBefore() {
    return balanceBefore;
  }

  /**
   * Sets the balance before.
   *
   * @param balanceBefore the new balance before
   */
  public final void setBalanceBefore(double balanceBefore) {
    this.balanceBefore = balanceBefore;
  }

  /**
   * Gets the balance after.
   *
   * @return the balance after
   */
  public final double getBalanceAfter() {
    return balanceAfter;
  }

  /**
   * Sets the balance after.
   *
   * @param balanceAfter the new balance after
   */
  public final void setBalanceAfter(double balanceAfter) {
    this.balanceAfter = balanceAfter;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public final String getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public final void setStatus(String status) {
    this.status = status;
  }

  /**
   * From json.
   *
   * @param actionJson the action json
   * @return the action
   */
  public static Action fromJson(JSONObject actionJson) {
    Action action = new Action();
    action.setAmount(actionJson.getDouble("amount"));
    action.setBalanceAfter(actionJson.getDouble("balanceAfter"));
    action.setBalanceBefore(actionJson.getDouble("balanceBefore"));
    action.setDate(actionJson.getString("Date"));
    action.setId(actionJson.getString("id"));
    action.setStatus(actionJson.getString("status"));
    return action;
  }

}
