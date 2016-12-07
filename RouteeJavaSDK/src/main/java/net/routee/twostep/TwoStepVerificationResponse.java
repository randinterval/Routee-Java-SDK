package net.routee.twostep;

import org.json.JSONObject;



/**
 * The Class TwoStepVerificationResponse.
 */
public class TwoStepVerificationResponse {

  /**
   * The tracking id used to reference this specific verification.
   */
  private String trackingId;

  /**
   * The status of the verification.
   */
  private String status;

  /**
   * The last time this verification was updated.
   */
  private String updatedAt;


  /**
   * Instantiates a new two step verification response.
   *
   * @param trackingId the tracking id
   * @param status the status
   * @param updatedAt the updated at
   */
  public TwoStepVerificationResponse(String trackingId, String status, String updatedAt) {
    this.trackingId = trackingId;
    this.status = status;
    this.updatedAt = updatedAt;
  }

  /**
   * Instantiates a new two step verification response.
   */
  public TwoStepVerificationResponse() {

  }

  /**
   * Gets the tracking id.
   *
   * @return the tracking id
   */
  public String getTrackingId() {
    return trackingId;
  }

  /**
   * Sets the tracking id.
   *
   * @param trackingId the new tracking id
   */
  public void setTrackingId(String trackingId) {
    this.trackingId = trackingId;
  }

  /**
   * Gets the status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Gets the updated at.
   *
   * @return the updated at
   */
  public String getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Sets the updated at.
   *
   * @param updatedAt the new updated at
   */
  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * From json.
   *
   * @param result the result
   * @return the two step verification response
   */
  public static TwoStepVerificationResponse fromJson(JSONObject result) {
    TwoStepVerificationResponse responseObject = new TwoStepVerificationResponse();
    responseObject.setTrackingId(result.getString("trackingId"));
    responseObject.setStatus(result.getString("status"));
    responseObject.setUpdatedAt(result.getString("updatedAt"));
    return responseObject;
  }


}
