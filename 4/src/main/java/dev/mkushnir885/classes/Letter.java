package dev.mkushnir885.classes;

/**
 * Represents a single letter in the English alphabet. A letter is immutable and case-insensitive
 * for comparison.
 */
public class Letter {

  /**
   * Regular expression to match a single alphabetic character (A-Z or a-z).
   */
  public final static String REGEX = "[a-zA-Z]";

  /**
   * The character value of the letter.
   */
  private final char value;

  /**
   * Constructs a {@code Letter} instance from a string.
   *
   * @param letter a string containing the letter, must not be null and must match the
   *               {@link #REGEX}
   * @throws StringIndexOutOfBoundsException if the string is empty
   */
  public Letter(String letter) {
    value = letter.charAt(0);
  }

  /**
   * Compares this letter with another for equality, ignoring case.
   *
   * @param other the {@code Letter} to compare with
   * @return {@code true} if the letters are equal (case-insensitive); {@code false} otherwise
   */
  public boolean equals(Letter other) {
    return Character.toLowerCase(value) == Character.toLowerCase(other.value);
  }

  /**
   * Returns the string representation of the letter.
   *
   * @return a string containing the letter
   */
  @Override
  public String toString() {
    return Character.toString(value);
  }
}
