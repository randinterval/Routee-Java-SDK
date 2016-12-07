package net.routee.messaging;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 * The Class CampaignAnalysisResponse.
 */
public class CampaignAnalysisResponse {

  /**
   * The total number of recipients.
   */
  private int numberOfRecipients;

  /** A list of total recipients per country. The key refers to the country. */
  private ArrayList<RecipientPerCountry> recipientsPerCountry;

  /**
   * A list of country that each mobile belongs to. The key refers to the mobile of the recipients
   * request property
   */
  private ArrayList<RecipientCountry> recipientCountries;

  /** A list of contact ids that the message will be sent. */
  private ArrayList<String> contacts;

  /** A list of groups of contacts in the account selected as recipients. */
  private ArrayList<RecipientGroup> recipientsPerGroup;

  /**
   * The total number of recipients in all given groups excluding the ones already specified (in
   * contacts and recipients request property) as well as the ones that are blacklisted.
   */
  private int totalInGroups;

  /**
   * The analysis for the body of the SMS.
   */
  private BodyAnalysis bodyAnalysis;



  /**
   * Instantiates a new campaign analysis response.
   *
   * @param numberOfRecipients the number of recipients
   * @param recipientsPerCountry the recipients per country
   * @param recipientCountries the recipient countries
   * @param contacts the contacts
   * @param recipientsPerGroup the recipients per group
   * @param totalInGroups the total in groups
   * @param bodyAnalysis the body analysis
   */
  public CampaignAnalysisResponse(int numberOfRecipients,
      ArrayList<RecipientPerCountry> recipientsPerCountry,
      ArrayList<RecipientCountry> recipientCountries, ArrayList<String> contacts,
      ArrayList<RecipientGroup> recipientsPerGroup, int totalInGroups, BodyAnalysis bodyAnalysis) {
    this.numberOfRecipients = numberOfRecipients;
    this.recipientsPerCountry = recipientsPerCountry;
    this.recipientCountries = recipientCountries;
    this.contacts = contacts;
    this.recipientsPerGroup = recipientsPerGroup;
    this.totalInGroups = totalInGroups;
    this.bodyAnalysis = bodyAnalysis;
  }

  /**
   * Instantiates a new campaign analysis response.
   */
  public CampaignAnalysisResponse() {
    this.recipientsPerCountry = new ArrayList<RecipientPerCountry>();
    this.recipientCountries = new ArrayList<RecipientCountry>();
    this.contacts = new ArrayList<String>();
    this.recipientsPerGroup = new ArrayList<RecipientGroup>();
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
   * Gets the recipients per country.
   *
   * @return the recipients per country
   */
  public ArrayList<RecipientPerCountry> getRecipientsPerCountry() {
    return recipientsPerCountry;
  }

  /**
   * Sets the recipients per country.
   *
   * @param recipientsPerCountry the new recipients per country
   */
  public void setRecipientsPerCountry(ArrayList<RecipientPerCountry> recipientsPerCountry) {
    this.recipientsPerCountry = recipientsPerCountry;
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
   * Gets the recipients per group.
   *
   * @return the recipients per group
   */
  public ArrayList<RecipientGroup> getRecipientsPerGroup() {
    return recipientsPerGroup;
  }

  /**
   * Sets the recipients per group.
   *
   * @param recipientsPerGroup the new recipients per group
   */
  public void setRecipientsPerGroup(ArrayList<RecipientGroup> recipientsPerGroup) {
    this.recipientsPerGroup = recipientsPerGroup;
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
    if (this.recipientsPerCountry == null) {
      this.recipientsPerCountry = new ArrayList<RecipientPerCountry>();
    }
    this.recipientsPerCountry.add(recipient);
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
    if (this.recipientsPerGroup == null) {
      this.recipientsPerGroup = new ArrayList<RecipientGroup>();
    }
    this.recipientsPerGroup.add(group);
  }

  /**
   * From json.
   *
   * @param jsonResponse the json response
   * @return the campaign analysis response
   */
  public static CampaignAnalysisResponse fromJson(JSONObject jsonResponse) {
    CampaignAnalysisResponse analysis = new CampaignAnalysisResponse();
    analysis.setNumberOfRecipients(jsonResponse.getInt("numberOfRecipients"));
    JSONObject recipientsPerCountryJson = jsonResponse.getJSONObject("recipientsPerCountry");
    if (recipientsPerCountryJson != null && recipientsPerCountryJson.length() > 0) {
      for (int i = 0; i < recipientsPerCountryJson.names().length(); i++) {
        RecipientPerCountry recipient = new RecipientPerCountry();
        recipient.setCountryCode(recipientsPerCountryJson.names().getString(i));
        recipient.setCount(
            recipientsPerCountryJson.getInt(recipientsPerCountryJson.names().getString(i)));
        analysis.addRecipientPerCountry(recipient);
      }

    }
    if (jsonResponse.has("recipientCountries")) {
      JSONObject recipientsCountriesJson = jsonResponse.getJSONObject("recipientCountries");
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

    if (!jsonResponse.has("contacts")) {
      JSONArray array = jsonResponse.getJSONArray("contacts");
      if (array.length() > 0) {
        for (int i = 0; i < array.length(); i++) {
          analysis.addContact(array.getString(i));
        }
      }
    }
    if (jsonResponse.has("recipientsPerGroup")) {
      JSONObject recipientsGroupJson = jsonResponse.getJSONObject("recipientsPerGroup");
      if (recipientsGroupJson != null && recipientsGroupJson.length() > 0) {
        for (int i = 0; i < recipientsGroupJson.names().length(); i++) {
          RecipientGroup group = new RecipientGroup();
          group.setGroupName(recipientsGroupJson.names().getString(i));
          group.setNumber(
              String.valueOf(recipientsGroupJson.getInt(recipientsGroupJson.names().getString(i))));
          analysis.addRecipientGroup(group);
        }
      }
    }
    if (jsonResponse.has("bodyAnalysis")) {
      JSONObject bodyAnalysisJson = jsonResponse.getJSONObject("bodyAnalysis");
      analysis.setBodyAnalysis(BodyAnalysis.fromJson(bodyAnalysisJson));
    }
    analysis.setTotalInGroups(jsonResponse.getInt("totalInGroups"));
    return analysis;
  }


}
