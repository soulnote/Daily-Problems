class Solution {
    public int characterReplacement(String s, int k) {
        // Create an array to store the frequency of each character in the window
        int[] charCount = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Increment the count of the current character
            charCount[s.charAt(right) - 'A']++;

            // Update the count of the most frequent character in the window
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

            // If the number of characters to change exceeds k, shrink the window
            while (right - left + 1 - maxCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}