package net.routee.messaging;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 * The Class SmsAnalysis.
 */
public class SmsAnalysis {

  /**
   * The total number of recipients.
   */
  private int numberOfRecipients;

  /**
   * A list of total recipients per country. The key refers to the country.
   */
  private ArrayList<RecipientPerCountry> recipientPerCountries;

  /**
   * A list of country that each mobile belongs to. The key refers to the mobile of the recipients
   * request property
   */
  private ArrayList<RecipientCountry> recipientCountries;

  /**
   * A list of details for each contact. The key refers to the id of the contact given in the
   * request.
   */
  private ArrayList<String> contacts;

  /**
   * A list For each group the number of recipients that it contains without the blacklisted
   * contacts (in SMS blacklist). The key refers to the group given in the group request property.
   */
  private ArrayList<RecipientGroup> recipientGroups;

  /**
   * A list of total number of recipients in all given groups excluding the ones already specified
   * (in contacts and recipients request property) as well as the ones that are blacklisted.
   */
  private int totalInGroups;

  /** The analysis for the body of the SMS. */
  private BodyAnalysis bodyAnalysis;



  /**
   * Instantiates a new sms analysis.
   *
   * @param numberOfRecipients the number of recipients
   * @param recipientPerCountries the recipient per countries
   * @param recipientCountries the recipient countries
   * @param contacts the contacts
   * @param recipientGroups the recipient groups
   * @param totalInGroups the total in groups
   * @param bodyAnalysis the body analysis
   */
  public SmsAnalysis(int numberOfRecipients, ArrayList<RecipientPerCountry> recipientPerCountries,
      ArrayList<RecipientCountry> recipientCountries, ArrayList<String> contacts,
      ArrayList<RecipientGroup> recipientGroups, int totalInGroups, BodyAnalysis bodyAnalysis) {
    this.numberOfRecipients = numberOfRecipients;
    this.recipientPerCountries = recipientPerCountries;
    this.recipientCountries = recipientCountries;
    this.contacts = contacts;
    this.recipientGroups = recipientGroups;
    this.totalInGroups = totalInGroups;
    this.bodyAnalysis = bodyAnalysis;
  }

  /**
   * Instantiates a new sms analysis.
   */
  public SmsAnalysis() {

    this.recipientPerCountries = new ArrayList<RecipientPerCountry>();
    this.recipientCountries = new ArrayList<RecipientCountry>();
    this.contacts = new ArrayList<String>();
    this.recipientGroups = new ArrayList<RecipientGroup>();
    this.bodyAnalysis = new BodyAnalysis();

  }

  /**
   * Gets the number of recipients.
   *
   * @return the number of recipients
   */
  public int getNumberOfRecipients() {
    return numberOfRecipients;
  }

  /**
   * Sets the number of recipients.
   *
   * @param numberOfRecipients the new number of recipients
   */
  public void setNumberOfRecipients(int numberOfRecipients) {
    this.numberOfRecipients = numberOfRecipients;
  }

  /**
   * Gets the recipient per countries.
   *
   * @return the recipient per countries
   */
  public ArrayList<RecipientPerCountry> getRecipientPerCountries() {
    return recipientPerCountries;
  }

  /**
   * Sets the recipient per countries.
   *
   * @param recipientPerCountries the new recipient per countries
   */
  public void setRecipientPerCountries(ArrayList<RecipientPerCountry> recipientPerCountries) {
    this.recipientPerCountries = recipientPerCountries;
  }

  /**
   * Gets the recipient countries.
   *
   * @return the recipient countries
   */
  public ArrayList<RecipientCountry> getRecipientCountries() {
    return recipientCountries;
  }

