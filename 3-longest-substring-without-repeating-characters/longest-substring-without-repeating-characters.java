class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128]; // Assuming ASCII characters
        
        for (int i = 0, j = 0; j < n; j++) {
            char currentChar = s.charAt(j);
            // Update the start of the window if the character is already seen and its index is greater than or equal to the start of the current window
            i = Math.max(charIndex[currentChar], i);
            // Update the maximum length if needed
            maxLength = Math.max(maxLength, j - i + 1);
            // Store the index of the next character
            charIndex[currentChar] = j + 1;
        }
        
        return maxLength;
    }
}
