import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charIndexes = new int[128];
        Arrays.fill(charIndexes, -1);
        int left = 0;
        int maxLen = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (charIndexes[ch] != -1) {
                left = Math.max(left, charIndexes[ch] + 1);
            }
            maxLen = Math.max(maxLen, right - left + 1);
            charIndexes[ch] = right;
            right++;
        }
        return maxLen;
    }
}
