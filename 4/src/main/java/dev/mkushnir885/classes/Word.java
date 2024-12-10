package dev.mkushnir885.classes;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Represents a word in a sentence. A word consists of one or more letters and may have a trailing
 * space.
 */
public class Word extends SentenceItem {

  /**
   * Regular expression to match a sequence of letters.
   */
  public final static String REGEX = Letter.REGEX + "+";

  /**
   * Array of {@code Letter} objects representing the letters in the word.
   */
  private final Letter[] letters;

  /**
   * Constructs a {@code Word} instance from a string.
   *
   * @param word the string representation of the word, must not be null and must match the
   *             {@link #REGEX}
   */
  public Word(String word) {
    super(word);

    letters = Pattern
        .compile(Letter.REGEX)
        .matcher(word)
        .results()
        .map(res -> new Letter(res.group())).toArray(Letter[]::new);
  }

  /**
   * Private constructor used for creating modified copies of a {@code Word}.
   *
   * @param letters       the letters of the word
   * @param hasTrailSpace {@code true} if the word has a trailing space; {@code false} otherwise
   */
  private Word(Letter[] letters, boolean hasTrailSpace) {
    super(hasTrailSpace);
    this.letters = letters;
  }

  /**
   * Returns the number of letters in the word.
   *
   * @return the length of the word in letters
   */
  public int len() {
    return letters.length;
  }

  /**
   * Returns a copy of the letters in the word.
   *
   * @return an array of {@code Letter} objects
   */
  public Letter[] getLetters() {
    return Arrays.copyOf(letters, letters.length);
  }

  /**
   * Trims the word from the start by the specified number of letters.
   *
   * @param startIdx the index to start trimming from (inclusive)
   * @return a new {@code Word} instance with the trimmed letters
   */
  public Word trimStart(int startIdx) {
    return new Word(Arrays.copyOfRange(letters, startIdx, letters.length), hasTrailSpace);
  }

  /**
   * Trims the word from the end by the specified number of letters.
   *
   * @param endIdx the index to stop trimming at (exclusive)
   * @return a new {@code Word} instance with the trimmed letters
   */
  public Word trimEnd(int endIdx) {
    return new Word(Arrays.copyOfRange(letters, 0, endIdx), false);
  }

  /**
   * Returns the length of the string representation of the word, including any trailing space.
   *
   * @return the length of the word string
   */
  @Override
  public int strLen() {
    return letters.length + (hasTrailSpace ? 1 : 0);
  }

  /**
   * Returns the string representation of the word.
   *
   * @return a string containing the word and potential trailing space
   */
  @Override
  public String toString() {
    var sb = new StringBuilder();
    for (var letter : letters) {
      sb.append(letter);
    }
    return sb.append(hasTrailSpace ? " " : "").toString();
  }
}
