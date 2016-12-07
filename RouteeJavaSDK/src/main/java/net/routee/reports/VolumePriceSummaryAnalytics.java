package net.routee.reports;

import org.json.JSONObject;



/**
 * The Class VolumePriceSummaryAnalytics.
 */
public class VolumePriceSummaryAnalytics {

  /**
   * The country’s code in ISO 3166­1 alpha­2 format.
   */
  private String country;

  /**
   * The operator’s name.
   */
  private String operator;

  /**
   * The mobile country code.
   */
  private String mcc;

  /** The mobile network code. */
  private String mnc;

  /** The date and time of the first SMS of this report. */
  private String startDateTime;

  /** The time interval that the reports are grouped by. */
  private String timeGrouping;

  /** The ID of the campaign that the SMS belongs to. */
  private String smsCampaignId;

  /**
   * The total messages count.
   */
  private double count;

  /** The amount of the delivered messages. */
  private double deliveredCount;

  /**
   * The amount of the failed messages.
   */
  private double failedCount;

  /** The amount of the queued messages. */
  private double queuedCount;

  /**
   * The amount of the sent messages.
   */
  private double sentCount;

  /**
   * The amount of the undelivered messages.
   */
  private double undeliveredCount;

  /** The total price of this report. */
  private double price;

  /**
   * Instantiates a new volume price summary analytics.
   *
   * @param country the country
   * @param operator the operator
   * @param mcc the mcc
   * @param mnc the mnc
   * @param startDateTime the start date time
   * @param timeGrouping the time grouping
   * @param smsCampaignId the sms campaign id
   * @param count the count
   * @param deliveredCount the delivered count
   * @param failedCount the failed count
   * @param queuedCount the queued count
   * @param sentCount the sent count
   * @param undeliveredCount the undelivered count
   * @param price the price
   */
  public VolumePriceSummaryAnalytics(String country, String operator, String mcc, String mnc,
      String startDateTime, String timeGrouping, String smsCampaignId, double count,
      double deliveredCount, double failedCount, double queuedCount, double sentCount,
      double undeliveredCount, double price) {
    this.country = country;
    this.operator = operator;
    this.mcc = mcc;
    this.mnc = mnc;
    this.startDateTime = startDateTime;
    this.timeGrouping = timeGrouping;
    this.smsCampaignId = smsCampaignId;
    this.count = count;
    this.deliveredCount = deliveredCount;
    this.failedCount = failedCount;
    this.queuedCount = queuedCount;
    this.sentCount = sentCount;
    this.undeliveredCount = undeliveredCount;
    this.price = price;
  }

