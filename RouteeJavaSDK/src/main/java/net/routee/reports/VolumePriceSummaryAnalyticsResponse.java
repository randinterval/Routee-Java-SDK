package net.routee.reports;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 * The Class VolumePriceSummaryAnalyticsResponse.
 */
public class VolumePriceSummaryAnalyticsResponse {

  /** The report. */
  private ArrayList<VolumePriceSummaryAnalytics> report;


  /**
   * Instantiates a new volume price summary analytics response.
   *
   * @param report the report
   */
  public VolumePriceSummaryAnalyticsResponse(ArrayList<VolumePriceSummaryAnalytics> report) {
    this.report = report;
  }

  /**
   * Instantiates a new volume price summary analytics response.
   */
  public VolumePriceSummaryAnalyticsResponse() {
    this.report = new ArrayList<VolumePriceSummaryAnalytics>();
  }

  /**
   * Gets the report.
   *
   * @return the report
   */
  public ArrayList<VolumePriceSummaryAnalytics> getReport() {
    return report;
  }

  /**
   * Sets the report.
   *
   * @param report the new report
   */
  public void setReport(ArrayList<VolumePriceSummaryAnalytics> report) {
    this.report = report;
  }

  /**
   * Adds the report.
   *
   * @param analaytics the analaytics
   */
  public void addReport(VolumePriceSummaryAnalytics analaytics) {
    if (this.report == null) {
      this.report = new ArrayList<VolumePriceSummaryAnalytics>();
    }
    this.report.add(analaytics);
  }

  /**
   * From json.
   *
   * @param jsonArrayResponse the json array response
   * @return the volume price summary analytics response
   */
  public static VolumePriceSummaryAnalyticsResponse fromJson(JSONArray jsonArrayResponse) {
    VolumePriceSummaryAnalyticsResponse responseObject = new VolumePriceSummaryAnalyticsResponse();
    for (int i = 0; i < jsonArrayResponse.length(); i++) {
      JSONObject detailJson = jsonArrayResponse.getJSONObject(i);
      responseObject.addReport(VolumePriceSummaryAnalytics.fromJson(detailJson));

    }
    return responseObject;
  }



}
