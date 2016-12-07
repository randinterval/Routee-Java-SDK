package net.routee.accounts;

import java.io.IOException;

import org.json.JSONObject;

import net.routee.authentication.RouteeAuthentication;
import net.routee.authentication.RouteeAuthenticationException;
import net.routee.configuration.Configuration;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * The Class RouteeAccountsClient.
 */
public class RouteeAccountsClient {


  /** Endpoint that Retrieves the balance of the current account. */
  public static final String ENDPOINT_BALANCE = "/accounts/me/balance";

  /** Endpoint that Retrieves the prices for all Routee services. */
  public static final String ENDPOINT_PRICES = "system/prices";

  /** Endpoint that Retrieves the transactions of the current account. */
  public static final String ENDPOINT_TRANSACTIONS = "accounts/me/transactions";

  /** Endpoint that Retrieve the available bank accounts. */
  public static final String ENDPOINT_BANKS = "/accounts/me/banks";

  /**
   * The Routee Authentication Object used to obtain Routee oAuth Token to make requests to Routee
   * API.
   */

  private RouteeAuthentication auth = null;

  /** The http client. */
  private OkHttpClient httpClient = null;


  /**
   * Instantiates a new routee accounts client.
   *
   * @param applicationId the application id
   * @param applicationSecret the application secret
   */
  public RouteeAccountsClient(final String applicationId, final String applicationSecret) {
    this.auth = new RouteeAuthentication(applicationId, applicationSecret);
  }

  /**
   * Instantiates a new routee accounts client.
   *
   * @param auth the auth
   */
  public RouteeAccountsClient(RouteeAuthentication auth) {
    this.auth = auth;
  }

  /**
   * Method to check for available balance in your Routee Account Routee will return the amount in
   * the currency you have defined in your account's settings.
   * 
   * @return the routee account balance
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  public RouteeAccountBalance retrieveAccountBalance()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_BALANCE)
        .get().addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeAccountsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return RouteeAccountBalance.fromJson(jsonResponse);
  }

  /**
   * Method to retrieve all the prices for all Routee services You can also specify various filters
   * in order to retrieve only the prices that are of interest.
   *
   * @param parameters the parameters
   * @return the retrieve prices response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  public RetrievePricesResponse retrievePricesRouteeServices(RetrievePriceParameters parameters)
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_PRICES);
    if (parameters != null) {
      if (parameters.getMcc() != null) {
        urlBuilder.addQueryParameter("mcc", parameters.getMcc());
      }
      if (parameters.getMnc() != null) {
        urlBuilder.addQueryParameter("mnc", parameters.getMnc());
      }
      if (parameters.getService() != null) {
        urlBuilder.addQueryParameter("service", parameters.getService().toString());
      }
      if (parameters.getCurrency() != null) {
        urlBuilder.addQueryParameter("currency", parameters.getCurrency());

      }
    }

    String finalUrl = urlBuilder.build().toString().replace("%2F", "/");

    Request request = new Request.Builder().url(finalUrl).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeAccountsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return RetrievePricesResponse.fromJson(jsonResponse);
  }


  /**
   * Method to Retrieve All the Transactions in your account You can filter transactions within
   * specific date range.
   *
   * @param parameters the parameters
   * @return the retrieve transaction response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  public RetrieveTransactionResponse retrieveTransacations(RetrieveTransactionParameters parameters)
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Builder urlBuilder = new HttpUrl.Builder();
    urlBuilder.scheme("https");
    urlBuilder.host(Configuration.DEFAULT_BASE_URL_WITHOUT_PROTOCOL);
    urlBuilder.addPathSegment(ENDPOINT_TRANSACTIONS);
    if (parameters != null) {
      if (parameters.getFrom() != null) {
        urlBuilder.addQueryParameter("from", parameters.getFrom());
      }
      if (parameters.getTo() != null) {
        urlBuilder.addQueryParameter("to", parameters.getTo());
      }
      if (parameters.getPage() != -1) {
        urlBuilder.addQueryParameter("page", Integer.toString(parameters.getPage()));
      }
      if (parameters.getSize() != -1) {
        urlBuilder.addQueryParameter("size", Integer.toString(parameters.getSize()));

      }
    }
    String finalUrl = urlBuilder.build().toString().replace("%2F", "/");
    Request request = new Request.Builder().url(finalUrl).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404 || responseCode == 400) {
      throw new RouteeAccountsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return RetrieveTransactionResponse.fromJSON(result);

  }

  /**
   * Retrieve available bank accounts from Routee It fetches AMD billing details and the available
   * bank accounts where you can transfer money.
   * 
   * @return the retrieve bank accounts response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  public RetrieveBankAccountsResponse retrieveAvailableBankAccounts()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_BANKS)
        .get().addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400) {
      throw new RouteeAccountsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return RetrieveBankAccountsResponse.fromJSON(jsonResponse);
  }

}
