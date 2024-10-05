class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(); // Length of the first string (s1)
        int len2 = s2.length(); // Length of the second string (s2)

        // If s1 is longer than s2, it's impossible for s2 to contain any permutation of s1
        if (len1 > len2) return false;

        int[] charCount = new int[26]; // Array to keep track of character frequencies

        // Populate frequency array with counts from s1
        for (int i = 0; i < len1; i++) {
            charCount[s1.charAt(i) - 'a']++;
        }

        // Subtract the frequency of the first len1 characters in s2
        for (int i = 0; i < len1; i++) {
            charCount[s2.charAt(i) - 'a']--;
        }

        // If the initial window (first len1 characters) is a permutation, return true
        if (allZeroes(charCount)) return true;

        int left = 0; // Left pointer of the sliding window
        int right = len1; // Right pointer of the sliding window

        // Slide the window over s2
        while (right < len2) {
            // Add the character going out of the window (left side)
            charCount[s2.charAt(left) - 'a']++;

            // Subtract the character coming into the window (right side)
            charCount[s2.charAt(right) - 'a']--;

            // Check if the current window is a permutation of s1
            if (allZeroes(charCount)) return true;

            // Move the window to the right
            left++;
            right++;
        }

        // No permutation found
        return false;
    }

    // Helper method to check if all counts in the array are zero
    public boolean allZeroes(int[] countArray) {
        for (int count : countArray) {
            if (count != 0) return false;
        }
        return true;
    }
}
