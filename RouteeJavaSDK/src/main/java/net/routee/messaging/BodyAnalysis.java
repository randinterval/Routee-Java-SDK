package net.routee.messaging;

import org.json.JSONObject;



/**
 * The analysis for the body of the SMS.
 */
public class BodyAnalysis {


  /** The total number of characters of the message body. */
  private int characters;

  /**
   * The number of actual SMS that will be sent.
   */
  private int parts;

  /**
   * Contains information for the transcoded body of the SMS message. This will be available only if
   * the message can be transcoded.
   */
  private Transcode transcode;

  /** Indicates if the body contains unicode characters. */
  private boolean unicode;

  /** Which characters caused the message to be considered as unicode. */
  private String unsupportedGSMCharacters;


  /**
   * Instantiates a new body analysis.
   *
   * @param characters the characters
   * @param parts the parts
   * @param transcode the transcode
   * @param unicode the unicode
   * @param unsupportedGSMCharacters the unsupported GSM characters
   */
  public BodyAnalysis(int characters, int parts, Transcode transcode, boolean unicode,
      String unsupportedGSMCharacters) {
    super();
    this.characters = characters;
    this.parts = parts;
    this.transcode = transcode;
    this.unicode = unicode;
    this.unsupportedGSMCharacters = unsupportedGSMCharacters;
  }


  /**
   * Instantiates a new body analysis.
   */
  public BodyAnalysis() {}


  /**
   * Gets the characters.
   *
   * @return the characters
   */
  public int getCharacters() {
    return characters;
  }


  /**
   * Sets the characters.
   *
   * @param characters the new characters
   */
  public void setCharacters(int characters) {
    this.characters = characters;
  }


  /**
   * Gets the parts.
   *
   * @return the parts
   */
  public int getParts() {
    return parts;
  }


  /**
   * Sets the parts.
   *
   * @param parts the new parts
   */
  public void setParts(int parts) {
    this.parts = parts;
  }


  /**
   * Gets the transcode.
   *
   * @return the transcode
   */
  public Transcode getTranscode() {
    return transcode;
  }


  /**
   * Sets the transcode.
   *
   * @param transcode the new transcode
   */
  public void setTranscode(Transcode transcode) {
    this.transcode = transcode;
  }


  /**
   * Checks if is unicode.
   *
   * @return true, if is unicode
   */
  public boolean isUnicode() {
    return unicode;
  }


  /**
   * Sets the unicode.
   *
   * @param unicode the new unicode
   */
  public void setUnicode(boolean unicode) {
    this.unicode = unicode;
  }


  /**
   * Gets the unsupported GSM characters.
   *
   * @return the unsupported GSM characters
   */
  public String getUnsupportedGSMCharacters() {
    return unsupportedGSMCharacters;
  }


  /**
   * Sets the unsupported GSM characters.
   *
   * @param unsupportedGSMCharacters the new unsupported GSM characters
   */
  public void setUnsupportedGSMCharacters(String unsupportedGSMCharacters) {
    this.unsupportedGSMCharacters = unsupportedGSMCharacters;
  }

  /**
   * From json.
   *
   * @param bodyAnalysisJSON the body analysis JSON
   * @return the body analysis
   */
  public static BodyAnalysis fromJson(JSONObject bodyAnalysisJSON) {
    BodyAnalysis analysis = new BodyAnalysis();
    analysis.setCharacters(bodyAnalysisJSON.getInt("characters"));
    analysis.setParts(bodyAnalysisJSON.getInt("parts"));
    if (bodyAnalysisJSON.has("transcode")) {
      JSONObject transcodeJson = bodyAnalysisJSON.getJSONObject("transcode");
      analysis.setTranscode(Transcode.fromJson(transcodeJson));
    }
    analysis.setUnicode(bodyAnalysisJSON.getBoolean("unicode"));
    return analysis;
  }

}
