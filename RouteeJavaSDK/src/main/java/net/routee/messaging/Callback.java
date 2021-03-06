package net.routee.messaging;

import org.json.JSONObject;



/**
 * A class that defines the notification callback information for an individual message progress of
 * the SMS campaign.
 */
public class Callback {

  /**
   * The URL that Routee will POST to, each time your message status changes to one of the
   * following: Queued, Failed, Sent, Unsent, Delivered, or Undelivered.
   */
  private String callbackUrl;

  /**
   * When the URL will be called. Two possible values: on every status change (OnChange) or when a
   * final status arrives (OnCompletion)
   */
  private String callbackStrategy;

  /**
   * Instantiates a new callback.
   *
   * @param callbackUrl the callback url
   * @param callbackStrategy the callback strategy
   */
  public Callback(String callbackUrl, String callbackStrategy) {
    this.callbackUrl = callbackUrl;
    this.callbackStrategy = callbackStrategy;
  }

  /**
   * Instantiates a new callback.
   */
  public Callback() {}

  /**
   * Gets the callback url.
   *
   * @return the callback url
   */
  public String getCallbackUrl() {
    return callbackUrl;
  }

  /**
   * Sets the callback url.
   *
   * @param callbackUrl the new callback url
   */
  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  /**
   * Gets the callback strategy.
   *
   * @return the callback strategy
   */
  public String getCallbackStrategy() {
    return callbackStrategy;
  }

  /**
   * Sets the callback strategy.
   *
   * @param callbackStrategy the new callback strategy
   */
  public void setCallbackStrategy(String callbackStrategy) {
    this.callbackStrategy = callbackStrategy;
  }

  /**
   * From json.
   *
   * @param callbackObject the callback object
   * @return the callback
   */
  public static Callback fromJson(JSONObject callbackObject) {
    Callback callback = new Callback();
    callback.setCallbackStrategy(callbackObject.getString("strategy"));
    callback.setCallbackUrl(callbackObject.getString("url"));
    return callback;
  }

}
