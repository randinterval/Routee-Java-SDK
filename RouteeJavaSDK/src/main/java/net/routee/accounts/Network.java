package net.routee.accounts;

import org.json.JSONObject;


/**
 * Class containing information about a specific network such as its name, code and price.
 */
public class Network {

  /** The network name. */
  private String name;

  /** The mobile network code. */
  private String mnc;

  /** The price for the specific network. */
  private double price;



  /**
   * Instantiates a new network.
   *
   * @param name the name
   * @param mnc the mnc
   * @param price the price
   */
  public Network(String name, String mnc, double price) {
    this.name = name;
    this.mnc = mnc;
    this.price = price;
  }

  /**
   * Instantiates a new network.
   */
  public Network() {

  }

  /**
   * Gets the name.
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
   * Gets the mnc.
   *
   * @return the mnc
   */
  public String getMnc() {
    return mnc;
  }

  /**
   * Sets the mnc.
   *
   * @param mnc the new mnc
   */
  public void setMnc(String mnc) {
    this.mnc = mnc;
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
   * From json.
   *
   * @param networkObject the network object
   * @return the network
   */
  public static Network fromJson(JSONObject networkObject) {
    Network network = new Network();
    network.setMnc(networkObject.getString("mnc"));
    network.setName(networkObject.getString("network"));
    network.setPrice(networkObject.getDouble("price"));
    return network;
  }

}
