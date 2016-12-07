package net.routee.accounts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class RetrieveTransactionResponse.
 */
public class RetrieveTransactionResponse {

  /** The number of total pages. */
  private int totalPages;

  /** Whether the current page is the last one. */
  private boolean last;

  /** The total amount of elements for the current search. */
  private int totalElements;

  /** Whether the current page is the first one. */
  private boolean first;

  /** The number of elements currently on this page. */
  private int numberOfElements;

  /** The requested page size. */
  private int size;

  /** The requested page number. */
  private int number;

  /** List of all Transactions retrieved from Routee API. */
  ArrayList<Transaction> Transactions;


  /**
   * Instantiates a new retrieve transaction response.
   *
   * @param totalPages the total pages
   * @param last the last
   * @param totalElements the total elements
   * @param first the first
   * @param numberOfElements the number of elements
   * @param size the size
   * @param number the number
   * @param transactions the transactions
   */
  public RetrieveTransactionResponse(int totalPages, boolean last, int totalElements, boolean first,
      int numberOfElements, int size, int number, ArrayList<Transaction> transactions) {
    this.totalPages = totalPages;
    this.last = last;
    this.totalElements = totalElements;
    this.first = first;
    this.numberOfElements = numberOfElements;
    this.size = size;
    this.number = number;
    Transactions = transactions;
  }

  /**
   * Instantiates a new retrieve transaction response.
   */
  public RetrieveTransactionResponse() {
    this.Transactions = new ArrayList<Transaction>();
  }


  /**
   * Gets the total pages.
   *
   * @return the total pages
   */
  public int getTotalPages() {
    return totalPages;
  }

  /**
   * Sets the total pages.
   *
   * @param totalPages the new total pages
   */
  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  /**
   * Checks if is last.
   *
   * @return true, if is last
   */
  public boolean isLast() {
    return last;
  }

  /**
   * Sets the last.
   *
   * @param last the new last
   */
  public void setLast(boolean last) {
    this.last = last;
  }

  /**
   * Gets the total elements.
   *
   * @return the total elements
   */
  public int getTotalElements() {
    return totalElements;
  }

  /**
   * Sets the total elements.
   *
   * @param totalElements the new total elements
   */
  public void setTotalElements(int totalElements) {
    this.totalElements = totalElements;
  }

  /**
   * Checks if is first.
   *
   * @return true, if is first
   */
  public boolean isFirst() {
    return first;
  }

  /**
   * Sets the first.
   *
   * @param first the new first
   */
  public void setFirst(boolean first) {
    this.first = first;
  }

  /**
   * Gets the number of elements.
   *
   * @return the number of elements
   */
  public int getNumberOfElements() {
    return numberOfElements;
  }

  /**
   * Sets the number of elements.
   *
   * @param numberOfElements the new number of elements
   */
  public void setNumberOfElements(int numberOfElements) {
    this.numberOfElements = numberOfElements;
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
   * @param size the new size
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Gets the number.
   *
   * @return the number
   */
  public int getNumber() {
    return number;
  }

  /**
   * Sets the number.
   *
   * @param number the new number
   */
  public void setNumber(int number) {
    this.number = number;
  }

  /**
   * Gets the transactions.
   *
   * @return the transactions
   */
  public ArrayList<Transaction> getTransactions() {
    return Transactions;
  }

  /**
   * Sets the transactions.
   *
   * @param transactions the new transactions
   */
  public void setTransactions(ArrayList<Transaction> transactions) {
    Transactions = transactions;
  }

  /**
   * Adds the transaction.
   *
   * @param transaction the transaction
   */
  public void addTransaction(Transaction transaction) {
    if (this.Transactions == null) {
      this.Transactions = new ArrayList<Transaction>();
    }
    this.Transactions.add(transaction);
  }

  /**
   * From JSON.
   *
   * @param result the result
   * @return the retrieve transaction response
   */
  public static RetrieveTransactionResponse fromJSON(JSONObject result) {

    RetrieveTransactionResponse responseObject = new RetrieveTransactionResponse();
    responseObject.setFirst(result.getBoolean("first"));
    responseObject.setLast(result.getBoolean("last"));
    responseObject.setNumber(result.getInt("number"));
    responseObject.setNumberOfElements(result.getInt("numberOfElements"));
    responseObject.setSize(result.getInt("size"));
    responseObject.setTotalElements(result.getInt("totalElements"));
    responseObject.setTotalPages(result.getInt("totalPages"));
    JSONArray jsonArray = result.getJSONArray("content");
    Transaction transaction;
    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject transactionJson = jsonArray.getJSONObject(i);
      transaction = Transaction.fromJson(transactionJson);
      responseObject.addTransaction(transaction);
    }
    return responseObject;
  }

}
