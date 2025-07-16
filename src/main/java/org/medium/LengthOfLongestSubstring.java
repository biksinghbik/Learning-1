package org.medium;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Set<Character> seen = new HashSet<>();
        int max = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l1 = new LengthOfLongestSubstring();
        System.out.println(l1.lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(l1.lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(l1.lengthOfLongestSubstring("pwwkew"));   // Output: 3
    }
}
