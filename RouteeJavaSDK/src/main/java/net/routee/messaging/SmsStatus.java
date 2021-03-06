package net.routee.messaging;

import org.json.JSONObject;



/**
 * The status of the SMS tracking.
 * 
 */
public class SmsStatus {

  /** The status. */
  private String status;

  /**
   * The date that the status was reported.
   */
  private String date;


  /**
   * Instantiates a new sms status.
   *
   * @param status the status
   * @param date the date
   */
  public SmsStatus(String status, String date) {
    this.status = status;
    this.date = date;
  }

  /**
   * Instantiates a new sms status.
   */
  public SmsStatus() {

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
   * From json.
   *
   * @param jsonStatus the json status
   * @return the sms status
   */
  public static SmsStatus fromJson(JSONObject jsonStatus) {
    SmsStatus status = new SmsStatus();
    status.setStatus(jsonStatus.getString("status"));
    status.setDate(jsonStatus.getString("date"));
    return status;
  }

}
