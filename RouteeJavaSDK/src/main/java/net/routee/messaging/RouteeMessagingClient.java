package net.routee.messaging;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import net.routee.authentication.RouteeAuthentication;
import net.routee.authentication.RouteeAuthenticationException;
import net.routee.configuration.Configuration;
import net.routee.contacts.Filter;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



/**
 * The Class RouteeMessagingClient.
 */
public class RouteeMessagingClient {


  /** The Constant ENDPOINT_SMS. */
  public static final String ENDPOINT_SMS = "/sms";

  /** The Constant ENDPOINT_ANALYZESMS. */
  public static final String ENDPOINT_ANALYZESMS = "/sms/analyze";

  /** The Constant ENDPOINT_SENDCAMPAIGN. */
  public static final String ENDPOINT_SENDCAMPAIGN = "/sms/campaign";

  /** The Constant ENDPOINT_ANALYZECAMPAIGN. */
  public static final String ENDPOINT_ANALYZECAMPAIGN = "/sms/analyze/campaign";

  /** The Constant ENDPOINT_TRACKSMS. */
  public static final String ENDPOINT_TRACKSMS = "/sms/tracking/single/";

  /** The Constant ENDPOINT_TRACKMULTIPLESMS. */
  public static final String ENDPOINT_TRACKMULTIPLESMS = "/sms/tracking/campaign/";

  /** The Constant ENDPOINT_TRACKMULTIPLESMSFILTER. */
  public static final String ENDPOINT_TRACKMULTIPLESMSFILTER = "/sms/tracking";

  /** The Constant ENDPOINT_RETCOUNTRIESQUIETHOURS. */
  public static final String ENDPOINT_RETCOUNTRIESQUIETHOURS = "/sms/quietHours/countries/";

  /** The Constant ENDPOINT_CAMPAIGN. */
  public static final String ENDPOINT_CAMPAIGN = "/campaigns/";

  /** The auth. */
  private RouteeAuthentication auth = null;

  /** The http client. */
  private OkHttpClient httpClient = null;

  /**
   * Instantiates a new routee messaging client.
   *
   * @param applicationId the application id
   * @param applicationSecret the application secret
   */
  public RouteeMessagingClient(final String applicationId, final String applicationSecret) {
    this.auth = new RouteeAuthentication(applicationId, applicationSecret);
  }

  /**
   * Instantiates a new routee messaging client.
   *
   * @param auth the auth
   */
  public RouteeMessagingClient(RouteeAuthentication auth) {
    this.auth = auth;
  }

