package net.routee.reports;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import net.routee.TestConfiguration;
import net.routee.authentication.RouteeAuthenticationException;
import net.routee.contacts.RouteeContactsException;



/**
 * The Class RouteeReportsTest.
 */
public class RouteeReportsTest {

  /**
   * Test view volume price summary for range of messages.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   */
  @Test
  public void testViewVolumePriceSummaryForRangeOfMessages()
      throws RouteeAuthenticationException, IOException, RouteeReportsException {
    RouteeReportsClient client = new RouteeReportsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<Integer> result = client.viewTimeSummaryAnalyticsRangeOfMessages(
        TestConfiguration.START_DATE, TestConfiguration.END_DATE);
    assertNotNull(result);
  }

  /**
   * Test view volume price summary for country.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testViewVolumePriceSummaryForCountry() throws RouteeAuthenticationException,
      IOException, RouteeReportsException, RouteeContactsException {
    RouteeReportsClient client = new RouteeReportsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    VolumePriceSummaryAnalyticsResponse result = client.viewVolumePriceSummaryAnalyticsCountry(
        TestConfiguration.START_DATE, TestConfiguration.END_DATE, TestConfiguration.MCC);
    assertNotNull(result.getReport());
  }

  /**
   * Test view volume price summary for country invalid date.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeReportsException.class)
  public void testViewVolumePriceSummaryForCountryInvalidDate()
      throws RouteeAuthenticationException, IOException, RouteeReportsException,
      RouteeContactsException {
    RouteeReportsClient client = new RouteeReportsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    client.viewVolumePriceSummaryAnalyticsCountry("dummy", "dummy", "dummy");
  }

  /**
   * Test view volume price summary for country and network.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testViewVolumePriceSummaryForCountryAndNetwork() throws RouteeAuthenticationException,
      IOException, RouteeReportsException, RouteeContactsException {
    RouteeReportsClient client = new RouteeReportsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    VolumePriceSummaryAnalyticsResponse result =
        client.viewVolumePriceSummaryAnalyticsCountryAndNetwork(TestConfiguration.START_DATE,
            TestConfiguration.END_DATE, TestConfiguration.MNC, TestConfiguration.MCC);
    assertNotNull(result.getReport());
  }

  /**
   * Test view time summary analytics for range of messages.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   */
  @Test
  public void testViewTimeSummaryAnalyticsForRangeOfMessages()
      throws RouteeAuthenticationException, IOException, RouteeReportsException {
    RouteeReportsClient client = new RouteeReportsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<Integer> result = client.viewTimeSummaryAnalyticsRangeOfMessages(
        TestConfiguration.START_DATE, TestConfiguration.END_DATE);
    assertNotNull(result);
  }

  /**
   * Test view time summary analytics for country.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   */
  @Test
  public void testViewTimeSummaryAnalyticsForCountry()
      throws RouteeAuthenticationException, IOException, RouteeReportsException {
    RouteeReportsClient client = new RouteeReportsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<Integer> result = client.viewTimeSummaryAnalyticsForCountry(
        TestConfiguration.START_DATE, TestConfiguration.END_DATE, TestConfiguration.COUNTRY_CODE);
    assertNotNull(result);
  }

  /**
   * Test view time summary analytics for country and network.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   */
  @Test
  public void testViewTimeSummaryAnalyticsForCountryAndNetwork()
      throws RouteeAuthenticationException, IOException, RouteeReportsException {
    RouteeReportsClient client = new RouteeReportsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<Integer> result =
        client.viewTimeSummaryAnalyticsForCountryAndNetwork(TestConfiguration.START_DATE,
            TestConfiguration.END_DATE, TestConfiguration.MCC, TestConfiguration.MNC);
    assertNotNull(result);
  }

  /**
   * Test view time summary analytics for invalid campaign.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeReportsException the routee reports exception
   */
  @Test(expected = RouteeReportsException.class)
  public void testViewTimeSummaryAnalyticsForInvalidCampaign()
      throws RouteeAuthenticationException, IOException, RouteeReportsException {
    RouteeReportsClient client = new RouteeReportsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<Integer> result = client.viewTimeSummaryAnalyticsCampaign("invalid");
    assertNotNull(result);
  }



}
