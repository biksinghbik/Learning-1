package org.medium;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > result.length()) {
                result = oddPalindrome;
            }
            // Check for even-length palindromes
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome.length() > result.length()) {
                result = evenPalindrome;
            }

        }
        return result;
    }

    private String expandAroundCenter(String s, int i, int i1) {
        int left = i, right = i1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String input = "abccbx"; // Example input
        String result = solution.longestPalindrome(input);
        System.out.println("Longest palindromic substring of '" + input + "' is: " + result);
    }
}