  /**
   * Sets the recipient countries.
   *
   * @param recipientCountries the new recipient countries
   */
  public void setRecipientCountries(ArrayList<RecipientCountry> recipientCountries) {
    this.recipientCountries = recipientCountries;
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
   * Gets the recipient groups.
   *
   * @return the recipient groups
   */
  public ArrayList<RecipientGroup> getrecipientGroups() {
    return recipientGroups;
  }

  /**
   * Sets the recipient groups.
   *
   * @param recipientGroups the new recipient groups
   */
  public void setrecipientGroups(ArrayList<RecipientGroup> recipientGroups) {
    this.recipientGroups = recipientGroups;
  }

  /**
   * Gets the total in groups.
   *
   * @return the total in groups
   */
  public int getTotalInGroups() {
    return totalInGroups;
  }

  /**
   * Sets the total in groups.
   *
   * @param totalInGroups the new total in groups
   */
  public void setTotalInGroups(int totalInGroups) {
    this.totalInGroups = totalInGroups;
  }

  /**
   * Gets the body analysis.
   *
   * @return the body analysis
   */
  public BodyAnalysis getBodyAnalysis() {
    return bodyAnalysis;
  }

  /**
   * Sets the body analysis.
   *
   * @param bodyAnalysis the new body analysis
   */
  public void setBodyAnalysis(BodyAnalysis bodyAnalysis) {
    this.bodyAnalysis = bodyAnalysis;
  }

  /**
   * Adds the contact.
   *
   * @param contact the contact
   */
  public void addContact(String contact) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<String>();
    }
    contacts.add(contact);
  }

  /**
   * Adds the recipient per country.
   *
   * @param recipient the recipient
   */
  public void addRecipientPerCountry(RecipientPerCountry recipient) {
    if (this.recipientPerCountries == null) {
      this.recipientPerCountries = new ArrayList<RecipientPerCountry>();
    }
    this.recipientPerCountries.add(recipient);
  }

  /**
   * Adds the recipient country.
   *
   * @param recipient the recipient
   */
  public void addRecipientCountry(RecipientCountry recipient) {
    if (this.recipientCountries == null) {
      this.recipientCountries = new ArrayList<RecipientCountry>();
    }
    this.recipientCountries.add(recipient);
  }

  /**
   * Adds the recipient group.
   *
   * @param group the group
   */
  public void addRecipientGroup(RecipientGroup group) {
    if (this.recipientGroups == null) {
      this.recipientGroups = new ArrayList<RecipientGroup>();
    }
    this.recipientGroups.add(group);
  }

  /**
   * From json.
   *
   * @param smsAnalysisResult the sms analysis result
   * @return the sms analysis
   */
  public static SmsAnalysis fromJson(JSONObject smsAnalysisResult) {
    SmsAnalysis analysis = new SmsAnalysis();
    analysis.setNumberOfRecipients(smsAnalysisResult.getInt("numberOfRecipients"));
    JSONObject recipientsPerCountryJson = smsAnalysisResult.getJSONObject("recipientsPerCountry");
    if (recipientsPerCountryJson != null && recipientsPerCountryJson.length() > 0) {
      for (int i = 0; i < recipientsPerCountryJson.names().length(); i++) {
        RecipientPerCountry recipient = new RecipientPerCountry();
        recipient.setCountryCode(recipientsPerCountryJson.names().getString(i));
        recipient.setCount(
            recipientsPerCountryJson.getInt(recipientsPerCountryJson.names().getString(i)));
        analysis.addRecipientPerCountry(recipient);
      }

    }
    if (smsAnalysisResult.has("recipientCountries")) {
      JSONObject recipientsCountriesJson = smsAnalysisResult.getJSONObject("recipientCountries");
      if (recipientsCountriesJson != null && recipientsCountriesJson.length() > 0) {
        for (int i = 0; i < recipientsCountriesJson.names().length(); i++) {
          RecipientCountry recipient = new RecipientCountry();
          recipient.setNumber(recipientsCountriesJson.names().getString(i));
          recipient.setCountry(
              recipientsCountriesJson.getString(recipientsCountriesJson.names().getString(i)));
          analysis.addRecipientCountry(recipient);
        }
      }
    }
    if (!smsAnalysisResult.has("contacts")) {
      JSONArray array = smsAnalysisResult.getJSONArray("contacts");
      if (array.length() > 0) {
        for (int i = 0; i < array.length(); i++) {
          analysis.addContact(array.getString(i));
        }
      }
    }
    if (smsAnalysisResult.has("recipientsPerGroup")) {
      JSONObject recipientsGroupJson = smsAnalysisResult.getJSONObject("recipientsPerGroup");
      if (recipientsGroupJson != null && recipientsGroupJson.length() > 0) {
        for (int i = 0; i < recipientsGroupJson.names().length(); i++) {
          RecipientGroup group = new RecipientGroup();
          group.setGroupName(recipientsGroupJson.names().getString(i));
          group.setNumber(recipientsGroupJson.getString(recipientsGroupJson.names().getString(i)));
          analysis.addRecipientGroup(group);
        }
      }
    }
    analysis.setTotalInGroups(smsAnalysisResult.getInt("totalInGroups"));
    if (smsAnalysisResult.has("bodyAnalysis")) {
      JSONObject bodyAnalysisJson = smsAnalysisResult.getJSONObject("bodyAnalysis");
      analysis.setBodyAnalysis(BodyAnalysis.fromJson(bodyAnalysisJson));
    }
    return analysis;
  }

}
