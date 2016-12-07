package net.routee.accounts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class RetrieveBankAccountsResponse.
 */
public class RetrieveBankAccountsResponse {


  /** The name of AMD company. */
  private String name;

  /** The address of AMD company. */
  private String address;

  /** The phone number of AMD company. */
  private String phone;

  /** The vat id of AMD company. */
  private String vatId;

  /** The email of AMD company. */
  private String email;

  /** A list with all available banks where you can transfer money. */
  private ArrayList<Bank> banks;

  /**
   * Instantiates a new retrieve bank accounts response.
   *
   * @param name the name
   * @param address the address
   * @param phone the phone
   * @param vatId the vat id
   * @param email the email
   * @param banks the banks
   */
  public RetrieveBankAccountsResponse(String name, String address, String phone, String vatId,
      String email, ArrayList<Bank> banks) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.vatId = vatId;
    this.email = email;
    this.banks = banks;
  }

  /**
   * Instantiates a new retrieve bank accounts response.
   */
  public RetrieveBankAccountsResponse() {
    this.banks = new ArrayList<Bank>();
  }

  /**
   * Gets the name.
   * 
   * Returns the name
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the address.
   * 
   * Returns the address
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets the address.
   *
   * @param address the new address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets the phone.
   * 
   * Returns the phone
   *
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets the phone.
   *
   * @param phone the new phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gets the vat id.
   * 
   * Returns the vat id
   *
   * @return the vat id
   */
  public String getVatId() {
    return vatId;
  }

  /**
   * Sets the vat id.
   *
   * @param vatId the new vat id
   */
  public void setVatId(String vatId) {
    this.vatId = vatId;
  }

  /**
   * Gets the email.
   * 
   * Returns the email
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email the new email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the banks.
   * 
   * Returns List of Available Links Account
   *
   * @return the banks
   */
  public ArrayList<Bank> getBanks() {
    return banks;
  }

  /**
   * Sets the banks.
   *
   * @param banks the new banks
   */
  public void setBanks(ArrayList<Bank> banks) {
    this.banks = banks;
  }

  /**
   * Adds the bank.
   *
   * @param bank the bank
   */
  public void addBank(Bank bank) {
    if (this.banks == null) {
      this.banks = new ArrayList<Bank>();
    }
    this.banks.add(bank);
  }

  /**
   * From JSON.
   *
   * @param jsonResponse the json response
   * @return the retrieve bank accounts response
   */
  public static RetrieveBankAccountsResponse fromJSON(JSONObject jsonResponse) {
    RetrieveBankAccountsResponse responseObject = new RetrieveBankAccountsResponse();
    responseObject.setName(jsonResponse.getString("name"));
    responseObject.setAddress(jsonResponse.getString("address"));
    responseObject.setEmail(jsonResponse.getString("email"));
    responseObject.setVatId(jsonResponse.getString("vatId"));
    responseObject.setPhone(jsonResponse.getString("phone"));
    JSONArray banksArray = jsonResponse.getJSONArray("banks");
    for (int i = 0; i < banksArray.length(); i++) {
      JSONObject bankJson = banksArray.getJSONObject(i);
      responseObject.addBank(Bank.fromJson(bankJson));
    }
    return responseObject;
  }
}
