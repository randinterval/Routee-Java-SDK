package net.routee.contacts;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import net.routee.authentication.RouteeAuthentication;
import net.routee.authentication.RouteeAuthenticationException;
import net.routee.configuration.Configuration;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * The Class RouteeContactsClient.
 */
public class RouteeContactsClient {


  /** The Constant ENDPOINT_CONTACTS. */
  public static final String ENDPOINT_CONTACTS = "/contacts/my";

  /** The Constant ENDPOINT_GROUPS. */
  public static final String ENDPOINT_GROUPS = "/groups/my";



  /** The auth. */
  private RouteeAuthentication auth = null;

  /** The http client. */
  private OkHttpClient httpClient = null;



  /**
   * Instantiates a new routee contacts client.
   *
   * @param applicationId the application id
   * @param applicationSecret the application secret
   */
  public RouteeContactsClient(final String applicationId, final String applicationSecret) {
    this.auth = new RouteeAuthentication(applicationId, applicationSecret);
  }

  /**
   * Instantiates a new routee contacts client.
   *
   * @param auth the auth
   */
  public RouteeContactsClient(RouteeAuthentication auth) {
    this.auth = auth;
  }


  /**
   * Create a new contact or update it if it already exists.
   *
   * @param contact the contact
   * @return the contact
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */

  public Contact createContact(Contact contact)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, contact.toJson());
    Request request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS)
        .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 404 || responseCode == 409) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return Contact.fromJSON(result);
  }


  /**
   * Delete multiple contacts that exist in the specified account.
   *
   * @param contactIds the contact ids
   * @return the array list
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public ArrayList<String> deleteMultipleContacts(ArrayList<String> contactIds)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    JSONArray jsonBody = new JSONArray();
    for (int i = 0; i < contactIds.size(); i++) {
      jsonBody.put(contactIds.get(i));
    }
    body = RequestBody.create(mediaType, jsonBody.toString());
    Request request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS)
        .delete(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404 || responseCode == 500) {
      throw new RouteeContactsException(response.body().string());
    }
    return contactIds;
  }

  /**
   * Retrieve all the contacts of this account and sub-accounts in paged format.
   *
   * @return the retrieve contacts response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public RetrieveContactsResponse retrieveAllContacts()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS)
        .get().addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return RetrieveContactsResponse.fromJson(result);
  }


  /**
   * Retrieve all contacts.
   *
   * @param page The page number to retrieve, default value is 0 (meaning the first page).
   * @return the retrieve contacts response
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeContactsException the routee contacts exception
   */
  public RetrieveContactsResponse retrieveAllContacts(int page)
      throws IOException, RouteeAuthenticationException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "? page=" + page).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return RetrieveContactsResponse.fromJson(result);
  }

  /**
   * Retrieve all contacts.
   *
   * @param page The page number to retrieve, default value is 0 (meaning the first page).
   * @param size The number of items to retrieve, default value is 10
   * @return the retrieve contacts response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeContactsException the routee contacts exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public RetrieveContactsResponse retrieveAllContacts(int page, int size)
      throws RouteeAuthenticationException, RouteeContactsException, IOException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request = new Request.Builder()
        .url(
            Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "? page=" + page + "&size=" + size)
        .get().addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return RetrieveContactsResponse.fromJson(result);
  }

  /**
   * Get the details of a specific contact providing the contact’s id.
   *
   * @param id The id of the contact.
   * @return the contact
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public Contact retrieveContact(String id)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "/" + id)
            .get().addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return Contact.fromJSON(result);
  }

  /**
   * Change the details of a specific contact providing the contact’s id..
   *
   * @param contact the contact
   * @return the contact
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public Contact updateContact(Contact contact)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, contact.toJson());
    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "/" + contact.getContactId())
        .put(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 404 || responseCode == 409) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return Contact.fromJSON(result);
  }

  /**
   * Delete an already existing contact providing the contact’s id.
   *
   * @param id The id of the contact to be deleted.
   * @return the contact
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public Contact deleteContact(String id)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "/" + id)
            .delete().addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404 || responseCode == 500) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return Contact.fromJSON(result);

  }

  /**
   * Check if there is an already existing contact with the same mobile providing the contact’s
   * mobile.
   *
   * @param mobileNumber The mobile used to check if a contact already exists.
   * @return true, if successful
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws RouteeContactsException the routee contacts exception
   */
  public boolean contactExists(String mobileNumber)
      throws IOException, RouteeAuthenticationException, RouteeContactsException {

    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "/mobile?value=" + mobileNumber)
        .head().addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 200) {
      return true;
    } else if (responseCode == 404) {
      return false;
    } else {
      throw new RouteeContactsException(response.body().string());

    }
  }

  /**
   * Insert existing contacts to a service’s blacklist.
   *
   * @param service The service (Sms, TwoStep) for which the contact will be added in blacklist.
   * @param contactIds the contact ids
   * @return the int
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public int addContactsToBlackList(Service service, ArrayList<String> contactIds)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {


    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    JSONArray bodyArray = new JSONArray();
    for (int i = 0; i < contactIds.size(); i++) {
      bodyArray.put(contactIds.get(i));
    }
    RequestBody body = null;
    body = RequestBody.create(mediaType, bodyArray.toString());
    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "/blacklist/" + service)
        .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode != 200) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return result.getInt("updated");
  }

  /**
   * Returns all the contacts which are blacklisted for the given service.
   *
   * @param service The service (Sms, TwoStep) to get the blacklisted contacts for.
   * @return the black listed contacts for service
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public ArrayList<Contact> getBlackListedContactsForService(Service service)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "/blacklist/" + service).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONArray contactsArray = new JSONArray(response.body().string());
    ArrayList<Contact> contacts = new ArrayList<Contact>();
    for (int i = 0; i < contactsArray.length(); i++) {
      JSONObject contactJSON = contactsArray.getJSONObject(i);
      contacts.add(Contact.fromJSON(contactJSON));
    }
    return contacts;

  }

  /**
   * Remove a group of existing contacts from the blacklist of a service.
   *
   * @param service the service
   * @param group the group
   * @return the int
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public int removeGroupOfContactsFromBlackList(Service service, String group)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    JSONArray bodyArray = new JSONArray();
    bodyArray.put(group);
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, bodyArray.toString());
    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "/blacklist/" + service
            + "/groups")
        .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return result.getInt("updated");
  }

  /**
   * Retrieve the account’s labels both default and custom..
   *
   * @return the JSON object
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public JSONObject retrieveAccountContactLabels()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + "/contacts/labels/my").get()
            .addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    if (response.code() == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject responseJson = new JSONObject(response.body().string());
    return responseJson;
  }

  /**
   * Creates extra contact labels for the specified account.
   *
   * @param labels the labels
   * @return the array list
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public ArrayList<Label> createLabels(ArrayList<Label> labels)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    JSONArray bodyArray = new JSONArray();
    for (int i = 0; i < labels.size(); i++) {
      JSONObject labelJson = new JSONObject();
      Label l = labels.get(i);
      labelJson.put("name", l.getName());
      labelJson.put("type", l.getType());
      bodyArray.put(labelJson);
    }
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, bodyArray.toString());
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + "/contacts/labels/my").post(body)
            .addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    if (response.code() == 404 || response.code() == 409 || response.code() != 200) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONArray responseArray = new JSONArray(response.body().string());
    ArrayList<Label> responseLabels = new ArrayList<Label>();
    for (int i = 0; i < responseArray.length(); i++) {
      JSONObject jsonLabel = responseArray.getJSONObject(i);
      responseLabels.add(Label.fromJson(jsonLabel));
    }
    return responseLabels;
  }

  /**
   * Retrieve the specified account’s groups of contacts.
   *
   * @return the array list
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public ArrayList<Group> retrieveAccountGroups()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Request request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS)
        .get().addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONArray jsonResponse = new JSONArray(response.body().string());
    ArrayList<Group> groups = new ArrayList<Group>();
    for (int i = 0; i < jsonResponse.length(); i++) {
      groups.add(Group.fromJson(jsonResponse.getJSONObject(i)));
    }
    return groups;
  }


  /**
   * Returns one of the groups that the account has created with the number of contacts in it.
   *
   * @param groupName The name of the group.
   * @return the group
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public Group retrieveAccountGroup(String groupName)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();

    Request request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS + "/" + groupName).get()
        .addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject object = new JSONObject(response.body().string());
    return Group.fromJson(object);
  }

  /**
   * Retrieve a page of the specified account’s groups of contacts.
   *
   * @return the retrieve groups paged response
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public RetrieveGroupsPagedResponse retrieveAccountGroupsPaged()
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null) {

      this.httpClient = new OkHttpClient();

    }
    Request request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS + "/page").get()
            .addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    int responseCode = response.code();
    if (responseCode == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject result = new JSONObject(response.body().string());
    return RetrieveGroupsPagedResponse.fromJson(result);
  }

  /**
   * Creates a new group. The group can be either created empty or contacts can be added to it
   * during the creation. The contacts can be added by using filters.
   *
   * @param group the group
   * @return the group
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public Group createGroup(Group group)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, group.toJson());
    Request request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS)
        .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    if (response.code() == 400 || response.code() == 404 || response.code() == 409) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject responseObject = new JSONObject(response.body().string());
    return Group.fromJson(responseObject);
  }

  /**
   * Deletes groups from the specified account.
   *
   * @param Groups the groups
   * @param deletedContacts If true, the contacts included in the group will also be deleted.
   * @return the array list
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public ArrayList<DeleteGroupsResponse> deleteGroups(ArrayList<String> Groups,
      boolean deletedContacts)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    JSONArray jsonBody = new JSONArray();
    for (int i = 0; i < Groups.size(); i++) {
      jsonBody.put(Groups.get(i));
    }
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, jsonBody.toString());
    Request request = null;
    if (deletedContacts) {
      request = new Request.Builder()
          .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS + "?deleteContacts="
              + deletedContacts)
          .delete(body).addHeader("authorization", "Bearer " + this.auth.getToken())
          .addHeader("content-type", "application/json").build();
    } else {
      request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS)
          .delete(body).addHeader("authorization", "Bearer " + this.auth.getToken())
          .addHeader("content-type", "application/json").build();
    }
    Response response = httpClient.newCall(request).execute();
    if (response.code() == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONArray array = new JSONArray(response.body().string());
    ArrayList<DeleteGroupsResponse> responseArray = new ArrayList<DeleteGroupsResponse>();
    for (int i = 0; i < array.length(); i++) {
      JSONObject jsonGroup = array.getJSONObject(i);
      responseArray.add(DeleteGroupsResponse.fromJson(jsonGroup));

    }
    return responseArray;
  }

  /**
   * Creates a new group as a merged result of multiple groups of contacts. Duplicate contacts will
   * be added once in the new group. An extra group tag of the new merged group is added in every
   * associated contact.
   *
   * @param name The name of the group to be created.
   * @param groups The names of the groups that will be merged.
   * @return the group
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public Group mergeMultipleGroups(String name, ArrayList<String> groups)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    JSONObject jsonBody = new JSONObject();
    jsonBody.put("name", name);
    JSONArray jsonArray = new JSONArray();
    for (int i = 0; i < groups.size(); i++) {
      jsonArray.put(groups.get(i));
    }
    jsonBody.put("groups", jsonArray);
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, jsonBody.toString());
    Request request = null;
    request = new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS + "/merge")
        .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    if (response.code() == 404 || response.code() == 409) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return Group.fromJson(jsonResponse);
  }

  /**
   * Creates a new group from the difference of contacts between the provided groups.
   *
   * @param name The name of the group to be created.
   * @param groups The names of the groups used to create the new group
   * @return the group
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public Group createGroupFromDifference(String name, ArrayList<String> groups)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    JSONObject jsonBody = new JSONObject();
    jsonBody.put("name", name);
    JSONArray jsonArray = new JSONArray();
    for (int i = 0; i < groups.size(); i++) {
      jsonArray.put(groups.get(i));
    }
    jsonBody.put("groups", jsonArray);
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, jsonBody.toString());
    Request request = null;
    request =
        new Request.Builder().url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS + "/difference")
            .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
            .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    if (response.code() == 404 || response.code() == 409) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return Group.fromJson(jsonResponse);
  }



  /**
   * Deletes the contacts that match the provided ids from the specified group.
   *
   * @param groupName The name of the group which contains the contacts
   * @param contacts the contacts
   * @return the group
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public Group deleteContactsOfGroup(String groupName, ArrayList<String> contacts)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    JSONArray jsonArray = new JSONArray();
    for (int i = 0; i < contacts.size(); i++) {
      jsonArray.put(contacts.get(i));
    }
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, jsonArray.toString());
    Request request = null;
    request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS + "/" + groupName + "/contacts")
        .delete(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    if (response.code() == 400 || response.code() == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return Group.fromJson(jsonResponse);
  }


  /**
   * Update one of your groups by adding existing contacts to it.
   *
   * @param groupName The name of the group
   * @param contacts the contacts
   * @return the group
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public Group addContactsToGroup(String groupName, ArrayList<String> contacts)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    JSONArray jsonArray = new JSONArray();
    for (int i = 0; i < contacts.size(); i++) {
      jsonArray.put(contacts.get(i));
    }
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, jsonArray.toString());
    Request request = null;
    request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_GROUPS + "/" + groupName + "/contacts")
        .post(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    if (response.code() == 400 || response.code() == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return Group.fromJson(jsonResponse);
  }

  /**
   * Extract existing contacts from a service’s blacklist.
   *
   * @param service The service for which the contact will be extracted from blacklist (Sms,
   *        TwoStep).
   * @param contacts the contacts
   * @return the int
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeContactsException the routee contacts exception
   */
  public int removeContactsFromBlackList(Service service, ArrayList<String> contacts)
      throws RouteeAuthenticationException, IOException, RouteeContactsException {
    if (this.httpClient == null)
      this.httpClient = new OkHttpClient();
    JSONArray jsonArray = new JSONArray();
    for (int i = 0; i < contacts.size(); i++) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("id", contacts.get(i));
      jsonArray.put(jsonObject);
    }
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = null;
    body = RequestBody.create(mediaType, jsonArray.toString());
    Request request = null;
    request = new Request.Builder()
        .url(Configuration.DEFAULT_BASE_URL + ENDPOINT_CONTACTS + "/blacklist/" + service)
        .delete(body).addHeader("authorization", "Bearer " + this.auth.getToken())
        .addHeader("content-type", "application/json").build();
    Response response = httpClient.newCall(request).execute();
    if (response.code() == 404) {
      throw new RouteeContactsException(response.body().string());
    }
    JSONObject jsonResponse = new JSONObject(response.body().string());
    return jsonResponse.getInt("updated");
  }

}
