package net.routee.twostep;

import org.json.JSONObject;



/**
 * The Class PerCountry.
 */
public class PerCountry {

  /** The country. */
  private String country;

  /** The pending. */
  private int pending;

  /** The verified. */
  private int verified;

  /** The cancelled. */
  private int cancelled;

  /** The expired. */
  private int expired;

  /** The failed. */
  private int failed;


  /**
   * Instantiates a new per country.
   *
   * @param country the country
   * @param pending the pending
   * @param verified the verified
   * @param cancelled the cancelled
   * @param expired the expired
   * @param failed the failed
   */
  public PerCountry(String country, int pending, int verified, int cancelled, int expired,
      int failed) {
    this.country = country;
    this.pending = pending;
    this.verified = verified;
    this.cancelled = cancelled;
    this.expired = expired;
    this.failed = failed;
  }

  /**
   * Instantiates a new per country.
   */
  public PerCountry() {

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
   * @param perCountryJson the per country json
   * @return the per country
   */
  public static PerCountry fromJson(JSONObject perCountryJson) {
    PerCountry countryData = new PerCountry();
    if (perCountryJson.has("Pending")) {
      countryData.setPending(perCountryJson.getInt("Pending"));
    }
    if (perCountryJson.has("Expired")) {
      countryData.setExpired(perCountryJson.getInt("Expired"));
    }
    if (perCountryJson.has("Cancelled")) {
      countryData.setCancelled(perCountryJson.getInt("Cancelled"));
    }
    if (perCountryJson.has("Verified")) {
      countryData.setVerified(perCountryJson.getInt("Verified"));
    }
    if (perCountryJson.has("Failed")) {
      countryData.setFailed(perCountryJson.getInt("Failed"));
    }
    return countryData;
  }

}
