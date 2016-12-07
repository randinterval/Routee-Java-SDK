package net.routee.accounts;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * The Class RetrievePricesResponse.
 */
public class RetrievePricesResponse {

  /** Contains all the prices for sms service (per mcc and mnc). */
  private ArrayList<SmsPricingInfo> smsInfo;

  /** Contains prices for the lookup service. */
  private double lookupPricePerRequest;

  /** Contains prices for the 2Step service. */
  private TwoStepPrice twoStepPrice;

  /** The currency of all prices. */
  private Currency currency;



  /**
   * Instantiates a new retrieve prices response.
   *
   * @param smsInfo the sms info
   * @param lookupPricePerRequest the lookup price per request
   * @param twoStepPrice the two step price
   * @param currency the currency
   */
  public RetrievePricesResponse(ArrayList<SmsPricingInfo> smsInfo, double lookupPricePerRequest,
      TwoStepPrice twoStepPrice, Currency currency) {
    this.smsInfo = smsInfo;
    this.lookupPricePerRequest = lookupPricePerRequest;
    this.twoStepPrice = twoStepPrice;
    this.currency = currency;
  }

  /**
   * Instantiates a new retrieve prices response.
   */
  public RetrievePricesResponse() {
    this.smsInfo = new ArrayList<SmsPricingInfo>();
  }

  /**
   * Gets the sms info.
   *
   * @return the sms info
   */
  public final ArrayList<SmsPricingInfo> getSmsInfo() {
    return smsInfo;
  }

  /**
   * Sets the sms info.
   *
   * @param smsInfo the new sms info
   */
  public final void setSmsInfo(ArrayList<SmsPricingInfo> smsInfo) {
    this.smsInfo = smsInfo;
  }

  /**
   * Gets the lookup price per request.
   *
   * @return the lookup price per request
   */
  public final double getLookupPricePerRequest() {
    return lookupPricePerRequest;
  }

  /**
   * Sets the lookup price per request.
   *
   * @param lookupPricePerRequest the new lookup price per request
   */
  public final void setLookupPricePerRequest(double lookupPricePerRequest) {
    this.lookupPricePerRequest = lookupPricePerRequest;
  }

  /**
   * Gets the two step price.
   *
   * @return the two step price
   */
  public final TwoStepPrice getTwoStepPrice() {
    return twoStepPrice;
  }

  /**
   * Sets the two step price.
   *
   * @param twoStepPrice the new two step price
   */
  public final void setTwoStepPrice(TwoStepPrice twoStepPrice) {
    this.twoStepPrice = twoStepPrice;
  }

  /**
   * Gets the currency.
   *
   * @return the currency
   */
  public final Currency getCurrency() {
    return currency;
  }

  /**
   * Sets the currency.
   *
   * @param currency the new currency
   */
  public final void setCurrency(Currency currency) {
    this.currency = currency;
  }

  /**
   * Adds the sms pricing info.
   *
   * @param info the info
   */
  void addSmsPricingInfo(SmsPricingInfo info) {
    if (this.smsInfo == null) {
      this.smsInfo = new ArrayList<SmsPricingInfo>();
    }
    this.smsInfo.add(info);
  }

  /**
   * From json.
   *
   * @param jsonResponse the json response
   * @return the retrieve prices response
   */
  public static RetrievePricesResponse fromJson(JSONObject jsonResponse) {
    RetrievePricesResponse prices = new RetrievePricesResponse();
    if (jsonResponse.has("sms")) {
      JSONArray jsonSmsInfo = jsonResponse.getJSONArray("sms");
      for (int i = 0; i < jsonSmsInfo.length(); i++) {
        JSONObject info = jsonSmsInfo.getJSONObject(i);
        prices.addSmsPricingInfo(SmsPricingInfo.fromJson(info));
      }
    }
    if (jsonResponse.has("lookup")) {
      prices.setLookupPricePerRequest(jsonResponse.getJSONObject("lookup").getDouble("PerRequest"));
    }
    if (jsonResponse.has("twoStep")) {
      prices.setTwoStepPrice(TwoStepPrice.fromJson(jsonResponse.getJSONObject("twoStep")));
    }
    if (jsonResponse.has("currency")) {
      JSONObject jsonCurrency = jsonResponse.getJSONObject("currency");
      prices.setCurrency(Currency.fromJson(jsonCurrency));
    }
    return prices;
  }

}
