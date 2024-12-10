package dev.mkushnir885.classes;

/**
 * Represents a punctuation mark in a sentence. Punctuation is immutable and always consists of a
 * single character and may have a trailing space.
 */
public class Punctuation extends SentenceItem {

  /**
   * Regular expression to match punctuation characters.
   */
  public final static String REGEX = "\\p{Punct}";

  /**
   * The punctuation character.
   */
  private final char value;

  /**
   * Constructs a {@code Punctuation} instance from a string.
   *
   * @param punct a string containing the punctuation mark, must not be null and must match the
   *              {@link #REGEX}
   * @throws StringIndexOutOfBoundsException if the string is empty
   */
  public Punctuation(String punct) {
    super(punct);
    value = punct.charAt(0);
  }

  /**
   * Returns the length of the string representation of the punctuation, including any trailing
   * space.
   *
   * @return the length of the punctuation string
   */
  @Override
  public int strLen() {
    return 1 + (hasTrailSpace ? 1 : 0);
  }

  /**
   * Returns the string representation of the punctuation.
   *
   * @return a string containing the punctuation mark and potential trailing space
   */
  @Override
  public String toString() {
    return value + (hasTrailSpace ? " " : "");
  }
}
