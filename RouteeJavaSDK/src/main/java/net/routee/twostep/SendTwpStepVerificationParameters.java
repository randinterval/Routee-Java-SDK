package net.routee.twostep;

import java.util.ArrayList;

import org.json.JSONObject;



/**
 * The Class SendTwpStepVerificationParamters.
 */
public class SendTwpStepVerificationParameters {

  /**
   * The method which will be used to send the 2step verification.
   */
  private String method;

  /**
   * The type of the message.
   */
  private String type;

  /**
   * The recipient that will receive the 2step verification. For sms method format with a '+' and
   * country code e.g., +306948530920 (E.164 format).
   */
  private String recipient;

  /**
   * If the template is for example '@@name your code is @@pin' and the argument has a property
   * name: 'Nick' the message will be 'Nick your code is 4232'. Note that if the template contains
   * a @@ placeholder and a value is not present in the arguments property it will stay as is..
   */
  private ArrayList<Argument> arguments;

  /**
   * The template of the message. It must contain a @@pin that will be replaced by the generated
   * code.
   */
  private String template;

  /**
   * Country in ISO-3166-1 alpha 2 format (GR, US etc.). The country to use in order to select a
   * translated template (if defined in Routee web interface)
   */
  private String templateCountry;

  /** The senderId that will be set when sending the SMS. */
  private String originator;

  /**
   * How many seconds this verification will remain active. After that time passes the verification
   * status will be Expired.
   */
  private double lifetimeInSeconds;

  /**
   * Defines the number of times the user can re-confirm the verification before the verification
   * changes its state to Failed.
   */
  private double maxRetries;

  /**
   * The number of digits of the generated random numeric code.
   */
  private double digits;



  /**
   * Instantiates a new send twp step verification paramters.
   *
   * @param method the method
   * @param type the type
   * @param recipient the recipient
   * @param arguments the arguments
   * @param template the template
   * @param templateCountry the template country
   * @param originator the originator
   * @param lifetimeInSeconds the lifetime in seconds
   * @param maxRetries the max retries
   * @param digits the digits
   */
  public SendTwpStepVerificationParameters(String method, String type, String recipient,
      ArrayList<Argument> arguments, String template, String templateCountry, String originator,
      double lifetimeInSeconds, double maxRetries, double digits) {
    this.method = method;
    this.type = type;
    this.recipient = recipient;
    this.arguments = arguments;
    this.template = template;
    this.templateCountry = templateCountry;
    this.originator = originator;
    this.lifetimeInSeconds = lifetimeInSeconds;
    this.maxRetries = maxRetries;
    this.digits = digits;
  }

  /**
   * Instantiates a new send twp step verification paramters.
   */
  public SendTwpStepVerificationParameters() {
    this.arguments = new ArrayList<Argument>();
  }

  /**
   * Gets the method.
   *
   * @return the method
   */
  public String getMethod() {
    return method;
  }

  /**
   * Sets the method.
   *
   * @param method the new method
   */
  public void setMethod(String method) {
    this.method = method;
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
   * Gets the recipient.
   *
   * @return the recipient
   */
  public String getRecipient() {
    return recipient;
  }

  /**
   * Sets the recipient.
   *
   * @param recipient the new recipient
   */
  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  /**
   * Gets the arguments.
   *
   * @return the arguments
   */
  public ArrayList<Argument> getArguments() {
    return arguments;
  }

  /**
   * Sets the arguments.
   *
   * @param arguments the new arguments
   */
  public void setArguments(ArrayList<Argument> arguments) {
    this.arguments = arguments;
  }

  /**
   * Gets the template.
   *
   * @return the template
   */
  public String getTemplate() {
    return template;
  }

  /**
   * Sets the template.
   *
   * @param template the new template
   */
  public void setTemplate(String template) {
    this.template = template;
  }

  /**
   * Gets the template country.
   *
   * @return the template country
   */
  public String getTemplateCountry() {
    return templateCountry;
  }

  /**
   * Sets the template country.
   *
   * @param templateCountry the new template country
   */
  public void setTemplateCountry(String templateCountry) {
    this.templateCountry = templateCountry;
  }

  /**
   * Gets the originator.
   *
   * @return the originator
   */
  public String getOriginator() {
    return originator;
  }

  /**
   * Sets the originator.
   *
   * @param originator the new originator
   */
  public void setOriginator(String originator) {
    this.originator = originator;
  }

  /**
   * Gets the lifetime in seconds.
   *
   * @return the lifetime in seconds
   */
  public double getLifetimeInSeconds() {
    return lifetimeInSeconds;
  }

  /**
   * Sets the lifetime in seconds.
   *
   * @param lifetimeInSeconds the new lifetime in seconds
   */
  public void setLifetimeInSeconds(double lifetimeInSeconds) {
    this.lifetimeInSeconds = lifetimeInSeconds;
  }

  /**
   * Gets the max retries.
   *
   * @return the max retries
   */
  public double getMaxRetries() {
    return maxRetries;
  }

  /**
   * Sets the max retries.
   *
   * @param maxRetries the new max retries
   */
  public void setMaxRetries(double maxRetries) {
    this.maxRetries = maxRetries;
  }

  /**
   * Gets the digits.
   *
   * @return the digits
   */
  public double getDigits() {
    return digits;
  }

  /**
   * Sets the digits.
   *
   * @param digits the new digits
   */
  public void setDigits(double digits) {
    this.digits = digits;
  }

  /**
   * Adds the argument.
   *
   * @param argument the argument
   */
  public void addArgument(Argument argument) {
    if (this.arguments == null) {
      this.arguments = new ArrayList<Argument>();
    }
    this.arguments.add(argument);
  }

  /**
   * To json.
   *
   * @return the string
   */
  public String toJson() {

    JSONObject jsonBody = new JSONObject();
    jsonBody.put("method", this.getMethod());
    jsonBody.put("type", this.getType());
    jsonBody.put("recipient", this.getRecipient());
    if (this.getTemplate() != null) {
      jsonBody.put("template", this.getTemplate());
      if (this.getArguments() != null) {
        if (this.getArguments().size() != 0) {
          ArrayList<Argument> arguments = this.getArguments();
          JSONObject argumentJsonObject = new JSONObject();
          for (int i = 0; i < arguments.size(); i++) {
            argumentJsonObject.put(arguments.get(i).getName(), arguments.get(i).getValue());
          }
          jsonBody.put("arguments", argumentJsonObject);
        }
      }
      if (this.getTemplateCountry() != null) {
        jsonBody.put("templateCountry", this.getTemplateCountry());
      }
      if (this.getOriginator() != null) {
        jsonBody.put("originator", this.getOriginator());
      }
      if (this.getLifetimeInSeconds() != 0) {
        jsonBody.put("lifetimeInSeconds", this.getLifetimeInSeconds());
      }
      if (this.getMaxRetries() != 0) {
        jsonBody.put("maxRetries", this.getMaxRetries());
      }
      if (this.getDigits() != 0) {
        jsonBody.put("digits", this.getDigits());
      }
    }
    return jsonBody.toString();
  }

}
