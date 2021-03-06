package net.routee.messaging;



/**
 * The Class TrackMultipleSmsParamters.
 */
public class TrackMultipleSmsParamters {


  /** ISO-8601 date-time format. */
  private String dateStart;

  /** ISO-8601 date-time format. */
  private String dateEnd;

  /** The page number to retrieve, default value is 0 (meaning the first page). */
  private String page;

  /**
   * The number of items to retrieve, default value is 10.
   */
  private String size;

  /**
   * The field name that will be used to sort the results.
   */
  private String sort;

  /**
   * If provided then only the SMS messages for the specific tracking id will be retrieved.
   */
  private String trackingId;

  /**
   * If true it will return only SMS messages that belong to an SMS campaign.
   */
  private String campaign;

  /**
   * Instantiates a new track multiple sms paramters.
   *
   * @param dateStart the date start
   * @param dateEnd the date end
   * @param page the page
   * @param size the size
   * @param sort the sort
   * @param trackingId the tracking id
   * @param campaign the campaign
   */
  public TrackMultipleSmsParamters(String dateStart, String dateEnd, String page, String size,
      String sort, String trackingId, String campaign) {
    this.dateStart = dateStart;
    this.dateEnd = dateEnd;
    this.page = page;
    this.size = size;
    this.sort = sort;
    this.trackingId = trackingId;
    this.campaign = campaign;
  }

  /**
   * Instantiates a new track multiple sms paramters.
   */
  public TrackMultipleSmsParamters() {

  }

  /**
   * Gets the date start.
   *
   * @return the date start
   */
  public String getDateStart() {
    return dateStart;
  }

  /**
   * Sets the date start.
   *
   * @param dateStart the new date start
   */
  public void setDateStart(String dateStart) {
    this.dateStart = dateStart;
  }

  /**
   * Gets the date end.
   *
   * @return the date end
   */
  public String getDateEnd() {
    return dateEnd;
  }

  /**
   * Sets the date end.
   *
   * @param dateEnd the new date end
   */
  public void setDateEnd(String dateEnd) {
    this.dateEnd = dateEnd;
  }

  /**
   * Gets the page.
   *
   * @return the page
   */
  public String getPage() {
    return page;
  }

  /**
   * Sets the page.
   *
   * @param page the new page
   */
  public void setPage(String page) {
    this.page = page;
  }

  /**
   * Gets the size.
   *
   * @return the size
   */
  public String getSize() {
    return size;
  }

  /**
   * Sets the size.
   *
   * @param size the new size
   */
  public void setSize(String size) {
    this.size = size;
  }

  /**
   * Gets the sort.
   *
   * @return the sort
   */
  public String getSort() {
    return sort;
  }

  /**
   * Sets the sort.
   *
   * @param sort the new sort
   */
  public void setSort(String sort) {
    this.sort = sort;
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
   * Gets the campaign.
   *
   * @return the campaign
   */
  public String getCampaign() {
    return campaign;
  }

  /**
   * Sets the campaign.
   *
   * @param campaign the new campaign
   */
  public void setCampaign(String campaign) {
    this.campaign = campaign;
  }



}
