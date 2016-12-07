package net.routee.accounts;

import net.routee.contacts.Service;


/**
 * The Class RetrievePriceParameters.
 */
public class RetrievePriceParameters {

  /** The mobile country code to filter price results. */
  private String mcc;

  /** The mobile network code to filter price results. */
  private String mnc;

  /** The service to filter price results (it can accept Sms, TwoStep, Lookup). */
  private Service service;

  /** The currency code to retrieve the prices. */
  private String currency;

  /**
   * Instantiates a new retrieve price parameters.
   *
   * @param mcc the mcc
   * @param mnc the mnc
   * @param service the service
   * @param currency the currency
   */
  public RetrievePriceParameters(String mcc, String mnc, Service service, String currency) {
    this.mcc = mcc;
    this.mnc = mnc;
    this.service = service;
    this.currency = currency;
  }

  /**
   * Instantiates a new retrieve price parameters.
   */
  public RetrievePriceParameters() {

  }

  /**
   * Gets the mcc.
   *
   * @return the mcc
   */
  public String getMcc() {
    return mcc;
  }

  /**
   * Sets the mcc.
   *
   * @param mcc the new mcc
   */
  public void setMcc(String mcc) {
    this.mcc = mcc;
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
   * Gets the service.
   *
   * @return the service
   */
  public Service getService() {
    return service;
  }

  /**
   * Sets the service.
   *
   * @param service the new service
   */
  public void setService(Service service) {
    this.service = service;
  }

  /**
   * Gets the currency.
   *
   * @return the currency
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Sets the currency.
   *
   * @param currency the new currency
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }

}
