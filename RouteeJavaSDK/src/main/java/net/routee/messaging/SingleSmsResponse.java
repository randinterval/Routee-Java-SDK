package net.routee.messaging;

import org.json.JSONObject;


/**
 * The Class SingleSmsResponse.
 */
public class SingleSmsResponse {


  /** The trackingId of the single SMS. */
  private String trackingId;

  /** The created at. */
  private String createdAt;

  /** The senderId of the SMS message. */
  private String from;

  /** The recipient of the SMS message (in E.164 format) */
  private String to;

  /** The message of the SMS. */
  private String body;

  /**
   * The status of the SMS tracking.
   */
  private String status;

  /** The label of the SMS tracking. */
  private String label;

  /**
   * The analysis for the body of the SMS.
   */
  private BodyAnalysis analysis;

  /**
   * Indicates if the SMS is a flash SMS. A flash SMS is a type of SMS that appears directly on the
   * main screen without user interaction and is not automatically stored in the inbox. It can be
   * useful in emergencies, such as a fire alarm or cases of confidentiality, as in delivering
   * one-time passwords
   */
  private boolean flash;

  /**
   * Defines the callback information for an individual message.
   */
  private Callback callback;

  /**
   * Instantiates a new single sms response.
   */
  public SingleSmsResponse() {

  }

  /**
   * Instantiates a new single sms response.
   *
   * @param trackingId the tracking id
   * @param createdAt the created at
   * @param from the from
   * @param to the to
   * @param body the body
   * @param status the status
   * @param label the label
   * @param analysis the analysis
   * @param flash the flash
   * @param callback the callback
   */
  public SingleSmsResponse(String trackingId, String createdAt, String from, String to, String body,
      String status, String label, BodyAnalysis analysis, boolean flash, Callback callback) {
    super();
    this.trackingId = trackingId;
    this.createdAt = createdAt;
    this.from = from;
    this.to = to;
    this.body = body;
    this.status = status;
    this.label = label;
    this.analysis = analysis;
    this.flash = flash;
    this.callback = callback;
  }

  /**
   * Gets the tracking id.
   *
   * @return the tracking id
   */
  public String getTrackingId() {
    return trackingId;
  }

  /**
   * Sets the tracking id.
   *
   * @param trackingId the new tracking id
   */
  public void setTrackingId(String trackingId) {
    this.trackingId = trackingId;
  }

  /**
   * Gets the created at.
   *
   * @return the created at
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the created at.
   *
   * @param createdAt the new created at
   */
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets the from.
   *
   * @return the from
   */
  public String getFrom() {
    return from;
  }

  /**
   * Sets the from.
   *
   * @param from the new from
   */
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * Gets the to.
   *
   * @return the to
   */
  public String getTo() {
    return to;
  }

  /**
   * Sets the to.
   *
   * @param to the new to
   */
  public void setTo(String to) {
    this.to = to;
  }

  /**
   * Gets the body.
   *
   * @return the body
   */
  public String getBody() {
    return body;
  }

  /**
   * Sets the body.
   *
   * @param body the new body
   */
  public void setBody(String body) {
    this.body = body;
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
   * Gets the label.
   *
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * Sets the label.
   *
   * @param label the new label
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * Gets the analysis.
   *
   * @return the analysis
   */
  public BodyAnalysis getAnalysis() {
    return analysis;
  }

  /**
   * Sets the analysis.
   *
   * @param analysis the new analysis
   */
  public void setAnalysis(BodyAnalysis analysis) {
    this.analysis = analysis;
  }

  /**
   * Checks if is flash.
   *
   * @return true, if is flash
   */
  public boolean isFlash() {
    return flash;
  }

  /**
   * Sets the flash.
   *
   * @param flash the new flash
   */
  public void setFlash(boolean flash) {
    this.flash = flash;
  }

  /**
   * Gets the callback.
   *
   * @return the callback
   */
  public Callback getCallback() {
    return callback;
  }

  /**
   * Sets the callback.
   *
   * @param callback the new callback
   */
  public void setCallback(Callback callback) {
    this.callback = callback;
  }

  /**
   * From json.
   *
   * @param result the result
   * @return the single sms response
   */
  public static SingleSmsResponse fromJson(JSONObject result) {
    SingleSmsResponse smsResult = new SingleSmsResponse();
    smsResult.setTrackingId(result.getString("trackingId"));
    smsResult.setCreatedAt(result.getString("createdAt"));
    smsResult.setFrom(result.getString("from"));
    smsResult.setTo(result.getString("to"));
    smsResult.setBody(result.getString("body"));
    smsResult.setStatus(result.getString("status"));
    if (result.has("label")) {
      smsResult.setLabel(result.getString("label"));
    }
    JSONObject bodyAnalysisJSON = result.getJSONObject("bodyAnalysis");
    smsResult.setAnalysis(BodyAnalysis.fromJson(bodyAnalysisJSON));
    smsResult.setFlash(result.getBoolean("flash"));
    if (result.has("callback")) {
      JSONObject callbackObject = result.getJSONObject("callback");
      smsResult.setCallback(Callback.fromJson(callbackObject));
    }
    return smsResult;
  }
}
