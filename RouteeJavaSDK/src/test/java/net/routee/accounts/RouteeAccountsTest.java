package net.routee.accounts;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import net.routee.TestConfiguration;
import net.routee.authentication.RouteeAuthenticationException;
import net.routee.contacts.Service;



/**
 * The Class RouteeAccountsTest.
 */
public class RouteeAccountsTest {



  /**
   * Test balance.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testBalance()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RouteeAccountBalance balance = client.retrieveAccountBalance();
    assertTrue(balance.getBalance() >= 0);
  }

  /**
   * Test currency.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testCurrency()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RouteeAccountBalance balance = client.retrieveAccountBalance();
    assertNotNull(balance.getCurrency());
  }

  /**
   * Test retrieve prices for services.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testRetrievePricesForServices()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrievePricesResponse prices = client.retrievePricesRouteeServices(null);
    assertTrue(prices.getSmsInfo().size() > 0);
  }

  /**
   * Test retrieve prices for services look up.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  public void testRetrievePricesForServicesLookUp()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrievePricesResponse prices = client.retrievePricesRouteeServices(null);
    assertTrue(prices.getLookupPricePerRequest() > 0);
  }


  /**
   * Test retrieve prices for services without sms.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testRetrievePricesForServicesWithoutSms()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrievePriceParameters parameters = new RetrievePriceParameters();
    parameters.setService(Service.TWOSTEPVERIFICATION);
    RetrievePricesResponse prices = client.retrievePricesRouteeServices(parameters);
    assertTrue(prices.getSmsInfo().size() == 0);
  }

  /**
   * Test retrieve prices for services without two step.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testRetrievePricesForServicesWithoutTwoStep()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrievePriceParameters parameters = new RetrievePriceParameters();
    parameters.setService(Service.SMS);
    RetrievePricesResponse prices = client.retrievePricesRouteeServices(parameters);
    assertNull(prices.getTwoStepPrice());
  }

  /**
   * Test retrieve prices for services with invalid currency.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test(expected = RouteeAccountsException.class)
  public void testRetrievePricesForServicesWithInvalidCurrency()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrievePriceParameters parameters = new RetrievePriceParameters();
    parameters.setCurrency("InvalidCurrency");
    client.retrievePricesRouteeServices(parameters);
  }

  /**
   * Test retrieve transactions of account.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testRetrieveTransactionsOfAccount()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrieveTransactionResponse transactions = client.retrieveTransacations(null);
    assertTrue(transactions.getTransactions().size() >= 0);
  }

  /**
   * Test retrieve transactions of account with size.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testRetrieveTransactionsOfAccountWithSize()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrieveTransactionParameters parameter = new RetrieveTransactionParameters();
    parameter.setSize(40);
    RetrieveTransactionResponse transactions = client.retrieveTransacations(parameter);
    assertTrue(transactions.getSize() == 40);
  }

  /**
   * Test available bank accounts name.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testAvailableBankAccountsName()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrieveBankAccountsResponse accounts = client.retrieveAvailableBankAccounts();
    assertNotNull(accounts.getName());
  }

  /**
   * Test available bank accounts size.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testAvailableBankAccountsSize()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrieveBankAccountsResponse accounts = client.retrieveAvailableBankAccounts();
    assertTrue(accounts.getBanks().size() > 0);
  }

  /**
   * Test balance currency.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testBalanceCurrency()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RouteeAccountBalance balance = client.retrieveAccountBalance();
    Currency currency = balance.getCurrency();
    assertTrue(
        currency.getName() != null && currency.getCode() != null && currency.getSign() != null);
  }

  /**
   * Test retrieve prices for two step.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testRetrievePricesForTwoStep()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrievePriceParameters parameters = new RetrievePriceParameters();
    parameters.setService(Service.TWOSTEPVERIFICATION);
    RetrievePricesResponse prices = client.retrievePricesRouteeServices(parameters);
    TwoStepPrice twostep = prices.getTwoStepPrice();
    assertTrue(twostep.getSmsVerificationPrice() > 0 && twostep.getVoiceVerificationPrice() > 0);
  }

  /**
   * Test retrieve banks bank info.
   *
   * @throws RouteeAuthenticationException the routee authentication exception
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws RouteeAccountsException the routee accounts exception
   */
  @Test
  public void testRetrieveBanksBankInfo()
      throws RouteeAuthenticationException, IOException, RouteeAccountsException {
    RouteeAccountsClient client = new RouteeAccountsClient(TestConfiguration.APPLICATION_ID,
        TestConfiguration.APPLICATION_SECRET);
    RetrieveBankAccountsResponse accounts = client.retrieveAvailableBankAccounts();
    ArrayList<Bank> banks = accounts.getBanks();
    Bank bank = banks.get(0);
    assertTrue(bank.getName() != null && bank.getIban() != null && bank.getSwiftCode() != null
        && bank.getMinAmount() >= 0 && bank.getAddress() != null);
  }


}
