package net.routee.contacts;



/**
 * The Enum Service.
 */
public enum Service {

  /** The sms. */
  SMS {

    @Override
    public String toString() {
      return "Sms";
    }
  },

  /** The twostepverification. */
  TWOSTEPVERIFICATION {
    @Override
    public String toString() {
      return "TwoStep";
    }
  }
}
