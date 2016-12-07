package net.routee.twostep;

import java.util.ArrayList;

import org.json.JSONObject;



/**
 * The Class TwoStepReport.
 */
public class TwoStepReport {

  /**
   * The total number of verifications sent.
   */
  private int total;

  /**
   * Count per verification status.
   */
  private Total totals;

  /**
   * Count per country and verification status.
   */
  private ArrayList<PerCountry> countries;


  /**
   * Instantiates a new two step report.
   *
   * @param total the total
   * @param totals the totals
   * @param countries the countries
   */
  public TwoStepReport(int total, Total totals, ArrayList<PerCountry> countries) {
    this.total = total;
    this.totals = totals;
    this.countries = countries;
  }

  /**
   * Instantiates a new two step report.
   */
  public TwoStepReport() {
    this.countries = new ArrayList<PerCountry>();
  }

  /**
   * Gets the total.
   *
   * @return the total
   */
  public int getTotal() {
    return total;
  }

  /**
   * Sets the total.
   *
   * @param total the new total
   */
  public void setTotal(int total) {
    this.total = total;
  }

  /**
   * Gets the totals.
   *
   * @return the totals
   */
  public Total getTotals() {
    return totals;
  }

  /**
   * Sets the totals.
   *
   * @param totals the new totals
   */
  public void setTotals(Total totals) {
    this.totals = totals;
  }

  /**
   * Gets the countries.
   *
   * @return the countries
   */
  public ArrayList<PerCountry> getCountries() {
    return countries;
  }

  /**
   * Sets the countries.
   *
   * @param countries the new countries
   */
  public void setCountries(ArrayList<PerCountry> countries) {
    this.countries = countries;
  }

  /**
   * Adds the country report.
   *
   * @param country the country
   */
  public void addCountryReport(PerCountry country) {
    if (this.countries == null) {
      this.countries = new ArrayList<PerCountry>();
    }
    this.countries.add(country);
  }

  /**
   * From json.
   *
   * @param jsonResponse the json response
   * @return the two step report
   */
  public static TwoStepReport fromJson(JSONObject jsonResponse) {
    TwoStepReport report = new TwoStepReport();
    report.setTotal(jsonResponse.getInt("total"));
    JSONObject totalsJson = jsonResponse.getJSONObject("totals");
    report.setTotals(Total.fromJson(totalsJson));
    if (jsonResponse.has("perCountry")) {
      JSONObject country = jsonResponse.getJSONObject("perCountry");
      if (country != null && country.length() != 0) {
        for (int i = 0; i < country.names().length(); i++) {
          JSONObject perCountryJson = country.getJSONObject(country.names().getString(i));
          PerCountry Country = PerCountry.fromJson(perCountryJson);
          Country.setCountry(country.names().getString(i));
          report.addCountryReport(Country);
        }
      }
    }
    return report;
  }

}
