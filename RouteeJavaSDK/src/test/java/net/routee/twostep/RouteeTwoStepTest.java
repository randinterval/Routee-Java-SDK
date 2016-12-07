package net.routee.twostep;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import net.routee.TestConfiguration;
import net.routee.authentication.RouteeAuthenticationException;



/**
 * The Class RouteeTwoStepTest.
 */
public class RouteeTwoStepTest {

  /**
   * Test send two step verification.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeTwoStepException the routee two step exception
   */
  @Test
  public void testSendTwoStepVerification()
      throws RouteeAuthenticationException, IOException, RouteeTwoStepException {
    RouteeTwoStepClient client = new RouteeTwoStepClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    SendTwpStepVerificationParameters parameters = new SendTwpStepVerificationParameters();
    parameters.setMethod("sms");
    parameters.setType("code");
    parameters.setRecipient(TestConfiguration.DUMMY_NUMBER);
    TwoStepVerificationResponse result = client.sendTwoStepVerification(parameters);
    assertTrue(result.getTrackingId() != null && result.getStatus() != null
        && result.getUpdatedAt() != null);
  }

  /**
   * Test send two step verification with argument.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeTwoStepException the routee two step exception
   */
  @Test
  public void testSendTwoStepVerificationWithArgument()
      throws RouteeAuthenticationException, IOException, RouteeTwoStepException {
    RouteeTwoStepClient client = new RouteeTwoStepClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    SendTwpStepVerificationParameters parameters = new SendTwpStepVerificationParameters();
    parameters.setMethod("sms");
    parameters.setType("code");
    parameters.setTemplate("@@name your code is @@pin");
    Argument argument = new Argument();
    argument.setName("name");
    argument.setValue("ArgumentTest");
    parameters.addArgument(argument);
    parameters.setRecipient(TestConfiguration.DUMMY_NUMBER);
    TwoStepVerificationResponse result = client.sendTwoStepVerification(parameters);
    assertTrue(result.getTrackingId() != null && result.getStatus() != null
        && result.getUpdatedAt() != null);
  }


  /**
   * Test send two step verification invalid number.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeTwoStepException the routee two step exception
   */
  @Test(expected = RouteeTwoStepException.class)
  public void testSendTwoStepVerificationInvalidNumber()
      throws RouteeAuthenticationException, IOException, RouteeTwoStepException {
    RouteeTwoStepClient client = new RouteeTwoStepClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    SendTwpStepVerificationParameters parameters = new SendTwpStepVerificationParameters();
    parameters.setMethod("sms");
    parameters.setType("code");
    parameters.setRecipient("12");
    client.sendTwoStepVerification(parameters);
  }

  /**
   * Test retrieve statusof two step verification.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeTwoStepException the routee two step exception
   */
  @Test
  public void testRetrieveStatusofTwoStepVerification()
      throws RouteeAuthenticationException, IOException, RouteeTwoStepException {
    RouteeTwoStepClient client = new RouteeTwoStepClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    SendTwpStepVerificationParameters parameters = new SendTwpStepVerificationParameters();
    parameters.setMethod("sms");
    parameters.setType("code");
    parameters.setRecipient(TestConfiguration.DUMMY_NUMBER);
    TwoStepVerificationResponse result = client.sendTwoStepVerification(parameters);
    TwoStepVerificationResponse resultTest =
        client.getTwoStepVerificationStatus(result.getTrackingId());
    assertNotNull(resultTest);
  }

  /**
   * Test retrieve statusof two step verification with invalid id.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeTwoStepException the routee two step exception
   */
  @Test(expected = RouteeTwoStepException.class)
  public void testRetrieveStatusofTwoStepVerificationWithInvalidId()
      throws RouteeAuthenticationException, IOException, RouteeTwoStepException {
    RouteeTwoStepClient client = new RouteeTwoStepClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    client.getTwoStepVerificationStatus("123");
  }

  /**
   * Test confirm two step withinvalid code.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeTwoStepException the routee two step exception
   */
  @Test(expected = RouteeTwoStepException.class)
  public void testConfirmTwoStepWithinvalidCode()
      throws RouteeAuthenticationException, IOException, RouteeTwoStepException {
    RouteeTwoStepClient client = new RouteeTwoStepClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    SendTwpStepVerificationParameters parameters = new SendTwpStepVerificationParameters();
    parameters.setMethod("sms");
    parameters.setType("code");
    parameters.setRecipient(TestConfiguration.DUMMY_NUMBER);
    TwoStepVerificationResponse result = client.sendTwoStepVerification(parameters);
    client.confirmTwoStepVerificationStatus(result.getTrackingId(), "12345");
  }

  /**
   * Testr retrieve account two step reports.
   *
   * @throws RouteeTwoStepException the routee two step exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  @Test
  public void testrRetrieveAccountTwoStepReports()
      throws RouteeTwoStepException, IOException, RouteeAuthenticationException {
    RouteeTwoStepClient client = new RouteeTwoStepClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    TwoStepReport result = client.retrieveTwpStepAccountReports();
    assertTrue(result.getTotal() >= 0);
  }


  /**
   * Testr retrieve account two step application reports.
   *
   * @throws RouteeTwoStepException the routee two step exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  @Test
  public void testrRetrieveAccountTwoStepApplicationReports()
      throws RouteeTwoStepException, IOException, RouteeAuthenticationException {
    RouteeTwoStepClient client = new RouteeTwoStepClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    TwoStepReport result =
        client.retrieveTwpSteApplicationReports(TestConfiguration.APPLICATION_ID);
    assertTrue(result.getTotal() >= 0);
  }


  /**
   * Test routee two step verification of cancelled two step.
   *
   * @throws RouteeTwoStepException the routee two step exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   */
  @Test(expected = RouteeTwoStepException.class)
  public void testRouteeTwoStepVerificationOfCancelledTwoStep()
      throws RouteeTwoStepException, IOException, RouteeAuthenticationException {
    RouteeTwoStepClient client = new RouteeTwoStepClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    SendTwpStepVerificationParameters parameters = new SendTwpStepVerificationParameters();
    parameters.setDigits(5);
    parameters.setMethod("sms");
    parameters.setType("code");
    parameters.setRecipient(TestConfiguration.DUMMY_NUMBER);
    TwoStepVerificationResponse result = client.sendTwoStepVerification(parameters);
    client.cancelTwoStepVerificationStatus(result.getTrackingId());
    client.confirmTwoStepVerificationStatus(result.getTrackingId(), "12345");

  }



}
