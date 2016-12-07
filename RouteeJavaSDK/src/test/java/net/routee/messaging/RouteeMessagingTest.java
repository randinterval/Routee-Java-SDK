package net.routee.messaging;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import net.routee.TestConfiguration;
import net.routee.authentication.RouteeAuthentication;
import net.routee.authentication.RouteeAuthenticationException;
import net.routee.contacts.Contact;
import net.routee.contacts.Filter;
import net.routee.contacts.RouteeContactsClient;
import net.routee.contacts.RouteeContactsException;


/**
 * The Class RouteeMessagingTest.
 */
public class RouteeMessagingTest {

  /**
   * Test single SMS.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testSingleSMS()
      throws RouteeAuthenticationException, RouteeMessagingException, IOException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Message msg = new Message();
    msg.setFrom("Saad");
    msg.setBody("Routee Messaging Test");
    msg.setTo(TestConfiguration.DUMMY_NUMBER);
    SingleSmsResponse result = client.sendSingleSms(msg);
    assertNotNull(result.getTrackingId());
  }

  /**
   * Test single SMS with call back.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testSingleSMSWithCallBack()
      throws RouteeAuthenticationException, RouteeMessagingException, IOException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Message msg = new Message();
    msg.setFrom("Saad");
    msg.setBody("Routee Messaging Test");
    msg.setTo(TestConfiguration.DUMMY_NUMBER);
    Callback callback = new Callback();
    callback.setCallbackStrategy("OnChange");
    callback.setCallbackUrl("http://randinterval.com");
    msg.setCallback(callback);
    SingleSmsResponse result = client.sendSingleSms(msg);
    assertTrue(result.getCallback() != null && result.getCallback().getCallbackStrategy() != null);
  }

  /**
   * Testbody analysis of single message.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testbodyAnalysisOfSingleMessage()
      throws RouteeAuthenticationException, RouteeMessagingException, IOException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Message msg = new Message();
    msg.setFrom("Saad");
    msg.setBody("Routee Messaging Test");
    msg.setTo(TestConfiguration.DUMMY_NUMBER);
    SingleSmsResponse result = client.sendSingleSms(msg);
    BodyAnalysis analyze = result.getAnalysis();
    assertNotNull(analyze.getCharacters());

  }

  /**
   * Test single SMS invalid number.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test(expected = RouteeMessagingException.class)
  public void testSingleSMSInvalidNumber()
      throws RouteeAuthenticationException, RouteeMessagingException, IOException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Message msg = new Message();
    msg.setFrom("Saad");
    msg.setBody("Routee Messaging Test");
    msg.setTo("Invalid");
    client.sendSingleSms(msg);
  }



  /**
   * Test analyze A single message.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testAnalyzeASingleMessage()
      throws RouteeAuthenticationException, RouteeMessagingException, IOException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Message msg = new Message();
    msg.setFrom("Saad");
    msg.setBody("Routee Messaging Test");
    msg.setTo(TestConfiguration.DUMMY_NUMBER);
    SingleMessageAnalysisResponse result = client.analyzeSingleMessage(msg);
    assertTrue(result.getCost() >= 0);
  }

  /**
   * Test send campaign.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testSendCampaign()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    CampaignResponse result = client.sendCampaign(campaign);
    assertNotNull(result.getTrackingId());
  }



  /**
   * Test track multiple sms of specific campaign.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testTrackMultipleSmsOfSpecificCampaign() throws RouteeAuthenticationException,
      IOException, RouteeMessagingException, InterruptedException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    CampaignResponse result = client.sendCampaign(campaign);
    Thread.sleep(100);
    TrackMultipleSmsResponse trackResult =
        client.trackMultipleSmsOfSpecificCampaign(null, result.getTrackingId());
    assertNotNull(trackResult.getSmsInformation());
  }

  /**
   * Test track multiple sms of specific campaign sms data.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testTrackMultipleSmsOfSpecificCampaignSmsData() throws RouteeAuthenticationException,
      IOException, RouteeMessagingException, InterruptedException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    CampaignResponse result = client.sendCampaign(campaign);
    Thread.sleep(1000);
    TrackMultipleSmsResponse trackResult =
        client.trackMultipleSmsOfSpecificCampaign(null, result.getTrackingId());
    ArrayList<SmsData> smsInfoArray = trackResult.getSmsInformation();
    SmsData data = smsInfoArray.get(0);
    assertTrue(data.getBody() != null && data.getApplicationName() != null
        && data.getCountry() != null && data.getDirection() != null);
  }

  /**
   * Test track multiple sms of specific campaign sms data with parameters.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testTrackMultipleSmsOfSpecificCampaignSmsDataWithParameters()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    CampaignResponse result = client.sendCampaign(campaign);
    TrackMultipleSmsParamters parameter = new TrackMultipleSmsParamters();
    parameter.setPage("1");
    parameter.setSize("10");
    TrackMultipleSmsResponse trackResult =
        client.trackMultipleSmsOfSpecificCampaign(parameter, result.getTrackingId());
    ArrayList<SmsData> smsInfoArray = trackResult.getSmsInformation();
    assertNotNull(smsInfoArray);
  }

  /**
   * Test retrieve countries supported by quiet hours.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testRetrieveCountriesSupportedByQuietHours()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<QuietHourCountry> result = client.retrieveQuetHourSupportedCountries("en");
    assertNotNull(result);
  }

  /**
   * Test delete schedueled campaign.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = RouteeMessagingException.class)
  public void testDeleteSchedueledCampaign() throws RouteeAuthenticationException, IOException,
      RouteeMessagingException, InterruptedException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    CampaignResponse result = client.sendCampaign(campaign);
    // Should get an exception as the campaign is set to be sent instantly so should not be able to
    // delete..
    client.deleteScheduledCampaign(result.getTrackingId());
  }

  /**
   * Test analyze A campaign.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testAnalyzeACampaign()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    Fallback fallback = new Fallback();
    fallback.setName("Hello");
    fallback.setValue("Ok");
    fallback.getClass();
    fallback.getValue();
    Reminder reminder = new Reminder();
    reminder.setMinutesAfter(12);
    reminder.setMinutesBefore(13);
    reminder.getClass();
    Transcode transcode = new Transcode("Ok", 12);
    transcode.setMessage("OK");
    transcode.setParts(12);
    transcode.getMessage();
    transcode.getParts();
    CampaignAnalysisResponse result = client.analyzeACampaign(campaign);
    assertTrue(result.getBodyAnalysis() != null && result.getRecipientCountries() != null);
  }


  /**
   * Test analyze A campaign with groups.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testAnalyzeACampaignWithGroups()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");

    ArrayList<String> groups = new ArrayList<String>();
    groups.add("All");
    campaign.setGroups(groups);
    CampaignAnalysisResponse result = client.analyzeACampaign(campaign);
    ArrayList<RecipientGroup> rpg = result.getRecipientsPerGroup();
    assertNotNull(rpg);
  }

  /**
   * Test analyze A campaign with groups with receipients.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testAnalyzeACampaignWithGroupsWithReceipients()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    ArrayList<String> groups = new ArrayList<String>();
    groups.add("All");
    campaign.setGroups(groups);
    CampaignAnalysisResponse result = client.analyzeACampaign(campaign);
    assertTrue(result.getTotalInGroups() >= 0);
  }


  /**
   * Test analyze A campaign with groups with receipients per country.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testAnalyzeACampaignWithGroupsWithReceipientsPerCountry()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    ArrayList<String> groups = new ArrayList<String>();
    groups.add("All");
    campaign.setGroups(groups);
    CampaignAnalysisResponse result = client.analyzeACampaign(campaign);
    assertNotNull(result.getRecipientsPerCountry());
  }

  /**
   * Test analyze A campaign with groups with receipients per country verify counry.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testAnalyzeACampaignWithGroupsWithReceipientsPerCountryVerifyCounry()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    ArrayList<String> groups = new ArrayList<String>();
    groups.add("All");
    campaign.setGroups(groups);
    CampaignAnalysisResponse result = client.analyzeACampaign(campaign);
    ArrayList<RecipientPerCountry> country = result.getRecipientsPerCountry();
    assertNotNull(country.get(0).getCountryCode().equals("PK"));
  }

  /**
   * Test analyze A campaign with groups with group verify group name.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testAnalyzeACampaignWithGroupsWithGroupVerifyGroupName()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    ArrayList<String> groups = new ArrayList<String>();
    groups.add("All");
    campaign.setGroups(groups);
    CampaignAnalysisResponse result = client.analyzeACampaign(campaign);
    assertTrue(result.getRecipientsPerGroup().get(0).getGroupName().equals("All"));
  }

  /**
   * Test analyze A campaign with groups with group verify group count.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   */
  @Test
  public void testAnalyzeACampaignWithGroupsWithGroupVerifyGroupCount()
      throws RouteeAuthenticationException, IOException, RouteeMessagingException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    ArrayList<String> groups = new ArrayList<String>();
    groups.add("All");
    campaign.setGroups(groups);
    CampaignAnalysisResponse result = client.analyzeACampaign(campaign);
    assertTrue(Integer.parseInt(result.getRecipientsPerGroup().get(0).getNumber()) >= 0);
  }


  /**
   * Test retrive details about campaign.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testRetriveDetailsAboutCampaign() throws RouteeAuthenticationException, IOException,
      RouteeMessagingException, InterruptedException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();
    campaign.setBody("Hi");
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("+923114641538");
    campaign.setTo(contacts);
    campaign.setFrom("Saad");
    CampaignResponse result = client.sendCampaign(campaign);
    // If we call retrieve Campaign details immediately than the tests fails
    // becasue routee returns that no such campaign exists
    // however if we call after a while, it passes which means it takes a while for the new campaign
    // to sync on server
    // hence sleeping for 1 second
    Thread.sleep(1000);
    CampaignResponse campaignDetails = client.retrieveCampaignDetails(result.getTrackingId());
    assertTrue(campaignDetails.getBody() != null && campaignDetails.getTrackingId() != null
        && campaignDetails.getCreatedAt() != null);
  }

  /**
   * Test track single sms test.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testTrackSingleSmsTest() throws RouteeAuthenticationException,
      RouteeMessagingException, IOException, InterruptedException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Message msg = new Message();
    msg.setFrom("Saad");
    msg.setBody("Routee Messaging Test");
    msg.setTo(TestConfiguration.DUMMY_NUMBER);
    SingleSmsResponse result = client.sendSingleSms(msg);
    Thread.sleep(1000);
    SingleSmsTrackResponse response = client.trackSingleSms(result.getTrackingId());
    assertNotNull(response.getOperator());
  }

  /**
   * Test track single sms test status.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testTrackSingleSmsTestStatus() throws RouteeAuthenticationException,
      RouteeMessagingException, IOException, InterruptedException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Message msg = new Message();
    msg.setFrom("Saad");
    msg.setBody("Routee Messaging Test");
    msg.setTo(TestConfiguration.DUMMY_NUMBER);
    SingleSmsResponse result = client.sendSingleSms(msg);
    Thread.sleep(1000);
    SingleSmsTrackResponse response = client.trackSingleSms(result.getTrackingId());
    SmsStatus status = response.getStatus();
    assertTrue(status.getStatus() != null && status.getDate() != null);
  }

  /**
   * Test track single sms test body.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testTrackSingleSmsTestBody() throws RouteeAuthenticationException,
      RouteeMessagingException, IOException, InterruptedException {
    RouteeMessagingClient client = new RouteeMessagingClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Message msg = new Message();
    msg.setFrom("Saad");
    msg.setBody("Routee Messaging Test");
    msg.setTo(TestConfiguration.DUMMY_NUMBER);
    SingleSmsResponse result = client.sendSingleSms(msg);
    Thread.sleep(1000);
    SingleSmsTrackResponse response = client.trackSingleSms(result.getTrackingId());
    assertNotNull(response.getBody());
  }

  /**
   * Test track multiple sms with filters.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testTrackMultipleSmsWithFilters()
      throws RouteeAuthenticationException, RouteeMessagingException, IOException {
    RouteeAuthentication client = new RouteeAuthentication(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Message msgToMobile = new Message();
    msgToMobile.setFrom("amdTelecom");
    msgToMobile.setTo("+923114641535");
    msgToMobile.setBody("Hello World - This is a test");
    RouteeMessagingClient messagingClient = new RouteeMessagingClient(client);
    messagingClient.sendSingleSms(msgToMobile);
    Filter filter = new Filter();
    filter.setFieldName("To");
    filter.setSearchTerm("amdTelecom");
    TrackMultipleSmsResponse result = messagingClient.trackMultipleSmsWithFilters(null, filter);
    assertTrue(result.getSize() > 0);
  }

  /**
   * Test campaign with status.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   * @throws RouteeMessagingException the routee messaging exception
   * @throws InterruptedException the interrupted exception
   */
  @Test
  public void testCampaignWithStatus() throws RouteeAuthenticationException, IOException,
      RouteeContactsException, RouteeMessagingException, InterruptedException {
    RouteeAuthentication auth = new RouteeAuthentication(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("Saad");
    contact.setLastName("Ahmed");
    contact.setMobile("+923114641539");
    contact.setEmail("saad2992@gmail.com");
    RouteeContactsClient client = new RouteeContactsClient(auth);
    contact = client.createContact(contact);
    Contact contact1 = new Contact();
    contact1.setFirstName("Ali");
    contact1.setLastName("Ahmed");
    contact1.setMobile("+923114641538");
    contact1.setEmail("ali@gmail.com");
    contact1 = client.createContact(contact1);
    Callback callback = new Callback();
    callback.setCallbackStrategy("OnChange");
    callback.setCallbackUrl("http://test.com/callbackurl");
    Campaign campaign = new Campaign();
    campaign.setCallback(callback);
    campaign.setFrom("Test");
    campaign.addContact(contact);
    campaign.addContact(contact1);
    campaign.setBody("Testing Campaign");
    RouteeMessagingClient messagingClient = new RouteeMessagingClient(auth);
    CampaignResponse campaignResponse = messagingClient.sendCampaign(campaign);
    Thread.sleep(6000);
    CampaignResponse details =
        messagingClient.retrieveCampaignDetails(campaignResponse.getTrackingId());
    TrackMultipleSmsResponse trackDetails =
        messagingClient.trackMultipleSmsOfSpecificCampaign(null, details.getTrackingId());
    assertTrue(trackDetails.getSize() > 0);

  }

  /**
   * Test delete schedule campaign.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeMessagingException the routee messaging exception
   * @throws InterruptedException the interrupted exception
   */
  @Test(expected = RouteeMessagingException.class)
  public void testDeleteScheduleCampaign() throws RouteeAuthenticationException, IOException,
      RouteeMessagingException, InterruptedException {

    RouteeAuthentication auth = new RouteeAuthentication(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Campaign campaign = new Campaign();

    campaign.setFrom("Saad");
    campaign.setBody("Test Campaign");
    ArrayList<String> to = new ArrayList<String>();
    to.add("+923114641539");
    campaign.setScheduledDate("2016-09-25T23:46:00.000Z");
    campaign.setTo(to);
    RouteeMessagingClient client = new RouteeMessagingClient(auth);
    CampaignResponse result = client.sendCampaign(campaign);

    Thread.sleep(6000);
    client.deleteScheduledCampaign(result.getTrackingId());
    client.retrieveCampaignDetails(result.getTrackingId());
  }


}
