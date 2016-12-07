package net.routee.twostep;

import org.json.JSONObject;



/**
 * The Class Total.
 */
public class Total {

  /** The pending. */
  int pending;

  /** The verified. */
  int verified;

  /** The cancelled. */
  int cancelled;

  /** The expired. */
  int expired;

  /** The failed. */
  int failed;

  /**
   * Instantiates a new total.
   *
   * @param pending the pending
   * @param verified the verified
   * @param cancelled the cancelled
   * @param expired the expired
   * @param failed the failed
   */
  public Total(int pending, int verified, int cancelled, int expired, int failed) {
    this.pending = pending;
    this.verified = verified;
    this.cancelled = cancelled;
    this.expired = expired;
    this.failed = failed;
  }

  /**
   * Instantiates a new total.
   */
  public Total() {

  }

  /**
   * Gets the pending.
   *
   * @return the pending
   */
  public int getPending() {
    return pending;
  }

  /**
   * Sets the pending.
   *
   * @param pending the new pending
   */
  public void setPending(int pending) {
    this.pending = pending;
  }

  /**
   * Gets the verified.
   *
   * @return the verified
   */
  public int getVerified() {
    return verified;
  }

  /**
   * Sets the verified.
   *
   * @param verified the new verified
   */
  public void setVerified(int verified) {
    this.verified = verified;
  }

  /**
   * Gets the cancelled.
   *
   * @return the cancelled
   */
  public int getCancelled() {
    return cancelled;
  }

  /**
   * Sets the cancelled.
   *
   * @param cancelled the new cancelled
   */
  public void setCancelled(int cancelled) {
    this.cancelled = cancelled;
  }

  /**
   * Gets the expired.
   *
   * @return the expired
   */
  public int getExpired() {
    return expired;
  }

  /**
   * Sets the expired.
   *
   * @param expired the new expired
   */
  public void setExpired(int expired) {
    this.expired = expired;
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
   * From json.
   *
   * @param totalsJson the totals json
   * @return the total
   */
  public static Total fromJson(JSONObject totalsJson) {
    Total total = new Total();
    if (totalsJson.has("Pending")) {
      total.setPending(totalsJson.getInt("Pending"));
    }
    if (totalsJson.has("Expired")) {
      total.setExpired(totalsJson.getInt("Expired"));
    }
    if (totalsJson.has("Cancelled")) {
      total.setCancelled(totalsJson.getInt("Cancelled"));
    }
    if (totalsJson.has("Verified")) {
      total.setVerified(totalsJson.getInt("Verified"));
    }
    if (totalsJson.has("Failed")) {
      total.setFailed(totalsJson.getInt("Failed"));
    }
    return total;
  }

}
