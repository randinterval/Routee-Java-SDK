package net.routee.accounts;

import org.json.JSONObject;


/**
 * The Class TwoStepPrice Contains prices for the 2Step service.
 */
public class TwoStepPrice {


  /** Price per successful verification when verification is sent through SMS. */
  private Double smsVerificationPrice;

  /** Price per successful verification when verification is sent through Audio. */
  private Double voiceVerificationPrice;



  /**
   * Instantiates a new two step price.
   *
   * @param smsVerificationPrice the sms verification price
   * @param voiceVerificationPrice the voice verification price
   */
  public TwoStepPrice(Double smsVerificationPrice, Double voiceVerificationPrice) {
    this.smsVerificationPrice = smsVerificationPrice;
    this.voiceVerificationPrice = voiceVerificationPrice;
  }

  /**
   * Instantiates a new two step price.
   */
  public TwoStepPrice() {

  }


  /**
   * Gets the sms verification price.
   *
   * @return the sms verification price
   */
  public Double getSmsVerificationPrice() {
    return smsVerificationPrice;
  }

  /**
   * Sets the sms verification price.
   *
   * @param smsVerificationPrice the new sms verification price
   */
  public void setSmsVerificationPrice(Double smsVerificationPrice) {
    this.smsVerificationPrice = smsVerificationPrice;
  }

  /**
   * Gets the voice verification price.
   *
   * @return the voice verification price
   */
  public Double getVoiceVerificationPrice() {
    return voiceVerificationPrice;
  }

  /**
   * Sets the voice verification price.
   *
   * @param voiceVerificationPrice the new voice verification price
   */
  public void setVoiceVerificationPrice(Double voiceVerificationPrice) {
    this.voiceVerificationPrice = voiceVerificationPrice;
  }

  /**
   * From json.
   *
   * @param jsonTwoStep the json two step
   * @return the two step price
   */
  public static TwoStepPrice fromJson(JSONObject jsonTwoStep) {
    TwoStepPrice twoStepPrice = new TwoStepPrice();
    twoStepPrice.setSmsVerificationPrice(jsonTwoStep.getDouble("SmsVerification"));
    twoStepPrice.setVoiceVerificationPrice(jsonTwoStep.getDouble("VoiceVerification"));
    return twoStepPrice;
  }

}
