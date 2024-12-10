package dev.mkushnir885.classes;

import java.util.regex.Pattern;

/**
 * Represents a sentence, which is composed of words and punctuation items. A {@code Sentence} is
 * immutable and provides methods to analyze and manipulate its content.
 */
public class Sentence {

  /**
   * Regular expression to match a valid sentence. A valid sentence consists of words, punctuation,
   * and spaces, and ends with a sentence-ending punctuation (e.g., '.', '!', or '?').
   */
  public final static String REGEX = String
      .format("(%s|%s| )*?[.!?]( |$)", Letter.REGEX, Punctuation.REGEX);

  /**
   * The array of {@code SentenceItem} objects representing the components of the sentence.
   */
  private final SentenceItem[] items;

  /**
   * The total count of letters in the sentence.
   */
  private int letterCount;

  /**
   * Constructs a {@code Sentence} from a string.
   *
   * @param sentence the string representation of the sentence, must not be null or empty
   * @throws IllegalArgumentException if the input string does not contain any words
   */
  public Sentence(String sentence) {
    items = Pattern
        .compile(String.format("(%s|%s) ?", Word.REGEX, Punctuation.REGEX))
        .matcher(sentence)
        .results()
        .map(res -> {
          String item = res.group();
          if (item.trim().matches(Word.REGEX)) {
            var word = new Word(item);
            letterCount += word.len();
            return word;
          } else {
            return new Punctuation(item);
          }
        })
        .toArray(SentenceItem[]::new);

    if (letterCount == 0) {
      throw new IllegalArgumentException("No words in sentence.");
    }
  }

  /**
   * Private constructor for creating a new {@code Sentence} from a subset of items.
   *
   * @param items       the array of sentence items
   * @param letterCount the total count of letters in the sentence
   */
  private Sentence(SentenceItem[] items, int letterCount) {
    this.items = items;
    this.letterCount = letterCount;
  }

  /**
   * Returns the total number of letters in the sentence.
   *
   * @return the number of letters
   */
  public int letterCount() {
    return letterCount;
  }

  /**
   * Returns an array of all the letters in the sentence.
   *
   * @return an array of {@code Letter} objects representing all letters in the sentence
   */
  public Letter[] getLetters() {
    Letter[] letters = new Letter[letterCount];
    int i = 0;

    for (var item : items) {
      if (item instanceof Word word) {
        for (var letter : word.getLetters()) {
          letters[i++] = letter;
        }
      }
    }
    return letters;
  }

  /**
   * Trims the sentence from the start by a specified number of letters.
   *
   * @param startIdx the number of letters to trim from the start
   * @return a new {@code Sentence} with the specified letters removed from the start
   */
  public Sentence trimStartByLetter(int startIdx) {
    int remainingToTrim = startIdx;
    for (int i = 0; i < items.length; i++) {
      if (items[i] instanceof Word word) {
        if (remainingToTrim < word.len()) {
          var newItems = new SentenceItem[items.length - i];
          newItems[0] = word.trimStart(remainingToTrim);
          System.arraycopy(items, i + 1, newItems, 1, newItems.length - 1);
          return new Sentence(newItems, letterCount - startIdx);
        }

        if (remainingToTrim == word.len()) {
          int nextWordIdx = i + 1;
          for (; nextWordIdx < items.length; nextWordIdx++) {
            if (items[nextWordIdx] instanceof Word) {
              break;
            }
          }
          var newItems = new SentenceItem[items.length - nextWordIdx];
          if (newItems.length > 0) {
            System.arraycopy(items, nextWordIdx, newItems, 0, newItems.length);
          }
          return new Sentence(newItems, letterCount - startIdx);
        }

        remainingToTrim -= word.len();
      }
    }
    return new Sentence(new SentenceItem[0], 0);
  }

  /**
   * Trims the sentence from the end by a specified number of letters.
   *
   * @param endIdx the number of letters to retain from the start of the sentence
   * @return a new {@code Sentence} with the specified letters retained from the start
   */
  public Sentence trimEndByLetter(int endIdx) {
    int curLetterCount = letterCount;
    for (int i = items.length - 1; i >= 0; i--) {
      if (items[i] instanceof Word word) {
        int nextLetterCount = curLetterCount - word.len();

        if (nextLetterCount < endIdx) {
          var newItems = new SentenceItem[i + 1];
          newItems[i] = word.trimEnd(endIdx - nextLetterCount);
          System.arraycopy(items, 0, newItems, 0, i);
          return new Sentence(newItems, endIdx);
        }

        curLetterCount -= word.len();
      }
    }
    return new Sentence(new SentenceItem[0], 0);
  }

  /**
   * Returns the total length of the sentence as a string, including spaces.
   *
   * @return the string length of the sentence
   */
  public int strLen() {
    int len = 0;
    for (var item : items) {
      len += item.strLen();
    }
    return len;
  }

  /**
   * Returns the string representation of the sentence.
   *
   * @return a string containing the sentence
   */
  @Override
  public String toString() {
    var sb = new StringBuilder();
    for (var item : items) {
      sb.append(item);
    }
    return sb.toString();
  }
}
