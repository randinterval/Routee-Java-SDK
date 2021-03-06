package net.routee.messaging;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 * The Class CampaignResponse.
 */
public class CampaignResponse {



  /** The tracking id used to identify the message. */
  private String trackingId;

  /** The date that this resource was created. */
  private String createdAt;

  /** The service type of the campaign. */
  private String type;

  /** The time the campaign is scheduled to run. */
  private String scheduledDate;

  /** The name of the campaign. */
  private String campaignName;

  /**
   * The sender of the message.
   */
  private String from;

  /** The message you sent. */
  private String body;

  /** The state of the campaign. */
  private String state;

  /**
   * Defines the number of SMS per message status. Either, Queued, Sent, Unsent, Failed, Delivered,
   * Undelivered.
   */
  private Status statuses;

  /**
   * The data analysis the this SMS.
   */
  private SmsAnalysis smsAnalysis;

  /** Indicates if the message is a flash SMS. */
  private boolean flash;

  /**
   * Indicates if the SMS should respect the quiet hours. Quiet Hours are set by default to 23.00 -
   * 08.00 and 14.00-17.00 destination local time. Please note that not all countries are supported
   * with this feature due to multiple time zones within the country.
   */
  private boolean respectQuietHours;

  /** Defines the notification callback information for the progress of the SMS campaign.. */
  private Callback campaignCallback;

  /**
   * Defines the notification callback information for an individual message progress of the SMS
   * campaign.
   */
  private Callback callback;

  /**
   * Defines the recipients that will receive a test SMS before and/or after the actual SMS is sent.
   */
  private Reminder reminder;

  /**
   * A list of phone numbers the message is about to be sent to. Format with a '+' and country code
   * e.g., +306948530920 (E.164 format).
   */
  private ArrayList<String> to;

  /** A list of contact ids that the message will be sent. */
  private ArrayList<String> contacts;

  /** The cost of the SMS. */
  private double cost;

  /** The total messages. */
  private double totalMessages;


  /**
   * Instantiates a new campaign response.
   *
   * @param trackingId the tracking id
   * @param createdAt the created at
   * @param type the type
   * @param scheduledDate the scheduled date
   * @param campaignName the campaign name
   * @param from the from
   * @param body the body
   * @param state the state
   * @param statuses the statuses
   * @param smsAnalysis the sms analysis
   * @param flash the flash
   * @param respectQuietHours the respect quiet hours
   * @param campaignCallback the campaign callback
   * @param callback the callback
   * @param reminder the reminder
   * @param to the to
   * @param contacts the contacts
   * @param cost the cost
   * @param totalMessages the total messages
   */
  public CampaignResponse(String trackingId, String createdAt, String type, String scheduledDate,
      String campaignName, String from, String body, String state, Status statuses,
      SmsAnalysis smsAnalysis, boolean flash, boolean respectQuietHours, Callback campaignCallback,
      Callback callback, Reminder reminder, ArrayList<String> to, ArrayList<String> contacts,
      double cost, double totalMessages) {
    this.trackingId = trackingId;
    this.createdAt = createdAt;
    this.type = type;
    this.scheduledDate = scheduledDate;
    this.campaignName = campaignName;
    this.from = from;
    this.body = body;
    this.state = state;
    this.statuses = statuses;
    this.smsAnalysis = smsAnalysis;
    this.flash = flash;
    this.respectQuietHours = respectQuietHours;
    this.campaignCallback = campaignCallback;
    this.callback = callback;
    this.reminder = reminder;
    this.to = to;
    this.contacts = contacts;
    this.cost = cost;
    this.totalMessages = totalMessages;
  }



  /**
   * Instantiates a new campaign response.
   */
  public CampaignResponse() {
    this.to = new ArrayList<String>();
    this.contacts = new ArrayList<String>();

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
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }



  /**
   * Sets the type.
   *
   * @param type the new type
   */
  public void setType(String type) {
    this.type = type;
  }



  /**
   * Gets the scheduled date.
   *
   * @return the scheduled date
   */
  public String getScheduledDate() {
    return scheduledDate;
  }



  /**
   * Sets the scheduled date.
   *
   * @param scheduledDate the new scheduled date
   */
  public void setScheduledDate(String scheduledDate) {
    this.scheduledDate = scheduledDate;
  }



  /**
   * Gets the campaign name.
   *
   * @return the campaign name
   */
  public String getCampaignName() {
    return campaignName;
  }



  /**
   * Sets the campaign name.
   *
   * @param campaignName the new campaign name
   */
  public void setCampaignName(String campaignName) {
    this.campaignName = campaignName;
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
   * Gets the state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }



  /**
   * Sets the state.
   *
   * @param state the new state
   */
  public void setState(String state) {
    this.state = state;
  }



