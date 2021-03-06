package net.routee.messaging;

import java.util.ArrayList;

import org.json.JSONObject;


/**
 * The Class SmsData.
 */
public class SmsData {

  /** The id of one of the sms parts included in a message. */
  private String smsId;

  /**
   * The id of the message.
   */
  private String messageId;

  /** The recipient. */
  private String to;

  /** The groups. */
  private ArrayList<String> groups;

  /** The country. */
  private String country;

  /** The operator of the recipient. */
  private String Operator;

  /**
   * The groups that the recipient belongs to.
   */
  private SmsStatus status;

  /**
   * The message of the SMS.
   */
  private String body;

  /**
   * The name of the campaign that this message was sent from.
   */
  private String campaignName;

  /** The name of the application that was used to send this message. */
  private String applicationName;

  /**
   * The service that sent this message.
   */
  private String originatinService;

  /** The overall delivery latency of the message. */
  private int latency;

  /**
   * The number of actual SMS parts.
   */
  private int parts;

  /** The cost of this SMS part. */
  private double price;

  /**
   * he sender of the message. This can be a telephone number or an alphanumeric string. In case of
   * an alphanumeric string, the maximum length is 11 characters. In case of a numeric only string
   * the length is 16 characters.
   */
  private String from;

  /** The direction of the SMS. */
  private String direction;


  /**
   * Instantiates a new sms data.
   *
   * @param smsId the sms id
   * @param messageId the message id
   * @param to the to
   * @param groups the groups
   * @param country the country
   * @param operator the operator
   * @param status the status
   */
  public SmsData(String smsId, String messageId, String to, ArrayList<String> groups,
      String country, String operator, SmsStatus status) {
    this.smsId = smsId;
    this.messageId = messageId;
    this.to = to;
    this.groups = groups;
    this.country = country;
    Operator = operator;
    this.status = status;
  }

  /**
   * Instantiates a new sms data.
   */
  public SmsData() {
    this.groups = new ArrayList<String>();

  }

  /**
   * Adds the group.
   *
   * @param group the group
   */
  public void addGroup(String group) {
    if (this.groups == null) {
      this.groups = new ArrayList<String>();
    }
    this.groups.add(group);
  }



  /**
   * Gets the sms id.
   *
   * @return the sms id
   */
  public String getSmsId() {
    return smsId;
  }

  /**
   * Sets the sms id.
   *
   * @param smsId the new sms id
   */
  public void setSmsId(String smsId) {
    this.smsId = smsId;
  }

  /**
   * Gets the message id.
   *
   * @return the message id
   */
  public String getMessageId() {
    return messageId;
  }

  /**
   * Sets the message id.
   *
   * @param messageId the new message id
   */
  public void setMessageId(String messageId) {
    this.messageId = messageId;
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
   * Gets the groups.
   *
   * @return the groups
   */
  public ArrayList<String> getGroups() {
    return groups;
  }

  /**
   * Sets the groups.
   *
   * @param groups the new groups
   */
  public void setGroups(ArrayList<String> groups) {
    this.groups = groups;
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
    return Operator;
  }

  /**
   * Sets the operator.
   *
   * @param operator the new operator
   */
  public void setOperator(String operator) {
    Operator = operator;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public SmsStatus getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(SmsStatus status) {
    this.status = status;
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
   * Gets the application name.
   *
   * @return the application name
   */
  public String getApplicationName() {
    return applicationName;
  }

  /**
   * Sets the application name.
   *
   * @param applicationName the new application name
   */
  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  /**
   * Gets the originatin service.
   *
   * @return the originatin service
   */
  public String getOriginatinService() {
    return originatinService;
  }

  /**
   * Sets the originatin service.
   *
   * @param originatinService the new originatin service
   */
  public void setOriginatinService(String originatinService) {
    this.originatinService = originatinService;
  }

  /**
   * Gets the latency.
   *
   * @return the latency
   */
  public int getLatency() {
    return latency;
  }

  /**
   * Sets the latency.
   *
   * @param latency the new latency
   */
  public void setLatency(int latency) {
    this.latency = latency;
  }

  /**
   * Gets the parts.
   *
   * @return the parts
   */
  public int getParts() {
    return parts;
  }

  /**
   * Sets the parts.
   *
   * @param parts the new parts
   */
  public void setParts(int parts) {
    this.parts = parts;
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
   * Gets the direction.
   *
   * @return the direction
   */
  public String getDirection() {
    return direction;
  }

  /**
   * Sets the direction.
   *
   * @param direction the new direction
   */
  public void setDirection(String direction) {
    this.direction = direction;
  }

  /**
   * From json.
   *
   * @param smsInfoJson the sms info json
   * @return the sms data
   */
  public static SmsData fromJson(JSONObject smsInfoJson) {

    SmsData data = new SmsData();
    if (smsInfoJson.has("smsId") && smsInfoJson.has("messageId")) {
      data.setSmsId(smsInfoJson.getString("smsId"));
      data.setMessageId(smsInfoJson.getString("messageId"));
    } else {
      data.setMessageId(smsInfoJson.getString("messageId"));
    }
    data.setMessageId(smsInfoJson.getString("to"));
    if (smsInfoJson.has("groups")) {
      if (smsInfoJson.getJSONArray("groups").length() > 0) {
        for (int j = 0; j < smsInfoJson.getJSONArray("groups").length(); j++) {
          data.addGroup(smsInfoJson.getJSONArray("groups").getString(j));
        }
      }
    }
    data.setCountry(smsInfoJson.getString("country"));
    if (smsInfoJson.has("operator")) {
      data.setOperator(smsInfoJson.getString("operator"));
    }
    data.setBody(smsInfoJson.getString("body"));
    if (smsInfoJson.has("campaignName")) {
      data.setCampaignName(smsInfoJson.getString("campaignName"));
    }
    if (smsInfoJson.has("applicationName")) {
      data.setApplicationName(smsInfoJson.getString("applicationName"));
    }
    if (smsInfoJson.has("originatingService")) {
      data.setOriginatinService(smsInfoJson.getString("originatingService"));
    }
    data.setLatency(smsInfoJson.getInt("latency"));
    data.setPrice(smsInfoJson.getInt("price"));
    data.setFrom(smsInfoJson.getString("from"));
    data.setDirection(smsInfoJson.getString("direction"));
    JSONObject jsonStatus = smsInfoJson.getJSONObject("status");
    data.setStatus(SmsStatus.fromJson(jsonStatus));;
    return data;
  }

}
