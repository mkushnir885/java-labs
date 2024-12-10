package dev.mkushnir885.classes;

/**
 * Abstract base class representing an item in a sentence. A sentence item can either be a word or a
 * punctuation mark.
 */
public abstract class SentenceItem {

  /**
   * Indicates whether the sentence item is followed by a trailing space.
   */
  protected boolean hasTrailSpace;

  /**
   * Constructs a {@code SentenceItem} and determines if it has a trailing space.
   *
   * @param item the string representation of the sentence item
   */
  protected SentenceItem(String item) {
    hasTrailSpace = item.endsWith(" ");
  }

  /**
   * Constructs a {@code SentenceItem} with a specified trailing space indicator.
   *
   * @param hasTrailSpace {@code true} if the item has a trailing space; {@code false} otherwise
   */
  protected SentenceItem(boolean hasTrailSpace) {
    this.hasTrailSpace = hasTrailSpace;
  }

  /**
   * Returns the length of the string representation of the sentence item.
   *
   * @return the length of the sentence item string, including any trailing space
   */
  public abstract int strLen();
}
