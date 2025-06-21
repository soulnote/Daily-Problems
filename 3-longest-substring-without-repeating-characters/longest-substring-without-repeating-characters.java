class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // While we find a duplicate, shrink the window
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to set
            set.add(c);

            // Update maxLength if current window is larger
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}