  /**
   * Gets the statuses.
   *
   * @return the statuses
   */
  public Status getStatuses() {
    return statuses;
  }



  /**
   * Sets the statuses.
   *
   * @param statuses the new statuses
   */
  public void setStatuses(Status statuses) {
    this.statuses = statuses;
  }



  /**
   * Gets the sms analysis.
   *
   * @return the sms analysis
   */
  public SmsAnalysis getSmsAnalysis() {
    return smsAnalysis;
  }



  /**
   * Sets the sms analysis.
   *
   * @param smsAnalysis the new sms analysis
   */
  public void setSmsAnalysis(SmsAnalysis smsAnalysis) {
    this.smsAnalysis = smsAnalysis;
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
   * Checks if is respect quiet hours.
   *
   * @return true, if is respect quiet hours
   */
  public boolean isRespectQuietHours() {
    return respectQuietHours;
  }



  /**
   * Sets the respect quiet hours.
   *
   * @param respectQuietHours the new respect quiet hours
   */
  public void setRespectQuietHours(boolean respectQuietHours) {
    this.respectQuietHours = respectQuietHours;
  }



  /**
   * Gets the campaign callback.
   *
   * @return the campaign callback
   */
  public Callback getCampaignCallback() {
    return campaignCallback;
  }



  /**
   * Sets the campaign callback.
   *
   * @param campaignCallback the new campaign callback
   */
  public void setCampaignCallback(Callback campaignCallback) {
    this.campaignCallback = campaignCallback;
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
   * Gets the reminder.
   *
   * @return the reminder
   */
  public Reminder getReminder() {
    return reminder;
  }



  /**
   * Sets the reminder.
   *
   * @param reminder the new reminder
   */
  public void setReminder(Reminder reminder) {
    this.reminder = reminder;
  }



  /**
   * Gets the to.
   *
   * @return the to
   */
  public ArrayList<String> getTo() {
    return to;
  }



  /**
   * Sets the to.
   *
   * @param to the new to
   */
  public void setTo(ArrayList<String> to) {
    this.to = to;
  }



  /**
   * Gets the contacts.
   *
   * @return the contacts
   */
  public ArrayList<String> getContacts() {
    return contacts;
  }



  /**
   * Sets the contacts.
   *
   * @param contacts the new contacts
   */
  public void setContacts(ArrayList<String> contacts) {
    this.contacts = contacts;
  }

  /**
   * Adds the contact.
   *
   * @param contactId the contact id
   */
  public void addContact(String contactId) {
    this.contacts.add(contactId);
  }

  /**
   * Adds the to.
   *
   * @param contactId the contact id
   */
  public void addTo(String contactId) {
    this.to.add(contactId);
  }



  /**
   * Gets the cost.
   *
   * @return the cost
   */
  public double getCost() {
    return cost;
  }



  /**
   * Sets the cost.
   *
   * @param cost the new cost
   */
  public void setCost(double cost) {
    this.cost = cost;
  }



  /**
   * Gets the total messages.
   *
   * @return the total messages
   */
  public double getTotalMessages() {
    return totalMessages;
  }



  /**
   * Sets the total messages.
   *
   * @param totalMessages the new total messages
   */
  public void setTotalMessages(double totalMessages) {
    this.totalMessages = totalMessages;
  }

  /**
   * From json.
   *
   * @param jsonResult the json result
   * @return the campaign response
   */
  public static CampaignResponse fromJson(JSONObject jsonResult) {
    CampaignResponse result = new CampaignResponse();
    result.setTrackingId(jsonResult.getString("trackingId"));
    result.setType(jsonResult.getString("type"));
    result.setState(jsonResult.getString("state"));
    result.setCreatedAt(jsonResult.getString("createdAt"));
    result.setRespectQuietHours(jsonResult.getBoolean("respectQuietHours"));
    result.setFrom(jsonResult.getString("from"));
    if (jsonResult.has("to")) {
      JSONArray array = jsonResult.getJSONArray("to");
      if (array.length() > 0) {
        for (int i = 0; i < array.length(); i++) {
          result.addTo(array.getString(i));
        }
      }
    }
    result.setBody(jsonResult.getString("body"));
    if (jsonResult.has("smsAnalysis")) {
      JSONObject smsAnalysisResult = jsonResult.getJSONObject("smsAnalysis");
      result.setSmsAnalysis(SmsAnalysis.fromJson(smsAnalysisResult));
    }
    result.setCost(jsonResult.getDouble("cost"));
    result.setTotalMessages(jsonResult.getDouble("totalMessages"));
    if (jsonResult.has("statuses")) {
      JSONObject statusJson = jsonResult.getJSONObject("statuses");
      result.setStatuses(Status.fromJson(statusJson));
    }
    return result;
  }


}