  /**
   * Instantiates a new volume price summary analytics.
   */
  public VolumePriceSummaryAnalytics() {

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
   * Gets the operator.
   *
   * @return the operator
   */
  public String getOperator() {
    return operator;
  }

  /**
   * Sets the operator.
   *
   * @param operator the new operator
   */
  public void setOperator(String operator) {
    this.operator = operator;
  }

  /**
   * Gets the mcc.
   *
   * @return the mcc
   */
  public String getMcc() {
    return mcc;
  }

  /**
   * Sets the mcc.
   *
   * @param mcc the new mcc
   */
  public void setMcc(String mcc) {
    this.mcc = mcc;
  }

  /**
   * Gets the mnc.
   *
   * @return the mnc
   */
  public String getMnc() {
    return mnc;
  }

  /**
   * Sets the mnc.
   *
   * @param mnc the new mnc
   */
  public void setMnc(String mnc) {
    this.mnc = mnc;
  }

  /**
   * Gets the start date time.
   *
   * @return the start date time
   */
  public String getStartDateTime() {
    return startDateTime;
  }

  /**
   * Sets the start date time.
   *
   * @param startDateTime the new start date time
   */
  public void setStartDateTime(String startDateTime) {
    this.startDateTime = startDateTime;
  }

  /**
   * Gets the time grouping.
   *
   * @return the time grouping
   */
  public String getTimeGrouping() {
    return timeGrouping;
  }

  /**
   * Sets the time grouping.
   *
   * @param timeGrouping the new time grouping
   */
  public void setTimeGrouping(String timeGrouping) {
    this.timeGrouping = timeGrouping;
  }

  /**
   * Gets the sms campaign id.
   *
   * @return the sms campaign id
   */
  public String getSmsCampaignId() {
    return smsCampaignId;
  }

  /**
   * Sets the sms campaign id.
   *
   * @param smsCampaignId the new sms campaign id
   */
  public void setSmsCampaignId(String smsCampaignId) {
    this.smsCampaignId = smsCampaignId;
  }

  /**
   * Gets the count.
   *
   * @return the count
   */
  public double getCount() {
    return count;
  }

  /**
   * Sets the count.
   *
   * @param count the new count
   */
  public void setCount(double count) {
    this.count = count;
  }

  /**
   * Gets the delivered count.
   *
   * @return the delivered count
   */
  public double getDeliveredCount() {
    return deliveredCount;
  }

  /**
   * Sets the delivered count.
   *
   * @param deliveredCount the new delivered count
   */
  public void setDeliveredCount(double deliveredCount) {
    this.deliveredCount = deliveredCount;
  }

  /**
   * Gets the failed count.
   *
   * @return the failed count
   */
  public double getFailedCount() {
    return failedCount;
  }

  /**
   * Sets the failed count.
   *
   * @param failedCount the new failed count
   */
  public void setFailedCount(double failedCount) {
    this.failedCount = failedCount;
  }

  /**
   * Gets the queued count.
   *
   * @return the queued count
   */
  public double getQueuedCount() {
    return queuedCount;
  }

  /**
   * Sets the queued count.
   *
   * @param queuedCount the new queued count
   */
  public void setQueuedCount(double queuedCount) {
    this.queuedCount = queuedCount;
  }

  /**
   * Gets the sent count.
   *
   * @return the sent count
   */
  public double getSentCount() {
    return sentCount;
  }

  /**
   * Sets the sent count.
   *
   * @param sentCount the new sent count
   */
  public void setSentCount(double sentCount) {
    this.sentCount = sentCount;
  }

  /**
   * Gets the undelivered count.
   *
   * @return the undelivered count
   */
  public double getUndeliveredCount() {
    return undeliveredCount;
  }

  /**
   * Sets the undelivered count.
   *
   * @param undeliveredCount the new undelivered count
   */
  public void setUndeliveredCount(double undeliveredCount) {
    this.undeliveredCount = undeliveredCount;
  }

  /**
   * Gets the price.
   *
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * Sets the price.
   *
   * @param price the new price
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * From json.
   *
   * @param detailJson the detail json
   * @return the volume price summary analytics
   */
  public static VolumePriceSummaryAnalytics fromJson(JSONObject detailJson) {
    VolumePriceSummaryAnalytics analytics = new VolumePriceSummaryAnalytics();
    analytics.setStartDateTime(detailJson.getString("startDateTime"));
    analytics.setTimeGrouping(detailJson.getString("timeGrouping"));
    analytics.setDeliveredCount(detailJson.getDouble("deliveredCount"));
    analytics.setUndeliveredCount(detailJson.getDouble("undeliveredCount"));
    analytics.setFailedCount(detailJson.getDouble("failedCount"));
    analytics.setQueuedCount(detailJson.getDouble("queuedCount"));
    analytics.setSentCount(detailJson.getDouble("sentCount"));
    analytics.setCount(detailJson.getDouble("count"));
    analytics.setPrice(detailJson.getDouble("price"));
    analytics.setCountry(detailJson.getString("country"));
    analytics.setOperator(detailJson.getString("operator"));
    analytics.setMcc(detailJson.getString("mcc"));
    analytics.setMnc(detailJson.getString("mnc"));
    if (detailJson.has("smsCampaignId")) {
      analytics.setSmsCampaignId(detailJson.getString("smsCampaignId"));
    }
    return analytics;

  }

}
