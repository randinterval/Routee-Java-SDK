package net.routee.accounts;


/**
 * The Class RetrieveTransactionParameters.
 */
public class RetrieveTransactionParameters {

  /**
   * Start Date from Which to get Transactions in ISO-8601 date-time format e.g 2015-11-11T15:00Z
   */
  private String from;

  /** End Date until which to get Transactions in ISO-8601 date-time format e.g 2015-11-11T15:00Z */
  private String to;

  /** The page number to retrieve, default value is 0 (meaning the first page). */
  private int page;

  /** The number of items to retrieve, default value is 20. */
  private int size;


  /**
   * Instantiates a new retrieve transaction parameters.
   *
   * @param from the from
   * @param to the to
   * @param page the page
   * @param size the size
   */
  public RetrieveTransactionParameters(String from, String to, int page, int size) {
    this.from = from;
    this.to = to;
    this.page = page;
    this.size = size;
  }

  /**
   * Instantiates a new retrieve transaction parameters.
   */
  public RetrieveTransactionParameters() {

    this.page = -1;
    this.size = -1;

  }

  /**
   * Gets the from.
   *
   * @return the from
   */
  public final String getFrom() {
    return from;
  }

  /**
   * Sets the from.
   *
   * @param from the new from
   */
  public final void setFrom(String from) {
    this.from = from;
  }

  /**
   * Gets the to.
   *
   * @return the to
   */
  public final String getTo() {
    return to;
  }

  /**
   * Sets the to.
   *
   * @param to the new to
   */
  public final void setTo(String to) {
    this.to = to;
  }

  /**
   * Gets the page.
   *
   * @return the page
   */
  public final int getPage() {
    return page;
  }

  /**
   * Sets the page.
   *
   * @param page the new page
   */
  public final void setPage(int page) {
    this.page = page;
  }

  /**
   * Gets the size.
   *
   * @return the size
   */
  public final int getSize() {
    return size;
  }

  /**
   * Sets the size.
   *
   * @param size the new size
   */
  public final void setSize(int size) {
    this.size = size;
  }

}
