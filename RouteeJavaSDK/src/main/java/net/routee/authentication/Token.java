package net.routee.authentication;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;


/**
 * The Class Token.
 */
public class Token {

  /** The generated access_token. This must be used in all requests. */
  private String accessToken;

  /** The token type. */
  private String tokenType;

  /** The token scope. */
  private String tokenScope;

  /**
   * Time in seconds that the token will expire. If for example it has 30, it means that the token
   * will expire in 30 seconds. Default setting is for the token to be valid for 1 hour.
   */
  private String expiresIn;

  /** The token permissions. */
  private List<String> tokenPermissions;

  /**
   * Gets the access token.
   *
   * @return the access token
   */
  public String getAccessToken() {
    return accessToken;
  }

  /**
   * Sets the access token.
   *
   * @param accessToken the new access token
   */
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  /**
   * Gets the token type.
   *
   * @return the token type
   */
  public String getTokenType() {
    return tokenType;
  }

  /**
   * Sets the token type.
   *
   * @param tokenType the new token type
   */
  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }

  /**
   * Gets the token scope.
   *
   * @return the token scope
   */
  public String getTokenScope() {
    return tokenScope;
  }

  /**
   * Sets the token scope.
   *
   * @param tokenScope the new token scope
   */
  public void setTokenScope(String tokenScope) {
    this.tokenScope = tokenScope;
  }

  /**
   * Gets the token permissions.
   *
   * @return the token permissions
   */
  public List<String> getTokenPermissions() {
    return tokenPermissions;
  }

  /**
   * Sets the token permissions.
   *
   * @param tokenPermissions the new token permissions
   */
  public void setTokenPermissions(List<String> tokenPermissions) {
    this.tokenPermissions = tokenPermissions;
  }

  /**
   * Gets the expires in.
   *
   * @return the expires in
   */
  public String getExpiresIn() {
    return expiresIn;
  }

  /**
   * Sets the expires in.
   *
   * @param expiresIn the new expires in
   */
  public void setExpiresIn(String expiresIn) {
    this.expiresIn = expiresIn;
  }


  /**
   * From json.
   *
   * @param response the response
   * @return the token
   */
  public static Token fromJson(JSONObject response) {
    Token oauthToken = new Token();
    oauthToken.setAccessToken(response.getString("access_token"));
    oauthToken.setTokenScope(response.getString("scope"));
    oauthToken.setExpiresIn(Integer.toString(response.getInt("expires_in")));
    oauthToken.setTokenType(response.getString("token_type"));
    List<Object> permissionsList = response.getJSONArray("permissions").toList();
    List<String> permissions = new ArrayList<String>();
    for (int i = 0; i < permissionsList.size(); i++) {
      permissions.add(permissionsList.get(i).toString());
    }
    oauthToken.setTokenPermissions(permissions);
    return oauthToken;
  }

}
