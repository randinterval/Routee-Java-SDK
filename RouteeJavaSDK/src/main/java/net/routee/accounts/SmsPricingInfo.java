package net.routee.accounts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class SmsPricingInfo.
 */
public class SmsPricingInfo {

  /** The mobile country code. */
  private String mcc;

  /** The country name. */
  private String country;

  /** The ISO-3166 alpha 2 code of the country. */
  private String iso;

  /** List of all the networks of the country each containing the price. */
  private ArrayList<Network> networks;


  /**
   * Instantiates a new sms pricing info.
   *
   * @param mcc the mcc
   * @param country the country
   * @param iso the iso
   * @param networks the networks
   */
  public SmsPricingInfo(String mcc, String country, String iso, ArrayList<Network> networks) {
    this.mcc = mcc;
    this.country = country;
    this.iso = iso;
    this.networks = networks;
  }


  /**
   * Instantiates a new sms pricing info.
   */
  public SmsPricingInfo() {
    this.networks = new ArrayList<Network>();
  }


  /**
   * Gets the mcc.
   *
   * @return the mcc
   */
  public final String getMcc() {
    return mcc;
  }

  /**
   * Sets the mcc.
   *
   * @param mcc the new mcc
   */
  public final void setMcc(String mcc) {
    this.mcc = mcc;
  }

  /**
   * Gets the country.
   *
   * @return the country
   */
  public final String getCountry() {
    return country;
  }

  /**
   * Sets the country.
   *
   * @param country the new country
   */
  public final void setCountry(String country) {
    this.country = country;
  }

  /**
   * Gets the iso.
   *
   * @return the iso
   */
  public final String getIso() {
    return iso;
  }

  /**
   * Sets the iso.
   *
   * @param iso the new iso
   */
  public final void setIso(String iso) {
    this.iso = iso;
  }

  /**
   * Gets the networks.
   *
   * @return the networks
   */
  public final ArrayList<Network> getNetworks() {
    return networks;
  }

  /**
   * Sets the networks.
   *
   * @param networks the new networks
   */
  public final void setNetworks(ArrayList<Network> networks) {
    this.networks = networks;
  }

  /**
   * Adds the network.
   *
   * @param network the network
   */
  public void addNetwork(Network network) {
    if (this.networks == null) {
      this.networks = new ArrayList<Network>();
    }
    this.networks.add(network);
  }

  /**
   * From json.
   *
   * @param info the info
   * @return the sms pricing info
   */
  public static SmsPricingInfo fromJson(JSONObject info) {
    SmsPricingInfo smsInfo = new SmsPricingInfo();
    smsInfo.setMcc(info.getString("mcc"));
    smsInfo.setCountry(info.getString("country"));
    smsInfo.setIso(info.getString("iso"));
    JSONArray networkArray = info.getJSONArray("networks");
    for (int j = 0; j < networkArray.length(); j++) {
      JSONObject networkObject = networkArray.getJSONObject(j);
      smsInfo.addNetwork(Network.fromJson(networkObject));
    }
    return smsInfo;

  }

}
