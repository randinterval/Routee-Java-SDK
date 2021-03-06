package net.routee.messaging;

import java.util.ArrayList;



/**
 * This class defines the recipients that will receive a test SMS before and/or after the actual SMS
 * is sent.
 */
public class Reminder {

  /**
   * The minutes after the scheduled date (that the SMS will be sent) that the test SMS will be
   * sent.
   */
  private int minutesAfter;

  /**
   * The minutes before the scheduled date (that the SMS will be sent) that the test SMS will be
   * sent.
   */
  private int minutesBefore;

  /**
   * A list of recipients that will get the test SMS before and/or after the campaign will start.
   * Must be a list with valid mobile numbers starting with “ + ” and the country code.
   */
  private ArrayList<String> to;

  /**
   * Instantiates a new reminder.
   *
   * @param minutesAfter the minutes after
   * @param minutesBefore the minutes before
   * @param to the to
   */
  public Reminder(int minutesAfter, int minutesBefore, ArrayList<String> to) {
    this.minutesAfter = minutesAfter;
    this.minutesBefore = minutesBefore;
    this.to = to;
  }

  /**
   * Instantiates a new reminder.
   */
  public Reminder() {

  }

  /**
   * Gets the minutes after.
   *
   * @return the minutes after
   */
  public int getMinutesAfter() {
    return minutesAfter;
  }

  /**
   * Sets the minutes after.
   *
   * @param minutesAfter the new minutes after
   */
  public void setMinutesAfter(int minutesAfter) {
    this.minutesAfter = minutesAfter;
  }

  /**
   * Gets the minutes before.
   *
   * @return the minutes before
   */
  public int getMinutesBefore() {
    return minutesBefore;
  }

  /**
   * Sets the minutes before.
   *
   * @param minutesBefore the new minutes before
   */
  public void setMinutesBefore(int minutesBefore) {
    this.minutesBefore = minutesBefore;
  }

  /**
   * Gets the to.
   *
   * @return the to
   */
  public ArrayList<String> getTo() {
    return to;
  }

  /**
   * Sets the to.
   *
   * @param to the new to
   */
  public void setTo(ArrayList<String> to) {
    this.to = to;
  }

}
