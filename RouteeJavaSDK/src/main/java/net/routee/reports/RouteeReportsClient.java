package net.routee.reports;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import net.routee.authentication.RouteeAuthentication;
import net.routee.authentication.RouteeAuthenticationException;
import net.routee.configuration.Configuration;
import net.routee.contacts.RouteeContactsException;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



/**
 * The Class RouteeReportsClient.
 */
public class RouteeReportsClient {



  /** The Constant ENDPOINT_VOLPRICEMESSAGES. */
  public static final String ENDPOINT_VOLPRICEMESSAGES = "reports/my/volPrice";

  /** The Constant ENDPOINT_VOLPRICECOUNTRY. */
  public static final String ENDPOINT_VOLPRICECOUNTRY = "reports/my/volPrice/perMcc";

  /** The Constant ENDPOINT_VOLPRICECOUNTRYANDNETWORK. */
  public static final String ENDPOINT_VOLPRICECOUNTRYANDNETWORK = "reports/my/volPrice/perMccMnc";

  /** The Constant ENDPOINT_VOLPRICECAMPAIGN. */
  public static final String ENDPOINT_VOLPRICECAMPAIGN = "reports/my/volPrice/perCampaign";

  /** The Constant ENDPOINT_TIMESUMMARYMESSAGES. */
  public static final String ENDPOINT_TIMESUMMARYMESSAGES = "reports/my/latency";

  /** The Constant ENDPOINT_TIMESUMMARYCOUNTRY. */
  public static final String ENDPOINT_TIMESUMMARYCOUNTRY = "reports/my/latency/perCountry";

  /** The Constant ENDPOINT_TIMESUMMARYCOUNTRYNETWORK. */
  public static final String ENDPOINT_TIMESUMMARYCOUNTRYNETWORK = "reports/my/latency/perMccMnc";

  /** The Constant ENDPOINT_TIMESUMMARYCAMPAIGN. */
  public static final String ENDPOINT_TIMESUMMARYCAMPAIGN = "reports/my/latency/perCampaign";

  /** The auth. */
  private RouteeAuthentication auth = null;

  /** The http client. */
  private OkHttpClient httpClient = null;


  /**
   * Instantiates a new routee reports client.
   *
   * @param applicationId the application id
   * @param applicationSecret the application secret
   */
  public RouteeReportsClient(final String applicationId, final String applicationSecret) {
    this.auth = new RouteeAuthentication(applicationId, applicationSecret);
  }

  /**
   * Instantiates a new routee reports client.
   *
   * @param auth the auth
   */
  public RouteeReportsClient(RouteeAuthentication auth) {
    this.auth = auth;
  }


