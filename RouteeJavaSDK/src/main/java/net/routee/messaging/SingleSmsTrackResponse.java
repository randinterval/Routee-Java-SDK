package net.routee.messaging;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class SingleSmsTrackResponse.
 */
public class SingleSmsTrackResponse {

  /** The application name. */
  private String applicationName;

  /** The country. */
  private String country;

  /** The sms id. */
  private String smsId;

  /** The message id. */
  private String messageId;

  /** The groups. */
  private ArrayList<String> groups;

  /** The body. */
  private String body;

  /** The operator. */
  private String operator;

  /** The originating service. */
  private String originatingService;

  /** The to. */
  private String to;

  /** The label. */
  private String label;

  /** The direction. */
  private String direction;

  /** The status. */
  private SmsStatus status;

  /** The latency. */
  private double latency;

  /** The parts. */
  private double parts;

  /** The price. */
  private double price;

  /** The from. */
  private String from;



  /**
   * Instantiates a new single sms track response.
   *
   * @param applicationName the application name
   * @param country the country
   * @param smsId the sms id
   * @param messageId the message id
   * @param groups the groups
   * @param body the body
   * @param operator the operator
   * @param originatingService the originating service
   * @param to the to
   * @param label the label
   * @param status the status
   * @param latency the latency
   * @param parts the parts
   * @param price the price
   */
  public SingleSmsTrackResponse(String applicationName, String country, String smsId,
      String messageId, ArrayList<String> groups, String body, String operator,
      String originatingService, String to, String label, SmsStatus status, double latency,
      double parts, double price) {
    this.applicationName = applicationName;
    this.country = country;
    this.smsId = smsId;
    this.messageId = messageId;
    this.groups = groups;
    this.body = body;
    this.operator = operator;
    this.originatingService = originatingService;
    this.to = to;
    this.label = label;
    this.status = status;
    this.latency = latency;
    this.parts = parts;
    this.price = price;
  }

  /**
   * Instantiates a new single sms track response.
   */
  public SingleSmsTrackResponse() {
    this.groups = new ArrayList<String>();
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
   * Gets the originating service.
   *
   * @return the originating service
   */
  public String getOriginatingService() {
    return originatingService;
  }

  /**
   * Sets the originating service.
   *
   * @param originatingService the new originating service
   */
  public void setOriginatingService(String originatingService) {
    this.originatingService = originatingService;
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
   * Gets the latency.
   *
   * @return the latency
   */
  public double getLatency() {
    return latency;
  }

  /**
   * Sets the latency.
   *
   * @param latency the new latency
   */
  public void setLatency(double latency) {
    this.latency = latency;
  }

  /**
   * Gets the parts.
   *
   * @return the parts
   */
  public double getParts() {
    return parts;
  }

  /**
   * Sets the parts.
   *
   * @param parts the new parts
   */
  public void setParts(double parts) {
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
   * Adds the group.
   *
   * @param groupName the group name
   */
  public void AddGroup(String groupName) {
    if (this.groups == null) {
      this.groups = new ArrayList<String>();
    }
    this.groups.add(groupName);
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
   * @param jsonResponse the json response
   * @return the single sms track response
   */
  public static SingleSmsTrackResponse fromJson(JSONObject jsonResponse) {
    SingleSmsTrackResponse response = new SingleSmsTrackResponse();
    response.setTo(jsonResponse.getString("to"));
    response.setBody("body");
    response.setStatus(SmsStatus.fromJson(jsonResponse.getJSONObject("status")));
    response.setDirection(jsonResponse.getString("direction"));
    response.setOriginatingService(jsonResponse.getString("originatingService"));
    response.setApplicationName(jsonResponse.getString("applicationName"));
    response.setParts(jsonResponse.getDouble("parts"));
    response.setFrom(jsonResponse.getString("from"));
    response.setOperator(jsonResponse.getString("operator"));
    response.setCountry(jsonResponse.getString("country"));
    response.setPrice(jsonResponse.getDouble("price"));
    response.setLatency(jsonResponse.getDouble("latency"));
    response.setMessageId(jsonResponse.getString("messageId"));
    response.setSmsId(jsonResponse.getString("smsId"));
    JSONArray jsonArray = jsonResponse.getJSONArray("groups");
    for (int i = 0; i < jsonArray.length(); i++) {
      response.AddGroup(jsonArray.getString(i));
    }
    return response;

  }


}
