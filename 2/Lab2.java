public class Lab2 {

  public static void main(String[] args) {
    final String TEXT = """
        On a warm day in a quiet town, Eve saw her reflection in a lake. 'Wow!' she whispered.
        Bob, her friend, laughed. No lemon, no melon! - he exclaimed.
        Eve smiled. 'Radar shows that level of calm.'
        Later, she walked by the racecar parked by the street,
        noting the sign: "A man, a plan, a canal, Panama!" She thought,
        `Madam, in Eden, I’m Adam,` before turning away.
        As they strolled back, she spotted an owl.
        Evil is a name of a foeman, as I live, she murmured.
        Eve knew some things could only be seen in reverse.""";

    try {

      String result = longestPalindrome(TEXT);
      System.out.printf("Longest palindrome: '%s'%n", result);

    } catch (IllegalArgumentException e) {
      System.err.println("Execution failed. " + e.getMessage());
      System.exit(1);
    }
  }

  public static String longestPalindrome(String str) {
    if (str == null) {
      throw new IllegalArgumentException("Text string cannot be null.");
    }

    str = trimNonAlphanumeric(str);

    if (str.length() < 2) {
      return str;
    }

    String longest = "";

    for (int i = 0; i < str.length(); i++) {
      String palindrome1 = expandAroundCenter(str, i, i);
      String palindrome2 = expandAroundCenter(str, i, i + 1);

      String longer = (palindrome1.length() > palindrome2.length())
          ? palindrome1
          : palindrome2;
      longest = (longer.length() > longest.length())
          ? longer
          : longest;
    }

    return longest;
  }

  private static String expandAroundCenter(String str, int left, int right) {
    String lowerStr = str.toLowerCase();
    while (left >= 0 && right < str.length()) {
      char leftChar = lowerStr.charAt(left);
      char rightChar = lowerStr.charAt(right);

      if (!Character.isLetterOrDigit(leftChar)) {
        left--;
      } else if (!Character.isLetterOrDigit(rightChar)) {
        right++;
      } else if (leftChar == rightChar) {
        left--;
        right++;
      } else {
        break;
      }
    }
    return trimNonAlphanumeric(str.substring(left + 1, right));
  }

  private static String trimNonAlphanumeric(String str) {
    return str.replaceAll("(^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$)", "");
  }
}
