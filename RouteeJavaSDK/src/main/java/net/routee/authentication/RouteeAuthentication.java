package net.routee.authentication;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * The Class RouteeAuthentication.
 */
public class RouteeAuthentication {

  /** Routee Services Default Base URL. */
  public static final String DEFAULT_BASE_URL = "https://auth.routee.net";

  /** Endpoint that retrives oAuth token for Routee Web Service. */
  private static final String ENDPOINT_TOKEN = "/oauth/token";

  /** Routee Services Base URL. */
  private final String baseUrl;

  /** The application id. */
  private final String applicationId;

  /** The application secret. */
  private final String applicationSecret;

  /** The authentication scope. */
  private String authenticationScope;

  /** The oauth token obtained from Routee Services. */
  private Token oauthToken;

  /** The http client. */
  private OkHttpClient httpClient = null;

  /**
   * Instantiates a new routee authentication.
   *
   * @param applicationId the application id
   * @param applicationSecret the application secret
   */
  public RouteeAuthentication(final String applicationId, final String applicationSecret) {

    this.applicationId = applicationId;
    this.applicationSecret = applicationSecret;
    this.baseUrl = DEFAULT_BASE_URL;
    this.authenticationScope = "*";
  }

  /**
   * Instantiates a new routee authentication.
   *
   * @param applicationId the application id
   * @param applicationSecret the application secret
   * @param baseUrl the base url
   */
  public RouteeAuthentication(final String applicationId, final String applicationSecret,
      final String baseUrl) {
    if (baseUrl == null) {
      throw new IllegalArgumentException("Base URL is null");
    }
    if (!baseUrl.toLowerCase().startsWith("https")) {
      throw new IllegalArgumentException("Base URL does not start with https:// - Invalid URL");
    }
    this.applicationId = applicationId;
    this.applicationSecret = applicationSecret;
    this.baseUrl = baseUrl;
    this.authenticationScope = "*";
  }


  /**
   * Gets the token.
   *
   * @return the token
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public String getToken() throws RouteeAuthenticationException {
    if (oauthToken == null) {
      Response result = makeRequest();
      if (result.code() == 401) {
        JSONObject response = null;
        try {
          response = new JSONObject(result.body().string());
        } catch (IOException e) {
          e.printStackTrace();
        }
        String exceptionMessage = response.getString("error") + " " + response.getString("message");
        throw new RouteeAuthenticationException(exceptionMessage);
      } else if (result.code() == 400) {
        JSONObject response = null;
        try {
          response = new JSONObject(result.body().string());
        } catch (IOException e) {
          e.printStackTrace();
        }
        String exceptionMessage =
            response.getString("error") + " " + response.getString("error_description");
        throw new RouteeAuthenticationException(exceptionMessage);
      }
      if (result != null) {
        JSONObject response = null;

        try {
          response = new JSONObject(result.body().string());
        } catch (JSONException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
        oauthToken = Token.fromJson(response);
        this.authenticationScope = oauthToken.getTokenScope();
        return oauthToken.getAccessToken();

      }
    }
    return oauthToken.getAccessToken();
  }

  /**
   * Make request.
   *
   * @return the response
   */
  private Response makeRequest() {
    this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    RequestBody body = null;
    if (authenticationScope.equals("*")) {
      body = RequestBody.create(mediaType, "grant_type=client_credentials");
    } else {
      body = RequestBody.create(mediaType,
          "scope=" + authenticationScope + "&grant_type=client_credentials");
    }
    String credential = Credentials.basic(applicationId, applicationSecret);
    Request request = new Request.Builder().url(this.baseUrl + ENDPOINT_TOKEN).post(body)
        .addHeader("authorization", credential)
        .addHeader("content-type", "application/x-www-form-urlencoded").build();
    Response response = null;
    try {
      response = httpClient.newCall(request).execute();
      return response;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   * Refresh token.
   *
   * @return the string
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public String refreshToken() throws RouteeAuthenticationException {
    oauthToken = null;
    return this.getToken();
  }

  /**
   * Gets the application id.
   *
   * @return the application id
   */
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * Gets the application secret.
   *
   * @return the application secret
   */
  public String getApplicationSecret() {
    return applicationSecret;
  }

  /**
   * Gets the base url.
   *
   * @return the base url
   */
  public String getBaseUrl() {
    return baseUrl;
  }

  /**
   * Gets the authentication scope.
   *
   * @return the authentication scope
   */
  public String getAuthenticationScope() {
    return authenticationScope;
  }

  /**
   * Sets the authentication scope.
   *
   * @param authenticationScope the new authentication scope
   */
  public void setAuthenticationScope(String authenticationScope) {
    this.authenticationScope = authenticationScope;
  }

  /**
   * Gets the token object.
   *
   * @return the token object
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  public Token getTokenObject() throws RouteeAuthenticationException {
    if (oauthToken == null) {
      Response result = makeRequest();
      if (result.code() == 401) {
        JSONObject response = null;
        try {
          response = new JSONObject(result.body().string());
        } catch (IOException e) {
          e.printStackTrace();
        }
        String exceptionMessage = response.getString("error") + " " + response.getString("message");
        throw new RouteeAuthenticationException(exceptionMessage);
      } else if (result.code() == 400) {
        JSONObject response = null;
        try {
          response = new JSONObject(result.body().string());
        } catch (IOException e) {
          e.printStackTrace();
        }
        String exceptionMessage =
            response.getString("error") + " " + response.getString("error_description");
        throw new RouteeAuthenticationException(exceptionMessage);
      }
      if (result != null) {
        JSONObject response = null;

        try {
          response = new JSONObject(result.body().string());
        } catch (JSONException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
        oauthToken = Token.fromJson(response);
        this.authenticationScope = oauthToken.getTokenScope();
      }

    }
    return oauthToken;

  }



}