  /**
   * This method returns analytics for a range of messages specified by a time frame associated with
   * the owner account. The response will contain an array of reports. Each report contains
   * information for a specific country, operator, campaign and date time. The startDateTime of a
   * report combined with the timeGrouping represent the time period that this report corresponds
   * to. The time grouping is calculated depending on the supplied starting and ending date time.
   * The possible results is showed bellow:
   * 
   * interval Hour: Fetch results in hourly intervals. True if endDate ­ startDate <= 24h interval
   * Day: Fetch results in daily intervals. True if 24h < endDate ­ startDate <= month interval
   * Month: Fetch results in monthly intervals. True if month < endDate - ­startDate <= year
   * interval Year: Fetch results in yearly intervals. True if Year < endDate - startDate <= 5 years
   *
   * 
   * 
   * @param startDate starting date to get reports
   * @param endDate ending date to get reports
   * @return the volume price summary analytics response
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeContactsException the routee contacts exception
   * @throws RouteeReportsException the routee reports exception
   */
  public VolumePriceSummaryAnalyticsResponse viewVolumePriceSummaryAnalyticsRangeOfMessages(
      String startDate, String endDate) throws IOException, RouteeAuthenticationException,
      RouteeContactsException, RouteeReportsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_VOLPRICEMESSAGES);
    urlBuilder.addQueryParameter("startDate", startDate);
    urlBuilder.addQueryParameter("endDate", endDate);
    String url = urlBuilder.toString().replace("%2F", "/");
    Request request = new Request.Builder().url(url).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500) {
      throw new RouteeReportsException(response.body().string());
    }
    JSONArray jsonArrayResponse = new JSONArray(response.body().string());
    return VolumePriceSummaryAnalyticsResponse.fromJson(jsonArrayResponse);
  }

  /**
   * This method returns analytics for a range of messages specified by a time frame associated with
   * the owner account and a country. The response will contain an array of reports. Each report
   * contains information for a specific country, operator, campaign and date time. The
   * startDateTime of a report combined with the timeGrouping represent the time period that this
   * report corresponds to. The time grouping is calculated depending on the supplied starting and
   * ending date time. The possible results is showed below:
   * 
   * interval Hour : Fetch results in hourly intervals. True if endDate - startDate <= 24h interval
   * Day : Fetch results in daily intervals. True if 24h < endDate - startDate <= month interval
   * Month : Fetch results in monthly intervals. True if month < endDate - startDate <= year
   * interval Year : Fetch results in yearly intervals. True if Year < endDate - startDate <= 5
   * years
   *
   * 
   * 
   * @param startDate starting date to get reports
   * @param endDate ending date to get reports
   * @param mcc the mcc code
   * @return the volume price summary analytics response
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeContactsException the routee contacts exception
   * @throws RouteeReportsException the routee reports exception
   */
  public VolumePriceSummaryAnalyticsResponse viewVolumePriceSummaryAnalyticsCountry(
      String startDate, String endDate, String mcc) throws IOException,
      RouteeAuthenticationException, RouteeContactsException, RouteeReportsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_VOLPRICECOUNTRY);
    urlBuilder.addQueryParameter("startDate", startDate);
    urlBuilder.addQueryParameter("endDate", endDate);
    urlBuilder.addQueryParameter("mcc", mcc);
    String url = urlBuilder.toString().replace("%2F", "/");
    Request request = new Request.Builder().url(url).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500) {
      throw new RouteeReportsException(response.body().string());
    }
    JSONArray jsonArrayResponse = new JSONArray(response.body().string());
    return VolumePriceSummaryAnalyticsResponse.fromJson(jsonArrayResponse);

  }

  /**
   * This method returns analytics for a range of messages specified by a time frame associated with
   * the owner account, a country and a network. The response will contain an array of reports. Each
   * report contains information for a specific country, operator, campaign and date time. The
   * startDateTime of a report combined with the timeGrouping represent the time period that this
   * report corresponds to. The time grouping is calculated depending on the supplied starting and
   * ending date time. The possible results is showed below:
   * 
   * interval Hour: Fetch results in hourly intervals. True if endDate - startDate <= 24h interval
   * Day: Fetch results in daily intervals. True if 24h < endDate - startDate <= month interval
   * Month: Fetch results in monthly intervals. True if month < endDate - startDate <= year interval
   * Year: Fetch results in yearly intervals. True if Year < endDate - startDate <= 5 years
   *
   * 
   * 
   * @param startDate starting date to get reports
   * @param endDate tending date to get reports
   * @param mcc the mcc code
   * @param mnc the mnc code
   * @return the volume price summary analytics response
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeContactsException the routee contacts exception
   * @throws RouteeReportsException the routee reports exception
   */
  public VolumePriceSummaryAnalyticsResponse viewVolumePriceSummaryAnalyticsCountryAndNetwork(
      String startDate, String endDate, String mcc, String mnc) throws IOException,
      RouteeAuthenticationException, RouteeContactsException, RouteeReportsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_VOLPRICECOUNTRYANDNETWORK);
    urlBuilder.addQueryParameter("startDate", startDate);
    urlBuilder.addQueryParameter("endDate", endDate);
    urlBuilder.addQueryParameter("mcc", mcc);
    urlBuilder.addQueryParameter("mnc", mnc);
    String url = urlBuilder.toString().replace("%2F", "/");
    Request request = new Request.Builder().url(url).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500) {
      throw new RouteeReportsException(response.body().string());
    }
    JSONArray jsonArrayResponse = new JSONArray(response.body().string());
    return VolumePriceSummaryAnalyticsResponse.fromJson(jsonArrayResponse);
  }

  /**
   * This method returns analytics for a range of messages specified by a time frame associated with
   * the owner account and a belonging campaign ID. The response will contain an array of reports.
   * Each report contains information for a specific country, operator, campaign and date time. The
   * startDateTime of a report combined with the timeGrouping represent the time period that this
   * report corresponds to. The time grouping is calculated depending on the interval between the
   * first and the last SMS of the campaign. The possible results is showed bellow:
   * 
   * interval Hour: Fetch results in hourly intervals. True if endDate - startDate <= 24h interval
   * Day: Fetch results in daily intervals. True if 24h < endDate - startDate <= month interval
   * Month: Fetch results in monthly intervals. True if month < endDate - startDate <= year interval
   * Year: Fetch results in yearly intervals. True if Year < endDate - startDate <= 5 years
   *
   * 
   * 
   * @param offset The time offset that the result will be calculated in ISO 8601.
   * @param campaignId The id of the campaign that the messages belong to.
   * @return the volume price summary analytics response
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeContactsException the routee contacts exception
   * @throws RouteeReportsException the routee reports exception
   */
  public VolumePriceSummaryAnalyticsResponse viewVolumePriceSummaryAnalyticsForCampaign(
      String offset, String campaignId) throws IOException, RouteeAuthenticationException,
      RouteeContactsException, RouteeReportsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_VOLPRICECAMPAIGN);
    urlBuilder.addQueryParameter("offset", offset);
    urlBuilder.addQueryParameter("campaignId", campaignId);
    String url = urlBuilder.toString().replace("%2F", "/");
    Request request = new Request.Builder().url(url).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500) {
      throw new RouteeReportsException(response.body().string());
    }
    JSONArray jsonArrayResponse = new JSONArray(response.body().string());
    return VolumePriceSummaryAnalyticsResponse.fromJson(jsonArrayResponse);
  }

  /**
   * This method returns time analytics for a range of messages specified by a time frame associated
   * with the owner account. The response will be an array of 46 values. The first value represents
   * the total amount of messages with latency of 1 second. The following values of the array
   * represent the same information, linearly increased for every second. The last value represents
   * the total amount of messages that had latency greater than 45 seconds. The latency represents
   * the time interval between the time that the message was created and the time the DLR is
   * received from the SMSC.
   *
   * @param startDate starting date to get reports
   * @param endDate ending date to get reports
   * @return the array list
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   */
  public ArrayList<Integer> viewTimeSummaryAnalyticsRangeOfMessages(String startDate,
      String endDate) throws RouteeAuthenticationException, IOException, RouteeReportsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_TIMESUMMARYMESSAGES);
    urlBuilder.addQueryParameter("startDate", startDate);
    urlBuilder.addQueryParameter("endDate", endDate);
    String url = urlBuilder.toString().replace("%2F", "/");
    Request request = new Request.Builder().url(url).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500) {
      throw new RouteeReportsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    JSONArray smsLatencyArrayJson = jsonResponse.getJSONArray("smsLatencyCount");
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < smsLatencyArrayJson.length(); i++) {
      result.add(smsLatencyArrayJson.getInt(i));
    }
    return result;
  }


  /**
   * Returns time analytics for a range of messages specified by a time frame associated with the
   * owner account and a country. The response will be an array of 46 values. The first value
   * represents the total amount of messages with latency of 1 second. The following values of the
   * array represent the same information , linearly increased for every second. The last value
   * represents the total amount of messages that had latency greater than 45 seconds. The latency
   * represents the time interval between the time that the message was created and the time the DLR
   * is received from the SMSC.
   *
   * @param startDate the starting date to get reports
   * @param endDate the ending date to get reports
   * @param countryCode the country’s code in ISO 3166­1 alpha­2 format
   * @return the array list
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   */
  public ArrayList<Integer> viewTimeSummaryAnalyticsForCountry(String startDate, String endDate,
      String countryCode)
      throws RouteeAuthenticationException, IOException, RouteeReportsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_TIMESUMMARYCOUNTRY);
    urlBuilder.addQueryParameter("startDate", startDate);
    urlBuilder.addQueryParameter("endDate", endDate);
    urlBuilder.addQueryParameter("countryCode", countryCode);
    String url = urlBuilder.toString().replace("%2F", "/");
    Request request = new Request.Builder().url(url).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500) {
      throw new RouteeReportsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    JSONArray smsLatencyArrayJson = jsonResponse.getJSONArray("smsLatencyCount");
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < smsLatencyArrayJson.length(); i++) {
      result.add(smsLatencyArrayJson.getInt(i));
    }
    return result;
  }

  /**
   * Returns time analytics for a range of messages specified by a time frame associated with the
   * owner account, a country and a network. The response will be an array of 46 values. The first
   * value represents the total amount of messages with latency of 1 second. The following values of
   * the array represent the same information , linearly increased for every second. The last value
   * represents the total amount of messages that had latency greater than 45 seconds. The latency
   * represents the time interval between the time that the message was created and the time the DLR
   * is received from the SMSC.
   *
   * @param startDate the starting date to get reports
   * @param endDate the ending date to get reports
   * @param mcc the mcc code
   * @param mnc the mnc code
   * @return the array list
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   */
  public ArrayList<Integer> viewTimeSummaryAnalyticsForCountryAndNetwork(String startDate,
      String endDate, String mcc, String mnc)
      throws RouteeAuthenticationException, IOException, RouteeReportsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_TIMESUMMARYCOUNTRYNETWORK);
    urlBuilder.addQueryParameter("startDate", startDate);
    urlBuilder.addQueryParameter("endDate", endDate);
    urlBuilder.addQueryParameter("mcc", mcc);
    urlBuilder.addQueryParameter("mnc", mnc);
    String url = urlBuilder.toString().replace("%2F", "/");
    Request request = new Request.Builder().url(url).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500) {
      throw new RouteeReportsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    JSONArray smsLatencyArrayJson = jsonResponse.getJSONArray("smsLatencyCount");
    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < smsLatencyArrayJson.length(); i++) {
      result.add(smsLatencyArrayJson.getInt(i));
    }
    return result;
  }


  /**
   * Returns time analytics for a range of messages specified by the owner account and a campaign.
   * The response will be an array of 46 values. The first value represents the total amount of
   * messages with latency of 1 second. The following values of the array represent the same
   * information, linearly increased for every second. The last value represents the total amount of
   * messages that had latency greater than 45 seconds. The latency represents the time interval
   * between the time that the message was created and the time the DLR is received from the SMSC.
   *
   * @param campaignId the Id of the campaign
   * @return the array list
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   */
  public ArrayList<Integer> viewTimeSummaryAnalyticsCampaign(String campaignId)
      throws RouteeAuthenticationException, IOException, RouteeReportsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_TIMESUMMARYCAMPAIGN);
    urlBuilder.addQueryParameter("campaignId", campaignId);

    String url = urlBuilder.toString().replace("%2F", "/");
    Request request = new Request.Builder().url(url).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 500 || responseCode != 200) {
      throw new RouteeReportsException(response.body().string());
    }
    ArrayList<Integer> result = new ArrayList<Integer>();
    JSONObject jsonResponse = new JSONObject(response.body().string());
    if (jsonResponse.has("smsLatencyCount")) {
      JSONArray smsLatencyArrayJson = jsonResponse.getJSONArray("smsLatencyCount");
      for (int i = 0; i < smsLatencyArrayJson.length(); i++) {
        result.add(smsLatencyArrayJson.getInt(i));
      }
    }
    return result;
  }

}
