package net.routee.contacts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import net.routee.TestConfiguration;
import net.routee.authentication.RouteeAuthenticationException;



/**
 * The Class RouteeContactsTest.
 */
public class RouteeContactsTest {


  /**
   * Test create contact.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testCreateContact()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {

    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    Contact response = client.createContact(contact);
    assertNotNull(response.getContactId());
  }

  /**
   * Testinvalidcreate contact.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeContactsException.class)
  public void testinvalidcreateContact()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("");
    contact.setVip(false);
    Contact response = client.createContact(contact);
    response.getContactId();
  }

  /**
   * Test delete multiple contacts.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testDeleteMultipleContacts()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {

    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    Contact response = client.createContact(contact);

    Contact contact1 = new Contact();
    contact1.setFirstName("TestContact");
    contact1.setLastName("TestContact1");
    contact1.setEmail("testContact@gmail.com");
    contact1.setMobile("+923124043212");
    contact1.setVip(false);
    Contact response1 = client.createContact(contact1);

    Contact contact2 = new Contact();
    contact2.setFirstName("TestContact2");
    contact2.setLastName("TestContact");
    contact2.setEmail("testContact@gmail.com");
    contact2.setMobile("+923124043213");
    contact2.setVip(false);
    Contact response2 = client.createContact(contact2);

    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add(response.getContactId());
    contacts.add(response1.getContactId());
    contacts.add(response2.getContactId());

    ArrayList<String> deletedContacts = client.deleteMultipleContacts(contacts);
    assertEquals(deletedContacts.size(), 3);
  }

  /**
   * Test delete multiple contacts invalid ID.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeContactsException.class)
  public void testDeleteMultipleContactsInvalidID()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("123");
    contacts.add("321");
    ArrayList<String> deletedContacts = client.deleteMultipleContacts(contacts);
    assertEquals(deletedContacts.size(), 3);
  }

  /**
   * Test delete multiple contacts empty.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = NullPointerException.class)
  public void testDeleteMultipleContactsEmpty()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    client.deleteMultipleContacts(null);
  }

  /**
   * Test empty delete multiple contacts.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = NullPointerException.class)
  public void testEmptyDeleteMultipleContacts()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    client.deleteMultipleContacts(null);
  }

  /**
   * Test retrieve multiple contacts.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testRetrieveMultipleContacts()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact1@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    client.createContact(contact);

    Contact contact1 = new Contact();
    contact1.setFirstName("TestContact");
    contact1.setLastName("TestContact1");
    contact1.setEmail("testContact2@gmail.com");
    contact1.setMobile("+923124043212");
    contact1.setVip(false);
    client.createContact(contact1);

    Contact contact2 = new Contact();
    contact2.setFirstName("TestContact3");
    contact2.setLastName("TestContact3");
    contact2.setEmail("testContact3@gmail.com");
    contact2.setMobile("+923124043213");
    contact2.setVip(false);
    client.createContact(contact2);

    RetrieveContactsResponse allContacts = client.retrieveAllContacts();
    assertTrue(allContacts.getContacts().size() >= 3);
  }

  /**
   * Test retrieve A contact.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testRetrieveAContact()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    Contact response = client.createContact(contact);
    Contact testResponse = client.retrieveContact(response.getContactId());
    assertEquals(testResponse.getContactId(), response.getContactId());
  }

  /**
   * Test update contact details.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testUpdateContactDetails()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    Contact response = client.createContact(contact);
    response.setFirstName("UpdatedName");
    Contact testResponse = client.updateContact(response);
    assertEquals("UpdatedName", testResponse.getFirstName());
  }

  /**
   * Test delete A contact.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testDeleteAContact()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    Contact response = client.createContact(contact);
    Contact testResponse = client.deleteContact(response.getContactId());
    assertEquals(testResponse.getContactId(), testResponse.getContactId());
  }

  /**
   * Test invalid id delete contact.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeContactsException.class)
  public void testInvalidIdDeleteContact()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    client.deleteContact("InvalidID");
  }

  /**
   * Test contact exists true.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testContactExistsTrue()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    client.createContact(contact);
    assertTrue(client.contactExists("+923124043211"));
  }

  /**
   * Test contact exists false.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testContactExistsFalse()
      throws IOException, RouteeAuthenticationException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    assertFalse(client.contactExists("+923121111111"));
  }

  /**
   * Test add contact to black list.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testAddContactToBlackList()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    contact = client.createContact(contact);
    ArrayList<String> contactIds = new ArrayList<String>();
    contactIds.add(contact.getContactId());
    int updated = client.addContactsToBlackList(Service.SMS, contactIds);
    assertTrue(updated >= 0);
  }

  /**
   * Test add contacto black list invalid id.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeContactsException.class)
  public void testAddContactoBlackListInvalidId()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<String> contactIds = new ArrayList<String>();
    contactIds.add("123");
    client.addContactsToBlackList(Service.SMS, contactIds);
  }

  /**
   * Test get black listed services for contact.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testGetBlackListedServicesForContact()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    contact = client.createContact(contact);
    ArrayList<String> contactIds = new ArrayList<String>();
    contactIds.add(contact.getContactId());
    client.addContactsToBlackList(Service.SMS, contactIds);
    ArrayList<Contact> contacts = client.getBlackListedContactsForService(Service.SMS);
    assertTrue(contacts.size() >= 1);
  }

  /**
   * Test remove contact from black list.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testRemoveContactFromBlackList()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    contact = client.createContact(contact);
    ArrayList<String> contactIds = new ArrayList<String>();
    contactIds.add(contact.getContactId());
    client.addContactsToBlackList(Service.SMS, contactIds);
    int updated = client.removeContactsFromBlackList(Service.SMS, contactIds);
    assertEquals(1, updated);
  }

  /**
   * Test create label.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testCreateLabel()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Label label = new Label();
    label.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    label.setType("Text");
    ArrayList<Label> labels = new ArrayList<Label>();
    labels.add(label);
    ArrayList<Label> responseLabels = client.createLabels(labels);
    assertEquals(labels.size(), responseLabels.size());
  }

  /**
   * Test create label empty.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeContactsException.class)
  public void testCreateLabelEmpty()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<Label> labels = new ArrayList<Label>();
    client.createLabels(labels);
  }

  /**
   * Test create multiple labels.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testCreateMultipleLabels()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Label label = new Label();
    label.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    label.setType("Text");
    ArrayList<Label> labels = new ArrayList<Label>();
    labels.add(label);
    label = new Label();
    label.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    label.setType("Text");
    labels.add(label);
    label = new Label();
    label.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    label.setType("Text");
    labels.add(label);
    label = new Label();
    label.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    label.setType("Text");
    labels.add(label);
    ArrayList<Label> responseLabels = client.createLabels(labels);
    assertEquals(labels.size(), responseLabels.size());
  }

  /**
   * Test create label invalid type.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeContactsException.class)
  public void testCreateLabelInvalidType()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Label label = new Label();
    label.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    label.setType("INVALID");
    ArrayList<Label> labels = new ArrayList<Label>();
    labels.add(label);
    client.createLabels(labels);
  }

  /**
   * Test retrieve account groups.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testRetrieveAccountGroups()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<Group> groups = client.retrieveAccountGroups();
    assertTrue(groups.size() > 0);
  }

  /**
   * Test retrieve specific group.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testRetrieveSpecificGroup()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Group groups = client.retrieveAccountGroup("All");
    assertEquals(groups.getName(), "All");
  }

  /**
   * Test retrieve account groups paged.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testRetrieveAccountGroupsPaged()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrieveGroupsPagedResponse groups = client.retrieveAccountGroupsPaged();
    assertTrue(groups.getGroups().size() > 0);
  }

  /**
   * Test create group.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testCreateGroup()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Group group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    Group responseGroup = client.createGroup(group);
    assertEquals(responseGroup.getName(), group.getName());
  }


  /**
   * Test create group invalid name.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeContactsException.class)
  public void testCreateGroupInvalidName()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Group group = new Group();
    group.setName("");
    client.createGroup(group);
  }

  /**
   * Test delete single group.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testDeleteSingleGroup()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Group group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    Group responseGroup = client.createGroup(group);
    ArrayList<String> groupNames = new ArrayList<String>();
    groupNames.add(responseGroup.getName());
    ArrayList<DeleteGroupsResponse> deletedGroups = client.deleteGroups(groupNames, false);
    assertEquals(deletedGroups.size(), 1);
  }

  /**
   * Test delete multiple groups.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testDeleteMultipleGroups()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Group group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    Group responseGroup = client.createGroup(group);
    ArrayList<String> groupNames = new ArrayList<String>();
    groupNames.add(responseGroup.getName());
    group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    responseGroup = client.createGroup(group);
    groupNames.add(responseGroup.getName());
    group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    responseGroup = client.createGroup(group);
    groupNames.add(responseGroup.getName());
    group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    responseGroup = client.createGroup(group);
    groupNames.add(responseGroup.getName());
    ArrayList<DeleteGroupsResponse> deletedGroups = client.deleteGroups(groupNames, true);
    assertEquals(deletedGroups.size(), 4);
  }

  /**
   * Test delete group invalid name.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeContactsException.class)
  public void testDeleteGroupInvalidName()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Group group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    ArrayList<String> groupNames = new ArrayList<String>();
    groupNames.add(group.getName());
    client.deleteGroups(groupNames, true);
  }

  /**
   * Test delete group contacts true.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testDeleteGroupContactsTrue()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Group group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    Group responseGroup = client.createGroup(group);
    ArrayList<String> groupNames = new ArrayList<String>();
    groupNames.add(responseGroup.getName());
    ArrayList<DeleteGroupsResponse> deletedGroups = client.deleteGroups(groupNames, true);
    assertTrue(deletedGroups.get(0).isDeletedContacts());
  }

  /**
   * Test merge multiple groups.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testMergeMultipleGroups()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Group group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    Group responseGroup = client.createGroup(group);
    ArrayList<String> groupNames = new ArrayList<String>();
    groupNames.add(responseGroup.getName());
    group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    responseGroup = client.createGroup(group);
    groupNames.add(responseGroup.getName());
    group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    responseGroup = client.createGroup(group);
    groupNames.add(responseGroup.getName());
    group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    responseGroup = client.createGroup(group);
    groupNames.add(responseGroup.getName());
    String newGroupName = Long.toHexString(Double.doubleToLongBits(Math.random()));
    Group testGroup = client.mergeMultipleGroups(newGroupName, groupNames);
    assertEquals(testGroup.getName(), newGroupName);
  }

  /**
   * Test multiple groups invalid group name.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test(expected = RouteeContactsException.class)
  public void testMultipleGroupsInvalidGroupName()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {

    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    ArrayList<String> groupNames = new ArrayList<String>();
    groupNames.add(Long.toHexString(Double.doubleToLongBits(Math.random())));
    groupNames.add(Long.toHexString(Double.doubleToLongBits(Math.random())));
    groupNames.add(Long.toHexString(Double.doubleToLongBits(Math.random())));
    client.mergeMultipleGroups("Testing", groupNames);
  }


  /**
   * Test create group from difference.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testCreateGroupFromDifference()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Group group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    Group responseGroup = client.createGroup(group);
    ArrayList<String> groupNames = new ArrayList<String>();
    groupNames.add(responseGroup.getName());
    group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    responseGroup = client.createGroup(group);
    groupNames.add(responseGroup.getName());
    group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    responseGroup = client.createGroup(group);
    groupNames.add(responseGroup.getName());
    group = new Group();
    group.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    responseGroup = client.createGroup(group);
    groupNames.add(responseGroup.getName());
    String newGroupName = Long.toHexString(Double.doubleToLongBits(Math.random()));
    Group testGroup = client.createGroupFromDifference(newGroupName, groupNames);
    assertEquals(testGroup.getName(), newGroupName);
  }

  /**
   * Test add contacts to specified group.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testAddContactsToSpecifiedGroup()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    Contact response = client.createContact(contact);
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add(response.getContactId());
    Group g = new Group();
    g.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    Group responseGroup = client.createGroup(g);
    Group group = client.addContactsToGroup(responseGroup.getName(), contacts);
    assertTrue(group.getSize() > 0);
  }

  /**
   * Test remove contact from specified group.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testRemoveContactFromSpecifiedGroup()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    Contact response = client.createContact(contact);
    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add(response.getContactId());
    Group g = new Group();
    g.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    Group responseGroup = client.createGroup(g);
    client.addContactsToGroup(responseGroup.getName(), contacts);
    Group result = client.deleteContactsOfGroup(responseGroup.getName(), contacts);
    assertTrue(result.getName().equals(responseGroup.getName()));
  }

  /**
   * Test remove contacts from black list.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testRemoveContactsFromBlackList()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Contact contact = new Contact();
    contact.setFirstName("TestContact");
    contact.setLastName("TestContact");
    contact.setEmail("testContact@gmail.com");
    contact.setMobile("+923124043211");
    contact.setVip(false);
    contact = client.createContact(contact);
    ArrayList<String> contactIds = new ArrayList<String>();
    contactIds.add(contact.getContactId());
    client.addContactsToBlackList(Service.SMS, contactIds);
    int updated = client.removeContactsFromBlackList(Service.SMS, contactIds);
    assertTrue(updated >= 0);
  }

  /**
   * Test create label numeric.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testCreateLabelNumeric()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Label label = new Label();
    label.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    label.setValue("5");
    label.setType("Number");
    ArrayList<Label> labels = new ArrayList<Label>();
    labels.add(label);
    ArrayList<Label> response = client.createLabels(labels);
    assertNotNull(response);
  }

  /**
   * Test create label numeric type.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  @Test
  public void testCreateLabelNumericType()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    RouteeContactsClient client = new RouteeContactsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    Label label = new Label();
    label.setName(Long.toHexString(Double.doubleToLongBits(Math.random())));
    label.setValue("5");
    label.setType("Number");
    ArrayList<Label> labels = new ArrayList<Label>();
    labels.add(label);
    ArrayList<Label> response = client.createLabels(labels);
    assertTrue(response.get(0).getType().equals("Number"));
  }


}
