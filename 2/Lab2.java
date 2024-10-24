public class Lab2 {

  public static void main(String[] args) {
    final String TEXT = "hello madam tattarrattat dad blablabla";

    try {

      String result = longestPalindrome(TEXT);
      System.out.printf("Longest palindrome: '%s'\n", result);

    } catch (IllegalArgumentException e) {
      System.err.println("Execution failed. " + e.getMessage());
      System.exit(1);
    }
  }

  public static String longestPalindrome(String str) {
    if (str == null || str.isEmpty()) {
      throw new IllegalArgumentException("Text string cannot be null or empty.");
    }

    if (str.length() < 2) {
      return str;
    }

    int start = 0, maxLen = 1;

    for (int i = 0; i < str.length(); i++) {
      int len1 = expandAroundCenter(str, i, i);
      int len2 = expandAroundCenter(str, i, i + 1);
      int len = Math.max(len1, len2);

      if (len > maxLen) {
        maxLen = len;
        start = i - (len - 1) / 2;
      }
    }

    return str.substring(start, start + maxLen);
  }

  private static int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}