  /**
   * Send single sms.
   *
   * @param message the message
   * @return the single sms response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public SingleSmsResponse sendSingleSms(Message message)
      throws RouteeAuthenticationException, RouteeMessagingException, IOException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, message.toJson());
    Request request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_SMS)
        .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return SingleSmsResponse.fromJson(result);
  }

  /**
   * Analyzing a single SMS is useful when the user needs information about the message before
   * actually sending it.
   *
   * @param message The message you want to send.
   * @return the single message analysis response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public SingleMessageAnalysisResponse analyzeSingleMessage(Message message)
      throws RouteeAuthenticationException, RouteeMessagingException, IOException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    JSONObject jsonBody = new JSONObject();
    jsonBody.put("from", message.getFrom());
    jsonBody.put("body", message.getBody());
    jsonBody.put("to", message.getTo());
    body = RequestBody.create(mediaType, jsonBody.toString());
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_ANALYZESMS).post(body)
            .addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404 || responseCode == 400) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return SingleMessageAnalysisResponse.fromJson(result);
  }

  /**
   * Routee allows to send an SMS campaign to multiple recipients/contacts/groups.
   *
   * @param campaign the campaign
   * @return the campaign response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  public CampaignResponse sendCampaign(Campaign campaign)
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, campaign.toJson());
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_SENDCAMPAIGN).post(body)
            .addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONObject jsonResult = new JSONObject(response.body().string());
    return CampaignResponse.fromJson(jsonResult);
  }

  /**
   * This Analyzing a campaign method is useful when the user needs information about the campaign
   * before actually sending it.
   *
   * @param campaign the campaign
   * @return the campaign analysis response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  public CampaignAnalysisResponse analyzeACampaign(Campaign campaign)
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, campaign.toJson());
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_ANALYZECAMPAIGN)
            .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return CampaignAnalysisResponse.fromJson(jsonResponse);
  }

  /**
   * This method is used to retrieve all the supported countries in your preferred language.
   *
   * @param language the language
   * @return the array list
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  public ArrayList<QuietHourCountry> retrieveQuetHourSupportedCountries(String language)
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_RETCOUNTRIESQUIETHOURS + "/" + language)
        .get().addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONArray jsonResponse = new JSONArray(response.body().string());
    ArrayList<QuietHourCountry> quietHourCountries = new ArrayList<QuietHourCountry>();
    for (int i = 0; i < jsonResponse.length(); i++) {
      JSONObject quietHourJson = jsonResponse.getJSONObject(i);
      quietHourCountries.add(QuietHourCountry.fromJson(quietHourJson));
    }
    return quietHourCountries;

  }

  /**
   * This method is used to Update an already scheduled campaign. You can change the recipients or
   * the sender id or any other parameter you set previously. Note that the campaign must have
   * status "Scheduled" in order to update it.
   *
   * @param campaignId the campaign’s tracking id.
   * @param campaign the campaign
   * @return the campaign response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  public CampaignResponse updateCampaign(String campaignId, Campaign campaign)
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {


    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, campaign.toJson());
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_SMS + "/" + campaignId)
            .put(body).addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONObject jsonResult = new JSONObject(response.body().string());
    return CampaignResponse.fromJson(jsonResult);
  }

  /**
   * This method is used When you no longer want to send an already scheduled campaign, deleting it
   * is very simple.
   *
   * @param campaignId the campaign id
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  public void deleteScheduledCampaign(String campaignId)
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_SMS + "/" + campaignId)
            .delete().addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeMessagingException(response.body().string());
    }
  }

  /**
   * This method is used when you want to retrieve the details of a specific campaign by its
   * tracking id.
   *
   * @param trackingId the campaign’s tracking id.
   * @return the campaign response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public CampaignResponse retrieveCampaignDetails(String trackingId)
      throws RouteeAuthenticationException, RouteeMessagingException, IOException {

    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CAMPAIGN + trackingId)
            .get().addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONObject jsonResult = new JSONObject(response.body().string());
    return CampaignResponse.fromJson(jsonResult);
  }

  /**
   * This method is used when you want to get all the tracking information for the messages (parts)
   * of a single SMS by providing its message id.
   *
   * @param messageId The id of the single SMS
   * @return the single sms track response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  public SingleSmsTrackResponse trackSingleSms(String messageId)
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_TRACKSMS + messageId)
            .get().addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONArray arrayResponse = new JSONArray(response.body().string());
    return SingleSmsTrackResponse.fromJson(arrayResponse.getJSONObject(0));
  }

  /**
   * This method is used to get all the tracking information for the messages of a campaign by
   * providing the campaign tracking id.
   *
   * @param parameters the parameters
   * @param CampaignID The tracking id of the campaign which includes the messages.
   * @return the track multiple sms response
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public TrackMultipleSmsResponse trackMultipleSmsOfSpecificCampaign(
      TrackMultipleSmsParamters parameters, String CampaignID)
      throws IOException, RouteeMessagingException, RouteeAuthenticationException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host("connect.routee.net");
    urlBuilder.addPathSegment(ENDPOINT_TRACKMULTIPLESMS + "/" + CampaignID);
    if (parameters != null) {
      if (parameters.getPage() != null) {
        urlBuilder.addQueryParameter("page", parameters.getPage());
      }
      if (parameters.getSize() != null) {
        urlBuilder.addQueryParameter("size", parameters.getSize());
      }
      if (parameters.getSort() != null) {
        urlBuilder.addQueryParameter("sort", parameters.getSort());
      }
    }
    String finalUrl = urlBuilder.build().toString().replace("%2F", "/");
    Request request = new Request.Builder().url(finalUrl).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return TrackMultipleSmsResponse.fromJson(jsonResponse);

  }


  /**
   * This method is used to Limit the tracking result of multiple sms by passing filters.
   *
   * @param parameters the parameters
   * @param filter the filter
   * @return the track multiple sms response
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public TrackMultipleSmsResponse trackMultipleSmsWithFilters(TrackMultipleSmsParamters parameters,
      Filter filter) throws IOException, RouteeMessagingException, RouteeAuthenticationException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, filter.toJson());
    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host("connect.routee.net");
    urlBuilder.addPathSegment(ENDPOINT_TRACKMULTIPLESMSFILTER);
    if (parameters != null) {
      if (parameters.getPage() != null) {
        urlBuilder.addQueryParameter("page", parameters.getPage());
      }
      if (parameters.getSize() != null) {
        urlBuilder.addQueryParameter("size", parameters.getSize());
      }
      if (parameters.getSort() != null) {
        urlBuilder.addQueryParameter("sort", parameters.getSort());
      }
    }
    String finalUrl = urlBuilder.build().toString().replace("%2F", "/");
    Request request = new Request.Builder().url(finalUrl).post(body)
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeMessagingException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return TrackMultipleSmsResponse.fromJson(jsonResponse);

  }

}
