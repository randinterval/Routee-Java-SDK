package net.routee.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import net.routee.TestConfiguration;



/**
 * The Class RouteeAuthenticationTest.
 */
public class RouteeAuthenticationTest {

  /**
   * Test valid credentails.
   */
  @Test
  public void testValidCredentails() {
    RouteeAuthentication auth = new RouteeAuthentication(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    try {
      assertNotNull(auth.getToken());
    } catch (RouteeAuthenticationException e) {
      fail();
    }
  }

  /**
   * Test invalid credentails.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  @Test(expected = RouteeAuthenticationException.class)
  public void testInvalidCredentails() throws RouteeAuthenticationException {
    RouteeAuthentication auth = new RouteeAuthentication("dummy", "dummy");
    auth.getToken();
  }

  /**
   * Test invalid base url.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBaseUrl() {
    @SuppressWarnings("unused")
    RouteeAuthentication auth = new RouteeAuthentication("dummy", "dummy", "routee.routee.net");
  }

  /**
   * Test single scope.
   */
  @Test
  public void testSingleScope() {
    RouteeAuthentication auth = new RouteeAuthentication(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    auth.setAuthenticationScope("sms");
    try {
      auth.getToken();
    } catch (RouteeAuthenticationException e) {

    }
    assertEquals("sms", auth.getAuthenticationScope());
  }

  /**
   * Test multiple scope.
   */
  @Test
  public void testMultipleScope() {
    RouteeAuthentication auth = new RouteeAuthentication(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    auth.setAuthenticationScope("sms,contact");
    try {
      auth.getToken();
    } catch (RouteeAuthenticationException e) {
      fail();
    }
  }

  /**
   * Test invalid scope.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  @Test(expected = RouteeAuthenticationException.class)
  public void testInvalidScope() throws RouteeAuthenticationException {
    RouteeAuthentication auth = new RouteeAuthentication(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    auth.setAuthenticationScope("invalid-scope");
    auth.getToken();
  }

  /**
   * Test token object.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  @Test
  public void testTokenObject() throws RouteeAuthenticationException {
    RouteeAuthentication auth = new RouteeAuthentication(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Token token = auth.getTokenObject();
    assertNotNull(token.getAccessToken() != null && token.getExpiresIn() != null
        && token.getTokenPermissions() != null && token.getTokenScope() != null
        && token.getTokenType() != null);
  }

}
