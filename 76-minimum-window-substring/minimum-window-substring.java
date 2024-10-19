import java.util.Arrays;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0 || s.length() == 0) return "";

        int[] tFq = new int[128]; // Frequency array for characters in t
        int[] wFq = new int[128]; // Frequency array for characters in the window

        // Populate tFq with the frequency of characters in t
        for (int i = 0; i < t.length(); i++) {
            tFq[t.charAt(i)]++;
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE, minStart = 0;
        int formed = 0; // Number of characters that are fully matched in the window
        int required = t.length(); // Total number of characters we need to match

        // Traverse s with the right pointer
        for (; right < s.length(); right++) {
            char ch = s.charAt(right);
            wFq[ch]++; // Add the character at right to window frequency

            // If this character is in t and its count in window matches or exceeds t's frequency, increase formed
            if (tFq[ch] > 0 && wFq[ch] <= tFq[ch]) {
                formed++;
            }

            // Try to contract the window when we have all characters in t matched
            while (formed == required) {
                // Update the minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left; // Store the start of the minimum window
                }

                // Remove the character at left from window frequency
                char leftChar = s.charAt(left);
                wFq[leftChar]--;

                // If the character at left is in t and its count in window falls below t's frequency, decrease formed
                if (tFq[leftChar] > 0 && wFq[leftChar] < tFq[leftChar]) {
                    formed--;
                }

                left++; // Move the left pointer to shrink the window
            }
        }

        // Return the minimum window substring, or an empty string if no valid window is found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
