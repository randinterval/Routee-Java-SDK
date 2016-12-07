package net.routee.messaging;

import org.json.JSONObject;



/**
 * The Class Status.
 */
public class Status {

  /** The queued. */
  private int queued;

  /** The sent. */
  private int sent;

  /** The failed. */
  private int failed;

  /** The delivered. */
  private int delivered;

  /** The undelivered. */
  private int undelivered;

  /**
   * Instantiates a new status.
   *
   * @param queued the queued
   * @param sent the sent
   * @param failed the failed
   * @param delivered the delivered
   * @param undelivered the undelivered
   */
  public Status(int queued, int sent, int failed, int delivered, int undelivered) {
    this.queued = queued;
    this.sent = sent;
    this.failed = failed;
    this.delivered = delivered;
    this.undelivered = undelivered;
  }

  /**
   * Instantiates a new status.
   */
  public Status() {

  }

  /**
   * Gets the queued.
   *
   * @return the queued
   */
  public int getQueued() {
    return queued;
  }

  /**
   * Sets the queued.
   *
   * @param queued the new queued
   */
  public void setQueued(int queued) {
    this.queued = queued;
  }

  /**
   * Gets the sent.
   *
   * @return the sent
   */
  public int getSent() {
    return sent;
  }

  /**
   * Sets the sent.
   *
   * @param sent the new sent
   */
  public void setSent(int sent) {
    this.sent = sent;
  }

  /**
   * Gets the failed.
   *
   * @return the failed
   */
  public int getFailed() {
    return failed;
  }

  /**
   * Sets the failed.
   *
   * @param failed the new failed
   */
  public void setFailed(int failed) {
    this.failed = failed;
  }

  /**
   * Gets the delivered.
   *
   * @return the delivered
   */
  public int getDelivered() {
    return delivered;
  }

  /**
   * Sets the delivered.
   *
   * @param delivered the new delivered
   */
  public void setDelivered(int delivered) {
    this.delivered = delivered;
  }

  /**
   * Gets the undelivered.
   *
   * @return the undelivered
   */
  public int getUndelivered() {
    return undelivered;
  }

  /**
   * Sets the undelivered.
   *
   * @param undelivered the new undelivered
   */
  public void setUndelivered(int undelivered) {
    this.undelivered = undelivered;
  }

  /**
   * From json.
   *
   * @param statusJson the status json
   * @return the status
   */
  public static Status fromJson(JSONObject statusJson) {
    Status statuses = new Status();
    statuses.setQueued(statusJson.getInt("Queued"));
    statuses.setSent(statusJson.getInt("Sent"));
    statuses.setFailed(statusJson.getInt("Failed"));
    statuses.setDelivered(statusJson.getInt("Delivered"));
    statuses.setUndelivered(statusJson.getInt("Undelivered"));
    return statuses;
  }

}
