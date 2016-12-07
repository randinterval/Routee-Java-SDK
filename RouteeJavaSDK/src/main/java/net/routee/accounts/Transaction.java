package net.routee.accounts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class Transaction.
 */
public class Transaction {

  /** The id of the transaction. */
  private String id;

  /** The source that created this transaction (can be PayPal, Bank). */
  private String source;

  /** Always TopUp. */
  private String transactionType;

  /** The amount of this transaction. */
  private double amount;

  /**
   * PendingNotCredited The specified amount will be added to the account at some point in the
   * future. The amount is NOT added to the balance of the account. Pending The amount is added to
   * the balance of the account. Completed The amount is added to the balance of the account.
   */
  private String status;

  /** The balance the account had before the transaction was processed. */
  private double balanceBefore;

  /**
   * The balance of the account after the transaction, depending on the transaction status the
   * balance might or might not be affected.
   */
  private double balanceAfter;

  /** The date that the transaction was created. */
  private String date;

  /** A list of all the transaction actions (see action type for more). */
  private ArrayList<Action> actions;



  /**
   * Instantiates a new transaction.
   *
   * @param id the id
   * @param source the source
   * @param transactionType the transaction type
   * @param amount the amount
   * @param status the status
   * @param balanceBefore the balance before
   * @param balanceAfter the balance after
   * @param date the date
   * @param actions the actions
   */
  public Transaction(String id, String source, String transactionType, double amount, String status,
      double balanceBefore, double balanceAfter, String date, ArrayList<Action> actions) {
    this.id = id;
    this.source = source;
    this.transactionType = transactionType;
    this.amount = amount;
    this.status = status;
    this.balanceBefore = balanceBefore;
    this.balanceAfter = balanceAfter;
    this.date = date;
    this.actions = actions;
  }

  /**
   * Instantiates a new transaction.
   */
  public Transaction() {
    this.actions = new ArrayList<Action>();
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the source.
   *
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * Sets the source.
   *
   * @param source the new source
   */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * Gets the transaction type.
   *
   * @return the transaction type
   */
  public String getTransactionType() {
    return transactionType;
  }

  /**
   * Sets the transaction type.
   *
   * @param transactionType the new transaction type
   */
  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  /**
   * Gets the amount.
   *
   * @return the amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Sets the amount.
   *
   * @param amount the new amount
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Gets the balance before.
   *
   * @return the balance before
   */
  public double getBalanceBefore() {
    return balanceBefore;
  }

  /**
   * Sets the balance before.
   *
   * @param balanceBefore the new balance before
   */
  public void setBalanceBefore(double balanceBefore) {
    this.balanceBefore = balanceBefore;
  }

  /**
   * Gets the balance after.
   *
   * @return the balance after
   */
  public double getBalanceAfter() {
    return balanceAfter;
  }

  /**
   * Sets the balance after.
   *
   * @param balanceAfter the new balance after
   */
  public void setBalanceAfter(double balanceAfter) {
    this.balanceAfter = balanceAfter;
  }

  /**
   * Gets the date.
   *
   * @return the date
   */
  public String getDate() {
    return date;
  }

  /**
   * Sets the date.
   *
   * @param date the new date
   */
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * Gets the actions.
   *
   * @return the actions
   */
  public ArrayList<Action> getActions() {
    return actions;
  }

  /**
   * Sets the actions.
   *
   * @param actions the new actions
   */
  public void setActions(ArrayList<Action> actions) {
    this.actions = actions;
  }

  /**
   * Adds the action.
   *
   * @param action the action
   */
  public void addAction(Action action) {
    if (this.actions == null) {
      this.actions = new ArrayList<Action>();
    }
    this.actions.add(action);
  }

  /**
   * From json.
   *
   * @param transactionJson the transaction json
   * @return the transaction
   */
  public static Transaction fromJson(JSONObject transactionJson) {
    Transaction transaction = new Transaction();
    transaction.setId(transactionJson.getString("id"));
    transaction.setSource(transactionJson.getString("source"));
    transaction.setTransactionType(transactionJson.getString("transactionType"));
    transaction.setAmount(transactionJson.getDouble("amount"));
    transaction.setStatus(transactionJson.getString("status"));
    transaction.setBalanceBefore(transactionJson.getDouble("balanceBefore"));
    transaction.setBalanceAfter(transactionJson.getDouble("balanceAfter"));
    transaction.setDate(transactionJson.getString("date"));
    JSONArray actionArray = transactionJson.getJSONArray("actions");
    for (int j = 0; j < actionArray.length(); j++) {
      JSONObject actionJson = actionArray.getJSONObject(j);
      transaction.addAction(Action.fromJson(actionJson));
    }
    return transaction;
  }

}
