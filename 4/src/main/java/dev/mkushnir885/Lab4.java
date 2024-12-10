package dev.mkushnir885;

import dev.mkushnir885.classes.Text;
import dev.mkushnir885.classes.Letter;

/**
 * Entry point for the Lab4 application.
 * <p>
 * This application processes a given text to find and display the longest palindromic substring. A
 * palindrome is a sequence of characters that reads the same backward as forward.
 * </p>
 */
public class Lab4 {

  /**
   * The main method serves as the entry point of the application.
   * <p>
   * The method initializes a predefined {@code Text} object and calculates the longest palindromic
   * substring. The result is printed to the standard output. If the text is invalid or processing
   * fails, an error message is printed to the standard error, and the application exits with a
   * non-zero status code.
   * </p>
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    final String TEXT = """
        On a warm day in a quiet town, Eve saw her reflection in a lake. 'Wow', she whispered.
        Bob, her friend, laughed. No lemon, no melon - he exclaimed.
        Eve smiled. Radar shows that level of calm.
        Later, she walked by the racecar parked by the street,
        noting the sign: "A man, a plan, a canal, Panama".
        As they strolled back, she spotted an owl.
        Eve knew some things could only be seen in reverse.""";

    try {

      Text result = longestPalindrome(new Text(TEXT));
      System.out.printf("Longest palindrome: '%s'%n", result);

    } catch (IllegalArgumentException e) {
      System.err.println("Execution failed. " + e.getMessage());
      System.exit(1);
    }
  }

  /**
   * Finds the longest palindromic substring within a given {@code Text} object.
   * <p>
   * This method iterates through the text's letters and checks for palindromes by expanding around
   * each character (for odd-length palindromes) and each pair of adjacent characters (for
   * even-length palindromes).
   * </p>
   *
   * @param text the {@code Text} object to search for palindromes, must not be null
   * @return the longest palindromic substring as a {@code Text} object
   */
  public static Text longestPalindrome(Text text) {
    Text longest = null;
    var letters = text.getLetters();

    for (int i = 0; i < letters.length; i++) {
      Text palindrome1 = expandAroundCenter(text, letters, i, i);
      Text palindrome2 = expandAroundCenter(text, letters, i, i + 1);

      Text longer = (palindrome1.strLen() > palindrome2.strLen())
          ? palindrome1
          : palindrome2;
      longest = (longest == null || longer.strLen() > longest.strLen())
          ? longer
          : longest;
    }
    return longest;
  }

  /**
   * Expands around the given center to find the longest palindrome substring.
   * <p>
   * Starting from the specified indices, this method compares letters outwardly until a mismatch is
   * found or the bounds of the text are reached.
   * </p>
   *
   * @param text    the {@code Text} object being searched
   * @param letters the array of {@code Letter} objects representing the text's letters
   * @param left    the starting left index for expansion
   * @param right   the starting right index for expansion
   * @return the longest palindromic substring found during expansion as a {@code Text} object
   */
  private static Text expandAroundCenter(Text text, Letter[] letters, int left, int right) {
    while (left >= 0 && right < letters.length) {
      if (letters[left].equals(letters[right])) {
        left--;
        right++;
      } else {
        break;
      }
    }
    return text.substrByLetters(left + 1, right);
  }
}
