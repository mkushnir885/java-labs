package dev.mkushnir885.classes;

import java.util.regex.Pattern;

/**
 * Represents a text composed of multiple sentences. A {@code Text} is immutable and provides
 * methods to analyze and manipulate its content.
 */
public class Text {

  /**
   * The array of {@code Sentence} objects representing the sentences in the text.
   */
  private final Sentence[] sentences;

  /**
   * The total count of letters in the text.
   */
  private int letterCount;

  /**
   * Constructs a {@code Text} object from a string.
   * <p>
   * The input text is normalized by replacing multiple spaces with a single space. The text must
   * match a sequence of valid {@code Sentence} objects.
   * </p>
   *
   * @param text the string representation of the text, must not be null or empty
   * @throws IllegalArgumentException if the input text is invalid or contains no valid sentences
   */
  public Text(String text) {
    text = text.replaceAll("\\s+", " ");

    if (!text.matches(String.format("(%s)+", Sentence.REGEX))) {
      throw new IllegalArgumentException("Invalid text.");
    }

    sentences = Pattern
        .compile(Sentence.REGEX)
        .matcher(text)
        .results()
        .map(res -> {
          var sentence = new Sentence(res.group());
          letterCount += sentence.letterCount();
          return sentence;
        })
        .toArray(Sentence[]::new);
  }

  /**
   * Private constructor for creating a new {@code Text} from a subset of sentences.
   *
   * @param sentences   the array of sentences in the text
   * @param letterCount the total count of letters in the text
   */
  private Text(Sentence[] sentences, int letterCount) {
    this.sentences = sentences;
    this.letterCount = letterCount;
  }

  public Letter[] getLetters() {
    var letters = new Letter[letterCount];
    int i = 0;

    for (var sentence : sentences) {
      for (var letter : sentence.getLetters()) {
        letters[i++] = letter;
      }
    }
    return letters;
  }

  /**
   * Trims the text from the start by a specified number of letters.
   *
   * @param startIdx the number of letters to trim from the start
   * @return a new {@code Text} with the specified letters removed from the start
   */
  public Text trimStartByLetter(int startIdx) {
    int remainingToTrim = startIdx;
    for (int i = 0; i < sentences.length; i++) {
      var sentence = sentences[i];

      if (remainingToTrim < sentence.letterCount()) {
        var newSentences = new Sentence[sentences.length - i];
        newSentences[0] = sentence.trimStartByLetter(remainingToTrim);
        System.arraycopy(sentences, i + 1, newSentences, 1, newSentences.length - 1);
        return new Text(newSentences, letterCount - startIdx);
      }

      if (remainingToTrim == sentence.letterCount()) {
        var newSentences = new Sentence[sentences.length - i - 1];
        if (newSentences.length > 0) {
          System.arraycopy(sentences, i + 1, newSentences, 0, newSentences.length);
          newSentences[0] = newSentences[0].trimStartByLetter(0);
        }
        return new Text(newSentences, letterCount - startIdx);
      }

      remainingToTrim -= sentence.letterCount();
    }
    return new Text(new Sentence[0], 0);
  }

  /**
   * Trims the text from the end by a specified number of letters.
   *
   * @param endIdx the number of letters to retain from the start of the text
   * @return a new {@code Text} with the specified letters retained from the start
   */
  public Text trimEndByLetter(int endIdx) {
    int curLetterCount = letterCount;
    for (int i = sentences.length - 1; i >= 0; i--) {
      var sentence = sentences[i];
      int nextLetterCount = curLetterCount - sentence.letterCount();

      if (nextLetterCount < endIdx) {
        var newSentences = new Sentence[i + 1];
        newSentences[i] = sentence.trimEndByLetter(endIdx - nextLetterCount);
        System.arraycopy(sentences, 0, newSentences, 0, i);
        return new Text(newSentences, endIdx);
      }

      curLetterCount -= sentence.letterCount();
    }
    return new Text(new Sentence[0], 0);
  }

  /**
   * Extracts a substring of the text based on the range of letters.
   *
   * @param from the starting index of the letter range (inclusive)
   * @param to   the ending index of the letter range (exclusive)
   * @return a new {@code Text} containing the letters in the specified range
   */
  public Text substrByLetters(int from, int to) {
    return trimEndByLetter(to).trimStartByLetter(from);
  }

  /**
   * Returns the total length of the text as a string, including spaces.
   *
   * @return the string length of the text
   */
  public int strLen() {
    int len = 0;
    for (var sentence : sentences) {
      len += sentence.strLen();
    }
    return len;
  }

  /**
   * Returns the string representation of the text.
   *
   * @return a string containing the entire text
   */
  @Override
  public String toString() {
    var sb = new StringBuilder();
    for (var sentence : sentences) {
      sb.append(sentence);
    }
    return sb.toString();
  }
}
